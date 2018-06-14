<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="js/bootstrap/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
		*{
			margin: 0;
			padding: 0;
		}
		body {
			background: #333333;
		}
		.touxiang{
			width: 150px;
			height: 150px;
			margin:20px auto;
			border-radius: 50%;
			overflow: hidden;
			border: 5px solid #fff;
		}
		.nav-left .list-group-item{
			background:transparent;
			border:none;
			border-radius: 0;
			color:#eee;
			font-size: 16px;
			line-height: 35px;
			letter-spacing: 1px;
			text-align: center;
			border-bottom: 1px solid #666;
		}
			.nav-left span{
			
				
				margin-right: 10px;
					
			}
</style>
<body>
	<div class="container-fluid">
		<!--
        	作者：1749574663@qq.com
        	时间：2018-05-30
        	描述：头像区开始
        -->
        <div class="row touxiang">
        	<a href="UpdateHead.html" title="点击修改头像" target="content">
        		<img src="" class="img-responsive" id="headImg">
        	</a>
        </div>
        <p class="text-center" style="color: #eee;">欢迎您，${empLoginName}</p>
		<!-- 左侧导航开始 -->
		<div class="row nav-left">
			<div class="list-group">
				<a href="QueryDept.html"  target="content" class="list-group-item active"><span class="glyphicon glyphicon-bullhorn"></span>部门管理</a>
				<a href="QueryJob.html"  target="content" class="list-group-item active"><span class="glyphicon glyphicon-duplicate"></span>职务管理</a>
				<a href="QueryEmp.html" target="content" class="list-group-item active"><span class="glyphicon glyphicon-user"></span>员工管理</a>
				<a href="Analyze.html" target="content" class="list-group-item active"><span class="glyphicon glyphicon-dashboard"></span>数据分析</a>
				<a href="#" target="content" class="list-group-item active"><span class="glyphicon glyphicon-adjust"></span>数据检索</a>
				<a href="QueryPic.html" target="content" class="list-group-item active"><span class="glyphicon glyphicon-copyright-mark"></span>公司图库</a>
				<a href="UpdateEmpPwd.html" target="content" class="list-group-item active"><span class="glyphicon glyphicon-share-alt"></span>修改密码</a>
				<a href="logout.jsp" target="_top" class="list-group-item active"><span class="glyphicon glyphicon-log-out"></span>退出登录</a>
				
			</div>
		</div>
	</div>
	<!--引入jquery，因为bootstrap.js依赖了jquery-->
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script src="js/layer/layer.js"></script>
	<script src="js/global.js"></script>
	<!--引入bootstrap.js，实现js功能-->
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.js" ></script>	
	<script>
		$.get(baseUrl + "/emp/getPic",function(data) {
			console.log(data);
			
			if(data && data != 'null'){
				$('#headImg').attr('src',data);
				
			}else{
				$('#headImg').attr('src','images/touxiang.png');
				
			}
			localStorage.setItem('headImg', data); 
		},'text').error(function(xhr,errorStatus,errorText) {
			layer.msg("头像请求失败" + errorText);
		});
	</script>
	
</body>
</html>