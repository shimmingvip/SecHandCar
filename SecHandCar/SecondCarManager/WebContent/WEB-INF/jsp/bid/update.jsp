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
<form action="book_exUpdate.do" method="post" class="definewidth m20" id="hh" enctype="multipart/form-data">
<table class="table table-bordered table-hover definewidth m10">
     <tr>
        <td width="10%" class="tableleft">预约名</td>
        <td><input type="text" name="bookName" id="bookName" value="${book.bookName}"/>
             <input  name="id" type="hidden" value="${book.id }"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">车辆类型</td>
        <td> <select name="carCategory.id" >
            <c:forEach  items="${carCatList}" var="cl" varStatus="l">
                  <c:choose>
                  <c:when test="${car.carCategory.id== cl.id}">
                      <option value="${cl.id }" selected="selected">${cl.cname }</option>
                   </c:when>
                  <c:otherwise>
                            <option value="${cl.id }">${cl.cname }</option>
                  </c:otherwise>
                  </c:choose>
            </c:forEach>
        </select>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">预约时间</td>
        <td><input type="text" name="bookTime" id="bookTime" value="${book.bookTime}"/></td>
    </tr>
      <tr>
        <td width="10%" class="tableleft">预约手机号码</td>
        <td><input type="text" name="bookPhone" id="bookPhone" value="${book.bookPhone}"/></td>
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