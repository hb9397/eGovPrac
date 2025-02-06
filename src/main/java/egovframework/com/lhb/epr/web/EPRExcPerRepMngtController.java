package egovframework.com.lhb.epr.web;

import java.util.List;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.SessionVO;
import egovframework.com.lhb.epr.com.EPRUtil;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtService;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtVO;
import egovframework.com.lhb.epr.service.EqpmnRepVwVO;
import egovframework.com.lhb.epr.service.ExcPerRepVO;
import egovframework.com.lhb.epr.service.SearchExcPerRepDtlVO;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Controller
@SessionAttributes(types = SessionVO.class)
@RequestMapping("/lhb/epr")
public class EPRExcPerRepMngtController {

	private final EgovMessageSource egovMessageSource;

	protected final EgovPropertyService propertiesService;

	private final DefaultBeanValidator beanValidator;

	private final EPRUtil eprUtil;

	private final EPRExcPerRepMngtService eprExcPerRepMngtService;

	// 수행실적 신고 페이징
	@RequestMapping("/selectExcPerRepListPageVw.do")
	public String selectEPRExcPerRepMngtList(@ModelAttribute("menuManageVO") MenuManageVO menuManageVO,
			@ModelAttribute("eprExcPerRepMngtVO") EPRExcPerRepMngtVO eprExcPerRepMngtVO, ModelMap model)
			throws Exception {

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(eprExcPerRepMngtVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(eprExcPerRepMngtVO.getPageUnit());
		paginationInfo.setPageSize(eprExcPerRepMngtVO.getPageSize());

		eprExcPerRepMngtVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		eprExcPerRepMngtVO.setLastIndex(paginationInfo.getLastRecordIndex());
		eprExcPerRepMngtVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		eprExcPerRepMngtVO.setSearchExcDate(eprExcPerRepMngtVO.getSearchExcDate());
		eprExcPerRepMngtVO.setSearchExcPerRepName(eprExcPerRepMngtVO.getSearchExcPerRepName());
		eprExcPerRepMngtVO
				.setEPRExcPerRepMngList(eprExcPerRepMngtService.selectEPRExcPerRepMngtList(eprExcPerRepMngtVO));
		model.addAttribute("eprExcPerRepMngList", eprExcPerRepMngtVO.getEPRExcPerRepMngList());

		int totCnt = eprExcPerRepMngtService.selectEPRExcPerRepMngtListTotCnt(eprExcPerRepMngtVO);
		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));
		model.addAttribute("list_headmenu", eprUtil.includeMenulist(menuManageVO));

		return "egovframework/com/lhb/epr/EPRExcPerRepMngt";

	}

	// 수행실적 신고 등록
	@RequestMapping(value = "/insertExcPerRep.do")
	public String insertEPRExcPerRepMngt(@ModelAttribute("eprExcPerRepMngtVO") EPRExcPerRepMngtVO eprExcPerRepMngtVO,
			BindingResult bindingResult, ModelMap model) throws Exception {

		beanValidator.validate(eprExcPerRepMngtVO, bindingResult); // validation 수행

		if (bindingResult.hasErrors()) {
			return "egovframework/com/lhb/epr/EPRExcPerRepMngt";
		} else {
			eprExcPerRepMngtService.insertEPRExcPerRepMngt(eprExcPerRepMngtVO);
			model.addAttribute("message", egovMessageSource.getMessage("success.common.insert"));
			return "redirect:/lhb/epr/selectExcPerRepListPageVw.do";
		}
	}

	// 수행실적 신고 상세
	@RequestMapping("/selectExcPerRepDtlVw.do")
	public String selectExcPerRepDtlVw(
			@ModelAttribute("menuManageVO") MenuManageVO menuManageVO,
			@ModelAttribute("searchExcPerRepDtlVO") SearchExcPerRepDtlVO searchExcPerRepDtlVO,
			ModelMap model)
			throws Exception {
	
	    PaginationInfo paginationInfoEqpmnRepVw = new PaginationInfo();
	    paginationInfoEqpmnRepVw.setCurrentPageNo(searchExcPerRepDtlVO.getEqpmnRepPageIndex());
	    paginationInfoEqpmnRepVw.setRecordCountPerPage(searchExcPerRepDtlVO.getEqpmnRepRecordCountPerPage());
	    paginationInfoEqpmnRepVw.setPageSize(searchExcPerRepDtlVO.getEqpmnRepPageSize());

	    searchExcPerRepDtlVO.setPaginationInfoForEqpmnRep(paginationInfoEqpmnRepVw);


	    EqpmnRepVwVO eqpmnRepVwVO = new EqpmnRepVwVO();
	    eqpmnRepVwVO.setSearchExcPerRepSeq(searchExcPerRepDtlVO.getSearchExcPerRepSeq());
	    eqpmnRepVwVO.setEqpmnRepVwVOList(eprExcPerRepMngtService.selectEqpmnRepVwList(searchExcPerRepDtlVO));

	    model.addAttribute("eqpmnRepVwList", eqpmnRepVwVO.getEqpmnRepVwVOList());

	    int totCntEqpmnVw = eprExcPerRepMngtService.selectEqpmnRepVwListTotCnt(searchExcPerRepDtlVO);
	    paginationInfoEqpmnRepVw.setTotalRecordCount(totCntEqpmnVw);
	    model.addAttribute("paginationInfoEqpmnRepVw", paginationInfoEqpmnRepVw);
	    
	    PaginationInfo paginationInfoExcPerRep = new PaginationInfo();
	    paginationInfoExcPerRep.setCurrentPageNo(searchExcPerRepDtlVO.getExcPerRepPageIndex());
	    paginationInfoExcPerRep.setRecordCountPerPage(searchExcPerRepDtlVO.getExcPerRepRecordCountPerPage());
	    paginationInfoExcPerRep.setPageSize(searchExcPerRepDtlVO.getExcPerRepPageSize());

	    searchExcPerRepDtlVO.setPaginationInfoForExcPerRep(paginationInfoExcPerRep);

	    ExcPerRepVO excPerRepVO = new ExcPerRepVO();
	    excPerRepVO.setSearchExcPerRepSeq(searchExcPerRepDtlVO.getSearchExcPerRepSeq());
	    excPerRepVO.setExcPerRepVOList(eprExcPerRepMngtService.selectExcPerList(searchExcPerRepDtlVO));

	    model.addAttribute("excPerRepList", excPerRepVO.getExcPerRepVOList());

	    int totCntExcPer = eprExcPerRepMngtService.selectExcPerListTotCnt(searchExcPerRepDtlVO);
	    paginationInfoExcPerRep.setTotalRecordCount(totCntExcPer);
	    model.addAttribute("paginationInfoExcPerRep", paginationInfoExcPerRep);

	    model.addAttribute("list_headmenu", eprUtil.includeMenulist(menuManageVO));
	    model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));

	    return "egovframework/com/lhb/epr/EPRExcPerRepMngtDetail";

	}
}
