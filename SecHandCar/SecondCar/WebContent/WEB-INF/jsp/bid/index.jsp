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
    
    <script src="${ctx}/resource/websitecss/js/assets/jquery-1.11.1.min.js"></script>
    <script src="${ctx}/resource/websitecss/js/bootstrap.min.js"></script>
     <script src="${ctx}/resource/websitecss/js/assets/jquery.backstretch.min.js"></script>
     <script type="text/javascript" src="https://img.99bill.com/seashell/boss-website/js/xAll.js"></script>
      <script src="${ctx}/resource/js/underscore-min.js"></script>

    <script>
    
    var carId=null;
    function showDialog(id){
    	carId=id;
    	$('#myModal').modal('show');
    }
//     function showDialog1(){
//      // window.location.href="${ctx}/bid_myInfo.do";
//       $.ajax({
//           url: ctx+'/bid_myInfo.do',
// 			type: 'POST',
// 			dataType: 'json',
// 		    data: {},
// 			async: false,
// 			success : function(data) {
// 				if(data.result!=null){
		
// 					 renderView(data.result);

// 					 $('#myModal').modal('hide');
// 					}
// 			},
// 				error : function() {
// 					alert("error");
// 				}
// 		});
//     	$('#myModal1').modal('show');
//     }
    
    
    //渲染问题类型选项
//     function renderView(data) {
//         var html = '', tmphtml = $('#tpl_type').html();
//         var compile = _.template(tmphtml);

//         if (data != null) {
//             html += compile({ data: data });
//             $('#view_type').html(html);
//         } else {
//             $('#view_type').html('<br/><center>暂无数据！</center>');
//         }
//     }
    
    
    
    //竞价提交
    function bid(){
		var bidMoney= $("#bidMoney").val();
		var bidTime = $("#bidTime").val();
		$.ajax({
             url: ctx+'/bid_bid.do',
			type: 'POST',
			dataType: 'json',
		    data: {bidMoney:bidMoney,bidTime:bidTime,carId:carId},
			async: false,
			success : function(data) {
				if(data.result == 1){
					 alert("竞价成功");
					 var bidMoney= $("#bidMoney").val('');
				     var bidTime = $("#bidTime").val('');
					 $('#myModal').modal('hide');
					 window.location.href='${ctx}/bid_index.do';
					}else{
						if(data.result == 2){
					  		alert("竞价失败,不得低于该车的价格");
					  		 var bidMoney= $("#bidMoney").val('');	
// 					  		 $('#myModal').modal('hide');
						}else{
							if(data.result ==3){
								alert("竞价失败,你还未登录");
								var bidMoney= $("#bidMoney").val('');
								var bidTime = $("#bidTime").val('');
								 $('#myModal').modal('hide');
							}else{
								alert("竞价失败,你已经竞价过此车");
								var bidMoney= $("#bidMoney").val('');
								var bidTime = $("#bidTime").val('');
								 $('#myModal').modal('hide');
							}
						
						}
					}
			},
				error : function() {
					alert("error");
				}
		});
	}
   
    //查询
	  function index(carPrice){
    		
    		$("#carPrice").val(carPrice)
    		
    		if(carPrice=="-1"){
    			$("#keyword").val($("#queryInput").val());
    		}
    		
    		$("#queryForm").submit();
    	}
    	
    </script>
        
</head>
<body>
<form id="queryForm" name="queryForm" method="post" action="bid_index.do">
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
                <a class="navbar-brand" style="font-family:楷体;font-size:32px" href="bid_index.do"><strong>二手汽车销售</strong></a>
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
<!--                         <button type="button" id="btnCar" class="btn btn-info btn-xs" onclick="javascript:showDialog1();">我的审核信息</button>  -->
                           <a href="${ctx}/bid_myInfo.do" style="display: inline;cursor: pointer;">我的订单</a>
                     </c:if>
                        <a href="${ctx}/login_tuichu.do" style="display: inline;cursor: pointer;">退出</a>
                    </li>
                	 
                </ul>
            </div>
        </nav>

        <hr />
         
        <div class="container">
			 <div class="row">
			  <div class="col-xs-12">
			    <div class="input-group">
			      <input id="queryInput" type="text" class="form-control" placeholder="请输入关键词" style="height:38px;" value="${keyword2 }">
			      <span class="input-group-btn">
<!-- 			        <button id="queryBtn" class="btn btn-info" type="button" onclick="query('-1');">查询</button> -->
                   <button id="queryBtn" class="btn btn-info" type="button" onclick="index('-1');">查询</button>
			      </span>
			    </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
			</div><!-- /.row -->
			
            <div class="row">
            <div class="col-md-12">
            <div class="text-left">
                    <h3><strong>价格区间</strong></h3>
                
                    <p><button type="button" class="btn btn-warning" onclick="index('10');">1-10万</button>
                    <button type="button" class="btn btn-primary" onclick="index('20');">10-20万</button>
                   <button type="button" class="btn btn-success" onclick="index('30');">20-30万</button>
                    <button type="button" class="btn btn-info" onclick="index('40');">30-40万</button>
                    <button type="button" class="btn btn-warning" onclick="index('50');">40-50万</button>
                    <button type="button" class="btn btn-danger" onclick="index('60');">50万以上</button></p>
                    
                    </div>
                 
             <div class="col-xs-12">
             </div>  
               <c:forEach items="${pagers.datas}" var="car" varStatus="status"> 
               <c:if test="${status.index==0 || status.index%6==0}">
                <div class="row">
                </c:if>
                	<div class="col-md-2">
                        <div class="well">
                            <img class="thumbnail img-responsive"  style="cursor:pointer; " src="${car.carImage}" />
                            <div class="caption">
						        <p><span class="label label-warning">车系</span><span style="padding:5px 5px; font-size:8px;">${car.carCategory.cname}</span></p>
						        <p><span class="label label-warning">车名</span><span style="padding:5px 5px;font-size:8px;">${car.carName}</span></p>
						        <p><span class="label label-warning">价格</span><span style="padding:5px 5px;font-size:8px;">￥${car.carPrice}万</span></p>
<%-- 						        <p><span class="label label-warning">油耗</span><span style="padding:5px 5px;font-size:8px;">${car.carOilConsumption}</span></p> --%>
						        <p><span class="label label-warning">排量</span><span style="padding:5px 5px;font-size:8px;">${car.carDisplacement}L</span></p>
						    </div>
						        <p>
						        <button type="button" id="btnCar" class="btn btn-info btn-xs" onclick="javascript:showDialog('${car.id}');">竞价此车</button> 
						        </p>
						 </div>
	                </div>
	             <c:if test="${status.index+1==pagers.total || (status.index+1)%6==0}">
				</div>
				</c:if>
	           </c:forEach>

                </div>
            </div>
        </div>
        </section>
        
        <script>
         
        </script>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel">
					竞价信息填写
				</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form">
				  <div class="form-group">
				    <label for="firstname" class="col-sm-6 control-label">竞价价格</label>
				    <div class="col-sm-10">
				      <input id="bidMoney" type="text" class="form-control" value="" placeholder="单位：万元"/>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="lastname" class="col-sm-6 control-label">竞价时间</label>
				    <div class="col-sm-10">
				      <input id="bidTime" type="text" class="form-control" value="" placeholder="例如：2016-11-15"/>
				    </div>
				  </div>
			</form>
			</div>
			
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="bid();" style="margin-right: 30px;">提交竞价</button>
				</div>
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- 模态框（Modal1） -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel">
					我的审核信息
				</h4>
			</div>
			<div id="view_type" class="modal-body">

				  
	
			</div>
			
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="extraBar" class="layoutExtraBar">
        	<ul class="sideList">
 				 
            </ul>
</div>


      
</form>
 <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/bid_index.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
		<pg:param name="keyword" value="${keyword}"/>
		
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
    
<!--      <script type="text/template" id="tpl_type"> -->
<!-- <table class="table  table-striped"> -->
<!--             <thead> -->
<!--             <tr> -->
<!--                 <th width="30%">状态</th> -->
<!--                 <th width="30%">车型</th> -->
<!--                 <th width="40%">车名</th> -->

<!--             </tr> -->
<!--             </thead> -->
<!--             <tbody id="content"> -->
<%--  <%= for(var i = 0; i < data.length; i++) {%> --%>
            <tr>
<%--                 <td><%= data[i].state %></td> --%>
<%--                 <td><%= data[i].car.carCategory.cname %></td> --%>
<%--                 <td><%= data[i].car.carName %></td> --%>
            </tr>
<%--         <%=};%> --%>
            
            </tbody>
        </table>

   </script>
   
    
    
</body>
</html>



