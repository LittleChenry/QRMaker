window.onload = function(){
	var name,id,admin,code,email;
	$.ajax({
        type:"post",
        url:"../ShowUserinfo.action",
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
            name=d.name;
            id=d.id;
            code=d.code;
            admin=d.admin;
            email=d.email;
            $("#com_id").val(d.id);
            $("#com_name").val(d.name);
            $("#com_code").val(d.code);
            $("#com_admin").val(d.admin);
            $("#com_email").val(d.email);
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }
    });

	
	$("#edit_info").click(function(){
		$("#com_admin").removeAttr("readonly");
		$("#com_email").removeAttr("readonly");
		$("#save_info").removeAttr("disabled");
	});
	
	$("#save_info").click(function(){
		$.ajax({
	        type:"post",
	        async:false,
	        url:"../ChangeInfo.action",
	        data:{
	        	admin:$("#com_admin").val(),
	        	email:$("#com_email").val()
	        },
	        dataType:"json",
	        success:function(data){
	            var d = eval("("+data+")");
	            if(d.message=="1"){
	            	$("#com_admin").val(admin);
		            $("#com_email").val(email);
	            	alert("该用户名已被注册！");
	            }
	            if(d.message=="0"){
		            $("#com_admin").val(d.admin);
		            $("#com_email").val(d.email);
		            alert("修改成功！");
		            //window.location.href="userinfo.html";
	            }
	        },
	        error:function(){
	            alert("系统异常，请稍后重试！");
	        }
	    });
		$("#com_admin").attr("readonly","readonly");
		$("#com_email").attr("readonly","readonly");
		$("#save_info").attr("disabled","disabled");
	});
	
	$("#oldpassword").keyup(function(){
		if(($("#oldpassword").val()!='')&&($("#newpassword").val()!='')&&($("#newpassword2").val()!='')){
			$("#save_passchange").removeAttr("disabled");
		}
		if(($("#oldpassword").val()=='')||($("#newpassword").val()=='')||($("#newpassword2").val()=='')){
			$("#save_passchange").attr("disabled","disabled");
		}
		if(($("#oldpassword").val()!='')||($("#newpassword").val()!='')||($("#newpassword2").val()!='')){
			$("#cancel_passchange").removeAttr("disabled");
		}
		if(($("#oldpassword").val()=='')&&($("#newpassword").val()=='')&&($("#newpassword2").val()=='')){
			$("#cancel_passchange").attr("disabled","disabled");
		}
	});
	$("#newpassword").keyup(function(){
		if(($("#oldpassword").val()!='')&&($("#newpassword").val()!='')&&($("#newpassword2").val()!='')){
			$("#save_passchange").removeAttr("disabled");
		}
		if(($("#oldpassword").val()=='')||($("#newpassword").val()=='')||($("#newpassword2").val()=='')){
			$("#save_passchange").attr("disabled","disabled");
		}
		if(($("#oldpassword").val()!='')||($("#newpassword").val()!='')||($("#newpassword2").val()!='')){
			$("#cancel_passchange").removeAttr("disabled");
		}
		if(($("#oldpassword").val()=='')&&($("#newpassword").val()=='')&&($("#newpassword2").val()=='')){
			$("#cancel_passchange").attr("disabled","disabled");
		}
	});
	$("#newpassword2").keyup(function(){
		if(($("#oldpassword").val()!='')&&($("#newpassword").val()!='')&&($("#newpassword2").val()!='')){
			$("#save_passchange").removeAttr("disabled");
		}
		if(($("#oldpassword").val()=='')||($("#newpassword").val()=='')||($("#newpassword2").val()=='')){
			$("#save_passchange").attr("disabled","disabled");
		}
		if(($("#oldpassword").val()!='')||($("#newpassword").val()!='')||($("#newpassword2").val()!='')){
			$("#cancel_passchange").removeAttr("disabled");
		}
		if(($("#oldpassword").val()=='')&&($("#newpassword").val()=='')&&($("#newpassword2").val()=='')){
			$("#cancel_passchange").attr("disabled","disabled");
		}
	});
	
	
}

$(function(){
	$("#save_passchange").click(function(){
		if($("#newpassword").val()==$("#newpassword2").val()){
			$.ajax({
		        type:"post",
		        async:false,
		        url:"../ChangePassword.action",
		        data:{
		        	oldpassword:$("#oldpassword").val(),
		        	newpassword:$("#newpassword").val()
		        },
		        dataType:"json",
		        success:function(data){
		        	var d = eval("("+data+")");
		        	if(d.message=="1"){
		        		alert("修改成功，请重新登陆！");
		        		window.location.href="../Logout.action";
		        		
		        	}else{
		        		alert("旧密码输入有误");
		        	}
		        },
		        error:function(){
		            alert("系统异常，请稍后重试！");
		        }
		    });
		}else{
			alert("新密码两次输入不一致");
		}
	});
})



















