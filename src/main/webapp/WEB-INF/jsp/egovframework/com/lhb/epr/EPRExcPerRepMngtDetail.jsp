<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수행실적목록 조회</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/lhb/epr/EPRExcPerRepMngtDetail.css' />">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수행실적 관리</title>
<p></p>
<script>
	function openModal(id) {
		document.getElementById(id).style.display = "flex";
	}

	function closeModal(id) {
		document.getElementById(id).style.display = "none";
	}
	function getAllExcPerRepSeq() {
		console.log(${param.excModalPerRepSeq});
		
	}

	
</script>
</head>
<body>

	<noscript class="noScriptTitle">
		<spring:message code="common.noScriptTitle.msg" />
	</noscript>
	<div class="header-container">
		<jsp:include page="../../head.jsp" />
	</div>
	<form name='listForm'>
		<div class="container" style="margin-top: 2rem;">
			<div style="border: 2px solid #000; display: flex; flex-direction: column; align-items: flex-start; justify-content: center; border-radius: 5px; width: 100%; height: 6rem; margin-bottom: 2rem">
				<h2 style="margin-left: 1rem;">${param.excModalPerRepSeq}수행실적정보</h2>
				<div style="width: 98%">
					<table border="1" style="border-collapse: collapse; margin-left: 1rem;">
						<tr>
							<th style="padding: 5px; width: 20%";>수행년도</th>
							<td style="padding: 5px; width: 30%;">2023</td>
							<th style="padding: 5px; width: 20%;">수행 명</th>
							<td style="padding: 5px; width: 30%;">2023년도 수행실적</td>
						</tr>
					</table>
				</div>
			</div>



			<div style="border: 2px solid #000; border-radius: 5px; margin-bottom: 2rem; padding: 15px;">
				<h2 style="padding-left: 10px;">장비신고 목록</h2>
				<table style="width: 100%; border-collapse: collapse; margin-top: 10px;">
					<thead>
						<tr>
							<th>장비일련련번호</th>
							<th>장비명</th>
							<th>규격</th>
							<th>등록번호</th>
							<th>등급</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${fn:length(eqpmnRepVwList) == 0}">
							<tr>
								<td colspan=""><spring:message code="common.nodata.msg" /></td>
							</tr>
						</c:if>
						<c:forEach var="eqpmnRepVwList" items="${eqpmnRepVwList}" varStatus="status">
							<tr>
								<td class="table-cell"><c:out value="${eqpmnRepVwList.eqpmnNo}" /></td>
								<td class="table-cell"><c:out value="${eqpmnRepVwList.eqpmnName}" /></td>
								<td class="table-cell"><c:out value="${eqpmnRepVwList.stndrd}" /></td>
								<td class="table-cell"><c:out value="${eqpmnRepVwList.regNo}" /></td>
								<td class="table-cell"><c:out value="${eqpmnRepVwList.gradName}" /></td>
								<td><button>X</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="width: 100%; display: flex; justify-content: flex-end; align-items: center; margin-top: 10px;">
					<button onclick="openModal('equipmentModal')">장비 등록</button>
				</div>
				<c:if test="${!empty eqpmnRepVwVO.pageIndex }">
					<!-- paging navigation -->
					<div div class="pagination" style="display: flex; justify-content: center; align-item: center; text-align: center; margin-top: 20px;">
						<ul id="pagination" style="display: flex; justify-content: center; align-item: center; text-align: center;">
							<ui:pagination paginationInfo="${paginationInfoEqpmnRepVw}" type="image" jsFunction="linkPage" />
						</ul>
					</div>
				</c:if>
			</div>

			<div style="border: 2px solid #000; border-radius: 5px; padding: 15px;">
				<h2 style="margin-left: 1rem;">실적신고 목록</h2>
				<table style="width: 100%; border-collapse: collapse; margin-top: 10px;">
					<thead>
						<tr>
							<th>실적일련번호</th>
							<th>용역명</th>
							<th>용역구분명</th>
							<th>계약금액</th>
							<th>담당자</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${fn:length(eqpmnRepVwList) == 0}">
							<tr>
								<td colspan="6"><spring:message code="common.nodata.msg" /></td>
							</tr>
						</c:if>
						<c:forEach var="eqpmnRepVwList" items="${excPerRepList}" varStatus="status">
							<tr>
								<td class="table-cell"><c:out value="${excPerRepList.perNo}" /></td>
								<td class="table-cell"><c:out value="${excPerRepList.servcName}" /></td>
								<td class="table-cell"><c:out value="${excPerRepList.servcSeName}" /></td>
								<td class="table-cell"><c:out value="${excPerRepList.cntrctAmount}" /></td>
								<td class="table-cell"><c:out value="${excPerRepList.chargerName}" /></td>
								<td><button>X</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="width: 100%; display: flex; justify-content: flex-end; align-items: center; margin-top: 10px">
					<button onclick="openModal('performanceModal')">실적 등록</button>

				</div>
				<c:if test="${!empty excPerRepVO.pageIndex }">
					<!-- paging navigation -->
					<div div class="pagination" style="display: flex; justify-content: center; align-item: center; text-align: center; margin-top: 20px;">
						<ul id="pagination" style="display: flex; justify-content: center; align-item: center; text-align: center;">
							<ui:pagination paginationInfo="${paginationInfoExcPerRep}" type="image" jsFunction="linkPage" />
						</ul>
					</div>
				</c:if>
			</div>
			<div style="display: flex; justify-content: space-between; align-items; margin-top: 10px;">
				<button onClick="">목록</button>
				<button onClick="getAllExcPerRepSeq();" class="submit-btn">제출</button>
			</div>

		</div>

		<!-- 장비 등록 모달 -->
		<div id="equipmentModal" class="modal">
			<div class="modal-content">
				<span class="close-btn" onclick="closeModal('equipmentModal')">&times;</span>
				<h2>장비 등록</h2>
				<label>장비명: <input type="text"></label> <label>규격: <input type="text"></label> <label>등록번호: <input type="text"></label>
				<button onclick="closeModal('equipmentModal')">저장</button>
			</div>
		</div>

		<!-- 실적 등록 모달 -->
		<div id="performanceModal" class="modal">
			<div class="modal-content">
				<span class="close-btn" onclick="closeModal('performanceModal')">&times;</span>
				<h2>실적 등록</h2>
				<label>용역명: <input type="text"></label> <label>용역구분명: <input type="text">
				</label> <label>계약금액: <input type="text"></label>
				<button onclick="closeModal('performanceModal')">저장</button>
			</div>
		</div>
	</form>
</body>
</html>
