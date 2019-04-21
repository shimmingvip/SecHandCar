<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="/common/taglibs.jsp"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="${ctx }/resource/css/font-awesome.min.css"/>
<link rel="stylesheet" href="${ctx }/resource/css/loginMy.css"/>
<script type="text/javascript" src="${ctx }/resource/js/jquery.min.js"></script>
<style>
html,body{width:100%;}
.main .center {
    width: 36%;
    height: 38em;
    background-position: 55% 56%;
}
</style>
</head>
<body>
<div class="main">
<h1 style="font-family: 'Exo 2', sans-serif;text-align: center;font-weight: 400;font-size: 2em;">用户注册录页面</h1>
	<div class="center">
<!-- 		<form action="" id="formOne" method="post"onsubmit="return submitB()" > -->
		    <input type="text" name="loginName" id="loginName" placeholder="账号名"onblur="checkUser1()"/>
			<br/>
			<input type="text" name="customerName" id="customerName" placeholder="用户名"onb	lur="checkUser()"/>
			<br/>
			<input type="password" name="passWord" id="passWord" placeholder="密码"onblur="checkUser1()"/>
			<br/>
<!-- 			 <span style=>性别：</span> -->
<!-- 			  男:<input type="radio" name="sex" value="1" /> -->
<!-- 		              女:<input type="radio" name="sex" value="2"  /> -->
<!-- 			<br/> -->
			<input type="text" name="phone" id="phone" placeholder="手机号"onblur="checkUser1()"/>
			<br/>
			<input type="submit" value="注册" id="submit" name="submit" onclick="register();"style="padding-left: 0px;width: 45.2%">
			<br/>
			<br/>
			<br/>
		    <a href="${ctx}/login_login.do" style="margin-left: 222px;">点击登录</a>
		      <a href="${ctx}/bid_index.do" style="margin-left: 42px;">进入首页</a>
<!-- 		</form> -->
	</div>
	
</div>


<script type="text/javascript" src="js/loginMy.js"></script>
<div style="text-align:center;">
</div>
</body>
 <script>
	   //注册验证
	function register(){
		   var loginName= $("#loginName").val();
		   var customerName= $("#customerName").val();
			var passWord = $("#passWord").val();
			var phone = $("#phone").val();
	 		$.ajax({
	              url: ctx+'/customer_register.do',
	 			type: 'POST',
	 			dataType: 'json',
	 		    data: {loginName:loginName,passWord:passWord,customerName:customerName,phone:phone},
	 			async: false,
	 			success : function(data) {
	 				if(data.result == 1){
	 					 alert("注册成功");
	 					// window.location.href='${ctx}/login_login.do';
	 					location.href='${ctx}/login_login.do';
	 					}else{
	 					     if(data.result == 2){
	 					    	 alert("该用户已经注册过");
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