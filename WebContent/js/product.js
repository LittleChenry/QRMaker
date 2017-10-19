window.onload = function(){
	$.ajax({
        type:"post",
        async:false,
        url:"../ShowInfo.action",
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
            var l = d.length;
            if(l>1){
            	for(var i=0;i<l-1;i++){
                	var j=i+1;
                	var t = "pesticide_tr"+j;
            		$("#tb_pesticide").append(
                        	"<tr id="+t+"></tr>"
                        );
    	            $("#"+t).append(
    	            	"<td>"+d[i].num+"</td>"+
    	            	"<td>"+d[i].name+"</td>"+
    	            	"<td>"+"有毒"+"</td>"+
    	            	"<td>"+"轻度污染"+"</td>"+
    	            	"<td>"+d[i].described+"</td>"+
    	            	"<td>"+d[i].solution+"</td>"+
    	            	"<td>"+d[i].usage+"</td>"
    	            );
                }
            }
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }
    });
	
	$.ajax({
        type:"post",
        async:false,
        url:"../ShowType.action",
        data:{id:"0"},
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
            var l = d.length;
            if(l>1){
            	for(var i=0;i<l-1;i++){
                	var j=i+1;
                	var t = "type_tr"+j;
            		$("#tb_type").append(
                        	"<tr id="+t+"></tr>"
                        );
    	            $("#"+t).append(
    	            	"<td>"+j+"</td>"+
    	            	"<td>"+d[i].pesticide+"</td>"+
    	            	"<td>"+d[i].type+"</td>"+
    	            	"<td>"+d[i].life+"</td>"+
    	            	"<td>"+d[i].specification+"</td>"+
    	            	"<td><a href='javascript:;'>操作</a></td>"
    	            );
                }
            }
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }
    });
	
	$.ajax({
        type:"post",
        async:false,
        url:"../ShowPlan.action",
        data:{id:"0"},
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
            var l = d.length;
            if(l>1){
            	for(var i=0;i<l-1;i++){
                	var j=i+1;
                	var t = "plan_tr"+j;
            		$("#tb_plan").append(
                        	"<tr id="+t+"></tr>"
                        );
    	            $("#"+t).append(
    	            	"<td>"+d[i].remark+"</td>"+
    	            	"<td>"+d[i].type+"</td>"+
    	            	"<td>"+d[i].btnum+"</td>"+
    	            	"<td>"+d[i].bxnum+"</td>"+
    	            	"<td><a href='javascript:;'>操作</a></td>"
    	            );
                }
            }
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }
    });
	
	$.ajax({
        type:"post",
        async:false,
        url:"../ShowFixedinfo.action",
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
        	var t = "fixedinfo_tr";
    		$("#tb_fixedinfo").append(
                	"<tr id="+t+"></tr>"
                );
            $("#"+t).append(
            	"<td>"+d.fixedtext+"</td>"+
            	"<td>"+d.pagepath+"</td>"+
            	"<td><a href='javascript:;'>操作</a></td>"
            );
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }
    });
}