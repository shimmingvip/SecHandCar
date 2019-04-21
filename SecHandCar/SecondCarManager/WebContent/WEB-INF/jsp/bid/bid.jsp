<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!-- 评价界面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <title>二手车后台管理系统</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/style.css" />
    <script type="text/javascript" src="${ctx}/resource/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/common.js"></script>
</head>
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
       td{text-align:center;}
    </style>
<body>
<!--private int id;
	private Customer customer;//与客户表关联
	private CarCategory carCategory;//车型
	private String bidTime; //竞价时间
    private double bidMoney; //竞价价格
    private int state;//是否审核 0：未审核 1：审核通过
    private int  isDelete; //0:不删除 1：删除  -->
<form class="form-inline definewidth m20" action="bid_bid.do" method="post">  
    竞价客户名：
    <input type="text" name="cName" id="cName"class="abc input-default" placeholder="" value="${cName}">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
</form>
<table class="table table-bordered table-hover definewidth m10" align="center">
    <thead>
    <tr>
        <th>竞价ID</th>
        <th>竞价车型</th>
        <th>竞价车名</th>
        <th>竞价价格</th>
<!--         <th>实际价格</th> -->
        <th>竞价时间</th>
        <th>竞价客户</th>
        <th>客户手机号</th>
        <th>审核状态</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
     <c:forEach items="${pagers.datas}" var="bid" varStatus="l">
      <tr >
            <td align="center">${bid.id}</td>
            <td>${bid.car.carCategory.cname}</td>
            <td>${bid.car.carName}</td>
            <td>￥${bid.bidMoney}万</td>
<%--             <td>￥${bid.car.carPrice}万</td> --%>
            <td>${bid.bidTime}</td>
            <td>${bid.customer.customerName}</td>
            <td>${bid.customer.phone}</td>
            <td>
               <c:if test="${bid.state == 0 }">
                                             未审核
               </c:if>
               <c:if test="${bid.state == 1 }">
                                             审核通过
               </c:if>
               <c:if test="${bid.state == 2 }">
                                             审核不通过
               </c:if>
            </td>
            <td>
               <c:if test="${bid.isDelete == 0 }">
                                              正常
               </c:if>
               <c:if test="${bid.isDelete == 1 }">
                                             删除
               </c:if>
            </td>
             <td>
              <c:if test="${bid.state == 0 }">
              <a id="update" href="${ctx}/bid_pass.do?id=${bid.id}">审核通过</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a id="update" href="${ctx}/bid_nopass.do?id=${bid.id}">审核不通过</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a id="update" href="${ctx}/bid_delete.do?id=${bid.id}" onclick= "if(confirm( '是否删除！ ')==false)return   false; ">删除</a>
              </c:if>
               <c:if test="${bid.state == 1 || bid.state == 2}">
                <a id="update" href="${ctx}/bid_delete.do?id=${bid.id}" onclick= "if(confirm( '是否删除！ ')==false)return   false; ">删除</a>   
               </c:if>
            </td>
        </tr>
     </c:forEach>
 </table>
 <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/bid_bid.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
		<pg:param name="cName" value="${cName}"/>
		
		<pg:last>  
			共${pagers.total}记录,共${pageNumber}页,  
		</pg:last>  
			当前第${curPage}页 
  
        <pg:first>  
    		<a href="${pageUrl}">首页</a>  
		</pg:first>  
		<pg:prev>  
    		<a href="${pageUrl}">上一页</a>  
		</pg:prev>  
      
       	<pg:pages>  
        	<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">[${pageNumber }]</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">${pageNumber}</a>  
            	</c:otherwise>  
        	</c:choose>  
    	</pg:pages>
             
        <pg:next>  
    		<a href="${pageUrl}">下一页</a>  
		</pg:next>  
		<pg:last>  
			<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">尾页</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">尾页</a>  
            	</c:otherwise>  
        	</c:choose> 
    		  
		</pg:last>
	</pg:pager>
    </div>
</body>
<script>
    $(function () {
		$('#add').click(function(){
			window.location.href="${ctx}/bid_add.do";
		 });
    });

</script>