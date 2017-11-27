<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="box">
		<form action="${pageforward }" class="form-horizontal" method="get">
			<input type="hidden" value="${param.pageNo }" name="pageNo"/>
			<div class="form-group">
				<div class="col-md-2">
					<select name="opt" class="form-control">
						<option value="name" ${param.opt == 'name' ? 'selected' : '' }>이름</option>
						<option value="job_type" ${param.opt == 'jobType' ? 'selected' : '' }>사원타입</option>
						<option value="id" ${param.opt == 'id' ? 'selected' : '' }>사원번호</option>
					</select>
				</div>
				<div class="col-md-5">
					<input type="text" name="keyword" placeholder="검색어" class="form-control" value="${param.keyword }"/>
				</div>
				<div class="col-md-1">
					<button class="btn btn-default" type="submit"><i class="fa fa-search fa-fw"></i>검색</button>
				</div>
			</div>
		</form>
		
		<table class="table top-margin">
			<colgroup>
				<col width="20%" />
				<col width="40%" />
				<col width="40%" />
			</colgroup>
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>직원타입</th>
			</tr>
			<c:choose>
				<c:when test="${not empty emps }">
					<c:forEach items="${emps }" var="emp">
						<tr class="tr-clickable hover" empId="${emp.id }">
							<td>${emp.jobType}-${emp.id }</td>
							<td>${emp.name }</td>
							<td>${emp.jobType == 'T' ? '티켓팅' : '안내'}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="3">검색결과가 없습니다</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<div class="text-right">
			<a id="btn-check" class="btn btn-default"><i class="fa fa-search fa-fw"></i> 상세조회</a>
		</div>
	</div>