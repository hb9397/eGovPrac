package egovframework.com.lhb.epr.web;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.SessionVO;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtService;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtVO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@SessionAttributes(types=SessionVO.class)
@RequestMapping("/lhb/epr")
public class EPRExcPerRepMngtController {
	
	private final EgovMessageSource egovMessageSource;
	
	protected final EgovPropertyService propertiesService;
	
	private final DefaultBeanValidator beanValidator;
	
	private final EPRExcPerRepMngtService eprExcPerRepMngtService;
	
    @RequestMapping("/EPRExcPerRepMngt.do")
    public String selectEPRExcPerRepMngtList(@ModelAttribute("eprExcPerRepMngtVO") EPRExcPerRepMngtVO eprExcPerRepMngtVO, 
    			ModelMap model) throws Exception {
    	
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(eprExcPerRepMngtVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(eprExcPerRepMngtVO.getPageUnit());
		paginationInfo.setPageSize(eprExcPerRepMngtVO.getPageSize());
		
		eprExcPerRepMngtVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		eprExcPerRepMngtVO.setLastIndex(paginationInfo.getLastRecordIndex());
		eprExcPerRepMngtVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		eprExcPerRepMngtVO.setEPRExcPerRepMngList(eprExcPerRepMngtService.selectEPRExcPerRepMngtList(eprExcPerRepMngtVO));
        model.addAttribute("eprExcPerRepMngList", eprExcPerRepMngtVO.getEPRExcPerRepMngList());
        
        int totCnt = eprExcPerRepMngtService.selectEPRExcPerRepMngtListTotCnt(eprExcPerRepMngtVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));
    	
        return "egovframework/com/lhb/epr/EPRExcPerRepMngt";
    }
}
