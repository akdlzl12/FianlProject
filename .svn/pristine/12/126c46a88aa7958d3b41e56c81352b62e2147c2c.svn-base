<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
	<title>시간표 등록</title>
	
	<%@ include file="/WEB-INF/views/common/head.jsp" %>
	<style>
        .auditorium {
            text-align: center;
        }
        
        .movielist {
            overflow:hidden;
            text-overflow:ellipsis;
            white-space:nowrap;
        }
        input {text-align: center;}
    </style>
</head>
<body>
	<c:set var="nav_active" value="movie" />
	
	<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="row">
		<div class="col-md-2">
			<c:set var="side_active" value="m1one" />
			<%@ include file="/WEB-INF/views/movie/common/side_movie.jsp" %>
		</div>
		<div class="col-md-10">
			<div class="container top-margin">
			 <h2 class="page-header">시간표 조회</h2>
				<div style="text-align: right;">
					
				</div>
				<form class="form-inline">
					<div class="form-group">
						<label for=dates>일자선택</label> 
						<input type="date" class="form-control" id="dates" />
					</div>
					<div class="form-group" style="text-align: right;">
						<a class="btn btn-primary" id="btn-add-row"><i class="fa fa-user-plus fa-fw fa-fw"></i>회차추가</a>
						<a class="btn btn-danger" id="btn-delete-row"><i class="fa fa-trash fa-fw"></i>회차삭제</a>				
					</div>
					<div class="box" style="overflow: auto; margin-top: 20px;">
					<table id="movie-table" class="table table-bordered"
						style="text-align: center">
						<colgroup>
							<col width="5%" ;/>
							<col width="19%" ;/>
							<col width="19%" ;/>
							<col width="19%" ;/>
							<col width="19%" ;/>
							<col width="19%" ;/>
						</colgroup>
						<thead>
							<tr>
								<th></th>
								<th class="auditorium">1관: <select class="movielist">
										<option>등록영화1</option>
										<option>등록영화2</option>
										<option>등록영화3</option>
								</select>
								</th>
								<th class="auditorium">2관: <select class="movielist">
										<option>등록영화1</option>
										<option>등록영화2</option>
										<option>등록영화3</option>
								</select>
								</th>
								<th class="auditorium">3관 <select class="movielist">
										<option>등록영화1</option>
										<option>등록영화2</option>
										<option>등록영화3</option>
								</select>
								</th>
								<th class="auditorium">4관 <select class="movielist">
										<option>등록영화1</option>
										<option>등록영화2</option>
										<option>등록영화3</option>
								</select>
								</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1회차</td>

								<td>
									<div class="form-group">
										<label>광고시작시간</label> <input type="time" name="adv-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화시작시간</label> <input type="time" name="start-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화상영시간</label> <input type="time" name="play-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화종료시간</label> <input type="time" name="end-time"
											class="form-control" />
									</div>
								</td>

								<td>
									<div class="form-group">
										<label>광고시작시간</label> <input type="time" name="adv-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화시작시간</label> <input type="time" name="start-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화상영시간</label> <input type="time" name="play-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화종료시간</label> <input type="time" name="end-time"
											class="form-control" />
									</div>
								</td>

								<td>
									<div class="form-group">
										<label>광고시작시간</label> <input type="time" name="adv-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화시작시간</label> <input type="time" name="start-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화상영시간</label> <input type="time" name="play-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화종료시간</label> <input type="time" name="end-time"
											class="form-control" />
									</div>
								</td>

								<td>
									<div class="form-group">
										<label>광고시작시간</label> <input type="time" name="adv-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화시작시간</label> <input type="time" name="start-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화상영시간</label> <input type="time" name="play-time"
											class="form-control" />
									</div>
									<div class="form-group">
										<label>영화종료시간</label> <input type="time" name="end-time"
											class="form-control" />
									</div>
								</td>
							</tr>

						</tbody>
					</table>
					
				  </div>

				</form>

				<div style="text-align: right">
					<button type="submit" class="btn btn-primary" value="등록" ><i class="fa fa-user-plus fa-fw fa-fw"></i>등록</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
<script>
$(function(){
  $('#btn-add-row').click(function() {

      var html = "";
      html += '<tr>';
      html += '<td>4회차</td>';
      html += '<td>';
      html += '<div class="form-group">';
      html += '<label>광고시작시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화시작시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화상영시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화종료시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '</td>';
      html += '<td>';
      html += '<div class="form-group">';
      html += '<label>광고시작시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화시작시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화상영시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화종료시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '</td>';
      html += '<td>';
      html += '<div class="form-group">';
      html += '<label>광고시작시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화시작시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화상영시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화종료시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '</td>';
      html += '<td>';
      html += '<div class="form-group">';
      html += '<label>광고시작시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화시작시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화상영시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '<div class="form-group">';
      html += '<label>영화종료시간</label>';
      html += '<input type="time" name="adv-time" class="form-control" />';
      html += '</div>';
      html += '</td>';
      html += '</tr>';

     $('#movie-table tbody').append(html);
  });
    
  $('#btn-delete-row').click(function() {
    $('#movie-table > tbody:last > tr:last').remove();
  });
    
});

</script>
</html>