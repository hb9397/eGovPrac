package egovframework.com.lhb.epr.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcPerRep extends ComDefaultVO{
	private static final long serialVersionUID = 1L;
	
	private String excPerRepSeq;
	
	private String perNo;
	
	private String servcName;
	
	private String servcSeCode;
	
	private String servcSeName;
	
	private String cntrctAmount;
	
	private String chargerName;
	
	private String servc;
	
	private String regDate;
	
	private String regId;
	
	private String cngDate;
	
	private String cngId;
	
	private String delDate;
	
	private String delId;
}
