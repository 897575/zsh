package org.jumutang.zsh.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jumutang.zsh.model.OilModel;
import org.jumutang.zsh.model.TopModel;
import org.jumutang.zsh.services.OilServiceI;
import org.jumutang.zsh.services.TopServiceI;
import org.jumutang.zsh.tools.DateUtil;
import org.jumutang.zsh.tools.ResResult;
import org.jumutang.zsh.tools.ResponseModel;
import org.jumutang.zsh.tools.ZshUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * �ϴ�������excel���
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
@Controller
@RequestMapping("excel")
public class ExcelController {
	
	//Ĭ���ļ�����Ϊxls��xlsx
	private final static String XLS_TYPE="xls";
	private final static String XLSX_TYPE="xlsx";
	@Autowired
	private OilServiceI oilService;
	
	@Autowired
	private TopServiceI topService;
	
	//�ϴ�������excel
	@ResponseBody
	@RequestMapping("/upload")
	public ResResult uploadExcel(HttpServletRequest request, HttpServletResponse response){
		
		try{

			MultipartHttpServletRequest mhr = (MultipartHttpServletRequest)request;
			MultipartFile file = mhr.getFile("excelFile");
			
			if(file==null){
				return ResponseModel.errorActive("���ϴ��ļ�");
			}
			//��ȡ·��ȫ��
			String fileName = file.getOriginalFilename().toLowerCase();
			String end = fileName.substring(fileName.indexOf(".")+1);
			//xls��ʽ
			if(XLS_TYPE.equals(end)){
				//����excel���
				return readExcelByxls(topService,file);//����excel���
			}else if(XLSX_TYPE.equals(end)){
				return readExcelXlsx(topService,file);
			}else{
				return ResponseModel.errorActive("���ļ�����excel�ļ�");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResponseModel.errorActive("�ϴ�ʧ��");
	}
	
	/**
	 * jxl ���xls��ʽexcel���
	 * 
	 * @param topServiceI
	 * @param MultipartFile
	 * 
	 * @return resResult
	 */
	public ResResult readExcelByxls(TopServiceI topServiceI,MultipartFile file){
		Workbook workbook = null;
		try{
		workbook = Workbook.getWorkbook(file.getInputStream());
		//��ȡ��һ�Ź��������
		Sheet sheet = workbook.getSheet(0);
		//��ȡ��һ�б�����
		String title = sheet.getCell(0,0).getContents().trim();
		List<TopModel> topList = new ArrayList<TopModel>();
		List<OilModel> oilList = new ArrayList<OilModel>();
		//���������������
		int desc = 1;
		if(!"".equals(title) && "�����ͼ�".equals(title)){
			for(int i = 2;i<sheet.getRows();i++){
				OilModel oilModel = new OilModel();
				Cell cell1 = sheet.getCell(0, i);
				Cell cell2 = sheet.getCell(1, i);
				Cell cell3 = sheet.getCell(2, i);
				//�ж���Ʒ����
				if("��ͨȼ����".equals(cell3.getContents().trim())){
					oilModel.setOilCategory(cell1.getContents().trim());
					oilModel.setOilId(ZshUtil.createUuid());
					oilModel.setOilDate(DateUtil.getDate());
					oilModel.setOilPriceType(new Short("1"));
					oilModel.setOilStatus(new Short("1"));
					oilModel.setOilCategoryType(new Short("1"));
					oilModel.setOilPrice(cell2.getContents().trim());
					oilModel.setDesc(desc);
					oilList.add(oilModel);
					
				}else if("����ȼ����".equals(cell3.getContents().trim())){
					oilModel.setOilCategory(cell1.getContents().trim());
					oilModel.setOilId(ZshUtil.createUuid());
					oilModel.setOilDate(DateUtil.getDate());
					oilModel.setOilPriceType(new Short("1"));
					oilModel.setOilStatus(new Short("1"));
					oilModel.setOilCategoryType(new Short("2"));
					oilModel.setOilPrice(cell2.getContents().trim());
					oilModel.setDesc(desc);
					oilList.add(oilModel);
				}	
				desc++;
		}
		}
		if(!"".equals(title) && "����֮��".equals(title)){
			for(int i = 2;i< sheet.getRows();i++){
				Cell cell1 = sheet.getCell(0, i);
				Cell cell2 = sheet.getCell(1, i);
				Cell cell3 = sheet.getCell(2, i);
				Cell[] cells = new Cell[]{cell1,cell2,cell3};
				Short status = new Short("1");
				TopModel topModel = saveTopModelByXls(cells, status);
				topList.add(topModel);
		}
		}
		//�����ڶ���������
		Sheet sheet1 = workbook.getSheet(1);
		String title1 = sheet1.getCell(0,0).getContents().trim();
		if(!"".equals(title1) && "�����ͼ�".equals(title1)){
			for(int i = 2;i< sheet1.getRows();i++){
				OilModel oilModel = new OilModel();
				Cell cell1 = sheet1.getCell(0, i);
				Cell cell2 = sheet1.getCell(1, i);
				oilModel.setOilCategory(cell1.getContents().trim());
				oilModel.setOilId(ZshUtil.createUuid());
				oilModel.setOilDate(DateUtil.getDate());
				oilModel.setOilStatus(new Short("1"));
				oilModel.setOilPriceType(new Short("2"));
				oilModel.setOilCategoryType(new Short("1"));
				oilModel.setOilPrice(cell2.getContents().trim());
				oilModel.setDesc(desc);
				oilList.add(oilModel);
				desc++;
		}
			List<OilModel> resultList = oilService.queryOil();
			if(resultList.size()==0){
			int result = oilService.batchInsertOil(oilList);
			if( result >0){
				return ResponseModel.successActive();
			}else if( result ==0){
				return ResponseModel.errorActive("��ȡ�����ݸ�ʽ����ȷ");
			}
			}
			int result1 = oilService.updateOil();
			int result = oilService.batchInsertOil(oilList);
			if(result!=0 && result1!=0){
				return ResponseModel.successActive();
			}else if(result==0 && result1==0){
				return ResponseModel.errorActive("��ȡ�����ݸ�ʽ����ȷ");
			}
		}
		if(!"".equals(title1) && "����֮��".equals(title1)){
			for(int i = 2;i< sheet1.getRows();i++){
				Cell cell1 = sheet1.getCell(0, i);
				Cell cell2 = sheet1.getCell(1, i);
				Cell cell3 = sheet1.getCell(2, i);
				Short status = new Short("2");
				Cell[] cells = new Cell[]{cell1,cell2,cell3};
				TopModel topModel = saveTopModelByXls(cells, status);
				topList.add(topModel);
			}	
		}
		//��ȡ���������������
		Sheet sheet2 = workbook.getSheet(2);
		//�����ڽ���������
		if(sheet2.getRows()!=0 && sheet2.getColumns()!=0){
			String title2 = sheet2.getCell(0,0).getContents().trim();
			if(!"".equals(title2) && "����֮��".equals(title2)){
				for(int i = 2;i< sheet2.getRows();i++){
					Cell cell1 = sheet2.getCell(0, i);
					Cell cell2 = sheet2.getCell(1, i);
					Cell cell3 = sheet2.getCell(2, i);
					Cell[] cells = new Cell[]{cell1,cell2,cell3};
					Short status = new Short("3");
					TopModel topModel = saveTopModelByXls(cells, status);
					topList.add(topModel);
				}
			}
		}
		
		//��ȡ���ĸ����������
		Sheet sheet3 = workbook.getSheet(3);
		if(sheet3.getRows()!=0 && sheet3.getColumns()!=0){
			String title3 = sheet3.getCell(0,0).getContents().trim();
			if(!"".equals(title3) && "����".equals(title3)){
				for(int i = 2;i< sheet3.getRows();i++){
					Cell cell1 = sheet3.getCell(0, i);
					Cell cell2 = sheet3.getCell(1, i);
					Cell cell3 = sheet3.getCell(2, i);
					Cell[] cells = new Cell[]{cell1,cell2,cell3};
					Short status = new Short("4");
					TopModel topModel = saveTopModelByXls(cells, status);
					topList.add(topModel);
				}	
			}
		}
		//��ѯ�Ƿ��ǵ�һ�β�������
		List<TopModel> resultList = topService.queryAll();
		if(resultList.size()==0){
		int result = topService.batchInsertTop(topList);
		if( result >0){
			return ResponseModel.successActive();
		}else if( result ==0){
			return ResponseModel.errorActive("��ȡ�����ݸ�ʽ����ȷ");
		}
		}
		int result = topService.updateTop();
		int result1 = topService.batchInsertTop(topList);
		if(result !=0 && result1 != 0){
			return ResponseModel.successActive();
		}else if(result ==0 && result1 ==0){
			return ResponseModel.errorActive("��ȡ�����ݸ�ʽ����ȷ");
		}
		
		}catch(Exception  e ){
			e.printStackTrace();
		}finally{
			workbook.close();
		}
		return ResponseModel.errorActive("���ʧ��");
	}
	/**
	 * ���xlsx��ʽexcel�ļ�
	 * @param topServiceI
	 * @param MultipartFile
	 * 
	 * @return resResult
	 */
	public ResResult readExcelXlsx(TopServiceI serviceI,MultipartFile file){
		XSSFWorkbook workbook = null;
		try{
			InputStream is = file.getInputStream();
			workbook = new XSSFWorkbook(is);
			int maxSheet = workbook.getNumberOfSheets();
			//��������
			int desc = 1;
			//�ͼ�excel
			if(maxSheet==2){
				List<OilModel> paramList = new ArrayList<OilModel>();
				for(int s=0 ; s<maxSheet;s++){
					XSSFSheet sheet = workbook.getSheetAt(s);
					XSSFRow row = sheet.getRow(0);
					 XSSFCell cell = row.getCell(0);
					if("�����ͼ�".equals(cell.getStringCellValue().trim())){
						
						for(int r = 2;r<=sheet.getLastRowNum();r++){
							XSSFRow row1 = sheet.getRow(r);
							XSSFCell cell1 = row1.getCell(0);
							XSSFCell cell2 = row1.getCell(1);
							XSSFCell cell3 = row1.getCell(2);
							XSSFCell[] cells = new XSSFCell[]{cell1,cell2};
							if("��ͨȼ����".equals(cell3.getStringCellValue().trim())){
								Short priceType = new Short("1");
								Short categoryType = new Short("1");
								OilModel oilModel = saveOilModelXlsx(cells, priceType, categoryType,desc);
								paramList.add(oilModel);
							}else if("����ȼ����".equals(cell3.getStringCellValue().trim())){
								Short priceType = new Short("1");
								Short categoryType = new Short("2");
								OilModel oilModel = saveOilModelXlsx(cells, priceType, categoryType,desc);
								paramList.add(oilModel);
							}
							desc++;
						}
				
					}else if("�����ͼ�".equals(cell.getStringCellValue().trim())){
						for(int r = 2;r<=sheet.getLastRowNum();r++){
							XSSFRow row1 = sheet.getRow(r);
							XSSFCell cell1 = row1.getCell(0);
							XSSFCell cell2 = row1.getCell(1);
							XSSFCell cell3 = row1.getCell(2);
							XSSFCell[] cells = new XSSFCell[]{cell1,cell2};
							if("��ͨȼ����".equals(cell3.getStringCellValue().trim())){
								Short priceType = new Short("2");
								Short categoryType = new Short("1");
								OilModel oilModel = saveOilModelXlsx(cells, priceType, categoryType,desc);
								paramList.add(oilModel);
							}else if("����ȼ����".equals(cell3.getStringCellValue().trim())){
								Short priceType = new Short("2");
								Short categoryType = new Short("2");
								OilModel oilModel = saveOilModelXlsx(cells, priceType, categoryType,desc);
								paramList.add(oilModel);
							}
							desc++;
						}
					}
				}
				List<OilModel> resultList = oilService.queryOil();
				if(resultList.size()==0){
				int result = oilService.batchInsertOil(paramList);
				if( result >0){
					return ResponseModel.successActive();
				}else if( result ==0){
					return ResponseModel.errorActive("��ȡ�����ݸ�ʽ����ȷ");
				}
				}
				int result1 = oilService.updateOil();
				int result = oilService.batchInsertOil(paramList);
				if(result !=0 && result1 !=0){
					return ResponseModel.successActive();
				}else if(result ==0 && result1 ==0){
					return ResponseModel.errorActive("��ȡ�����ݸ�ʽ����ȷ");
				}
			}else if(maxSheet ==4){
				List<TopModel> paramList = new ArrayList<TopModel>();
				for(int s=0 ; s<maxSheet;s++){
					XSSFSheet sheet = workbook.getSheetAt(s);
					XSSFRow row = sheet.getRow(0);
					 XSSFCell cell = row.getCell(0);
					 String title = cell.getStringCellValue();
					 if("����֮��".equals(title)){
						 for(int r=2;r<=sheet.getLastRowNum();r++){
							 XSSFRow row1 = sheet.getRow(r);
							 XSSFCell cell1 = row1.getCell(0);
							 XSSFCell cell2 = row1.getCell(1);
							 XSSFCell cell3 = row1.getCell(2);
							 XSSFCell[] cells = new XSSFCell[]{cell1,cell2,cell3};
							 Short status = new Short("1");
							 TopModel topModel = saveTopModelXlsx(cells, status);
							 paramList.add(topModel);
						 }
					 }else if("����֮��".equals(title)){
						 for(int r=2;r<=sheet.getLastRowNum();r++){
							 XSSFRow row1 = sheet.getRow(r);
							 XSSFCell cell1 = row1.getCell(0);
							 XSSFCell cell2 = row1.getCell(1);
							 XSSFCell cell3 = row1.getCell(2);
							 XSSFCell[] cells = new XSSFCell[]{cell1,cell2,cell3};
							 Short status = new Short("2");
							 TopModel topModel = saveTopModelXlsx(cells, status);
							 paramList.add(topModel);
						 }
					 }else if("����֮��".equals(title)){
						 for(int r=2;r<=sheet.getLastRowNum();r++){
							 XSSFRow row1 = sheet.getRow(r);
							 XSSFCell cell1 = row1.getCell(0);
							 XSSFCell cell2 = row1.getCell(1);
							 XSSFCell cell3 = row1.getCell(2);
							 XSSFCell[] cells = new XSSFCell[]{cell1,cell2,cell3};
							 Short status = new Short("3");
							 TopModel topModel = saveTopModelXlsx(cells, status);
							 paramList.add(topModel);
						 }
					 }else if("����".equals(title)){
						 for(int r=2;r<=sheet.getLastRowNum();r++){
							 XSSFRow row1 = sheet.getRow(r);
							 XSSFCell cell1 = row1.getCell(0);
							 XSSFCell cell2 = row1.getCell(1);
							 XSSFCell cell3 = row1.getCell(2);
							 XSSFCell[] cells = new XSSFCell[]{cell1,cell2,cell3};
							 Short status = new Short("4");
							 TopModel topModel = saveTopModelXlsx(cells, status);
							 paramList.add(topModel);
						 }
					 }
				}
				//��ѯ�Ƿ��ǵ�һ�β�������
				List<TopModel> resultList = topService.queryAll();
				if(resultList.size()==0){
					int result =topService.batchInsertTop(paramList);
					if(result !=0){
						return ResponseModel.successActive();
					}else{
						return ResponseModel.errorActive("��ȡ�����ݸ�ʽ����ȷ");
					}
				}
				int result = topService.updateTop();
				int result1 =topService.batchInsertTop(paramList);
			 if(result!=0 && result1!=0){
				 return ResponseModel.successActive();
			 }else if(result==0 && result1==0){
				 return ResponseModel.errorActive("��ȡ�����ݸ�ʽ����ȷ");
			 }
			}
			
		}catch(Exception e){
			
		}finally{
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseModel.errorActive("���ʧ��");
	}
	
	/**
	 * ���ڽ���xls��װ��������
	 * 
	 * @param cells
	 * @param status
	 * 
	 * @return
	 */
	public TopModel saveTopModelByXls(Cell[] cells,Short status){
		TopModel topModel = new TopModel();
		topModel.setEmployeeTop(Short.parseShort(cells[0].getContents()));
		topModel.setEmployeeHead(cells[1].getContents().trim());
		topModel.setEmployeeName(cells[2].getContents().trim());
		topModel.setTopStatus(new Short("1"));
		topModel.setTopId(ZshUtil.createUuid());
		topModel.setTopDate(DateUtil.getDate());
		topModel.setTopType(status);
		return topModel;
	}
	
	/**
	 * ���ڽ���xlsx��ʽ��װ�Ͷ���
	 * 
	 * @param cells
	 * @param status
	 * 
	 * @return
	 */
	public OilModel saveOilModelXlsx(XSSFCell[] objs,Short priceType,Short categoryType,int desc){
		OilModel oilModel = new OilModel();
		oilModel.setOilId(ZshUtil.createUuid());
		oilModel.setOilDate(DateUtil.getDate());
		oilModel.setOilPriceType(priceType);
		oilModel.setOilStatus(new Short("1"));
		oilModel.setDesc(desc);
		oilModel.setOilCategoryType(categoryType);
		oilModel.setOilCategory(objs[0].getStringCellValue().trim());
		String str = objs[1].toString();
		oilModel.setOilPrice(objs[1].toString().trim());
		if(str.contains(".")){
			StringBuffer sb = new StringBuffer(str);
			sb.delete(str.indexOf("."),str.length());
			oilModel.setOilPrice(sb.toString());
		}
		return oilModel;
	}
	
	/**
	 * ���ڽ���xls��װ��������
	 * 
	 * @param cells
	 * @param status
	 * 
	 * @return
	 */
	public TopModel saveTopModelXlsx(XSSFCell[] cells,Short status){
		TopModel topModel = new TopModel();
		topModel.setEmployeeTop((short)(cells[0].getNumericCellValue()));
		topModel.setEmployeeHead(cells[1].getStringCellValue().trim());
		topModel.setEmployeeName(cells[2].getStringCellValue().trim());
		topModel.setTopStatus(new Short("1"));
		topModel.setTopId(ZshUtil.createUuid());
		topModel.setTopDate(DateUtil.getDate());
		topModel.setTopType(status);
		return topModel;
	}
} 
