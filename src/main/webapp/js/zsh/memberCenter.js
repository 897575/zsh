//加载用户信息
$.ajax({
	url:"/zsh/customer/query",
	type:"get",
	success:function(data){
		if(data.status==0){
			var customer = data.data
			var html=
                		"<div class='memberCenter_icon'>" +
                			"<img src='"+customer.customerHead+"' >" +
                		"</div>" +
                		"<div class='memberCenter_name'>" +
                			"<span>"+customer.customerName+"</span>" ;
							if(customer.customerType){
								html +="<span><img src='img/goldIcon.png'></span>";
							}
                			
                    	html +="</div>" +
                    	"<div class='memberCenter_score'>"+
                    	"积分余额: <a>"+customer.customerIntegral+"</a>积分"+
                    	"</div>";
                   
                    	
			$(".memberCenter_top").append(html);
		}
		if(data.status==1){
			alert(data.describe);
		}
	}
});