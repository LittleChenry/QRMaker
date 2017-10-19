$("#test").click(function(){
	$.ajax({
        type:"post",
        url:"../Path.action",
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
            alert(d.message);
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }
	});
})