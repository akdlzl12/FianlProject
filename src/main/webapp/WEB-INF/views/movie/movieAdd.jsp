<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>영화등록</title>
	
	<%@ include file="/WEB-INF/views/common/head.jsp" %>
	<style>
        .form-group {
            margin-top: 30px;
        }
    </style>
</head>
<body>
	<c:set var="nav_active" value="movie"/>
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="row">
		<div class="col-md-2 div-side">
			<c:set var="side_active" value="m3one" />
			<%@ include file="/WEB-INF/views/movie/common/side_movie.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container top-margin">
			 <h2 class="page-header">영화 등록</h2>
				<form class="form-horizontal box" action="add.esc" method="post">
				
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label col-sm-3" for="movie-title">영화명</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="movie-title" name="name">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" for="publish-date">배급일</label>
							<div class="col-sm-6">
								<input type="date" class="form-control" id="publish-date" name="publishDate">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" for="open-date">개봉일</label>
							<div class="col-sm-6">
								<input type="date" class="form-control" id="open-date" name="openDate">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" >장르</label>
							<div class="col-sm-6" style="border: 1px solid black;">
								<div>
									<label> <input type="checkbox" id="genre-action" value="1" name="genre"> 액  션 </label> 
									<label> <input type="checkbox" id="genre-romance" value="2" name="genre"> 로맨스 </label> 
									<label> <input type="checkbox" id="genre-thriller" value="3" name="genre"> 스릴러 </label>
								</div>
								<div>
									<label> <input type="checkbox" id="genre-action" value="4" name="genre"> S  F </label> 
									<label> <input type="checkbox" id="genre-romance" value="5" name="genre"> 범죄 </label> 
									<label> <input type="checkbox" id="genre-thriller" value="6" name="genre"> 추리 </label>
								</div>
								<div>
									<label> <input type="checkbox" id="genre-action" value="7" name="genre"> 판타지 </label> 
									<label> <input type="checkbox" id="genre-romance" value="8" name="genre"> 멜 로 </label> 
									<label> <input type="checkbox" id="genre-thriller" value="9" name="genre"> 드라마 </label>
								</div>
							</div>
						</div>	
						
					</div>
					
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label col-sm-3" for="dubbed">더빙</label>
							<div class="col-sm-6">
								<label> <input type="radio"  value="1"	name="dubbed"> Y </label> 
								<label> <input type="radio"  value="0"   name="dubbed"> N </label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3" for="age-limit">상영등급</label>
							<div class="col-sm-6">
								<select id="age-limit" name="ageLimit">
									<option value="0">전체 이용가</option>
									<option value="12">12세 이용가</option>
									<option value="15">15세 이용가</option>
									<option value="18">청소년 관람불가</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" for="publish-country">국가</label>
							<div class="col-sm-6">
								<input type="text" id="publish-country" name="publishCountry">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3" for="image-uri">이미지</label>
							<div class="col-sm-6">
								<input type="file" id="image-uri" name="imageUri">(.jsp,.png)
							</div>
						</div>
					</div>
					
					 <div class="form-group">
					 	<div class="col-sm-10 col-sm-offset-1">
					 		<label class="control-label" for="movie-description" >영화정보</label>
							<textarea style="width: 100%" rows="5"  id="movie-description" name="description"></textarea>
						</div>
					 </div>
						
					<div class="form-group">
						<div class="col-sm-offset-10 col-sm-2">
							<button type="submit" class="btn btn-primary"><i class="fa fa-user-plus fa-fw fa-fw"></i>등록</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>