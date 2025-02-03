package egovframework.com.lhb.epr.service;

import java.util.List;

public interface EPRExcPerRepMngtService {
	
	public int selectEPRExcPerRepMngtListTotCnt(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception;

	public List<EPRExcPerRepMngtVO> selectEPRExcPerRepMngtList(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception;
}
