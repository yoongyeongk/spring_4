<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	$(function(){
		$("#btn").on("click", function(){
			$.get("../ajax/memberList", function(data){
				$("#result").html(data);
			})
		})
		
		$("#id").blur(function(){
			var id = $(this).val();
			$.post("../ajax/checkId",{id: id}, function(data){
				alert(data);				
			});
		});
	});
</script>

</head>
<body>
	<h1>Member Join</h1>
	
	<form name="frm" action="">
		ID <input type="text" name="id" id="id">
	</form>
	
	<input type="button" value="memberList" id="btn">
	<div id="result"></div>
</body>
</html>