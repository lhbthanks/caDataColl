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

import com.classnet.dao.suzuki.AirtightCheckDao;
import com.classnet.dao.suzuki.AirtightCheckDao;
import com.classnet.entity.suzuki.A301Entity;
import com.classnet.entity.suzuki.AirtightCheckEntity;
import com.classnet.util.ListUtil;
import com.classnet.util.WebUtils;
import com.classnet.util.page.IPagination;
import com.classnet.util.page.SimplePagination;
import com.classnet.util.page.WebUtil;

public class AirtightCheckAction extends DispatchAction{
	private AirtightCheckDao airtightCheckDao;
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String r_abon =request.getParameter("r_abon");
		String r_vin = request.getParameter("r_vin");
		String r_type = request.getParameter("r_type");
		String r_tqdr = request.getParameter("r_tqdr");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 50;
		DetachedCriteria dc = DetachedCriteria.forClass(AirtightCheckEntity.class);
		if(!WebUtils.isEmpty(r_abon))
		{
			r_abon = new String(r_abon.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.eq("r_abon", r_abon));
			request.setAttribute("r_abon", r_abon);
		}
		if(!WebUtils.isEmpty(r_vin))
		{
			r_vin = new String(r_vin.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.like("r_vin", r_vin, MatchMode.ANYWHERE));
			request.setAttribute("r_vin", r_vin);
		}
		if(!WebUtils.isEmpty(r_type))
		{
			r_type = new String(r_type.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("r_type", r_type));
			request.setAttribute("r_type", r_type);
		}
		if(!WebUtils.isEmpty(r_tqdr))
		{
			r_tqdr = new String(r_tqdr.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("r_tqdr", r_tqdr));
			request.setAttribute("r_tqdr", r_tqdr);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("r_date", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("r_date", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<AirtightCheckEntity> airtightCheckList = pp.getPage();
		request.setAttribute("airtightCheckList", airtightCheckList);
		
		List<AirtightCheckEntity> r_typeListTemp = airtightCheckDao.findByExample("select distinct r_type  from AirtightCheckEntity");
		List r_typeList = ListUtil.listChange(r_typeListTemp, "r_type");
		request.setAttribute("r_typeList", r_typeList);
		List<AirtightCheckEntity> r_tqdrListTemp = airtightCheckDao.findByExample("select distinct r_tqdr  from AirtightCheckEntity");
		List r_tqdrList = ListUtil.listChange(r_tqdrListTemp, "r_tqdr");
		request.setAttribute("r_tqdrList", r_tqdrList);
		return mapping.findForward("list");
	}

	public AirtightCheckDao getAirtightCheckDao() {
		return airtightCheckDao;
	}

	public void setAirtightCheckDao(AirtightCheckDao AirtightCheckDao) {
		this.airtightCheckDao = AirtightCheckDao;
	}
	
	public void listExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String r_abon =request.getParameter("r_abon");
		String r_vin = request.getParameter("r_vin");
		String r_type = request.getParameter("r_type");
		String r_tqdr = request.getParameter("r_tqdr");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 60000;
		DetachedCriteria dc = DetachedCriteria.forClass(AirtightCheckEntity.class);
		if(!WebUtils.isEmpty(r_abon))
		{
			r_abon = new String(r_abon.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.eq("r_abon", r_abon));
			request.setAttribute("r_abon", r_abon);
		}
		if(!WebUtils.isEmpty(r_vin))
		{
			r_vin = new String(r_vin.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.like("r_vin", r_vin, MatchMode.ANYWHERE));
			request.setAttribute("r_vin", r_vin);
		}
		if(!WebUtils.isEmpty(r_type))
		{
			r_type = new String(r_type.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("r_type", r_type));
			request.setAttribute("r_type", r_type);
		}
		if(!WebUtils.isEmpty(r_tqdr))
		{
			r_tqdr = new String(r_tqdr.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("r_tqdr", r_tqdr));
			request.setAttribute("r_tqdr", r_tqdr);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("r_date", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("r_date", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<AirtightCheckEntity> airtightCheckList = pp.getPage();
		String[] colNames= {"airtightid","ABON号","VIN码","车型","r_date","r_time","r_qmtp",
				"r_qmtd","r_qmdr","r_tqtp","r_tqtd","检测结果","r_power"};
		List exportList = new ArrayList();
		if(airtightCheckList != null && airtightCheckList.size()>0)
		{
			for(int e=0;e<airtightCheckList.size();e++){
				AirtightCheckEntity theForm = airtightCheckList.get(e);
				HashMap map = new HashMap();
				map.put(colNames[0], theForm.getAirtightid());
				map.put(colNames[1], theForm.getR_abon());
				map.put(colNames[2], theForm.getR_vin());
				map.put(colNames[5], theForm.getR_type());
				map.put(colNames[3], format2.format(theForm.getR_date()));
				map.put(colNames[4], format2.format(theForm.getR_time()));
				map.put(colNames[6], theForm.getR_qmtp());
				map.put(colNames[7], theForm.getR_qmtd());
				
				map.put(colNames[8], theForm.getR_qmdr());
				map.put(colNames[9], theForm.getR_tqtp());
				map.put(colNames[10], theForm.getR_tqtd() );
				map.put(colNames[11], theForm.getR_tqdr());
				map.put(colNames[12], theForm.getR_power());

				exportList.add(map);
			}
			CSVDownload(request, response, exportList, colNames, "燃油气密.xls");
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
