/**
 * 
 */
$(function() {
	$("#ajax_load").on(
			'click',
			function() {
				var $this = $(this);
				$("#load_html").html("<span>使用Ajax的load()方法加载数据</span>").load(
						"/springmvctest/static_resource/NewFile.html", function(data) {
							$this.attr("disabled", true);
							console.log(data);
						});
			});
	$("#getJSON").on('click', function() {
		var $this = $(this);
		$.getJSON("/springmvctest/static_resource/new_json.json", function(data) {
			$this.attr("disabled", true);
			console.log(JSON.stringify(data));
			$.each(data, function(index, sport) {
				console.log(sport.name);
				$("#json_json").append("<li>" + sport['name'] + "</li>");
			});
		});
	});
	$("#getScript").on('click', function() {
		var $this = $(this);
		$.getScript("/springmvctest/static_resource/script.js", function(data) {
			console.log(data);
			$this.attr("disabled", true);
		});
	});
	$("#get").on('click', function() {
		var $this = $(this);
		$.get("/springmvctest/static_resource/new_json.json", function(data){
			$this.attr("disabled", true);
			$.each(data, function(index, sport) {
				console.log(index + " : " + sport["name"]);
				$("ul").append("<li>" + sport["name"] + "</li>");
			});
		});
	});
	$("#post").on('click', function() {
		var $this = $(this);
		$.post("dopost.htm", {num: "3中文"}, function(data){
			$this.attr("disabled", true);
			console.log(data);
			console.log(JSON.parse(data).nature);
			$("ul").append("<li>" + JSON.parse(data).nature + "</li>");
		});
	});
});
