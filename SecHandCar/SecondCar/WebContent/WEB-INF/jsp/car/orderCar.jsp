<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!-- 评价界面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <title>后台管理系统</title>
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
 
<form class="form-inline definewidth m20" action="car_orderCar.do" method="post">  
    <button type="submit" class="btn btn-primary">按照销量排行</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" id="add">新增车辆</button>
</form>
<table class="table table-bordered table-hover definewidth m10" align="center">
    <thead>
    <!--  private int id;
    private String carName; //车名
    private CarCategory carCategory;//车型
    private String carOilConsumption;//油耗
    private String carDisplacement;//排量
    private double carPrice;//价格
    private String carColr;//颜色
    private String carImage;//图片
    private int type;//系列  -->
    <tr>
        <th>车辆ID</th>
        <th>车型</th>
        <th>油耗</th>
        <th>排量</th>
        <th>价格</th>
        <th>库存</th>
        <th>销量</th>
        <th>退车次数</th>
        <th>图片</th>
        <th>操作</th>
    </tr>
    </thead>
     <c:forEach items="${pagers.datas}" var="car" varStatus="l">
      <tr >
            <td align="center">${car.id}</td>
            <td>${car.carCategory.cname}</td>
            <td>${car.carOilConsumption}</td>
            <td>${car.carDisplacement}</td>
            <td>${car.carPrice}</td>
            <td>${car.carCategory.carNumber}</td>
            <td>${car.carCategory.carLevel}</td>
            <td>${car.carCategory.carReturn}</td>
            <td><img src="${car.carImage}" style="height: 80px;width: 100px"></td>
             <td>
                   <a id="update" href="${ctx}/car_update.do?id=${car.id}">修改</a>
                   <a id="update" href="${ctx}/car_delete.do?id=${car.id}">删除</a>
            </td>
        </tr>
     </c:forEach>
 </table>
 <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/car_car.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
		<pg:param name="" value=""/>
		
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
			window.location.href="${ctx}/car_add.do";
		 });
    });

//     function del(id)
// 	{
// 		if(confirm("确定要删除吗？"))
// 		{
// 			url="${ctx}/userlogin/delnode?id="+id;
//     		$.ajax({
//     			//cache: true,
//     			type : "post",
//     			url : url,
//     			dataType :'json',
//     			async : false,
//     			error : function(request) {
//     				return false;
//     			},
//     			success : function(data) {
//     				console.log(data)
//     				if(data.status ==1){
// 						 alert(data.desc);
// 						 window.location.href="${ctx}/userlogin/Node";
// 					 }else{
// 						 alert(data.desc);
// 				 }
//     			}
//     		});		
// 		}
// 	}
</script>