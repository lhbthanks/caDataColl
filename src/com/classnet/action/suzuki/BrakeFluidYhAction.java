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

import com.classnet.dao.suzuki.BrakeFluidYhDao;
import com.classnet.dao.suzuki.BrakeFluidYhDao;
import com.classnet.entity.suzuki.BrakeFluidDurrEntity;
import com.classnet.entity.suzuki.BrakeFluidYhEntity;
import com.classnet.util.ListUtil;
import com.classnet.util.WebUtils;
import com.classnet.util.page.IPagination;
import com.classnet.util.page.SimplePagination;
import com.classnet.util.page.WebUtil;

public class BrakeFluidYhAction extends DispatchAction{
	private BrakeFluidYhDao brakeFluidYhDao;
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String vin_code =request.getParameter("vin_code");
		String car_type = request.getParameter("car_type");
		String mobile_unit = request.getParameter("mobile_unit");
		String filling_result = request.getParameter("filling_result");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 50;
		DetachedCriteria dc = DetachedCriteria.forClass(BrakeFluidYhEntity.class);
		if(!WebUtils.isEmpty(vin_code))
		{
			vin_code = new String(vin_code.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.like("vin_code", vin_code, MatchMode.ANYWHERE));
			request.setAttribute("vin_code", vin_code);
		}
		if(!WebUtils.isEmpty(car_type))
		{
			car_type = new String(car_type.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("car_type", car_type));
			request.setAttribute("car_type", car_type);
		}
		if(!WebUtils.isEmpty(mobile_unit))
		{
			mobile_unit = new String(mobile_unit.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("mobile_unit", mobile_unit));
			request.setAttribute("mobile_unit", mobile_unit);
		}
		if(!WebUtils.isEmpty(filling_result))
		{
			filling_result = new String(filling_result.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("filling_result", filling_result));
			request.setAttribute("filling_result", filling_result);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("data_time", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("data_time", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<BrakeFluidYhEntity> brakeFluidYhList = pp.getPage();
		request.setAttribute("brakeFluidYhList", brakeFluidYhList);
		List<BrakeFluidYhEntity> car_typeListTemp = brakeFluidYhDao.findByExample("select distinct car_type  from BrakeFluidYhEntity");
		List car_typeList = ListUtil.listChange(car_typeListTemp, "car_type");
		request.setAttribute("car_typeList", car_typeList);
		List<BrakeFluidYhEntity> mobile_unitListTemp = brakeFluidYhDao.findByExample("select distinct mobile_unit  from BrakeFluidYhEntity");
		List mobile_unitList = ListUtil.listChange(mobile_unitListTemp, "mobile_unit");
		request.setAttribute("mobile_unitList", mobile_unitList);
		List<BrakeFluidYhEntity> filling_resultListTemp = brakeFluidYhDao.findByExample("select distinct filling_result  from BrakeFluidYhEntity");
		List filling_resultList = ListUtil.listChange(filling_resultListTemp, "filling_result");
		request.setAttribute("filling_resultList", filling_resultList);
		return mapping.findForward("list");
	}

	public BrakeFluidYhDao getBrakeFluidYhDao() {
		return brakeFluidYhDao;
	}

	public void setBrakeFluidYhDao(BrakeFluidYhDao BrakeFluidYhDao) {
		this.brakeFluidYhDao = BrakeFluidYhDao;
	}
	
	public void listExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String vin_code =request.getParameter("vin_code");
		String car_type = request.getParameter("car_type");
		String mobile_unit = request.getParameter("mobile_unit");
		String filling_result = request.getParameter("filling_result");
		String txtBeginDate = request.getParameter("txtBeginDate");
		String txtEndDate = request.getParameter("txtEndDate");
		int page = WebUtil.getPage(request);
		int page_size = 60000;
		DetachedCriteria dc = DetachedCriteria.forClass(BrakeFluidYhEntity.class);
		if(!WebUtils.isEmpty(vin_code))
		{
			vin_code = new String(vin_code.getBytes("ISO8859-1"),"utf-8").trim();
			dc.add(Restrictions.like("vin_code", vin_code, MatchMode.ANYWHERE));
			request.setAttribute("vin_code", vin_code);
		}
		if(!WebUtils.isEmpty(car_type))
		{
			car_type = new String(car_type.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("car_type", car_type));
			request.setAttribute("car_type", car_type);
		}
		if(!WebUtils.isEmpty(mobile_unit))
		{
			mobile_unit = new String(mobile_unit.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("mobile_unit", mobile_unit));
			request.setAttribute("mobile_unit", mobile_unit);
		}
		if(!WebUtils.isEmpty(filling_result))
		{
			filling_result = new String(filling_result.getBytes("ISO8859-1"),"utf-8");
			dc.add(Restrictions.eq("filling_result", filling_result));
			request.setAttribute("filling_result", filling_result);
		}
		if(!WebUtils.isEmpty(txtBeginDate))
		{
			txtBeginDate = new String(txtBeginDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtBeginDate);
			dc.add(Restrictions.ge("data_time", datetime));
			request.setAttribute("txtBeginDate", txtBeginDate);
		}
		if(!WebUtils.isEmpty(txtEndDate))
		{
			txtEndDate = new String(txtEndDate.getBytes("ISO8859-1"),"utf-8");
			Date datetime = format.parse(txtEndDate);
			dc.add(Restrictions.le("data_time", datetime));
			request.setAttribute("txtEndDate", txtEndDate);
		}
		
		IPagination pp = new SimplePagination(dc,Order.desc("id"),true,page,page_size);
		pp.save(request);
		List<BrakeFluidYhEntity> brakeFluidYhList = pp.getPage();
		
		String[] colNames= {"VIN码","车型","移动单元","加注结果","DATA_TIME","粗抽真空","时间",
				"细抽真空","时间","泄露检查","时间","最终真空值","时间","加注压力","加注量L","时间","循环时间"};
		List exportList = new ArrayList();
		if(brakeFluidYhList != null && brakeFluidYhList.size()>0)
		{
			for(int e=0;e<brakeFluidYhList.size();e++){
				BrakeFluidYhEntity theForm = brakeFluidYhList.get(e);
				HashMap map = new HashMap();
				map.put(colNames[0], theForm.getVin_code());
				map.put(colNames[1], theForm.getCar_type());
				map.put(colNames[2], theForm.getMobile_unit());
				map.put(colNames[3], theForm.getFilling_result());
				map.put(colNames[4], format2.format(theForm.getData_time()));
				map.put(colNames[5], theForm.getCorse_vacuum());
				map.put(colNames[6], theForm.getCorse_vacuum_time());
				map.put(colNames[7], theForm.getFine_vacuum());
				map.put(colNames[8], theForm.getFine_vacuum_time() );
				map.put(colNames[9], theForm.getVacuum_leak());
				map.put(colNames[10], theForm.getVacuum_leak_time());
				map.put(colNames[11], theForm.getPost_vacuum());
				map.put(colNames[12], theForm.getPost_vacuum_time());
				map.put(colNames[13], theForm.getFilling_pressure());
				map.put(colNames[14], theForm.getFilling_volume());
				map.put(colNames[15], theForm.getFilling_volume_time());
				map.put(colNames[16], theForm.getProcess_cycle_time());

				exportList.add(map);
			}
			CSVDownload(request, response, exportList, colNames, "易恒刹车油.xls");
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
