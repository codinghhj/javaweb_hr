//后端服务器地址
var baseUrl = "http://localhost:7777/hr-wjx_v2";

//全局ajax事件回调，处理ajax请求session超时
$.ajaxSetup({
	
	complete:function(xhr,textStatus) {
		//判断是否session超时
		var sessionStatus = xhr.getResponseHeader("sessionStatus");
		if(sessionStatus == "timeout") {
			alert("登陆超时，请重新登陆");
			location.top.href = baseUrl + "/logout.jsp";
		}
	}
	
});