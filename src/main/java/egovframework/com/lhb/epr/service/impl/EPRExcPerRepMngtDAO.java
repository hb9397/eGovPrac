package egovframework.com.lhb.epr.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.lhb.epr.service.EPRExcPerRepMngtVO;
import egovframework.com.lhb.epr.service.EqpmnRepVwVO;
import egovframework.com.lhb.epr.service.ExcPerRepVO;

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
    
    public int selectEqpmnRepVwListTotCnt(EqpmnRepVwVO eqpmnRepVwVO)  throws Exception {
        return (Integer)selectOne("eprExcPerRepMngtDAO.selectEqpmnRepVwListTotCnt", eqpmnRepVwVO);
    }
	
	public List<EqpmnRepVwVO> selectEqpmnRepVwList(EqpmnRepVwVO eqpmnRepVwVO) throws Exception {
        return selectList("eprExcPerRepMngtDAO.selectEqpmnRepVwList", eqpmnRepVwVO);
    }
	
	public int selectExcPerListTotCnt(ExcPerRepVO excPerRepVO)  throws Exception {
        return (Integer)selectOne("eprExcPerRepMngtDAO.selectExcPerListTotCnt", excPerRepVO);
    }
	
	public List<ExcPerRepVO> selectExcPerList(ExcPerRepVO excPerRepVO) throws Exception {
        return selectList("eprExcPerRepMngtDAO.selectEqpmnRepVwList", excPerRepVO);
    }
}
