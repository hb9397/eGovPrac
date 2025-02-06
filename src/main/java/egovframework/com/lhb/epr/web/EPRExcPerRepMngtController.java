package egovframework.com.lhb.epr.web;

import java.util.List;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.SessionVO;
import egovframework.com.lhb.epr.com.EPRUtil;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtService;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtVO;
import egovframework.com.lhb.epr.service.EqpmnRepVwVO;
import egovframework.com.lhb.epr.service.ExcPerRepVO;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;
import lombok.RequiredArgsConstructor;

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
			@ModelAttribute("eqpmnRepVwVO") EqpmnRepVwVO eqpmnRepVwVO,
			@ModelAttribute("excPerRepVO") ExcPerRepVO excPerRepVO, 
			ModelMap model)
			throws Exception {
		
		 // 장비 
		 PaginationInfo paginationInfoEqpmnRepVw = new PaginationInfo();
		 paginationInfoEqpmnRepVw.setCurrentPageNo(eqpmnRepVwVO.getPageIndex());
		 paginationInfoEqpmnRepVw.setRecordCountPerPage(eqpmnRepVwVO.getPageUnit());
		 paginationInfoEqpmnRepVw.setPageSize(eqpmnRepVwVO.getPageSize());
		 
		 eqpmnRepVwVO.setFirstIndex(paginationInfoEqpmnRepVw.getFirstRecordIndex());
		 eqpmnRepVwVO.setLastIndex(paginationInfoEqpmnRepVw.getLastRecordIndex());
		 eqpmnRepVwVO.setRecordCountPerPage(paginationInfoEqpmnRepVw.getRecordCountPerPage());
		 
		 eqpmnRepVwVO.setSearchExcPerRepSeq(eqpmnRepVwVO.getExcPerRepSeq());
		 eqpmnRepVwVO.setEqpmnRepVwVOList(eprExcPerRepMngtService.selectEqpmnRepVwList(eqpmnRepVwVO));
		 model.addAttribute("eqpmnRepVwList",eqpmnRepVwVO.getEqpmnRepVwVOList());
		 
		 int totCntEqpmnVw = eprExcPerRepMngtService.selectEqpmnRepVwListTotCnt(eqpmnRepVwVO);
		 paginationInfoEqpmnRepVw.setTotalRecordCount(totCntEqpmnVw);
		 
		 model.addAttribute("paginationInfoEqpmnRepVw", paginationInfoEqpmnRepVw);
		 
		 // 실적
		 PaginationInfo paginationInfoExcPerRep = new PaginationInfo();
		 paginationInfoExcPerRep.setCurrentPageNo(excPerRepVO.getPageIndex());
		 paginationInfoExcPerRep.setRecordCountPerPage(excPerRepVO.getPageUnit());
		 paginationInfoExcPerRep.setPageSize(excPerRepVO.getPageSize());
		 
		 excPerRepVO.setFirstIndex(paginationInfoExcPerRep.getFirstRecordIndex());
		 excPerRepVO.setLastIndex(paginationInfoExcPerRep.getLastRecordIndex());
		 excPerRepVO.setRecordCountPerPage(paginationInfoExcPerRep.getRecordCountPerPage());
		 
		 excPerRepVO.setSearchExcPerRepSeq(excPerRepVO.getExcPerRepSeq());
		 excPerRepVO.setExcPerRepVOList(eprExcPerRepMngtService.selectExcPerList(excPerRepVO));
		 model.addAttribute("excPerRepList",excPerRepVO.getExcPerRepVOList());
		 
		 int totCntExcPer = eprExcPerRepMngtService.selectExcPerListTotCnt(excPerRepVO);
		 paginationInfoExcPerRep.setTotalRecordCount(totCntExcPer);
		 
		 model.addAttribute("paginationInfoExcPerRep", paginationInfoExcPerRep);
		 
		 
		 model.addAttribute("list_headmenu", eprUtil.includeMenulist(menuManageVO));
		 model.addAttribute("message",egovMessageSource.getMessage("success.common.select"));

		return "egovframework/com/lhb/epr/EPRExcPerRepMngtDetail";

	}
}
