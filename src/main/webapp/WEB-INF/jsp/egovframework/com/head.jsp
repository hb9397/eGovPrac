<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="egovframework.com.cmm.util.EgovUserDetailsHelper"%>

<script language="text/javascript" src="<c:url value='/js/egovframework/com/main.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/main_portal.css' />">
<link type="text/css" rel="stylesheet" href="/css/egovframework/com/cmm/jqueryui.css">

<script src="<c:url value='/js/egovframework/com/cmm/jquery.js' />"></script>
<script src="<c:url value='/js/egovframework/com/cmm/jqueryui.js' />"></script>

<script type="text/javascript">
var $dialog;

$(document).ready(function () {
    // 초기에는 iframe 숨기기
    $("#submenu-container").hide();

    // 문서 전체 클릭 이벤트 감지하여 iframe 숨김 처리
    $(document).click(function(event) {
        var submenu = $("#submenu-container");
        var clickedElement = $(event.target);

        // iframe 바깥을 클릭하면 숨김
        if (!clickedElement.closest("#submenu-container").length && !clickedElement.closest("#new_topnavi").length) {
            submenu.hide();
        }
    });
});

// 메뉴 팝업 열기
function fn_openMenuPopup(menuNo) {
    var pagetitle = "<spring:message code='comCmm.unitContent.20'/>"; // 비밀번호 유효기간 만료 안내
    var page = "${pageContext.request.contextPath}/sym/mnu/mpm/EgovMainMenuLeft.do?vStartP=" + menuNo;

    $dialog = $('<div style="overflow:hidden;padding: 0px 0px 0px 0px;"></div>')
        .html('<iframe style="border: 0px;" src="' + page + '" width="100%" height="100%"></iframe>')
        .dialog({
            autoOpen: false,
            modal: true,
            width: 600,
            height: 550,
            title: pagetitle,
            dialogClass: 'headTitleClass'
        });

    $dialog.dialog('open');
}

// 상위 메뉴 클릭 시 iframe 로드 및 표시
function fn_main_headPageMove(menuNo, url) {
    $("#submenu-container").show(); // iframe 컨테이너 표시

    document.selectOne.menuNo.value = menuNo;
    document.selectOne.vStartP.value = menuNo;
    document.selectOne.action = "<c:url value='/sym/mnu/mpm/EgovMainMenuLeft.do'/>";
    document.selectOne.target = "frmSubMemnuList";
    document.selectOne.submit();
}

// 로그아웃 처리
function actionLogout() {
    document.selectOne.action = "<c:url value='/uat/uia/actionLogout.do'/>";
    document.selectOne.submit();
}

// iframe 높이 자동 조절
function resizeIframe() {
    var iframe = document.getElementById("subMenuIframe");
    if (iframe && iframe.contentWindow && iframe.contentWindow.document.body) {
        iframe.style.height = iframe.contentWindow.document.body.scrollHeight + "px";
    }
}

// iframe이 로드될 때 높이 조정
document.addEventListener("DOMContentLoaded", function() {
    var iframe = document.getElementById("subMenuIframe");
    if (iframe) {
        iframe.onload = resizeIframe;
    }
});
</script>

<form name="selectOne">
	<input name="menuNo" type="hidden" /> <input name="chkURL" type="hidden" /> <input name="vStartP" type="hidden" />

	<!-- 상단 로고 및 사용자 정보 -->
	<div id="gnb">
		<div id="top_logo">
			<a href="<c:url value='/sym/mnu/mpm/EgovMainMenuHome.do' />" target="_top"> <img src="<c:url value='/images/egovframework/com/cmm/main/logo_01.gif' />" alt="egovframe" />
			</a>
		</div>
		<div id="use_descri">
			<ul>
				<li><spring:message code="comSymMnuMpm.head.head" /></li>
				<!-- 공통서비스 테스트 사이트 -->
				<li><a href="javascript:actionLogout()"> <img src="<c:url value='/images/egovframework/com/cmm/main/logout_btn.gif' />" alt="로그아웃" />
				</a></li>
			</ul>
		</div>
	</div>

	<!-- 상위 메뉴 -->
	<div id="new_topnavi">
		<ul>
			<li><a href="<c:url value='/sym/mnu/mpm/EgovMainMenuHome.do' />" target="_top">HOME</a></li>
			<c:forEach var="result" items="${list_headmenu}" varStatus="status">
				<script>

			</script>

				<li class="gap">l</li>
				<li><a href="javascript:fn_main_headPageMove('<c:out value="${result.menuNo}"/>','<c:out value="${result.chkURL}"/>')"> <c:out value="${result.menuNm}" />
				</a></li>
			</c:forEach>
		</ul>
	</div>

	<!-- 하위 메뉴 (iframe) -->
	<div id="submenu-container" style="display: none;">
		<iframe id="subMenuIframe" name="frmSubMemnuList" src="" width="100%" border="0" frameborder="no" scrolling="no"></iframe>
	</div>
</form>
