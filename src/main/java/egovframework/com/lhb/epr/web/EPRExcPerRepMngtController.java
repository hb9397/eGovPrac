package egovframework.com.lhb.epr.web;

import java.util.List;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.SessionVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtService;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtVO;
import egovframework.com.sym.mnu.mpm.service.EgovMenuManageService;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@SessionAttributes(types=SessionVO.class)
@RequestMapping("/lhb/epr")
public class EPRExcPerRepMngtController {
	
	private final EgovMessageSource egovMessageSource;
	
	protected final EgovPropertyService propertiesService;
	
	private final DefaultBeanValidator beanValidator;
	
	private final EgovMenuManageService menuManageService;
	
	private final EPRExcPerRepMngtService eprExcPerRepMngtService;
	
    @RequestMapping("/EPRExcPerRepMngt.do")
    public String selectEPRExcPerRepMngtList(@ModelAttribute("menuManageVO") MenuManageVO menuManageVO, 
    		@ModelAttribute("eprExcPerRepMngtVO") EPRExcPerRepMngtVO eprExcPerRepMngtVO, ModelMap model) throws Exception {
    	
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
        
        // 현재 리턴 페이지에서 메뉴 보이게 하려고.,,.,. 사실 jsp 급하게 해서 head.jsp 를 모든 새로운 페이지가 따로 조회하는 형태가 되버림
        LoginVO user =
    			(LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();

    		// 미인증 사용자에 대한 보안처리
        	if(user == null) {
    			return "index";
        	}

        	menuManageVO.setTmpId(user.getId());
        	menuManageVO.setTmpPassword(user.getPassword());
        	menuManageVO.setTmpUserSe(user.getUserSe());
        	menuManageVO.setTmpName(user.getName());
        	menuManageVO.setTmpEmail(user.getEmail());
        	menuManageVO.setTmpOrgnztId(user.getOrgnztId());
        	menuManageVO.setTmpUniqId(user.getUniqId());

    		List<?> list_headmenu = menuManageService.selectMainMenuHead(menuManageVO);
    		model.addAttribute("list_headmenu", list_headmenu);
    	
        return "egovframework/com/lhb/epr/EPRExcPerRepMngt";
    }
}
