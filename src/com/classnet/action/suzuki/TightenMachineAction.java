package com.classnet.action.suzuki;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableWorkbook;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.classnet.dao.suzuki.TightenMachineDao;
import com.classnet.dao.suzuki.TightenMachineDao;
import com.classnet.entity.suzuki.AntifreezeEntity;
import com.classnet.entity.suzuki.TightenMachineEntity;
import com.classnet.util.ListUtil;
import com.classnet.util.WebUtils;
import com.classnet.util.page.IPagination;
import com.classnet.util.page.SimplePagination;
import com.classnet.util.page.WebUtil;

public class TightenMachineAction extends DispatchAction{
	private TightenMachineDao tightenMachineDao;
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String identifier =request.getParameter("identifier");
		String node = request.getParameter("node");
		String tooltype = request.getParameter("tooltype");
		String result = request.getParameter("result");
		Integer channel=0;
		if(request.getParameter("channel")!=null&&!"".equals(request.getParameter("channel")))
		{
			channel = Integer.valueOf(request.getParameter("channel"));
		}
		Integer program=0;
		if(request.getParameter("program")!=null&&!"".equals(request.getParameter("program")))
		{
			program = Integer.valueOf(request.getParameter("program"));
		}
		Integer cycle=0;
		if(request.getParameter("cycle")!=null&&!"".equals(request.getParameter("cycle")))
		{
			cycle = Integer.valueOf(request.getParameter("cycle"));
		}
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 10;
		DetachedCriteria dc = DetachedCriteria.forClass(TightenMachineEntity.class);
		if(!WebUtils.isEmpty(identifier))
		{
			identifier = new String(identifier.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.like("identifier", identifier, MatchMode.ANYWHERE));
			request.setAttribute("identifier", identifier);
		}
		if(!WebUtils.isEmpty(node))
		{
			node = new String(node.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("node", node));
			request.setAttribute("node", node);
		}
		if(!WebUtils.isEmpty(tooltype))
		{
			tooltype = new String(tooltype.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("tooltype", tooltype));
			request.setAttribute("tooltype", tooltype);
		}
		if(!WebUtils.isEmpty(result))
		{
			result = new String(result.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("result", result));
			request.setAttribute("result", result);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("daterq", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("daterq", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		if(channel!=0){
			dc.add(Restrictions.eq("channel", channel));
			request.setAttribute("channel", channel);
		}
		if(program!=0){
			dc.add(Restrictions.eq("program", program));
			request.setAttribute("program", program);
		}
		if(cycle!=0){
			dc.add(Restrictions.eq("cycle", cycle));
			request.setAttribute("cycle", cycle);
		}
		
		//程序查询失效时间
		dc.add(Restrictions.le("daterq", format.parse("2019-02-14")));
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<TightenMachineEntity> tightenMachineList = pp.getPage();
		request.setAttribute("tightenMachineList", tightenMachineList);
		List<TightenMachineEntity> nodeListTemp = tightenMachineDao.findByExample("select distinct node  from TightenMachineEntity");
		List nodeList = ListUtil.listChange(nodeListTemp, "node");
		request.setAttribute("nodeList", nodeList);
		List<TightenMachineEntity> tooltypeListTemp = tightenMachineDao.findByExample("select distinct tooltype  from TightenMachineEntity");
		List tooltypeList = ListUtil.listChange(tooltypeListTemp, "tooltype");
		request.setAttribute("tooltypeList", tooltypeList);
		List<TightenMachineEntity> resultListTemp = tightenMachineDao.findByExample("select distinct result  from TightenMachineEntity");
		List resultList = ListUtil.listChange(resultListTemp, "result");
		request.setAttribute("resultList", resultList);
		return mapping.findForward("list");
	}

	public TightenMachineDao getTightenMachineDao() {
		return tightenMachineDao;
	}

	public void setTightenMachineDao(TightenMachineDao TightenMachineDao) {
		this.tightenMachineDao = TightenMachineDao;
	}

	
	public void listExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String identifier =request.getParameter("identifier");
		String node = request.getParameter("node");
		String tooltype = request.getParameter("tooltype");
		String result = request.getParameter("result");
		Integer channel=0;
		if(request.getParameter("channel")!=null&&!"".equals(request.getParameter("channel")))
		{
			channel = Integer.valueOf(request.getParameter("channel"));
		}
		Integer program=0;
		if(request.getParameter("program")!=null&&!"".equals(request.getParameter("program")))
		{
			program = Integer.valueOf(request.getParameter("program"));
		}
		Integer cycle=0;
		if(request.getParameter("cycle")!=null&&!"".equals(request.getParameter("cycle")))
		{
			cycle = Integer.valueOf(request.getParameter("cycle"));
		}
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 60000;
		DetachedCriteria dc = DetachedCriteria.forClass(TightenMachineEntity.class);
		if(!WebUtils.isEmpty(identifier))
		{
			identifier = new String(identifier.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.like("identifier", identifier, MatchMode.ANYWHERE));
			request.setAttribute("identifier", identifier);
		}
		if(!WebUtils.isEmpty(node))
		{
			node = new String(node.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("node", node));
			request.setAttribute("node", node);
		}
		if(!WebUtils.isEmpty(tooltype))
		{
			tooltype = new String(tooltype.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("tooltype", tooltype));
			request.setAttribute("tooltype", tooltype);
		}
		if(!WebUtils.isEmpty(result))
		{
			result = new String(result.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("result", result));
			request.setAttribute("result", result);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("daterq", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("daterq", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		if(channel!=0){
			dc.add(Restrictions.eq("channel", channel));
			request.setAttribute("channel", channel);
		}
		if(program!=0){
			dc.add(Restrictions.eq("program", program));
			request.setAttribute("program", program);
		}
		if(cycle!=0){
			dc.add(Restrictions.eq("cycle", cycle));
			request.setAttribute("cycle", cycle);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<TightenMachineEntity> tightenMachineList = pp.getPage();
		
		String[] colNames= {"identifier","node","tooltype","result","date","time","channel",
				"program","cycle","data1","data2","data3",
				"data4","data5","data6","data7","data8",
				"data9","data10","data11","data12","data13",
				"duop","op"};
		List exportList = new ArrayList();
		if(tightenMachineList != null && tightenMachineList.size()>0)
		{
			for(int e=0;e<tightenMachineList.size();e++){
				TightenMachineEntity theForm = tightenMachineList.get(e);
				HashMap map = new HashMap();
				map.put(colNames[0], theForm.getIdentifier());
				map.put(colNames[1], theForm.getNode());
				map.put(colNames[2], theForm.getTooltype());
				map.put(colNames[3], theForm.getResult());
				map.put(colNames[4], format2.format(theForm.getDaterq()));
				map.put(colNames[5], theForm.getTime());
				map.put(colNames[6], theForm.getChannel());
				map.put(colNames[7], theForm.getProgram());
				map.put(colNames[8], theForm.getCycle());
				map.put(colNames[9], theForm.getData1() );
				map.put(colNames[10], theForm.getData2());
				map.put(colNames[11], theForm.getData3());
				map.put(colNames[12], theForm.getData4());
				map.put(colNames[13], theForm.getData5());
				map.put(colNames[14], theForm.getData6());
				map.put(colNames[15], theForm.getData7());
				map.put(colNames[16], theForm.getData8());
				map.put(colNames[17], theForm.getData9());
				map.put(colNames[18], theForm.getData10());
				map.put(colNames[19], theForm.getData11());
				map.put(colNames[20], theForm.getData12());
				map.put(colNames[21], theForm.getData13());
				map.put(colNames[22], theForm.getDuop());
				map.put(colNames[23], theForm.getOp());

				exportList.add(map);
			}
			CSVDownload(request, response, exportList, colNames, "拧紧机.xls");
		}
	}

	
	/*
	 * 导出Excle
	 */
	public void CSVDownload(HttpServletRequest request,
			HttpServletResponse response, List lst, String[] headNames, String fileName)
			throws Exception {

		response.reset();
		if (fileName == null || fileName.trim().equals("")) {
			fileName = "default.xls"; // 定义保存的文件名字
		}

		try {
			fileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			fileName = "default.xls";
		}

		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		response.setContentType("application/vnd.ms-excel;charset=GBK");

		WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 11,
				WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
				jxl.format.Colour.BLACK);

		WritableCellFormat titleFormat = new WritableCellFormat(titleFont);
		titleFormat.setBackground(Colour.BLUE_GREY); 

		WritableFont detFont = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				jxl.format.Colour.BLACK);
		WritableCellFormat detFormat = new WritableCellFormat(detFont);

		try {

			OutputStream os = response.getOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			jxl.write.WritableSheet ws = wwb.createSheet("Sheet1", 0);
			jxl.write.Label labelC = null;
			
			// ##############打印头#############################
			for (int i=0;i<headNames.length;i++) {
				labelC = new jxl.write.Label(i, 0, WebUtils.interlize(headNames[i]), titleFormat);
				ws.addCell(labelC);
			}

			// ############# body#############################
			for (int rows = 0; rows < lst.size(); rows++) {
				HashMap map = (HashMap) lst.get(rows);
				for (int i=0;i<headNames.length;i++) {
					Object lvalue = map.get(headNames[i]);
					if (lvalue != null && !lvalue.equals("")) {

					} else {
						lvalue = " ";
					}
					labelC = new jxl.write.Label(i, rows + 1, WebUtils.interlize(lvalue.toString()), detFormat);
					ws.addCell(labelC);
				}
			}

			// 设置表格的宽度
			int column = 0;
			for (int i=0;i<headNames.length;i++) {
				ws.setColumnView(column++, 15);
			}
			wwb.write();
			// 关闭Excel工作薄对象
			wwb.close();
			os.close();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}


}
