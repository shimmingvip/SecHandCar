<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>二手车交易系统</title>

    <link rel="stylesheet" type="text/css" href="https://img.99bill.com/seashell/boss-website/css/sidebar.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/websitecss/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/websitecss/css/assets/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/websitecss/css/local.css" />
    <link href="${ctx}/resource/css/common/cart.css"
	rel="stylesheet" type="text/css" />
	<link href="${ctx}/resource/css/common/product.css"
	rel="stylesheet" type="text/css" />
	<link href="${ctx}/resource/css/common/common.css"
	rel="stylesheet" type="text/css" />
    
    <script src="${ctx}/resource/websitecss/js/assets/jquery-1.11.1.min.js"></script>
    <script src="${ctx}/resource/websitecss/js/bootstrap.min.js"></script>
     <script src="${ctx}/resource/websitecss/js/assets/jquery.backstretch.min.js"></script>
     <script type="text/javascript" src="https://img.99bill.com/seashell/boss-website/js/xAll.js"></script>

</head>
<body>
<form id="queryForm" name="queryForm" method="post" action="book_index.do">
<input type="hidden" id="keyword" name="keyword"/>
<input type="hidden" id="keyword2" name="keyword2"/>
<input type="hidden" id="carPrice" name="carPrice"/>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" style="font-family:'楷体';font-size:32px" href="bid_index.do"><strong>二手汽车销售</strong></a>
            </div>
              <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav navbar-right navbar-user">
                	<li style="padding-top: 18px;">
                	<c:if test="${customerName ==null}">
                      <a href="${ctx}/login_login.do" style="display: inline;cursor: pointer;">登录</a>
                      <a href="${ctx}/login_register.do" style="display: inline;cursor: pointer;">注册</a>
                     </c:if>
                     <c:if test="${customerName !=null}">
                      <span style="color: #fff">你好： ${customerName}&nbsp;&nbsp;&nbsp;|</span> 
                           <a href="${ctx}/bid_myInfo.do" style="display: inline;cursor: pointer;">我的订单</a>
                     </c:if>
                        <a href="${ctx}/login_tuichu.do" style="display: inline;cursor: pointer;">退出</a>
                    </li>
                	 
                </ul>
            </div>
        </nav>
        <hr />
         
         	<div class="container cart">

		<div class="span24">

			<div class="step step1">
				<ul>
					<li class="current"></li>
					<li style="margin-left: 250px;color: red;font-size: 23px;margin-top: 10px">我的订单</li>
				</ul>
			</div>
			<table>
				<tbody>
						<tr>
						    <th>审核状态</th>
							<th>车型</th>
							<th>车名</th>
<!-- 							<th>竞标价格</th> -->
<!-- 							<th>实际价格</th> -->
                            <th>价格</th>
							<th>油耗</th>
							<th>排量</th>
							<th>颜色</th>
							<th>图片</th>
						</tr>	
					<c:forEach items="${pagers.datas}" var="bid" varStatus="l">
							<tr>
							 <td >
					           <c:if test="${bid.state==0}">
					             <span style="color: red">未审核</span>
					           </c:if>
					           <c:if test="${bid.state==1}">
					              <span style="color: red"> 审核已通过</span>
					           </c:if>
					           <c:if test="${bid.state==2}">
					              <span style="color: red">审核未通过</span>
					           </c:if>
					           </td>
								<td>${bid.car.carCategory.cname }</td>
								<td>${bid.car.carName }</td>
<!-- 								<td><span class="bidMoney">￥ -->
<%-- 											${bid.bidMoney }万 --%>
<!-- 								</span></td> -->
								<td><span class="carPrice">￥
											${bid.car.carPrice }万
								</span></td>
								<td>${bid.car.carOilConsumption }</td>
								<td>${bid.car.carDisplacement }L</td>
								<td>${bid.car.carColr }</td>
								<td ><img
									src="${bid.car.carImage }"/>
								</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="panel-foot text-center" style="margin: 0 auto; width: 350px" >
      <pg:pager  url="${ctx}/bid_myInfo.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
			<pg:param name="name" value="${product.name}"/>
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
         

<div id="extraBar" class="layoutExtraBar">
        	<ul class="sideList">
 				 
            </ul>
</div>

<script type="text/javascript">
</script>
      
</form>
</body>
</html>
