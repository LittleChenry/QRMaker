$("#button_cancel").click(function(){
	$("#com_pass").val("");
	$("#com_pass2").val("");
});

$("#edit_info").click(function(){
	$("#com_name").removeAttr("readonly");
	$("#com_email").removeAttr("readonly");
});

$("#save_passchange").click(function(){
	alert("请重新登陆！");
});
//登录验证
$(function(){
	$("#login_password").keyup(function(){
		var input = document.getElementById("login_admin");
	    if(input.value.length==0){
	    	input.setCustomValidity("请输入用户名");
	    }
	    else{
	    	input.setCustomValidity("");
	    }
	});

	$("#login_submit").click(function(){
		var input2 = document.getElementById("login_password");
	    if(input2.value.length==0){
	    	input2.setCustomValidity("请输入密码");
	    }
	    else{
	    	input2.setCustomValidity("");
	    }
	});
})


//注册验证
$(function(){
	var ok1=false;
	var ok2=false;
	var ok3=false;
	var ok4=false;
	var ok5=false;
	var ok6=false;
	$("#register_admin").keyup(function(){
		var admin = $(this).val();
	    if(admin==''){
	    	$("#register_admin_span").text("请输入用户名");
	        $("#register_submit").attr('readonly','readonly');
	        ok1=false;
	    }
	    else{
	    	ok1=true;
	    	$("#register_admin_span").css('display','none');
	    }
	    if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
	    	$("#register_submit").removeAttr("disabled");
	    }
	});
	$("#register_name").keyup(function(){
		var name = $(this).val();
	    if(name==''){
	    	$("#register_name_span").text("请输入公司名");
	        $("#register_submit").attr('readonly','readonly');
	        ok2=false;
	    }
	    else{
	    	ok2=true;
	    	$("#register_name_span").css('display','none');
	    }
	    if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
	    	$("#register_submit").removeAttr("disabled");
	    }
	});
	$("#register_id").keyup(function(){
		var id = $(this).val();
	    if(id==''){
	    	$("#register_id_span").text("请输入公司代码");
	        $("#register_submit").attr('readonly','readonly');
	        ok3=false;
	    }
	    else{
	    	ok3=true;
	    	$("#register_id_span").css('display','none');
	    }
	    if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
	    	$("#register_submit").removeAttr("disabled");
	    }
	});
	$("#register_code").keyup(function(){
		var id = $(this).val();
	    if(id==''){
	    	$("#register_code_span").text("请输入政府注册号");
	        $("#register_submit").attr('readonly','readonly');
	        ok3=false;
	    }
	    else{
	    	ok3=true;
	    	$("#register_code_span").css('display','none');
	    }
	    if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
	    	$("#register_submit").removeAttr("disabled");
	    }
	});
	$("#register_email").keyup(function(){
		var email = $(this).val();
	    if(email==''){
	    	$("#register_email_span").text("请输入邮箱");
	        $("#register_submit").attr('readonly','readonly');
	        ok4=false;
	    }
	    else{
	    	ok4=true;
	    	$("#register_email_span").css('display','none');
	    }
	    if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
	    	$("#register_submit").removeAttr("disabled");
	    }
	});
	$("#register_password").keyup(function(){
		var password = $(this).val();
	    if(password==''){
	    	$("#register_password_span").text("请输入密码");
	        $("#register_submit").attr('readonly','readonly');
	        ok5=false;
	    }
	    else{
	    	ok5=true;
	    	$("#register_password_span").css('display','none');
	    }
	    if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
	    	$("#register_submit").removeAttr("disabled");
	    }
	});
	$("#register_password2").keyup(function(){
		var password2 = $(this).val();
	    if(password2==''){
	    	$("#register_password2_span").text("请输入确认密码");
	        $("#register_submit").attr('readonly','readonly');
	        ok6=false;
	    }
	    else{
	    	ok6=true;
	    	$("#register_password2_span").css('display','none');
	    }
	    if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
	    	$("#register_submit").removeAttr("disabled");
	    }
	});
	$("#register_submit").click(function(){
		var admin = $("#register_admin").val();
		var email = $("#register_email").val();
		var id = $("#register_id").val();
		var password = $("#register_password").val();
		var password2 = $("#register_password2").val();
		var formatnum = /^[0-9]*$/;
		var format = /^(([a-z]+[0-9]+)|([0-9]+[a-z]+))[a-z0-9]*$/i;
		var emailformat = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(admin.length<6 || !(format.test(admin))){
	    	$("#register_admin_span").text("字母与数字组合，至少6位");
	    	$("#register_admin_span").css('display','block');
	        return false;
	    }
		if(id.length!=5 || !(formatnum.test(id))){
			$("#register_id_span").text("请输入5位纯数字");
	    	$("#register_id_span").css('display','block');
	        return false;
		}
		if(!(emailformat.test(email))){
			$("#register_email_span").text("请输入正确的邮箱格式");
	    	$("#register_email_span").css('display','block');
	        return false;
		}
	    if(password!=password2){
	    	$("#register_password2_span").text("密码两次输入不同");
	    	$("#register_password2_span").css('display','block');
	    	return false;
	    }else if(password.length<8 || !(format.test(password))){
	    	$("#register_password2_span").text("字母与数字组合，至少8位");
	    	$("#register_password2_span").css('display','block');
	    	return false;
	    }
	    $.ajax({
			type: "POST",
			url: "Register.action",
			data: {
				admin:$("#register_admin").val(),
				name:$("#register_name").val(),
				id:$("#register_id").val(),
				code:$("#register_code").val(),
				email:$("#register_email").val(),
				password:$("#register_password").val()
				},
			dataType: "json",
			success: function(data){
				var djson = eval("("+data+")");
				var situation = djson.situation;
				switch(situation){
				case "0":
					alert("注册成功！");
					window.location.href="pages/verify.html";
				case "1":
					$("#register_id_span").text("该公司已注册过账号");
					$("#register_id_span").css('display','block');
					return false;
				case "2":
					$("#register_admin_span").text("该用户名已被使用过");
					$("#register_admin_span").css('display','block');
					return false;
				default:
					alert("系统异常！");
					return false;
				}
			},
			error:function(){
				alert("系统异常，请稍后重试！");
			}
		});
	});
});

$(function(){
	$("#login_submit").click(function(){
		$.ajax({
	        type:"post",
	        url:"Login.action",
	        data:{
	        	admin:$("#login_admin").val(),
	        	password:$("#login_password").val()
	        },
	        dataType:"json",
	        success:function(data){
	            var d = eval("("+data+")");
	            if(d.message=="0"){
	            	window.location.href="pages/verify.html";
	            }
	            if(d.message=="1"){
	            	window.location.href="pages/addorder.html";
	            }
	            if(d.message=="2"){
	            	window.location.href="pages/verify.html";
	            }
	            if(d.message=="3"){
	            	alert("密码错误");
	            }
	            if(d.message=="4"){
	            	alert("该用户名不存在");
	            }
	        },
	        error:function(){
	            alert("系统异常，请稍后重试！");
	        }
	    });
	})
});


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

