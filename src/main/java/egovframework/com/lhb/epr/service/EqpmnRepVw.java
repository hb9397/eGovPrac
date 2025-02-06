package egovframework.com.lhb.epr.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EqpmnRepVw extends ComDefaultVO{
	private static final long serialVersionUID = 1L;
	
	private String excPerRepSeq;
	
	private String eqpmnNo;
	
	private String eqpmnName;
	
	private String stndrd;
	
	private String regNo;
	
	private String gradCode;
	
	private String gradName;
	
	private String regDate;
	
	private String regId;
	
	private String cngDate;
	
	private String cngId;
	
	private String delDate;
	
	private String delId;
}
