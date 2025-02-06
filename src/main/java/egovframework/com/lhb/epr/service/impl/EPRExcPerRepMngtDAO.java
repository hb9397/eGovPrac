package egovframework.com.lhb.epr.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtVO;
import egovframework.com.lhb.epr.service.EqpmnRepVwVO;
import egovframework.com.lhb.epr.service.ExcPerRepVO;
import egovframework.com.lhb.epr.service.SearchExcPerRepDtlVO;

@Repository("eprExcPerRepMngtDAO")
public class EPRExcPerRepMngtDAO extends EgovComAbstractDAO{
	
    public int selectEPRExcPerRepMngtListTotCnt(EPRExcPerRepMngtVO eprExcPerRepMngtVO)  throws Exception {
        return (Integer)selectOne("eprExcPerRepMngtDAO.selectEPRExcPerRepMngtListTotCnt", eprExcPerRepMngtVO);
    }
	
	public List<EPRExcPerRepMngtVO> selectEPRExcPerRepMngtList(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception {
        return selectList("eprExcPerRepMngtDAO.selectEPRExcPerRepMngtList", eprExcPerRepMngtVO);
    }
	
    public void insertEPRExcPerRepMngt(EPRExcPerRepMngtVO eprExcPerRepMngtVO) throws Exception {
        insert("eprExcPerRepMngtDAO.insertEPRExcPerRepMngt", eprExcPerRepMngtVO);
    }
    
    public int selectEqpmnRepVwListTotCnt(SearchExcPerRepDtlVO searchExcPerRepDtlVO)  throws Exception {
        return (Integer)selectOne("eprExcPerRepMngtDAO.selectEqpmnRepVwListTotCnt", searchExcPerRepDtlVO);
    }
	
	public List<EqpmnRepVwVO> selectEqpmnRepVwList(SearchExcPerRepDtlVO searchExcPerRepDtlVO) throws Exception {
        return selectList("eprExcPerRepMngtDAO.selectEqpmnRepVwList", searchExcPerRepDtlVO);
    }
	
	public int selectExcPerListTotCnt(SearchExcPerRepDtlVO searchExcPerRepDtlVO)  throws Exception {
        return (Integer)selectOne("eprExcPerRepMngtDAO.selectExcPerListTotCnt", searchExcPerRepDtlVO);
    }
	
	public List<ExcPerRepVO> selectExcPerList(SearchExcPerRepDtlVO searchExcPerRepDtlVO) throws Exception {
        return selectList("eprExcPerRepMngtDAO.selectEqpmnRepVwList", searchExcPerRepDtlVO);
    }
}
