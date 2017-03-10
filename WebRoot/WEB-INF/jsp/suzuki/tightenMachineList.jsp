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
	var identifier = document.getElementById("identifier");
	var node = document.getElementById("node");
	var tooltype = document.getElementById("tooltype");
	var result = document.getElementById("result");
	var channel = document.getElementById("channel");
	var program = document.getElementById("program");
	var cycle = document.getElementById("cycle");
	
	var url = "<c:url value="/suzuki/tightenMachine.do?m=list"/>";
	if(identifier.value!=""){
		url+="&identifier="+identifier.value;
	}
	if(node.value!=""){
		url+="&node="+node.value;
	}
	if(tooltype.value!=""){
		url+="&tooltype="+tooltype.value;
	}
	if(result.value!=""){
		url+="&result="+result.value;
	}
	if(txtBeginDate.value!=""){
		url+="&txtBeginDate="+txtBeginDate.value;
	}
	if(txtEndDate.value!=""){
		url+="&txtEndDate="+txtEndDate.value;
	}
	if(channel.value!=""){
		url+="&channel="+channel.value;
	}
	if(program.value!=""){
		url+="&program="+program.value;
	}
	if(cycle.value!=""){
		url+="&cycle="+cycle.value;
	}
	location=url;
}

function exportExcel(){
	var identifier = document.getElementById("identifier");
	var node = document.getElementById("node");
	var tooltype = document.getElementById("tooltype");
	var result = document.getElementById("result");
	var channel = document.getElementById("channel");
	var program = document.getElementById("program");
	var cycle = document.getElementById("cycle");
	
	var url = "<c:url value="/suzuki/tightenMachine.do?m=listExcel"/>";
	if(identifier.value!=""){
		url+="&identifier="+identifier.value;
	}
	if(node.value!=""){
		url+="&node="+node.value;
	}
	if(tooltype.value!=""){
		url+="&tooltype="+tooltype.value;
	}
	if(result.value!=""){
		url+="&result="+result.value;
	}
	if(txtBeginDate.value!=""){
		url+="&txtBeginDate="+txtBeginDate.value;
	}
	if(txtEndDate.value!=""){
		url+="&txtEndDate="+txtEndDate.value;
	}
	if(channel.value!=""){
		url+="&channel="+channel.value;
	}
	if(program.value!=""){
		url+="&program="+program.value;
	}
	if(cycle.value!=""){
		url+="&cycle="+cycle.value;
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
						<em><a href="<c:url value="#"/>">拧紧机查询</a></em>
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
								identifier:<input type="text" class="qidian" id="identifier" name="identifier"
									value="${identifier}" />
							</dt>
							<dt style="padding-right:5px;">
								node：<select id="node" name="node" style="width:100px;" >
								<option value="">全部</option>
								<c:forEach items="${nodeList}" var="menu">
									<option value="${menu.node}" ${menu.node==node?'selected=selected':''}><c:out value="${menu.node}"/></option>
								</c:forEach>
								</select>
							</dt>
							<dt style="padding-right:5px;">
								tooltype：<select id="tooltype" name="tooltype" style="width:100px;" >
								<option value="">全部</option>
								<c:forEach items="${tooltypeList}" var="menu">
									<option value="${menu.tooltype}" ${menu.tooltype==tooltype?'selected=selected':''}><c:out value="${menu.tooltype}"/></option>
								</c:forEach>
								</select>
							</dt>
							<dt style="padding-right:5px;">
								result：<select id="result" name="result" style="width:100px;" >
								<option value="">全部</option>
								<c:forEach items="${resultList}" var="menu">
									<option value="${menu.result}" ${menu.result==result?'selected=selected':''}><c:out value="${menu.result}"/></option>
								</c:forEach>
								</select>
							</dt>
							<dt style="padding-right:5px;">
							开始时间：<input id="txtBeginDate" style="width:70px;" value="${txtBeginDate}" />
  
							结束时间：<input id="txtEndDate" style="width:70px;" value="${txtEndDate}" />
						</dt>
							
						</dl>
						<dl>
						<dt style="padding-right:5px;">
								channel:<input type="text" class="qidian" id="channel" name="channel"
									value="${channel}" />
							</dt>
							<dt style="padding-right:5px;">
								program:<input type="text" class="qidian" id="program" name="program"
									value="${program}" />
							</dt>
							<dt style="padding-right:5px;">
								cycle:<input type="text" class="qidian" id="cycle" name="cycle"
									value="${cycle}" />
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
								<td  height="30" bgcolor="#e5edfa" align="center">identifier</td>
								<td  height="30" bgcolor="#e5edfa" align="center">node</td>
								<td  height="30" bgcolor="#e5edfa" align="center">tooltype</td>
								<td  height="30" bgcolor="#e5edfa" align="center">result</td>
								<td  height="30" bgcolor="#e5edfa" align="center">date</td>
								<td  height="30" bgcolor="#e5edfa" align="center">time</td>
								<td  height="30" bgcolor="#e5edfa" align="center">channel</td>
								<td  height="30" bgcolor="#e5edfa" align="center">program</td>
								<td  height="30" bgcolor="#e5edfa" align="center">cycle</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data1</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data2</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data3</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data4</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data5</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data6</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data7</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data8</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data9</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data10</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data11</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data12</td>
								<td  height="30" bgcolor="#e5edfa" align="center">data13</td>
								<td  height="30" bgcolor="#e5edfa" align="center">duop</td>
								<td  height="30" bgcolor="#e5edfa" align="center">op</td>
							</tr>
							<c:choose>
								<c:when test="${not empty tightenMachineList}">
									<c:forEach items="${tightenMachineList}" var="antifreeze" varStatus="vs">
										<tr>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.identifier}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.node}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.tooltype}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.result}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"><f:formatDate value="${antifreeze.daterq}" pattern="yyyy/MM/dd HH:mm"/></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.time}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.channel}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.program}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.cycle}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data1}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data2}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data3}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data4}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data5}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data6}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data7}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data8}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data9}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data10}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data11}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data12}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.data13}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.duop}" /></td>
											<td height="30" bgcolor="#FFFFFF" align="center"> <c:out value="${antifreeze.op}" /></td>
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
