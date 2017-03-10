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
	var t_vin = document.getElementById("t_vin");
	var t_abon = document.getElementById("t_abon");
	var t_type = document.getElementById("t_type");
	var t_result = document.getElementById("t_result");
	var url = "<c:url value="/suzuki/detachment.do?m=list"/>";
	if(t_vin.value!=""){
		url+="&t_vin="+t_vin.value;
	}
	if(t_abon.value!=""){
		url+="&t_abon="+t_abon.value;
	}
	if(t_type.value!=""){
		url+="&t_type="+t_type.value;
	}
	if(t_result.value!=""){
		url+="&t_result="+t_result.value;
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
	var t_vin = document.getElementById("t_vin");
	var t_abon = document.getElementById("t_abon");
	var t_type = document.getElementById("t_type");
	var t_result = document.getElementById("t_result");
	var url = "<c:url value="/suzuki/detachment.do?m=listExcel"/>";
	if(t_vin.value!=""){
		url+="&t_vin="+t_vin.value;
	}
	if(t_abon.value!=""){
		url+="&t_abon="+t_abon.value;
	}
	if(t_type.value!=""){
		url+="&t_type="+t_type.value;
	}
	if(t_result.value!=""){
		url+="&t_result="+t_result.value;
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
						<em><a href="<c:url value="#"/>">脱附检测查询</a></em>
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
								VIN码:<input type="text" class="qidian" id="t_vin" name="t_vin"
									value="${t_vin}" />
							</dt>
							<dt style="padding-right:5px;">
								ABON号：<input type="text" class="qidian" id="t_abon" name="t_abon"
									value="${t_abon}" />
							</dt>
							<dt style="padding-right:5px;">
								车型：<select id="t_type" name="t_type" style="width:100px;" >
								<option value="">全部</option>
								<c:forEach items="${t_typeList}" var="menu">
									<option value="${menu.t_type}" ${menu.t_type==t_type?'selected=selected':''}><c:out value="${menu.t_type}"/></option>
								</c:forEach>
								</select>
							</dt>
							<dt style="padding-right:5px;">
								检测结果：<select id="t_result" name="t_result" style="width:100px;" >
								<option value="">全部</option>
								<c:forEach items="${t_resultList}" var="menu">
									<option value="${menu.t_result}" ${menu.t_result==t_result?'selected=selected':''}><c:out value="${menu.t_result}"/></option>
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
								<td  height="30" bgcolor="#e5edfa" align="center">ABON号</td>
								<td  height="30" bgcolor="#e5edfa" align="center">VIN码</td>
								<td  height="30" bgcolor="#e5edfa" align="center">车型</td>
								<td  height="30" bgcolor="#e5edfa" align="center">T_DATE</td>
								<td  height="30" bgcolor="#e5edfa" align="center">T_TIME</td>
								<td  height="30" bgcolor="#e5edfa" align="center">检测结果</td>
								<td  height="30" bgcolor="#e5edfa" align="center">T_TP</td>
								<td  height="30" bgcolor="#e5edfa" align="center">T_FL</td>
							</tr>
							<c:choose>
								<c:when test="${not empty detachmentList}">
									<c:forEach items="${detachmentList}" var="antifreeze" varStatus="vs">
										<tr>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.t_abon}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.t_vin}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.t_type}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"><f:formatDate value="${antifreeze.t_date}" pattern="yyyy/MM/dd HH:mm"/></td>
											<td height="30" bgcolor="#FFFFFF" align="center"><f:formatDate value="${antifreeze.t_time}" pattern="yyyy/MM/dd HH:mm"/></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.t_result}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.t_tp}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.t_fl}" /></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="8" height="30" bgcolor="#ffffff" align="center">暂无数据</td>
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
