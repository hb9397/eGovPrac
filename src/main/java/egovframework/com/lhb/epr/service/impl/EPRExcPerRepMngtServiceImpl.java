package egovframework.com.lhb.epr.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.com.lhb.epr.service.EPRExcPerRepMngtService;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("ePRExcPerRepMngtService")
public class EPRExcPerRepMngtServiceImpl extends EgovAbstractServiceImpl implements EPRExcPerRepMngtService{
	private final EPRExcPerRepMngtDAO eprExcPerRepMngtDAO;

	@Override
	public int selectEPRExcPerRepMngtListTotCnt(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception {
		return eprExcPerRepMngtDAO.selectEPRExcPerRepMngtListTotCnt(eprExcPerRepMngtVO);
	}
	
	@Override
	public List<EPRExcPerRepMngtVO> selectEPRExcPerRepMngtList(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception {
		return eprExcPerRepMngtDAO.selectEPRExcPerRepMngtList(eprExcPerRepMngtVO);
	}

	@Override
	public void insertEPRExcPerRepMngt(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception {
		eprExcPerRepMngtDAO.insertEPRExcPerRepMngt(eprExcPerRepMngtVO);
	}
}
