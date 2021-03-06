<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json测试</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />  
<script
	src="<%=request.getContextPath()%>/source/script/lib/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/source/script/my/ajaxtest.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/source/style/lib/bootstrap/css/bootstrap.min.css">
<style>
body {
	padding: 20px 50px;
	background-color: #F0F8FF;
}
</style>
</head>
<body>
	<div class="container">
		<button id="ajax_load" class="btn btn-default">Ajax load()方法</button>
		<button id="getJSON" class="btn btn-default">Ajax getJSON()方法</button>
		<button id="getScript" class="btn btn-default">Ajax
			getScript()方法</button>
		<button id="get" class="btn btn-default">Ajax
			get()方法</button>
		<button id="post" class="btn btn-default">Ajax
			post()方法</button>
			<form>
				<div class="form-group">
					<input class="form-control" type="text" name="name">
					<input class="form-control" type="text" name="age">
				</div>
			</form>
			<button id="form" class="btn btn-default">Ajax
			serialize()方法</button>
			<button id="ajax" class="btn btn-default">Ajax
			ajax()方法</button>
			<button id="setup_one" class="btn btn-default">Ajax
			ajaxSetup()方法</button>
			<button id="setup_two" class="btn btn-default">Ajax
			ajaxSetup()方法</button>
	</div>
	<div id="load_html" class="container"></div>
	<div id="json_json" class="container"></div>
	<ul></ul>
	<span></span>
</body>
</html>