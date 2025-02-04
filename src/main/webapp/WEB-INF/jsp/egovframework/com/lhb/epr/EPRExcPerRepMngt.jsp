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
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/lhb/epr/EPRExcPerRepMngt.css' />">

<script>
	function fncSelectEPRExcPerRepMngtList(pageNo) {
	    document.listForm.searchCondition.value = "1";
	    document.listForm.pageIndex.value = pageNo;
		document.listForm.submit();
		console.log(pageNo)	    
	}
	function linkPage(pageNo) {
		document.listForm.pageIndex.value = pageNo;
		document.listForm.action = "<c:url value='/lhb/epr/EPRExcPerRepMngt.do'/>";
		document.listForm.submit();
	}
	function press() {

		if (event.keyCode == 13) {
			fncSelectAuthorList('1');
		}
	}
</script>
</head>

<body>
	<noscript class="noScriptTitle">
		<spring:message code="common.noScriptTitle.msg" />
	</noscript>
		<div class="header-container">
			<c:import url="../../head.jsp" />
		</div>
	<form name="listForm" action="<c:url value='/lhb/epr/EPRExcPerRepMngt.do'/>" method="post">


		<div class="container">
			<h2 class="mt10">수행실적목록 조회</h2>
			<div class="search-section">
				<h3 style="margin-bottom: 15px">▶ 조회조건</h3>
				<div style="margin-bottom: 10px">
					<label for="year">수행년도</label> <select class="yearSelector" id="yearSelector">
						<script>
							const yearSelect = document
									.getElementById("yearSelector");
							const currentYear = new Date().getFullYear();
							const selectedYear = "<c:out value='${eprExcPerRepMngtVO.excDate}'/>"; // 서버에서 받은 값

							// 기본 선택 옵션 추가
							const defaultOption = document
									.createElement("option");
							defaultOption.value = "";
							defaultOption.textContent = "선택 안함";
							yearSelect.appendChild(defaultOption);

							// 연도 추가 (현재 연도 -10 ~ 현재 연도 +10)
							for (let i = currentYear - 10; i <= currentYear + 10; i++) {
								let option = document.createElement("option");
								option.value = i;
								option.textContent = i;

								// 서버에서 가져온 값과 같은 경우 선택됨
								if (i == selectedYear) {
									option.selected = true;
								}

								yearSelect.appendChild(option);
							}
						</script>
					</select>

					<script>
						document.addEventListener("DOMContentLoaded", 
								function() {
											const yearSelect = document.getElementById("yearSelector");
											const yearInput = document.getElementById("selectedYear");
											// 값이 변경될 때 hidden input에 설정
											yearSelect.addEventListener("change",function() {yearInput.value = yearSelect.value;});
										});
					</script>
					<!-- listForm에 hidden input 추가 -->
					<input type="hidden" name="excDate" id="selectedYear" value="<c:out value='${eprExcPerRepMngtVO.excDate}'/>" />

					
				</div>
				<div style="margin-bottom: 1rem">
					<label>수행명</label> <input type="text" style="margin-left: 0.8rem" name="excPerRepName" value="<c:out value='${eprExcPerRepMngtVO.excPerRepName}'/>">
				</div>
				<div>
					<input type="submit" class="long_btn" value="조회" title="조회"/>
				</div>
			</div>

			<div class="results-section mt10">
				<div style="width: 100%; display: flex; justify-content: space-between; align-items: center">
					<h3>▶ 수행실적 조회내역</h3>
					<button class="btn">등록</button>
				</div>
				<table>
					<thead>
						<tr>
							<%-- <th><input type="checkbox" name="checkAll" class="check2" onclick="javascript:fncCheckAll()" title="<spring:message code="input.selectAll.title" />"></th><!-- 번호 --> --%>

							<th class="table-header">수행년도</th>
							<th class="table-header">수행명</th>
							<th class="table-header">진행상태</th>
							<th class="table-header">수정일시</th>

						</tr>
					</thead>
					<tbody class="data-table-body" id="data-table-body">
						<c:if test="${fn:length(eprExcPerRepMngList) == 0}">
							<tr>
								<td colspan="4"><spring:message code="common.nodata.msg" /></td>
							</tr>
						</c:if>
						<c:forEach var="eprExcPerRepMngList" items="${eprExcPerRepMngList}" varStatus="status">
							<tr>
								<%-- <td><input type="checkbox" name="delYn" class="check2" title="선택"><input type="hidden" name="checkId" value="<c:out value="${author.authorCode}"/>" /></td> --%>
								<%-- <td><a href="#LINK"
								onclick="javascript:fncSelectAuthor('<c:out value="${eprExcPerRepMngList.excDate}"/>')"><c:out
										value="${author.authorCode}" /></a></td> --%>

								<td class="table-cell"><c:out value="${eprExcPerRepMngList.excDate}" /></td>
								<td class="table-cell"><c:out value="${eprExcPerRepMngList.excPerRepName}" /></td>
								<td class="table-cell"><c:out value="${eprExcPerRepMngList.progrsStatCode}" /></td>
								<td class="table-cell"><c:choose>
										<c:when test="${not empty eprExcPerRepMngList.cngDate}">
											<c:out value="${eprExcPerRepMngList.cngDate}" />
										</c:when>
										<c:otherwise>-</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:if test="${!empty eprExcPerRepMngtVO.pageIndex }">
					<!-- paging navigation -->
					<div div class="pagination" style="display: flex; justify-content: center; align-item: center; text-align: center; margin-top: 20px;">
						<ul id="pagination" style="display: flex; justify-content: center; align-item: center; text-align: center;">
							<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
						</ul>
					</div>
				</c:if>
			</div>
		</div>

		<input type="hidden" name="pageIndex" value="<c:out value='${eprExcPerRepMngtVO.pageIndex}'/>" />
		<%-- <input type="hidden" name="excDate" value="<c:out value='${eprExcPerRepMngtVO.excDate}'/>" />
		<input type="hidden" name="excPerRepName" value="<c:out value='${eprExcPerRepMngtVO.excPerRepName}'/>" /> --%>
		<!-- <input type="submit" value="조회"> -->
	</form>
	<form name="Form" id="Form" method="post" action="">
		<input type=hidden name="excDate"> 
		<input type=hidden name="excPerRepName"> 
	</form>
</body>
</html>
