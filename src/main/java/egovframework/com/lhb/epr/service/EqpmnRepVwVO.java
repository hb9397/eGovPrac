package egovframework.com.lhb.epr.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EqpmnRepVwVO extends EqpmnRepVw{
	private static final long serialVersionUID = 1L;
	
	private List<EqpmnRepVwVO> EqpmnRepVwVOList;
	
	private String searchExcPerRepSeq;
}
