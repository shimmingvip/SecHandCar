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
	<title>管理后台登陆</title>
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
 <!--  private int id;
    private String carName; //车名
    private CarCategory carCategory;//车型
    private String carOilConsumption;//油耗
    private String carDisplacement;//排量
    private double carPrice;//价格
    private String carColr;//颜色
    private String carImage;//图片
    private int type;//系列  -->
</head>
<body>
<form action="car_exAdd.do" method="post" class="definewidth m20" id="hh" enctype="multipart/form-data">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">车辆类型</td>
        <td> <select name="carCategory.id" >
            <c:forEach  items="${carCatList}" var="cl" varStatus="l">
             <option value="${cl.id }">${cl.cname }</option>
            </c:forEach>
        </select>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">油耗</td>
        <td><input type="text" name="carOilConsumption" id="carOilConsumption" value="${car.carOilConsumption}"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">排量</td>
        <td><input type="text" name="carDisplacement" id="carDisplacement" value="${car.carDisplacement}"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">颜色</td>
        <td><input type="text" name="carColr" id="carColr" value="${car.carColr}"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">图片</td>
        <td><input type="file" name="file" id="" value="${car.carImage}"/></td>
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