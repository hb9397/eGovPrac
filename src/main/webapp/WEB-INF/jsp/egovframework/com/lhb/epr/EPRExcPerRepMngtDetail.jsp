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
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/cmm/jqueryui.css' />">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/lhb/epr/EPRExcPerRepMngtDetail.css' />">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수행실적 관리</title>
<link rel="stylesheet" type="text/css" href="performance_report.css">
<script>
	function openModal(id) {
		document.getElementById(id).style.display = "flex";
	}

	function closeModal(id) {
		document.getElementById(id).style.display = "none";
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

	<div class="container" style="margin-top: 2rem">
		<h2>수행실적정보</h2>
		<label>수행년도: <input type="text" value="2023"></label> <label>수행
			명: <input type="text" value="2023년도 수행실적">
		</label>

		<h3>장비신고 목록</h3>
		<table>
			<thead>
				<tr>
					<th>장비인련번호</th>
					<th>장비명</th>
					<th>규격</th>
					<th>등록번호</th>
					<th>등급</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>2023010001</td>
					<td>장비1</td>
					<td>규격1</td>
					<td>000001</td>
					<td>1등급</td>
					<td><button>X</button></td>
				</tr>
				<tr>
					<td>2023010002</td>
					<td>장비2</td>
					<td>규격2</td>
					<td>000002</td>
					<td>2등급</td>
					<td><button>X</button></td>
				</tr>
			</tbody>
		</table>
		<button onclick="openModal('equipmentModal')">장비 등록</button>

		<h3>실적신고 목록</h3>
		<table>
			<thead>
				<tr>
					<th>실적인련번호</th>
					<th>용역명</th>
					<th>용역구분명</th>
					<th>계약금액</th>
					<th>담당자</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>2023010001</td>
					<td>용역1</td>
					<td>GIS</td>
					<td>123,000,000</td>
					<td>예윤지</td>
					<td><button>X</button></td>
				</tr>
				<tr>
					<td>2023010002</td>
					<td>용역2</td>
					<td>부동산</td>
					<td>5,000,000</td>
					<td>이승은</td>
					<td><button>X</button></td>
				</tr>
			</tbody>
		</table>
		<button onclick="openModal('performanceModal')">실적 등록</button>

		<button class="submit-btn">제출</button>
	</div>

	<!-- 장비 등록 모달 -->
	<div id="equipmentModal" class="modal">
		<div class="modal-content">
			<span class="close-btn" onclick="closeModal('equipmentModal')">&times;</span>
			<h2>장비 등록</h2>
			<label>장비명: <input type="text"></label> <label>규격: <input
				type="text"></label> <label>등록번호: <input type="text"></label>
			<button onclick="closeModal('equipmentModal')">저장</button>
		</div>
	</div>

	<!-- 실적 등록 모달 -->
	<div id="performanceModal" class="modal">
		<div class="modal-content">
			<span class="close-btn" onclick="closeModal('performanceModal')">&times;</span>
			<h2>실적 등록</h2>
			<label>용역명: <input type="text"></label> <label>용역구분명:
				<input type="text">
			</label> <label>계약금액: <input type="text"></label>
			<button onclick="closeModal('performanceModal')">저장</button>
		</div>
	</div>

</body>
</html>
