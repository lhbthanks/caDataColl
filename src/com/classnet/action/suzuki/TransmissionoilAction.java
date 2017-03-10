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

import com.classnet.dao.suzuki.TransmissionoilDao;
import com.classnet.dao.suzuki.TransmissionoilDao;
import com.classnet.entity.suzuki.AntifreezeEntity;
import com.classnet.entity.suzuki.TransmissionoilEntity;
import com.classnet.util.ListUtil;
import com.classnet.util.WebUtils;
import com.classnet.util.page.IPagination;
import com.classnet.util.page.SimplePagination;
import com.classnet.util.page.WebUtil;

public class TransmissionoilAction extends DispatchAction{
	private TransmissionoilDao transmissionoilDao;
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String vin =request.getParameter("vin");
		String abon = request.getParameter("abon");
		String carmodelcode = request.getParameter("carmodelcode");
		String eventtype = request.getParameter("eventtype");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 50;
		DetachedCriteria dc = DetachedCriteria.forClass(TransmissionoilEntity.class);
		if(!WebUtils.isEmpty(vin))
		{
			vin = new String(vin.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.like("vin", vin, MatchMode.ANYWHERE));
			request.setAttribute("vin", vin);
		}
		if(!WebUtils.isEmpty(abon))
		{
			abon = new String(abon.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("abon", Integer.parseInt(abon)));
			request.setAttribute("abon", abon);
		}
		if(!WebUtils.isEmpty(carmodelcode))
		{
			carmodelcode = new String(carmodelcode.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.like("carmodelcode", carmodelcode, MatchMode.ANYWHERE));
			request.setAttribute("carmodelcode", carmodelcode);
		}
		if(!WebUtils.isEmpty(eventtype))
		{
			eventtype = new String(eventtype.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("eventtype", eventtype));
			request.setAttribute("eventtype", eventtype);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("datetime", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("datetime", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<TransmissionoilEntity> transmissionoilList = pp.getPage();
		request.setAttribute("transmissionoilList", transmissionoilList);
		List<TransmissionoilEntity> carmodelcodeListTemp = transmissionoilDao.findByExample("select distinct carmodelcode  from TransmissionoilEntity");
		List carmodelcodeList = ListUtil.listChange(carmodelcodeListTemp, "carmodelcode");
		request.setAttribute("carmodelcodeList", carmodelcodeList);
		List<TransmissionoilEntity> eventtypeListTemp = transmissionoilDao.findByExample("select distinct eventtype  from TransmissionoilEntity");
		List eventtypeList = ListUtil.listChange(eventtypeListTemp, "eventtype");
		request.setAttribute("eventtypeList", eventtypeList);
		return mapping.findForward("list");
	}

	public TransmissionoilDao getTransmissionoilDao() {
		return transmissionoilDao;
	}

	public void setTransmissionoilDao(TransmissionoilDao TransmissionoilDao) {
		this.transmissionoilDao = TransmissionoilDao;
	}
	
	public void listExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String vin =request.getParameter("vin");
		String abon = request.getParameter("abon");
		String carmodelcode = request.getParameter("carmodelcode");
		String eventtype = request.getParameter("eventtype");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 60000;
		DetachedCriteria dc = DetachedCriteria.forClass(TransmissionoilEntity.class);
		if(!WebUtils.isEmpty(vin))
		{
			vin = new String(vin.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.like("vin", vin, MatchMode.ANYWHERE));
			request.setAttribute("vin", vin);
		}
		if(!WebUtils.isEmpty(abon))
		{
			abon = new String(abon.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("abon", Integer.parseInt(abon)));
			request.setAttribute("abon", abon);
		}
		if(!WebUtils.isEmpty(carmodelcode))
		{
			carmodelcode = new String(carmodelcode.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.like("carmodelcode", carmodelcode,MatchMode.ANYWHERE));
			request.setAttribute("carmodelcode", carmodelcode);
		}
		if(!WebUtils.isEmpty(eventtype))
		{
			eventtype = new String(eventtype.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("eventtype", eventtype));
			request.setAttribute("eventtype", eventtype);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("datetime", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("datetime", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<TransmissionoilEntity> transmissionoilList = pp.getPage();
		
		String[] colNames= {"VIN码","ABON号","车型","设置油品/油量","实际油量","事件类型","DATETIME" };
		List exportList = new ArrayList();
		if(transmissionoilList != null && transmissionoilList.size()>0)
		{
			for(int e=0;e<transmissionoilList.size();e++){
				TransmissionoilEntity theForm = transmissionoilList.get(e);
				HashMap map = new HashMap();
				map.put(colNames[0], theForm.getVin());
				map.put(colNames[1], theForm.getAbon());
				map.put(colNames[2], theForm.getCarmodelcode());
				map.put(colNames[3], theForm.getData1());
				map.put(colNames[4], theForm.getData2());
				map.put(colNames[5], theForm.getEventtype());
				map.put(colNames[6], format2.format(theForm.getDatetime()));

				exportList.add(map);
			}
			CSVDownload(request, response, exportList, colNames, "变速箱.xls");
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
