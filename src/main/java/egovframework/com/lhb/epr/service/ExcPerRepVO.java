package egovframework.com.lhb.epr.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcPerRepVO extends ExcPerRep{
	private static final long serialVersionUID = 1L;
	
	private List<ExcPerRepVO> ExcPerRepVOList;
	
	private String searchExcPerRepSeq;
}
