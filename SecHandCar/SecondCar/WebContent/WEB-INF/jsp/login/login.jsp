<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="/common/taglibs.jsp"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="${ctx }/resource/css/font-awesome.min.css"/>
<link rel="stylesheet" href="${ctx }/resource/css/loginMy.css"/>
<script type="text/javascript" src="${ctx }/resource/js/jquery.min.js"></script>
<style>
html,body{width:100%;}
</style>
</head>
<body>
<div class="main">
<h1 style="font-family: 'Exo 2', sans-serif;text-align: center;font-weight: 400;font-size: 2em;">登录页面</h1>
	<div class="center">
<%-- 		<form action="${ctx}/customer_login.do " id="formOne" method="post"onsubmit="return submitB()" > --%>
			<i class="fa fa-user Cone">  | </i>
			<input type="text" name="loginName" id="loginName" placeholder="用户名"onblur="checkUser()"/>
			<span id="user_pass"></span>
			<br/>
			<i class="fa fa-key Cone">  | </i>
			<input type="password" name="passWord" id="passWord" placeholder="密码"onblur="checkUser1()"/>
			<span id="pwd_pass"></span>
			<br/>
			<input type="submit" value="登录" id="submit" name="submit" onclick="check()" style="padding-left: 0px;width: 45.2%">
			<br/>
			<br/>
			<br/>
			<br/>
		    <a href="${ctx}/login_register.do" style="margin-left: 222px;">点击注册</a>
		    <a href="${ctx}/bid_index.do" style="margin-left: 42px;">进入首页</a>
<!-- 		</form> -->
	</div>
	
</div>


<script type="text/javascript" src="js/loginMy.js"></script>
<div style="text-align:center;">
</div>
</body>

 <script>
	   //登录验证
	function check(){
		 var loginName= $("#loginName").val();
			var passWord = $("#passWord").val();
	 		$.ajax({
	              url: ctx+'/customer_login.do',
	 			type: 'POST',
	 			dataType: 'json',
	 		    data: {loginName:loginName,passWord:passWord},
	 			async: false,
	 			success : function(data) {
	 				if(data.result == 1){
// 	 					 alert("登录成功");
	 					 window.location.href='${ctx}/bid_index.do';
	 					}else{
	 					     if(data.result == 2){
	 					    	 alert("密码输入错误");
	 					     }else{
	 					    	 if(data.result == 3){
	 					    		alert("该用户不存在"); 
	 					    	 }
	 					    	
	 					     }
	 					}
	 			},
	 				error : function() {
	 					alert("error");
	 				}
	 		});
	   }
			
		
   
	</script>
</html>