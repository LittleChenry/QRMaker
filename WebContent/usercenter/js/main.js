i = 1;
	document.getElementById("b").onclick=function(){
		if(i < 6){
			document.getElementById("d").innerHTML+='<div id="div_'+i+'" class="tablerow"><p>成分:</p><p> 名称:<input id='+i+'1 name="text_'+i+'" type="text" /> 含量:<input id='+i+'2 name="num_'+i+'" type="text" /> <input id="input_'+i+'" type="button" value="删除"  onclick="del('+i+')"/></p></div>';
			i = i + 1;
			var input=document.getElementById("total");
			input.value=i;
			}
	}
	function del(o){
		document.getElementById("d").removeChild(document.getElementById("div_"+o));
		i = i - 1;
		var input = document.getElementById("total");
		input.value=i;
		j=o;
		for(j=j+1;j<6;j++){
			k=j-1;
			var div = document.getElementById("div_"+j);
			div.id="div_"+k;
			var input = document.getElementById("input_"+j);
			input.id="input_"+k;
			input.setAttribute("onclick","del("+k+")");
			var input = document.getElementById(j+"1");
			input.name="text_"+k;
			input.id=k+"1";
			var input = document.getElementById(j+"2");
			input.name="num_"+k;
			input.id=k+"2";
		}
	}