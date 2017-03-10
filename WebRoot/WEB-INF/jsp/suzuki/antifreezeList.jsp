<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>长安铃木数据采集系统</title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/admin.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/lyz.calendar.css" rel="stylesheet" type="text/css" />
<!-- <script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery.js"> </script> -->
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"> </script>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/lyz.calendar.min.js"> </script>
<script type="text/javascript">
function search(){
	var vin_code = document.getElementById("vin_code");
	var car_type = document.getElementById("car_type");
	var mobile_unit = document.getElementById("mobile_unit");
	var filling_result = document.getElementById("filling_result");
	var url = "<c:url value="/suzuki/antifreeze.do?m=list"/>";
	if(vin_code.value!=""){
		url+="&vin_code="+vin_code.value;
	}
	if(car_type.value!=""){
		url+="&car_type="+car_type.value;
	}
	if(mobile_unit.value!=""){
		url+="&mobile_unit="+mobile_unit.value;
	}
	if(filling_result.value!=""){
		url+="&filling_result="+filling_result.value;
	}
	if(txtBeginDate.value!=""){
		url+="&txtBeginDate="+txtBeginDate.value;
	}
	if(txtEndDate.value!=""){
		url+="&txtEndDate="+txtEndDate.value;
	}
	location=url;
}

function exportExcel(){
	var vin_code = document.getElementById("vin_code");
	var car_type = document.getElementById("car_type");
	var mobile_unit = document.getElementById("mobile_unit");
	var filling_result = document.getElementById("filling_result");
	var url = "<c:url value="/suzuki/antifreeze.do?m=listExcel"/>";
	if(vin_code.value!=""){
		url+="&vin_code="+vin_code.value;
	}
	if(car_type.value!=""){
		url+="&car_type="+car_type.value;
	}
	if(mobile_unit.value!=""){
		url+="&mobile_unit="+mobile_unit.value;
	}
	if(filling_result.value!=""){
		url+="&filling_result="+filling_result.value;
	}
	if(txtBeginDate.value!=""){
		url+="&txtBeginDate="+txtBeginDate.value;
	}
	if(txtEndDate.value!=""){
		url+="&txtEndDate="+txtEndDate.value;
	}
	location=url;
}

</script>
<script>
    $(function () {
        $("#txtBeginDate").calendar({
            controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
            speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
            complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true
            readonly: true,                                       // 目标对象是否设为只读，默认：true
            upperLimit: new Date(),                               // 日期上限，默认：NaN(不限制)
            lowerLimit: new Date("2011/01/01"),                   // 日期下限，默认：NaN(不限制)
        });
        $("#txtEndDate").calendar();
    });
</script>
</head>
<body>
	<div class="wrap">
		<!--头部定义开始-->
		<div id="header" class="main">
			<jsp:include page="/WEB-INF/jsp/pub/header.jsp"></jsp:include>
		</div>
		<!--头部定义结束-->
		<!--中部内容定义开始-->
		<div class="main">
			<!--右侧内容定义-->

			<div class="c_spacing"></div>
			<div id="instructionalResearch" class="mediumTurquoise"
				style="margin-top:20px;">
				<dl>
					<dt>
						<em><a href="<c:url value="#"/>">防冻液查询</a></em>
					</dt>

				</dl>
			</div>
			<div class="c_spacing"></div>
		</div>
		<!-- 下面是长安铃木的查询内容 -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top">
					<div id="c01">
						<dl>
						    <dt style="padding-right:5px;">
								VIN码:<input type="text" class="qidian" id="vin_code" name="vin_code"
									value="${vin_code}" />
							</dt>
							<dt style="padding-right:5px;">
								车型：<select id="car_type" name="car_type" style="width:100px;" >
								<option value="">全部</option>
								<c:forEach items="${car_typeList}" var="menu">
									<option value="${menu.car_type}" ${menu.car_type==car_type?'selected=selected':''}><c:out value="${menu.car_type}"/></option>
								</c:forEach>
								</select>
							</dt>
							<dt style="padding-right:5px;">
								移动单元：<select id="mobile_unit" name="mobile_unit" style="width:100px;" >
								<option value="">全部</option>
								<c:forEach items="${mobile_unitList}" var="menu">
									<option value="${menu.mobile_unit}" ${menu.mobile_unit==mobile_unit?'selected=selected':''}><c:out value="${menu.mobile_unit}"/></option>
								</c:forEach>
								</select>
							</dt>
							<dt style="padding-right:5px;">
								加注 结果：<select id="filling_result" name="filling_result" style="width:100px;" >
								<option value="">全部</option>
								<c:forEach items="${filling_resultList}" var="menu">
									<option value="${menu.filling_result}" ${menu.filling_result==filling_result?'selected=selected':''}><c:out value="${menu.filling_result}"/></option>
								</c:forEach>
								</select>
							</dt>
							<dt style="padding-right:5px;">
							开始时间：<input id="txtBeginDate" style="width:70px;" value="${txtBeginDate}" />
  
							结束时间：<input id="txtEndDate" style="width:70px;" value="${txtEndDate}" />
						</dt>
							<dd style="padding-right:5px;">
								<input type="button" value="查询" class="chaxun"
									onclick="search()" />
							</dd>
							<dd style="padding-right:5px;">
								<input type="button" value="导出" class="chaxun"
									onclick="exportExcel()" />
							</dd>
						</dl>
						<table width="99%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#dae2e5"  >
							<tr>
								<td  height="30" bgcolor="#e5edfa" align="center">VIN码</td>
								<td  height="30" bgcolor="#e5edfa" align="center">车型</td>
								<td  height="30" bgcolor="#e5edfa" align="center">移动单元</td>
								<td  height="30" bgcolor="#e5edfa" align="center">加注结果</td>
								<td  height="30" bgcolor="#e5edfa" align="center">DATA_TIME</td>
								<td  height="30" bgcolor="#e5edfa" align="center">粗抽真空</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td  height="30" bgcolor="#e5edfa" align="center">细抽真空</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td  height="30" bgcolor="#e5edfa" align="center">泄露检查</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td  height="30" bgcolor="#e5edfa" align="center">二次抽真空</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td  height="30" bgcolor="#e5edfa" align="center">加注压力</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td  height="30" bgcolor="#e5edfa" align="center">最终加注压力</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td  height="30" bgcolor="#e5edfa" align="center">泄露检查</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td  height="30" bgcolor="#e5edfa" align="center">加注</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td  height="30" bgcolor="#e5edfa" align="center">附罐</td>
								<td  height="30" bgcolor="#e5edfa" align="center">时间</td>
								<td width="3%" height="30" bgcolor="#e5edfa" align="center">循环时间</td>
							</tr>
							<c:choose>
								<c:when test="${not empty antifreezeList}">
									<c:forEach items="${antifreezeList}" var="antifreeze" varStatus="vs">
										<tr>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.vin_code}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.car_type}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.mobile_unit}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.filling_result}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"><f:formatDate value="${antifreeze.data_time}" pattern="yyyy/MM/dd HH:mm"/></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.corse_vacuum}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.corse_vacuum_time}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.fine_vacuum}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.fine_vacuum_time}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.vacuum_leak}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.vacuum_leak_time}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.post_vacuum}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.post_vacuum_time}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.filling_pressure}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.filling_pressure_time}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.filling1_high_pressure}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.f1hp_time}" /></td> 
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.filling_pressure_leak}" /></td> 
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.fpl_time}" /></td> 
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.filling_volume}" /></td> 
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.filling_volume_time}" /></td> 
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.filling_additional_volume}" /></td> 
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.fav_time}" /></td> 
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.process_cycle_time}" /></td> 
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="24" height="30" bgcolor="#ffffff" align="center">暂无数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
						<jsp:include page="/WEB-INF/jsp/pub/page.jsp"></jsp:include>
					</div> <br /> <br />
				</td>
			</tr>
		</table>

		<br /> <br />
		<!-- 长安铃木的查询内容结束 -->
	</div>
	<!--中部内容定义结束-->

	<div class="clearbox"></div>
	<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
</body>
</html>
