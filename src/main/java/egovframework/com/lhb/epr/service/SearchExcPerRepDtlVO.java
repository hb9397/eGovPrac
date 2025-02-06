package egovframework.com.lhb.epr.service;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.com.cmm.ComDefaultVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchExcPerRepDtlVO extends ComDefaultVO {
	private static final long serialVersionUID = 1L;

    private String searchExcPerRepSeq;

    private int eqpmnRepPageIndex;
    private int eqpmnRepRecordCountPerPage;
    private int eqpmnRepPageSize;
    private int eqpmnRepFirstIndex;
    private int eqpmnRepLastIndex;

    private int excPerRepPageIndex;
    private int excPerRepRecordCountPerPage;
    private int excPerRepPageSize;
    private int excPerRepFirstIndex;
    private int excPerRepLastIndex;

    public void setPaginationInfoForEqpmnRep(PaginationInfo paginationInfo) {
        this.eqpmnRepPageIndex = paginationInfo.getCurrentPageNo();
        this.eqpmnRepRecordCountPerPage = paginationInfo.getRecordCountPerPage();
        this.eqpmnRepPageSize = paginationInfo.getPageSize();
        this.eqpmnRepFirstIndex = paginationInfo.getFirstRecordIndex();
        this.eqpmnRepLastIndex = paginationInfo.getLastRecordIndex();
    }

    public void setPaginationInfoForExcPerRep(PaginationInfo paginationInfo) {
        this.excPerRepPageIndex = paginationInfo.getCurrentPageNo();
        this.excPerRepRecordCountPerPage = paginationInfo.getRecordCountPerPage();
        this.excPerRepPageSize = paginationInfo.getPageSize();
        this.excPerRepFirstIndex = paginationInfo.getFirstRecordIndex();
        this.excPerRepLastIndex = paginationInfo.getLastRecordIndex();
    }
}

