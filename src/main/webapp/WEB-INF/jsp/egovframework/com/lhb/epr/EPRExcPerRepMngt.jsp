<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList, java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>수행실적목록 조회</title>
    <link rel="stylesheet" type="text/css" href="/css/egovframework/com/lhb/epr/EPRExcPerRepMngt.css">
<%-- 	<%
	    // 임시 데이터 생성
	    List<Map<String, String>> tempData = new ArrayList<>();
	
	    for (int i = 0; i < 30; i++) {
	        int day = (i % 30) + 1; // 1~30 범위의 날짜 생성
	        String formattedDay = (day < 10) ? "0" + day : "" + day; // 앞에 0 추가
	
	        Map<String, String> data = new HashMap<>();
	        data.put("year", String.valueOf(2025 - i)); // 연도
	        data.put("taskName", "수행실적 " + (i + 1)); // 수행명
	        data.put("status", new String[]{"승인완료", "작성중", "접수대기", "반려"}[i % 4]); // 상태
	        data.put("date", "2025-01-" + formattedDay); // 날짜
	        
	        tempData.add(data);
	    }
	
	    // Gson을 사용하여 JSON 문자열 변환
	    Gson gson = new Gson();
	    String jsonData = gson.toJson(tempData);
	%> --%>
	<script>
		const result = ${eprExcPerRepMngList};	
		console.log(result);
	    // 특정 페이지의 데이터 가져오기
	    function fetchData(page) {
	    	// 한 페이지당 10개 항목
	        const pageSize = 10; 
	    	
	     	// 전체 페이지 수 계산
	        const totalPages = Math.ceil(result.length / pageSize); 
	        const start = (page - 1) * pageSize;
	        const end = Math.min(start + pageSize, result.length);
	        
	        // 현재 페이지에 해당하는 데이터 가져오기
	        let items = result.slice(start, end);

	        // 데이터가 부족하면 행 추가
	        while (items.length < pageSize) {
	            items.push({ year: "-", taskName: "-", status: "-", date: "-" });
	        }

	        return {
	            items: items,
	            totalPages: totalPages
	        };
	    }

	    // 데이터 로드 및 테이블, 페이지네이션 업데이트
	    function loadData(page) {
	    	// 데이터 가져오기
	        let data = fetchData(page); 
	     	// 테이블 업데이트
	        renderTable(result.items); 
	     	// 페이지네이션 업데이트	
	        renderPagination(result.totalPages, page); 
	    }

	    // 테이블을 생성하여 데이터를 삽입하는 함수
		function renderTable(items) {
		    const tbody = document.getElementById("data-table-body");
		    
		    // tbody가 존재하는지 확인
		    if (!tbody) {
		        console.error("Error: 'data-table-body' not found");
		        return;
		    }
		
		    tbody.innerHTML = ""; // 기존 데이터 초기화
		
		    items.forEach(row => {
		        const tr = document.createElement("tr");
		
		        const tdYear = document.createElement("td");
		        if (row.year != null && row.year != "-") {
		            const yearLink = document.createElement("a");
		            yearLink.href = "#";
		            yearLink.textContent = row.year;
		            tdYear.appendChild(yearLink);
		        } else {
		            tdYear.textContent = "-";
		        }
		
		        const tdTaskName = document.createElement("td");
		        tdTaskName.classList.add("table-cell");
		        tdTaskName.textContent = row.taskName;
		
		        const tdStatus = document.createElement("td");
		        tdStatus.classList.add("table-cell");
		        tdStatus.textContent = row.status;
		
		        const tdDate = document.createElement("td");
		        tdDate.classList.add("table-cell");
		        tdDate.textContent = row.date;
		
		        tr.appendChild(tdYear);
		        tr.appendChild(tdTaskName);
		        tr.appendChild(tdStatus);
		        tr.appendChild(tdDate);
		
		        tbody.appendChild(tr);
		    });
		}


		// 페이지네이션
		function renderPagination(totalPages, currentPage) {
		    const paginationDiv = document.getElementById("pagination");
		    paginationDiv.innerHTML = "";

		    // 최대 표시 페이지
		    const maxVisiblePages = 5;
		    
		    // 시작 페이지, 끝 페이지 설정
		    let startPage = Math.max(1, currentPage - Math.floor(maxVisiblePages / 2));
		    let endPage = startPage + maxVisiblePages - 1;

		    // 끝 페이지가 전체 페이지를 초과하면 조정
		    if (endPage > totalPages) {
		        endPage = totalPages;
		        startPage = Math.max(1, endPage - maxVisiblePages + 1);
		    }

		    // 이전 버튼 (첫 번째 페이지에서는 숨김)
		    if (currentPage > 1) {
		        const prevButton = document.createElement("button");
		        prevButton.textContent = "◀";
		        prevButton.classList.add("pagination-button");
		        prevButton.onclick = () => loadData(currentPage - 1);
		        paginationDiv.appendChild(prevButton);
		    }

		    // 페이지 번호 버튼
		    for (let i = startPage; i <= endPage; i++) {
		        const button = document.createElement("button");
		        button.textContent = i;
		        button.classList.add("pagination-button");

		        // 현재 페이지 강조 스타일 추가
		        if (i === currentPage) {
		            button.classList.add("active");
		        }

		        // 클릭 시 해당 페이지 데이터 로드
		        button.onclick = () => loadData(i);

		        paginationDiv.appendChild(button);
		    }

		    // 다음 버튼 (마지막 페이지에서는 숨김)
		    if (currentPage < totalPages) {
		        const nextButton = document.createElement("button");
		        nextButton.textContent = "▶";
		        nextButton.classList.add("pagination-button");
		        nextButton.onclick = () => loadData(currentPage + 1);
		        paginationDiv.appendChild(nextButton);
		    }
		}

	    // 페이지가 로드될 때 첫 번째 페이지의 데이터 가져오기
	    window.onload = () => {
	        loadData(1);
	    };
	</script>
</head>
<body>
    <div class="header-container">
        <c:import url="../../head.jsp" />
    </div>

    <div class="container">
        <h2>수행실적목록 조회</h2>
        <div class="search-section">
            <h3 style="margin-bottom: 15px">▶ 조회조건</h3>
			<div style="margin-bottom: 10px">
			    <label for="year">수행년도</label>
			    <select class="yearSelector", id="yearSelector">
			        <script>
			        /* 급하니까 일단 js 로 생성하고 나중에 공통 코드로 */
			        const yearSelect = document.getElementById("yearSelector");
			        const currentYear = new Date().getFullYear();

			        const defaultOption = document.createElement("option");
			        defaultOption.value = "";
			        defaultOption.textContent = "선택 안함";
			        defaultOption.selected = true;
			        yearSelect.appendChild(defaultOption);

			        for (let i = currentYear - 10; i <= currentYear + 10; i++) {
			            let option = document.createElement("option");
			            option.value = i;
			            option.textContent = i;
			            yearSelect.appendChild(option);
			        }
			        </script>
			    </select>
			</div>
            <div>
                <label>수행명</label>
                <input type="text" id="taskName" style="margin-left:0.8rem">
            </div>
            
        </div>
        <div>
        	<button type="button" class="long_btn" onclick="loadData(1)">조회</button>
        </div>
        <div class="results-section">
            <div style="width:100%; display: flex; justify-content: space-between; align-items: center">
                <h3>▶ 수행실적 조회내역</h3>
                <button class="btn">등록</button>
            </div>
            
            <table>
                <thead>
                    <tr>
                        <th class="table-header">수행년도</th>
                        <th class="table-header">수행명</th>
                        <th class="table-header">진행상태</th>
                        <th class="table-header">수정일시</th>
                    </tr>
                </thead>
                <tbody id="data-table-body">
                </tbody>
            </table>
            
            <div id="pagination" class="pagination" style="display: flex; justify-content: center; align-item: center; text-align: center; margin-top: 20px;"></div>
        </div>
    </div>
</body>
</html>
