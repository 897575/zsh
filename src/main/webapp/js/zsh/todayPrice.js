//初始化页面数据
init();

//初始化页面数据
function init(){
	$.ajax({
		url:"/zsh/oil/query",
		type:"get",
		success:function(data){
			if(data.status==0){
				var oils = data.data;
				$(".zsh_oilPrice_top").text(" 执行日期:"+oils[0].oilDate);
				var html1="<tr><td>品名</td>";
				var html2="<tr><td>价格</td>";
				var html3="<tr><td> <div>品名</div>" +
                    		"<div>(轻质燃油料)</div>" +
                    		"</td>";
				var html4="<tr><td>价格</td>";
				var html5="<tr><td>品名</td>";
				var html6="<tr><td>价格</td>";
				$.each(oils,function(i,field){
					if(field.oilPriceType==1){
						if(field.oilCategoryType==1){
							html1 +="<td>"+field.oilCategory+"</td>";
							html2 +="<td>"+field.oilPrice+"</td>";
						}
						if(field.oilCategoryType==2){
							html3 +="<td>"+field.oilCategory+"</td>";
							html4 +="<td>"+field.oilPrice+"</td>";
						}
					}
					if(field.oilPriceType==2){
						html5 +="<td>"+field.oilCategory+"</td>";
						html6 +="<td>"+field.oilPrice+"</td>";
					}
				});
				html1 +="</tr>";
				html2 +="</tr>";
				html3 +="</tr>";
				html4 +="</tr>";
				html5 +="</tr>";
				html6 +="</tr>";
				$("#oil1").append(html1);
				$("#oil1").append(html2);
				$("#oil2").append(html3);
				$("#oil2").append(html4);
				$("#oil3").append(html5);
				$("#oil3").append(html6);
			}
			if(data.status==1){
				alert(data.describe);
			}
		}
	});
}