package egovframework.com.lhb.epr.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtVO;
import egovframework.com.sec.ram.service.AuthorManageVO;

@Repository("eprExcPerRepMngtDAO")
public class EPRExcPerRepMngtDAO extends EgovComAbstractDAO{
	
    public int selectEPRExcPerRepMngtListTotCnt(EPRExcPerRepMngtVO eprExcPerRepMngtVO)  throws Exception {
        return (Integer)selectOne("eprExcPerRepMngtDAO.selectEPRExcPerRepMngtListTotCnt", eprExcPerRepMngtVO);
    }
	
	public List<EPRExcPerRepMngtVO> selectEPRExcPerRepMngtList(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception {
        return selectList("eprExcPerRepMngtDAO.selectEPRExcPerRepMngtList", eprExcPerRepMngtVO);
    }
}
