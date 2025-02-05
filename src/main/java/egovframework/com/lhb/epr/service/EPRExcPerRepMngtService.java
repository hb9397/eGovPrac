package egovframework.com.lhb.epr.service;

import java.util.List;

import egovframework.com.sec.ram.service.AuthorManage;

public interface EPRExcPerRepMngtService {
	
	public int selectEPRExcPerRepMngtListTotCnt(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception;

	public List<EPRExcPerRepMngtVO> selectEPRExcPerRepMngtList(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception;
	
	public void insertEPRExcPerRepMngt(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception;
}
