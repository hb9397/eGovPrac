package egovframework.com.lhb.epr.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EPRExcPerRepMngt extends ComDefaultVO{
	private static final long serialVersionUID = 1L;
	
	private String excPerRepSeq;
	
	private String excPerRepName;
	
	private String progrsStatCode;
	
	private String progrsStatName;
	
	private String excDate;
	
	private String regDate;
	
	private String regID;
	
	private String cngDate;
	
	private String cngID;

}
