package egovframework.com.lhb.epr.com;

import java.util.List;

import org.springframework.stereotype.Component;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.sym.mnu.mpm.service.EgovMenuManageService;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EPRUtil {
	private final EgovMenuManageService menuManageService;
	
	public List<?> includeMenulist(MenuManageVO menuManageVO) throws Exception{
		// 현재 리턴 페이지에서 메뉴 보이게 하려고.,,.,. 사실 jsp 급하게 해서 head.jsp 를 모든 새로운 페이지가 따로 조회하는 형태가 되버림
        LoginVO user =
    			(LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();

    		// 미인증 사용자에 대한 보안처리
        	if(user == null) {
    			return null;
        	}

        	menuManageVO.setTmpId(user.getId());
        	menuManageVO.setTmpPassword(user.getPassword());
        	menuManageVO.setTmpUserSe(user.getUserSe());
        	menuManageVO.setTmpName(user.getName());
        	menuManageVO.setTmpEmail(user.getEmail());
        	menuManageVO.setTmpOrgnztId(user.getOrgnztId());
        	menuManageVO.setTmpUniqId(user.getUniqId());

    		return menuManageService.selectMainMenuHead(menuManageVO);
	}
}
