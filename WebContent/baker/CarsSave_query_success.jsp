<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:auto;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;进出车辆登记<span>&nbsp;
	</div>
</div>

<div id="mainContainer" style="overflow:auto">

<table class="default" width="100%" >
	<col width="10%">
	<col width="7%">
	<col width="7%">
	<col width="10%">
	<col width="25%">
	<col width="25%">
	<col width="10%">
	<col width="6%">
	<tr class="title">
		<td>车牌号</td>
		<td>车主</td>
		<td>品牌</td>
		<td>车辆类型</td>
		<td>登记时间</td>
		<td>注销时间</td>
		<td>停车费</td>
		<td>值班人员</td>
	</tr>
	
	<!-- 通过遍历显示所有车辆资料，读取车辆的集合list后，循环显示车辆数据 -->
	<!-- 遍历开始 -->
	<s:iterator value="#session.carssave_list" var="car">
	<!-- iterator迭代标签；var表示变量的名字为car
	说明：每次遍历，将session中的list的值取出一个放到对象car中，然后从car中取出Cars类的信息。-->
	<tr class="list" >
		<td><s:property value="#car.cnum"/></td>
		<td><s:property value="#car.name"/></td>
		<td><s:property value="#car.cbrand"/></td>
		<td><s:property value="#car.ctype"/></td>
		<td><s:date name="#car.ctime" format="yyyy年MM月dd日HH时MM分"/></td>
		<td><s:date name="#car.outtime" format="yyyy年MM月dd日HH时MM分"/></td>
		<td><s:property value="#car.money"/></td>	
		<td><s:property value="#car.worker"/></td>	
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>
</div>
</body>
</html>