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
				console.log(sport['name']);
				$("#json_json").append("<li>" + sport['name'] + "</li>");
			});
		});
	});
});