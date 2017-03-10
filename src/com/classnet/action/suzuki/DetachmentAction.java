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

import com.classnet.dao.suzuki.DetachmentDao;
import com.classnet.dao.suzuki.DetachmentDao;
import com.classnet.entity.suzuki.AntifreezeEntity;
import com.classnet.entity.suzuki.DetachmentEntity;
import com.classnet.util.ListUtil;
import com.classnet.util.WebUtils;
import com.classnet.util.page.IPagination;
import com.classnet.util.page.SimplePagination;
import com.classnet.util.page.WebUtil;

public class DetachmentAction extends DispatchAction{
	private DetachmentDao detachmentDao;
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String t_abon =request.getParameter("t_abon");
		String t_vin = request.getParameter("t_vin");
		String t_type = request.getParameter("t_type");
		String t_result = request.getParameter("t_result");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 50;
		DetachedCriteria dc = DetachedCriteria.forClass(DetachmentEntity.class);
		if(!WebUtils.isEmpty(t_abon))
		{
			t_abon = new String(t_abon.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.eq("t_abon", t_abon));
			request.setAttribute("t_abon", t_abon);
		}
		if(!WebUtils.isEmpty(t_vin))
		{
			t_vin = new String(t_vin.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.like("t_vin", t_vin, MatchMode.ANYWHERE));
			request.setAttribute("t_vin", t_vin);
		}
		if(!WebUtils.isEmpty(t_type))
		{
			t_type = new String(t_type.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("t_type", t_type));
			request.setAttribute("t_type", t_type);
		}
		if(!WebUtils.isEmpty(t_result))
		{
			t_result = new String(t_result.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("t_result", t_result));
			request.setAttribute("t_result", t_result);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("t_date", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("t_date", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<DetachmentEntity> detachmentList = pp.getPage();
		request.setAttribute("detachmentList", detachmentList);
		
		List<DetachmentEntity> t_typeListTemp = detachmentDao.findByExample("select distinct t_type  from DetachmentEntity");
		List t_typeList = ListUtil.listChange(t_typeListTemp, "t_type");
		request.setAttribute("t_typeList", t_typeList);
		List<DetachmentEntity> t_resultListTemp = detachmentDao.findByExample("select distinct t_result  from DetachmentEntity");
		List t_resultList = ListUtil.listChange(t_resultListTemp, "t_result");
		request.setAttribute("t_resultList", t_resultList);
		return mapping.findForward("list");
	}

	public DetachmentDao getDetachmentDao() {
		return detachmentDao;
	}

	public void setDetachmentDao(DetachmentDao DetachmentDao) {
		this.detachmentDao = DetachmentDao;
	}

	
	public void listExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t_abon =request.getParameter("t_abon");
		String t_vin = request.getParameter("t_vin");
		String t_type = request.getParameter("t_type");
		String t_result = request.getParameter("t_result");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 60000;
		DetachedCriteria dc = DetachedCriteria.forClass(DetachmentEntity.class);
		if(!WebUtils.isEmpty(t_abon))
		{
			t_abon = new String(t_abon.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.eq("t_abon", t_abon));
			request.setAttribute("t_abon", t_abon);
		}
		if(!WebUtils.isEmpty(t_vin))
		{
			t_vin = new String(t_vin.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.like("t_vin", t_vin, MatchMode.ANYWHERE));
			request.setAttribute("t_vin", t_vin);
		}
		if(!WebUtils.isEmpty(t_type))
		{
			t_type = new String(t_type.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("t_type", t_type));
			request.setAttribute("t_type", t_type);
		}
		if(!WebUtils.isEmpty(t_result))
		{
			t_result = new String(t_result.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("t_result", t_result));
			request.setAttribute("t_result", t_result);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("t_date", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("t_date", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<DetachmentEntity> detachmentList = pp.getPage();
		
		String[] colNames= {"ABON号","VIN码","车型","T_DATE","T_TIME","检测结果","T_TP",
				"T_FL"};
		List exportList = new ArrayList();
		if(detachmentList != null && detachmentList.size()>0)
		{
			for(int e=0;e<detachmentList.size();e++){
				DetachmentEntity theForm = detachmentList.get(e);
				HashMap map = new HashMap();
				map.put(colNames[0], theForm.getT_abon());
				map.put(colNames[1], theForm.getT_vin());
				map.put(colNames[2], theForm.getT_type());
				map.put(colNames[3], format2.format(theForm.getT_date()));
				map.put(colNames[4], format2.format(theForm.getT_time()));
				map.put(colNames[5], theForm.getT_result());
				map.put(colNames[6], theForm.getT_tp());
				map.put(colNames[7], theForm.getT_fl());

				exportList.add(map);
			}
			CSVDownload(request, response, exportList, colNames, "脱附检测.xls");
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
