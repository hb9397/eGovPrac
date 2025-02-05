package egovframework.com.lhb.epr.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EPRExcPerRepMngtVO extends EPRExcPerRepMngt{
	private static final long serialVersionUID = 1L;
	
	List <EPRExcPerRepMngtVO> EPRExcPerRepMngList;
	
	/*검색*/
	private String searchExcDate;
	
	private String searchExcPerRepName;
	
	/*삭제*/
	private String deleteExcDate;
}
