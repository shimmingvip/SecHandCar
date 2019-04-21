<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!-- 评价界面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx }/resource/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/resource/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/resource/css/style.css" />
    <script type="text/javascript" src="${ctx }/resource/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx }/resource/js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${ctx }/resource/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx }/resource/js/ckform.js"></script>
    <script type="text/javascript" src="${ctx }/resource/js/common.js"></script>
	<title>二手车管理后台登陆</title>
  <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
	 <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }

.table th,
.table td {
  padding: 8px;
  line-height: 20px;
  text-align: left;
  vertical-align: top;
  border-top: 1px solid #dddddd;
}
    </style>

</head>
<body>
<form action="customer_exUpdate.do" method="post" class="definewidth m20" id="hh">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">账号名</td>
        <td><input type="text" name="loginName" id="loginName" value="${customer.loginName}"/>
         <input type="hidden" name="id" value="${customer.id}">
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">真实名</td>
        <td><input type="text" name="customerName" id="customerName" value="${customer.customerName}"/>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">密码</td>
        <td><input type="password" name="passWord" id="passWord" value="${customer.passWord}"/>
        </td>
    </tr>
<!--        <tr> -->
<!--         <td width="10%" class="tableleft">性别</td> -->
<!--         <td> -->
<%--          <input type="radio" name="sex" value="1" <c:if test="${customer.sex == 1 }"> checked="checked" </c:if>/>&nbsp;&nbsp;男 --%>
<!--          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<%--          <input type="radio" name="sex"  value="2"<c:if test="${customer.sex == 2 }"> checked="checked"   </c:if>/>&nbsp;&nbsp;女 --%>
<!--         </td> -->
<!--     </tr> -->
    <tr>
        <td width="10%" class="tableleft">手机号</td>
        <td><input type="text" name="phone" id="phone" value="${customer.phone}"/></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="button" class="btn btn-primary" id="save" type="button">保存</button> &nbsp;&nbsp;
        </td>
    </tr>
</table>
</form>
</body>
<script>
    $(function () { 
    	$("#save").click(function(){
    		$("#hh").submit();
    	});
    	

    });
</script>