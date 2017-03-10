<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp"%>
<ul id="globalNav">
<script type="text/javascript">
var url = document.URL;
var index="washings";
if(url.indexOf("/antifreeze")!=-1){
	index="antifreeze";
}
else if(url.indexOf("/brakeFluidDurr")!=-1){
	index="brakeFluidDurr";
} 
else if(url.indexOf("/brakeFluidYh")!=-1){
	index="brakeFluidYh";
} 
else if(url.indexOf("/coolantDurr")!=-1){
	index="coolantDurr";
}
else if(url.indexOf("/coolantYh")!=-1){
	index="coolantYh";
} 
else if(url.indexOf("/washings")!=-1){
	index="washings";
} 
else if(url.indexOf("/tightenMachine")!=-1){
	index="tightenMachine";
} 
else if(url.indexOf("/transmissionoil")!=-1){
	index="transmissionoil";
}
else if(url.indexOf("/detachment")!=-1){
	index="detachment";
}
else if(url.indexOf("/airtightCheck")!=-1){
	index="airtightCheck";
}
else if(url.indexOf("/a301")!=-1){
	index="a301";
}



if(index=="washings"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/washings.do?m=list"/>"><span>洗涤液</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/washings.do?m=list"/>"><span>洗涤液</span></a></li>');
}
if(index=="brakeFluidYh"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/brakeFluidYh.do?m=list"/>"><span>易恒刹车油</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/brakeFluidYh.do?m=list"/>"><span>易恒刹车油</span></a></li>');
}
if(index=="brakeFluidDurr"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/brakeFluidDurr.do?m=list"/>"><span>杜尔刹车油</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/brakeFluidDurr.do?m=list"/>"><span>杜尔刹车油</span></a></li>');
}
if(index=="antifreeze"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/antifreeze.do?m=list"/>"><span>防冻液</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/antifreeze.do?m=list"/>"><span>防冻液</span></a></li>');
}
if(index=="coolantDurr"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/coolantDurr.do?m=list"/>"><span>杜尔冷媒</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/coolantDurr.do?m=list"/>"><span>杜尔冷媒</span></a></li>');
}
if(index=="coolantYh"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/coolantYh.do?m=list"/>"><span>易恒冷媒</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/coolantYh.do?m=list"/>"><span>易恒冷媒</span></a></li>');
}
if(index=="tightenMachine"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/tightenMachine.do?m=list"/>"><span>拧紧机</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/tightenMachine.do?m=list"/>"><span>拧紧机</span></a></li>');
}
if(index=="transmissionoil"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/transmissionoil.do?m=list"/>"><span>变速箱</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/transmissionoil.do?m=list"/>"><span>变速箱</span></a></li>');
}
if(index=="detachment"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/detachment.do?m=list"/>"><span>脱附检测</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/detachment.do?m=list"/>"><span>脱附检测</span></a></li>');
}
if(index=="airtightCheck"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/airtightCheck.do?m=list"/>"><span>燃油气密</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/airtightCheck.do?m=list"/>"><span>燃油气密</span></a></li>');
}
if(index=="a301"){
	document.write('<li id="topTabOn"><a href="<c:url value="/suzuki/a301.do?m=list"/>"><span>A301</span></a></li>');
}
else{
	document.write('<li><a href="<c:url value="/suzuki/a301.do?m=list"/>"><span>A301</span></a></li>');
}

</script>
</ul>