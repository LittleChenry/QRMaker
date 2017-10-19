window.onload = function(){
	$.ajax({
        type:"post",
        url:"../OldOrder.action",
        dataType:"json",
        success:function(data){
            var d = eval("("+data+")");
            if(d.length>1){
            	for(var i=0;i<d.length;i++){
                	var j=i+1;
                	var t = "table_tr"+j;
                	var st;
                	switch(d[i].status)
                	{
                	case "0":
                		st="正在生成";
                		$("#body-making").append(
                            	"<tr id="+t+"></tr>"
                            );
        	            $("#"+t).append(
        	            	"<td>"+d[i].remark+"</td>"+
        	            	"<td>"+d[i].name+"</td>"+
        	            	"<td>"+d[i].type+"</td>"+
        	            	"<td>"+d[i].specification+"</td>"+
        	            	"<td>"+d[i].btnum+"</td>"+
        	            	"<td>"+d[i].bxnum+"</td>"+
        	            	"<td>"+st+"</td>"
        	            );
                		break;
                	case "1":
                		var rootfile = d[d.length-1].rootfile;
                		var filepath = "../"+"tempfiles"+"/"+d[i].companyid+"/"+d[i].pesticideid+"/"+d[i].typeid+"/"+d[i].planid+"/"+"QRCODE_PDF&PIC.zip";
                		st="尚未导出";
                		op="<a href='"+filepath+"' onclick='downloaded("+d[i].planid+")' download>下载二维码</a>";
                		$("#body-unexport").append(
                            	"<tr id="+t+"></tr>"
                            );
        	            $("#"+t).append(
        	            	"<td>"+d[i].remark+"</td>"+
        	            	"<td>"+d[i].name+"</td>"+
        	            	"<td>"+d[i].type+"</td>"+
        	            	"<td>"+d[i].specification+"</td>"+
        	            	"<td>"+d[i].btnum+"</td>"+
        	            	"<td>"+d[i].bxnum+"</td>"+
        	            	"<td>"+st+"</td>"+
        	            	"<td>"+op+"</td>"
        	            );
                	break;
                	case "2":
                		var rootfile = d[d.length-1].rootfile;
                		var filepath = "../"+"tempfiles"+"/"+d[i].companyid+"/"+d[i].pesticideid+"/"+d[i].typeid+"/"+d[i].planid+"/"+"QRCODE_PDF&PIC.zip";
                		st="已经导出";
                		op="<a href='"+filepath+"' onclick='downloaded("+d[i].planid+")' download>重新下载二维码 </a><a href='javascript:;'> 删除</a>";
                		$("#body-finished").append(
                            	"<tr id="+t+"></tr>"
                            );
        	            $("#"+t).append(
        	            	"<td>"+d[i].remark+"</td>"+
        	            	"<td>"+d[i].name+"</td>"+
        	            	"<td>"+d[i].type+"</td>"+
        	            	"<td>"+d[i].specification+"</td>"+
        	            	"<td>"+d[i].btnum+"</td>"+
        	            	"<td>"+d[i].bxnum+"</td>"+
        	            	"<td>"+st+"</td>"+
        	            	"<td>"+op+"</td>"
        	            );
                  		break;
                	default:
                		st="已经删除";
                	}
            	}
            }
            
        },
        error:function(){
            alert("系统异常，请稍后重试！");
        }//这里不要加","
    });
};
