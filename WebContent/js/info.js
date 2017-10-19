window.onload = function(){
    var pesticide_name = new Array();
    var pesticide_id = new Array();
    var pesticide_num = new Array();
    var type_id = new Array();
    var type_life = new Array();
    var type_type = new Array();
    var type_specification = new Array();
    var pici_id = new Array();
    var pici_btnum = new Array();
    var pici_bxnum = new Array();
    var pici_remark = new Array();
    var pes_id;
    var t_id;
    var pc_id;
    
    //获取农药信息
	$.ajax({
        type:"post",
        async:false,
        url:"../ShowInfo.action",
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
            var l = d.length;
            for(var i=0;i<l;i++){
            	pesticide_name[i] = d[i].name;
            	pesticide_id[i] = d[i].id;
            	pesticide_num[i] = d[i].num;
            	//alert(pesticide_name[i]+" "+pesticide_id[i]+" "+pesticide_num[i]);
            	
            }
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }
    });
	
	//获取农药类型信息
	$("#pesticide_next").click(function(){
		$.ajax({
	        type:"post",
	        async:false,
	        url:"../ShowType.action",
	        data:{id:pes_id},
	        dataType:"json",
	        success:function(data){
	            var d = eval("("+data+")");
	            var l = d.length;
	            for(var i=0;i<l;i++){
	            	type_id[i] = d[i].id;
	            	type_life[i] = d[i].life;
	            	type_type[i] = d[i].type;
	            	type_specification[i] = d[i].specification;
	            }
	        },
	        error:function(){
	            alert("系统异常，请稍后重试！");
	        }
	    });
	});
	
	//获取生产计划信息
	$("#type_next").click(function(){
		$.ajax({
	        type:"post",
	        async:false,
	        url:"../ShowPlan.action",
	        data:{id:t_id},
	        dataType:"json",
	        success:function(data){
	            var d = eval("("+data+")");
	            var l = d.length;
	            for(var i=0;i<l;i++){
	            	pici_id[i] = d[i].id;
	                pici_btnum[i] = d[i].btnum;
	                pici_bxnum[i] = d[i].bxnum;
	                pici_remark[i] = d[i].remark;
	            }
	        },
	        error:function(){
	            alert("系统异常，请稍后重试！");
	        }
	    });
	});
	
	//在线生成二维码
	$("#create_online").click(function(){
		window.location.href="../pages/historyorder.html";
		$.ajax({
	        type:"post",
	        url:"../CreateOrder.action",
	        data:{
	        	pesticideid: pes_id,
	        	typeid: t_id,
	        	piciid: pc_id,
	        	queryurl: $("#confirm_fixedtext").val(),
	        	pagepath: $("#confirm_pagepath").val()
	        },
	        dataType:"json",
	        success:function(data){
	        	var d = eval("("+data+")");
	        	alert(d.info);
	        },
	        error:function(){
	            alert("成功！");
	        }
	    });
	});
	
	//农药信息下拉显示
	$(function(){
		var proposalList = $("#list_pesticide");
		var oldname = "$";
		var currentSelection = -1;
		var currentProposals = [];
		$("#name").keydown(function(e) {
			switch(e.which) {
			case 38: // Up arrow
			e.preventDefault();
			$('ul.proposal-list li').removeClass('selected');
			if((currentSelection - 1) >= 0){
				currentSelection--;
				$( "ul.proposal-list li:eq(" + currentSelection + ")" )
					.addClass('selected');
			} else {
				currentSelection = -1;
			}
			break;
			case 40: // Down arrow
			e.preventDefault();
			if((currentSelection + 1) < currentProposals.length){
				$('ul.proposal-list li').removeClass('selected');
				currentSelection++;
				$( "ul.proposal-list li:eq(" + currentSelection + ")" )
					.addClass('selected');
			}
			break;
			case 13: // Enter
				if(currentSelection > -1){
					var text = $( "ul.proposal-list li:eq(" + currentSelection + ")" ).html();
					$("#name").val(text);
				}
				currentSelection = -1;
				proposalList.empty();
				break;
			case 27: // Esc button
				currentSelection = -1;
				proposalList.empty();
				$("#name").val('');
				break;
			}
		});
		$("#name").bind("change paste keyup", function(e){
			if(oldname!=$("#name").val()){
				$("#num").val('');
			}
			if(e.which != 13 && e.which != 27 
					&& e.which != 38 && e.which != 40){
				currentProposals = [];
				currentSelection = -1;
				proposalList.empty();
				if($("#name").val() != ''){
					var word = "^" + $("#name").val() + ".*";
					proposalList.empty();
					for(var test in pesticide_name){
						if(pesticide_name[test].match(word)){
							currentProposals.push(pesticide_name[test]);
							var element = $('<li></li>')
								.html(pesticide_name[test])
								.addClass('proposal')
								.click(function(){
									$("#name").val($(this).html());
									oldname=$("#name").val();
									for(var j=0;j<pesticide_name.length;j++){
										if(pesticide_name[j]==$("#name").val()){
											$("#num").val(pesticide_num[j]);
											pes_id = pesticide_id[j];
										}
									}
									proposalList.empty();
								})
								.mouseenter(function() {
									$(this).addClass('selected');
								})
								.mouseleave(function() {
									$(this).removeClass('selected');
								});
							proposalList.append(element);
						}
					}
					if(currentProposals.length==0){
						var element = $('<li></li>')
						.html("没有 "+$("#name").val()+" 信息")
						.addClass('proposal')
						.click(function(){
							$("#name").val('');
							$("#num").val('');
							proposalList.empty();
						})
						.mouseenter(function() {
							$(this).addClass('selected');
						})
						.mouseleave(function() {
							$(this).removeClass('selected');
						});
					proposalList.append(element);
					}
				}
			}
		});
	})
	
	//农药类型下拉显示
	$(function(){
		var proposalList = $("#list_type");
		var oldname = "$";
		var currentSelection = -1;
		var currentProposals = [];
		$("#type").click(function(){
			proposalList.empty();
			for(var test in type_type){
				if(1){
					currentProposals.push(type_type[test]);
					var element = $('<li></li>')
						.html(type_type[test]+type_specification[test])
						.addClass('proposal')
						.click(function(){
							$("#type").val($(this).html());
							oldname=$("#type").val();
							for(var j=0;j<type_type.length;j++){
								if((type_type[j]+type_specification[j])==$("#type").val()){
									$("#life").val(type_life[j]);
									$("#specification").val(type_specification[j]);
									t_id = type_id[j];
								}
							}
							proposalList.empty();
						})
						.mouseenter(function() {
							$(this).addClass('selected');
						})
						.mouseleave(function() {
							$(this).removeClass('selected');
						});
					proposalList.append(element);
				}
			}
			if(currentProposals.length==0){
				var element = $('<li></li>')
				.html("没有信息")
				.addClass('proposal')
				.click(function(){
					$("#name").val('');
					$("#num").val('');
					proposalList.empty();
				})
				.mouseenter(function() {
					$(this).addClass('selected');
				})
				.mouseleave(function() {
					$(this).removeClass('selected');
				});
			proposalList.append(element);
			}
		});
		$("#type").keydown(function(e) {
			switch(e.which) {
			case 38: // Up arrow
			e.preventDefault();
			$('ul.proposal-list li').removeClass('selected');
			if((currentSelection - 1) >= 0){
				currentSelection--;
				$( "ul.proposal-list li:eq(" + currentSelection + ")" )
					.addClass('selected');
			} else {
				currentSelection = -1;
			}
			break;
			case 40: // Down arrow
			e.preventDefault();
			if((currentSelection + 1) < currentProposals.length){
				$('ul.proposal-list li').removeClass('selected');
				currentSelection++;
				$( "ul.proposal-list li:eq(" + currentSelection + ")" )
					.addClass('selected');
			}
			break;
			case 13: // Enter
				if(currentSelection > -1){
					var text = $( "ul.proposal-list li:eq(" + currentSelection + ")" ).html();
					$("#type").val(text);
				}
				currentSelection = -1;
				proposalList.empty();
				break;
			case 27: // Esc button
				currentSelection = -1;
				proposalList.empty();
				$("#type").val('');
				$("#life").val('');
				$("#specification").val('');
				break;
			}
		});
	})
	
	//生产计划下拉显示
	$(function(){
		var proposalList = $("#list_plan");
		var oldname = "$";
		var currentSelection = -1;
		var currentProposals = [];
		$("#remark").click(function(){
			proposalList.empty();
			for(var test in pici_remark){
				if(1){
					currentProposals.push(pici_remark[test]);
					var element = $('<li></li>')
						.html(pici_remark[test])
						.addClass('proposal')
						.click(function(){
							$("#remark").val($(this).html());
							oldname=$("#remark").val();
							for(var j=0;j<pici_remark.length;j++){
								if(pici_remark[j]==$("#remark").val()){
									$("#btnum").val(pici_btnum[j]);
									$("#bxnum").val(pici_bxnum[j]);
									pc_id = pici_id[j];
								}
							}
							proposalList.empty();
						})
						.mouseenter(function() {
							$(this).addClass('selected');
						})
						.mouseleave(function() {
							$(this).removeClass('selected');
						});
					proposalList.append(element);
				}
			}
			if(currentProposals.length==0){
				var element = $('<li></li>')
				.html("没有信息")
				.addClass('proposal')
				.click(function(){
					$("#remark").val('');
					$("#btnum").val('');
					$("#bxnum").val('');
					proposalList.empty();
				})
				.mouseenter(function() {
					$(this).addClass('selected');
				})
				.mouseleave(function() {
					$(this).removeClass('selected');
				});
			proposalList.append(element);
			}
		});
		$("#remark").keydown(function(e) {
			switch(e.which) {
			case 38: // Up arrow
			e.preventDefault();
			$('ul.proposal-list li').removeClass('selected');
			if((currentSelection - 1) >= 0){
				currentSelection--;
				$( "ul.proposal-list li:eq(" + currentSelection + ")" )
					.addClass('selected');
			} else {
				currentSelection = -1;
			}
			break;
			case 40: // Down arrow
			e.preventDefault();
			if((currentSelection + 1) < currentProposals.length){
				$('ul.proposal-list li').removeClass('selected');
				currentSelection++;
				$( "ul.proposal-list li:eq(" + currentSelection + ")" )
					.addClass('selected');
			}
			break;
			case 13: // Enter
				if(currentSelection > -1){
					var text = $( "ul.proposal-list li:eq(" + currentSelection + ")" ).html();
					$("#remark").val(text);
				}
				currentSelection = -1;
				proposalList.empty();
				break;
			case 27: // Esc button
				currentSelection = -1;
				proposalList.empty();
				$("#remark").val('');
				$("#btnum").val('');
				$("#bxnum").val('');
				break;
			}
		});
	})
};
