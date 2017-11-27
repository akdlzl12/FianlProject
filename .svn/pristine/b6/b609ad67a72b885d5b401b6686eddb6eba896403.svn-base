<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>Home</title>
	
	<%@ include file="/WEB-INF/views/common/head.jsp" %>	
</head>
<body>
	<c:set var="nav_active" value="management" />
	
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="row">
		<div class="col-md-2 div-side">
			<c:set var="side_active" value="register" />
			<%@ include file="/WEB-INF/views/management/sidebar/sideBar.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container" style="margin-top: 50px;">
			<h2 class="page-header">키인 관리</h2>
       <div style="overflow: auto;" class="box">
            <form action="">
                <table class="table">
                    <thead>
                        <tr>
                            <th><input type="checkbox" name="all-check"></th>
                            <th>키인 명</th>
                            <th>금액</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="checkbox" name="check1"></td>
                            <td>성인</td>
                            <td>8,000</td>
                            <td>울랄라</td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="check1"></td>
                            <td>성인</td>
                            <td>8,000</td>
                            <td>울랄라</td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="check1"></td>
                            <td>성인</td>
                            <td>8,000</td>
                            <td>울랄라</td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="check1"></td>
                            <td>성인</td>
                            <td>8,000</td>
                            <td>울랄라</td>
                        </tr>
                        
                    </tbody>
                </table>
                <div class="text-right" style="margin-left: 10px;">
                    <button type="button" class="btn btn-danger" id="btn-open-modal"><i class="fa fa-trash fa-fw"></i>삭제</button>
                </div>
            </form>
        </div>
        
        <h2 class="page-header">키인 추가</h2>
        <div style="overflow: auto;" class="box">
            <form class="form-horizontal" action="/action_page.php">
                <div class="form-group">
                     <label class="control-label col-xs-1" for="keyinname">키인 명:</label>
                     <div class="col-sm-10">
                       <input type="email" class="form-control" id="keyinname" placeholder="키인 명" name="keyinname">
                     </div>
                </div>
                <div class="form-group">
                     <label class="control-label col-xs-1" for="money">금액:</label>
                     <div class="col-sm-10">          
                       <input type="password" class="form-control" id=""money"" placeholder="금액" name=""money"">
                     </div>
                </div>
                <div class="form-group">
                     <label class="control-label col-xs-1" for="detail">비고:</label>
                     <div class="col-sm-10">
                        <textarea name="detail" id="detail" cols="" rows="5" class="form-control"></textarea>
                     </div>
                </div>
                <div class="form-group">        
                    <div class="text-right" style="padding-right: 13px;">
                      <button type="submit" class="btn btn-primary"><i class="fa fa-user-plus fa-fw fa-fw"></i>추가</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
		</div>
	</div>
	
</body>
</html>