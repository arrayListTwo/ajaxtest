<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/1.9.0/jquery.min.js"></script>
</head>
<body>
	<div id="divtest">
		<div class="title">
			<span class="fl">加载一段文字</span> <span class="fr"> <input
				id="btnShow" type="button" value="加载" />
			</span>
		</div>
		<ul>
		</ul>
	</div>

	<script type="text/javascript">
		$(function() {
			$(document).ajaxStart(function() {
				console.log("开始请求");
				$(this).html("正在请求数据...");
			});
			$(document).ajaxStop(function() {
				console.log("结束请求");
				$(this).html("数据请求完成！");
			});
			$("#btnShow").bind("click", function() {
				var $this = $(this);
				$.ajax({
					url : "/springmvctest/static_resource/new_json.json",
					dataType : "json",
					success : function(data) {
						$this.attr("disabled", "true");
						$.each(data, function(index, sport){
							$("ul").append("<li>我的名字叫：" + sport.name + "</li>");
						})
					}
				});
			})
		});
	</script>
</body>
</html>