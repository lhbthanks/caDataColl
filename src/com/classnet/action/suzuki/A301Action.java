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

import jxl.CellView;
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

import com.classnet.dao.suzuki.A301Dao;
import com.classnet.dao.suzuki.A301Dao;
import com.classnet.entity.suzuki.A301Entity;
import com.classnet.util.ListUtil;
import com.classnet.util.WebUtils;
import com.classnet.util.page.IPagination;
import com.classnet.util.page.SimplePagination;
import com.classnet.util.page.WebUtil;

public class A301Action extends DispatchAction{
	private A301Dao a301Dao;
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String vin =request.getParameter("vin");
		String ab_on = request.getParameter("ab_on");
		String result = request.getParameter("result");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 50;
		DetachedCriteria dc = DetachedCriteria.forClass(A301Entity.class);
		if(!WebUtils.isEmpty(vin))
		{
			vin = new String(vin.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.like("vin", vin, MatchMode.ANYWHERE));
			request.setAttribute("vin", vin);
		}
		if(!WebUtils.isEmpty(ab_on))
		{
			ab_on = new String(ab_on.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.like("ab_on", ab_on, MatchMode.ANYWHERE));
			request.setAttribute("ab_on", ab_on);
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
			dc.add(Restrictions.ge("datatime", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("datatime", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<A301Entity> a301List = pp.getPage();
		request.setAttribute("a301List", a301List);
		List<A301Entity> ab_onListTemp = a301Dao.findByExample("select distinct ab_on  from A301Entity");
		List ab_onList = ListUtil.listChange(ab_onListTemp, "ab_on");
		request.setAttribute("ab_onList", ab_onList);
		List<A301Entity> resultListTemp = a301Dao.findByExample("select distinct result  from A301Entity");
		List resultList = ListUtil.listChange(resultListTemp, "result");
		request.setAttribute("resultList", resultList);
		return mapping.findForward("list");
	}

	public A301Dao getA301Dao() {
		return a301Dao;
	}

	public void setA301Dao(A301Dao A301Dao) {
		this.a301Dao = A301Dao;
	}
	
	public void listExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String vin =request.getParameter("vin");
		String ab_on = request.getParameter("ab_on");
		String result = request.getParameter("result");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 50000;
		DetachedCriteria dc = DetachedCriteria.forClass(A301Entity.class);
		if(!WebUtils.isEmpty(vin))
		{
			vin = new String(vin.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.like("vin", vin, MatchMode.ANYWHERE));
			request.setAttribute("vin", vin);
		}
		if(!WebUtils.isEmpty(ab_on))
		{
			ab_on = new String(ab_on.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.like("ab_on", ab_on, MatchMode.ANYWHERE));
			request.setAttribute("ab_on", ab_on);
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
			dc.add(Restrictions.ge("datatime", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("datatime", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<A301Entity> a301List = pp.getPage();
		String[] colNames= {"id","VIN码","ABON号","datatime","time","bcm","ipc",
				"ems","abs","tcm","srs","检测结果"};
		List exportList = new ArrayList();
		if(a301List != null && a301List.size()>0)
		{
			for(int e=0;e<a301List.size();e++){
				A301Entity theForm = a301List.get(e);
				HashMap map = new HashMap();
				map.put(colNames[0], theForm.getId());
				map.put(colNames[1], theForm.getVin());
				map.put(colNames[2], theForm.getAb_on());
				map.put(colNames[3], format2.format(theForm.getDatatime()));
				map.put(colNames[4], format2.format(theForm.getTime()));
				map.put(colNames[5], theForm.getBcm());
				map.put(colNames[6], theForm.getIpc());
				map.put(colNames[7], theForm.getEms());
				
				map.put(colNames[8], theForm.getAbs());
				map.put(colNames[9], theForm.getTcm());
				map.put(colNames[10], theForm.getSrs() );
				map.put(colNames[11], theForm.getResult());

				exportList.add(map);
			}
			CSVDownload(request, response, exportList, colNames, "A301.xls");
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
