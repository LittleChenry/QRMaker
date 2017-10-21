window.onload = function(){
    var pesticide_name = new Array();
    var pesticide_id = new Array();
    var pesticide_num = new Array();
    var type_id = new Array();
    var type_life = new Array();
    var type_type = new Array();
    var type_specification = new Array();
    var type_specificationid = new Array();
    var specification_specification = new Array();
    var specification_id = new Array();
    var pici_id = new Array();
    var pici_btnum = new Array();
    var pici_bxnum = new Array();
    var pici_remark = new Array();
    var pes_id;
    var t_id;
    var pc_id;
    var spe_id;
    
  //获取农药信息
	$.ajax({
        type:"post",
        async:true,
        url:"../ShowInfo.action",
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
            var l = d.length;
            if(l>1){
            	for(var i=0;i<l-1;i++){
                	pesticide_name[i] = d[i].name;
                	pesticide_id[i] = d[i].id;
                	pesticide_num[i] = d[i].num;
                	//alert(pesticide_name[i]+" "+pesticide_id[i]+" "+pesticide_num[i]);
                }
            }
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }
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
					oldname=$("#name").val();
					for(var j=0;j<pesticide_name.length;j++){
						if(pesticide_name[j]==$("#name").val()){
							$("#num").val(pesticide_num[j]);
							$("#num").attr('readonly','readonly');
							pes_id = pesticide_id[j];
						}
					}
				}
				currentSelection = -1;
				proposalList.empty();
				break;
			case 27: // Esc button
				currentSelection = -1;
				proposalList.empty();
				$("#name").val('');
				$("#num").removeAttr('readonly');
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
					$("#num").removeAttr('readonly');
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
											$("#num").attr('readonly','readonly');
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
						.html("无 "+$("#name").val()+" 信息")
						.addClass('proposal')
						.click(function(){
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
	
	//获取农药类型信息
	$("#pesticide_next").click(function(){
		/*$.ajax({
	        type:"post",
	        async:true,
	        url:"../ShowType.action",
	        data:{id:pes_id},
	        dataType:"json",
	        success:function(data){
	            var d = eval("("+data+")");
	            var l = d.length;
	            if(l>1){
	            	for(var i=0;i<l-1;i++){
		            	type_id[i] = d[i].id;
		            	type_life[i] = d[i].life;
		            	type_type[i] = d[i].type;
		            	type_specification[i] = d[i].specification;
		            	type_specificationid[i] = d[i].specificationid;
		            }
	            }
	        },
	        error:function(){
	            alert("系统异常，请稍后重试！");
	        }
	    });*/
	});
	
	//农药类型下拉显示
	$(function(){
		var proposalList = $("#list_type");
		var oldname = "$";
		var currentSelection = -1;
		var currentProposals = [];
		$("#type").click(function(){
			if($("#type").val()==''){
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
										$("#life").attr('readonly','readonly');
										$("#specification").attr('readonly','readonly');
										t_id = type_id[j];
										spe_id = type_specificationid[j];
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
				var element = $('<li></li>')
					.html("新增农药生产类型")
					.addClass('proposal')
					.click(function(){
						t_id = "0";
						proposalList.empty();
						$("#type")[0].focus();
						$("#type").val('');
						$("#life").removeAttr('readonly');
						$("#life").val('');
						$("#specification").removeAttr('readonly');
						$("#specification").val('');
					})
					.mouseenter(function() {
						$(this).addClass('selected');
					})
					.mouseleave(function() {
						$(this).removeClass('selected');
					});
				proposalList.append(element);
				/*
				if(currentProposals.length==0){
					$("#type").attr('placeholder','输入农药类型，如 悬浮剂');
					t_id = "0";
				}*/
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
				$("#type").removeAttr('readonly');
				$("#life").val('');
				$("#life").removeAttr('readonly');
				$("#specification").val('');
				$("#specification").removeAttr('readonly');
				break;
			}
		});
	})
	
	//获取规格信息
	$("#pesticide_next").click(function(){
		/*$.ajax({
	        type:"post",
	        async:true,
	        url:"../ShowSpecification.action",
	        dataType:"json",
	        success:function(data){
	            var d = eval("("+data+")");
	            var l = d.length;
	            if(l>1){
	            	for(var i=0;i<l-1;i++){
	                	specification_specification[i] = d[i].specification;
	                	specification_id[i] = d[i].id;
	                	//alert(specification_specification[i]+" "+specification_id[i]);
	                }
	            }
	        },
	        error:function(){
	            alert("系统异常，请稍后重试！");
	        }
	    });*/
		
		//规格信息下拉显示
		$(function(){
			var proposalList = $("#list_specification");
			var oldname = "$";
			var currentSelection = -1;
			var currentProposals = [];
			$("#specification").keydown(function(e) {
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
						$("#specification").val(text);
					}
					currentSelection = -1;
					proposalList.empty();
					break;
				case 27: // Esc button
					currentSelection = -1;
					proposalList.empty();
					$("#specification").val('');
					break;
				}
			});
			
			$("#specification").bind("change paste keyup", function(e){
				if(e.which != 13 && e.which != 27 
						&& e.which != 38 && e.which != 40){
					currentProposals = [];
					currentSelection = -1;
					proposalList.empty();
					
					if($("#specification").val() != ''){
						var word = "^" + $("#specification").val() + ".*";
						proposalList.empty();
						for(var test in specification_specification){
							if(specification_specification[test].match(word)){
								currentProposals.push(specification_specification[test]);
								var element = $('<li></li>')
									.html(specification_specification[test])
									.addClass('proposal')
									.click(function(){
										$("#specification").val($(this).html());
										oldname=$("#specification").val();
										for(var j=0;j<specification_specification.length;j++){
											if(specification_specification[j]==$("#specification").val()){
												spe_id = specification_id[j];
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
						var formatnum = /^[0-9]*$/;
						if(currentProposals.length==0 && formatnum.test($("#specification").val())){
							var element = $('<li></li>')
							.html($("#specification").val()+"ml/瓶")
							.addClass('proposal')
							.click(function(){
								spe_id = "0";
								proposalList.empty();
								$("#specification").val($(this).html());
							})
							.mouseenter(function() {
								$(this).addClass('selected');
							})
							.mouseleave(function() {
								$(this).removeClass('selected');
							});
							proposalList.append(element);
							
							var element = $('<li></li>')
							.html($("#specification").val()+"ml/袋")
							.addClass('proposal')
							.click(function(){
								$("#specification").val($(this).html());
								spe_id = "0";
								proposalList.empty();
							})
							.mouseenter(function() {
								$(this).addClass('selected');
							})
							.mouseleave(function() {
								$(this).removeClass('selected');
							});
							proposalList.append(element);
							
							var element = $('<li></li>')
							.html($("#specification").val()+"g/瓶")
							.addClass('proposal')
							.click(function(){
								$("#specification").val($(this).html());
								spe_id = "0";
								proposalList.empty();
							})
							.mouseenter(function() {
								$(this).addClass('selected');
							})
							.mouseleave(function() {
								$(this).removeClass('selected');
							});
							proposalList.append(element);
							
							var element = $('<li></li>')
							.html($("#specification").val()+"g/袋")
							.addClass('proposal')
							.click(function(){
								$("#specification").val($(this).html());
								spe_id = "0";
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
	})
	
	//获取生产计划信息
	$("#type_next").click(function(){
		if(t_id!='0'){
			$.ajax({
		        type:"post",
		        async:true,
		        url:"../ShowPlan.action",
		        data:{id:t_id},
		        dataType:"json",
		        success:function(data){
		            var d = eval("("+data+")");
		            var l = d.length;
		            if(l>1){
		            	for(var i=0;i<l-1;i++){
			            	pici_id[i] = d[i].id;
			                pici_btnum[i] = d[i].btnum;
			                pici_bxnum[i] = d[i].bxnum;
			                pici_remark[i] = d[i].remark;
			            }
		            }
		        },
		        error:function(){
		            alert("系统异常，请稍后重试！");
		        }
		    });
		}
	});
	
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
									$("#btnum").attr('readonly','readonly');
									$("#bxnum").val(pici_bxnum[j]);
									$("#bxnum").attr('readonly','readonly');
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
			var element = $('<li></li>')
				.html("新增生产计划")
				.addClass('proposal')
				.click(function(){
					proposalList.empty();
					var date = new Date();
					var year =  date.getFullYear();
					var month = date.getMonth()+1;
					var day = date.getDate();
					var dateformat = String(year);
					if(month<10){
						if(day<10){
							dateformat = dateformat+"0"+String(month)+"0"+String(day);
						}else{
							dateformat = dateformat+"0"+String(month)+String(day);
						}
					}else{
						if(day<10){
							dateformat = dateformat+String(month)+"0"+String(day);
						}else{
							dateformat = dateformat+String(month)+String(day);
						}
					}
					pc_id = "0";
					$("#remark").val('生产批次'+dateformat);
					$("#btnum").removeAttr('readonly');
					$("#btnum").val('');
					$("#bxnum").removeAttr('readonly');
					$("#bxnum").val('');
				})
				.mouseenter(function() {
					$(this).addClass('selected');
				})
				.mouseleave(function() {
					$(this).removeClass('selected');
				});
			proposalList.append(element);
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
				$("#remark").removeAttr('readonly');
				$("#btnum").val('');
				$("#btnum").removeAttr('readonly');
				$("#bxnum").val('');
				$("#bxnum").removeAttr('readonly');
				break;
			}
		});
	})
	
	//链接信息
	$(function(){
		$("#plan_next").click(function(){
			$.ajax({
		        type:"post",
		        async:true,
		        url:"../ShowFixedinfo.action",
		        dataType:"json",
		        success:function(data){
		            var d = eval("("+data+")");
		            $("#fixedtext").text(d.fixedtext);
		            $("#pagepath").text(d.pagepath);
		        },
		        error:function(){
		            alert("系统异常，请稍后重试！");
		        }
		    });
		});
	})
	
	//农药生产信息预览
	$("#createQR").click(function(){
		$("#confirm_name").val($("#name").val());
		$("#confirm_num").val($("#num").val());
		$("#confirm_type").val($("#type").val());
		$("#confirm_spe").val($("#specification").val());
		$("#confirm_btnum").val($("#btnum").val());
		$("#confirm_bxnum").val($("#bxnum").val());
		$("#confirm_fixedtext").val($("#fixedtext").val());
		$("#confirm_pagepath").val($("#pagepath").val());
	});
	
	//在线生成二维码
	$("#create_online").click(function(){
		$('#waiting').modal({backdrop: 'static', keyboard: false});
		$.ajax({
	        type:"post",
	        async:true,
	        url:"../CreateOrder.action",
	        data:{
	        	pesticideid: pes_id,
	        	typeid: t_id,
	        	typetype: $("#confirm_type").val(),
	        	typelife: $("#life").val(),
	        	specificationid:spe_id,
	        	specification: $("#confirm_spe").val(),
	        	piciid: pc_id,
	        	piciremark:$("#remark").val(),
	        	picibtnum:$("#confirm_btnum").val(),
	        	picibxnum:$("#confirm_bxnum").val(),
	        	queryurl: $("#confirm_fixedtext").val(),
	        	pagepath: $("#confirm_pagepath").val()
	        },
	        dataType:"json",
	        success:function(data){
	        	var d = eval("("+data+")");
	        	alert(d.info);
	        	window.location.href="historyorder.html";
	        },
	        error:function(){
	            alert("订单生成失败，请重新生成！");
	        }
	    });
	});
}