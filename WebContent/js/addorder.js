$(document).ready(function(){
	completeNum();
    $("#category").bind("click",function(){
    	event.stopPropagation();
    	var data_category = [{"name":"PD","code":"1"},{"name":"WP","code":"2"},{"name":"临时登记","code":"3"}];
    	autoList(this, data_category);
    });
    $("#register").bind("input propertychange",function(){
    	event.stopPropagation();
    	var data_category = [{"name":"草甘膦","code":"102314"},{"name":"万草枯","code":"223410"},{"name":"敌敌畏","code":"261209"}];
    	autoList(this, data_category);
    });
    $("#producetype").bind("click",function(){
    	event.stopPropagation();
    	var data_category = [{"name":"持有人生产","code":"1"},{"name":"委托加工","code":"2"},{"name":"委托分装","code":"3"}];
    	autoList(this, data_category);
    });
    $("#productformat").bind("input propertychange",function(){
    	event.stopPropagation();
    	var data_category = [{"name":"250ml/瓶","code":"101"},{"name":"10g/袋","code":"201"},{"name":"1L/桶","code":"301"},{"name":"300ml/瓶","code":"102"}];
    	autoList(this, data_category);
    });
    $("#pic_size").bind("click",function(){
    	event.stopPropagation();
    	var data_category = [{"name":"1","code":"1cm×1cm"},{"name":"2","code":"2cm×2cm"},{"name":"3","code":"1.7cm×1.7cm"}];
    	autoList(this, data_category);
    });
    $("#pic_format").bind("click",function(){
    	event.stopPropagation();
    	var data_category = [{"name":"1","code":"PNG"},{"name":"2","code":"JPG"},{"name":"3","code":"BMP"}];
    	autoList(this, data_category);
    });
    $("#scanurl").blur(function(){
    	if ($("#scanurl").val()) {
    		var url = $("#scanurl").val() + "?=" + $("#code_1").html() + $("#code_2").html() + $("#code_3").html() + $("#code_4").html() + "000000000000000000001";
	    	$("#fullURL").html(url);
	    	var a = "<a class='visit_a' href='"+ url +"' target='_blank'>访问</a>";
	    	$("#fullURL").next().remove();
	    	$("#fullURL").parent().append(a);
    	}
    });
});

function completeNum(){
	if ($("#category").val() != "") {
		$("#code_1").html($("#category").val().split(":")[1]);
	}else{
		$("#code_1").html("_");
	}
	if ($("#register").val() != "") {
		$("#code_2").html($("#register").val().split(":")[1]);
	}else{
		$("#code_2").html("______");
	}
	if ($("#producetype").val() != "") {
		$("#code_3").html($("#producetype").val().split(":")[1]);
	}else{
		$("#code_3").html("_");
	}
	if ($("#productformat").val() != "") {
		$("#code_4").html($("#productformat").val().split(":")[1]);
	}else{
		$("#code_4").html("___");
	}
}

function autoList(e, data){
	var position = $(e).offset();
	var parentelement = $(e).parent();
    var pickerTop = position.top + 35;
    var pickerLeft = position.left;
    var pickerWidth = $(e).width() + 4;
    if ($(e).next()) {
    	$(e).next().remove();
    }
    $(document).click(function(){
	    $(e).next().remove();
	});
    var selectArea = "<div class='pickerarea'><ul class='auto_ul'>";
    for (var i = 0; i < data.length && i < 5; i++) {
    	li = "<li id='" + data[i].code +" class=''auto_list>" + data[i].name + ":" + data[i].code + "</li>";
    	selectArea += li;
    }
    selectArea += "</ul></div>";
    $(parentelement).append(selectArea);
    $(e).next().css({minWidth:pickerWidth});
    $(e).next().offset({top:pickerTop, left:pickerLeft});
    $(e).next().find("ul").find("li").each(function(){
    	$(this).mouseover(function(){
    		$(this).css("background","#EEEEEE");
    	});
    	$(this).mouseout(function(){
    		$(this).css("background","#FFFFFF");
    	});
    	$(this).bind("click",function(){
    		$(this).parent().parent().prev().val($(this).text());
    		$(this).parent().parent().remove();
    		completeNum();
    	});
    });
}
