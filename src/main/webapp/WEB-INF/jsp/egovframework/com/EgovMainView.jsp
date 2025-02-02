<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="comSymMnuMpm.mainView.mainViewTitle"/></title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
<script language="javascript" src="<c:url value='/js/egovframework/com/main.js' />"></script>
<script language="javascript">
function chk_all(val) {
    var arr_chk = document.getElementsByName("chk");
    if (val == "Y") {
        for (i = 0; i < arr_chk.length; i++) {
            arr_chk[i].checked = true;
        }
    } else if (val == "N") {
        for (i = 0; i < arr_chk.length; i++) {
            arr_chk[i].checked = false;
        }
    }
}
</script>
</head>

<body>

<!-- header -->
<div id="header-container">
    <c:import url="./head.jsp" />
</div>

<!-- contents -->
<div id="content-wrapper">
    <div class="mp_top">
        <div class="l">
            <div class="content-container">
                <c:import url="/WEB-INF/jsp/egovframework/com/cmm/EgovUnitContent.jsp" />
            </div>
        </div>
    </div>

    <%--  
    <div class="r">
        <h3 class="m_tit01 mt15"><spring:message code="comSymMnuMpm.mainView.selectBBSListPortlet"/></h3>
        <div style="height:150px">
            <c:import url="/cop/bbs/selectBBSListPortlet.do" />
        </div>
        
        <h3 class="m_tit01 mt15"><spring:message code="comSymMnuMpm.mainView.selectCommuMasterListPortlet"/></h3>
        <div style="height:150px">
            <c:import url="/cop/cmy/selectCommuMasterListPortlet.do" />
        </div>
        
        <h3 class="m_tit01 mt15"><spring:message code="comSymMnuMpm.mainView.selectBlogListPortlet"/></h3>
        <div style="height:150px">
            <c:import url="/cop/bbs/selectBlogListPortlet.do" />
        </div>
    </div>
    --%>  

    <%--  
    <h3 class="m_tit01 mt15"><spring:message code="comSymMnuMpm.mainView.getBannerImage"/></h3>
    <div class="mp_bn">
        <c:import url="/uss/ion/bnr/getBannerImage.do" charEncoding="utf-8">
            <c:param name="atchFileId" value="${banner.bannerImageFile}" />
        </c:import>
    </div>
    --%>

    <!-- bottom -->
    <c:import url="./main_bottom.jsp" />
</div>

</body>
</html>
