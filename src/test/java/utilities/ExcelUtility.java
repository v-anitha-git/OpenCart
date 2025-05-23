package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet sheet;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static CellStyle style;
		String path;
		
		public ExcelUtility(String path) {
			this.path=path;
		}
		
		public int getRowCount(String xlsheet) throws IOException {
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet(xlsheet);
			int rowcount=sheet.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;
		}
		
		public int getCellCount(String xlsheet,int rownum) throws IOException {
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet(xlsheet);
			int cellcount=sheet.getRow(rownum).getLastCellNum();
			wb.close();
			fi.close();			
			return cellcount;
			
		}

		public String getCellData(String xlsheet,int rownum,int colnum) throws IOException {
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet(xlsheet);
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			String data;
			try {
				//data=cell.toString();
				DataFormatter formatter=new DataFormatter();
				data=formatter.formatCellValue(cell);
			}
			catch(Exception e) {
				data="";
			}
			
			wb.close();
			fi.close();
			return data;
		}
		
		public void setCellData(String xlsheet,int rownum,int colnum,String data) throws IOException {
			File file=new File(path);
			
			if(!file.exists()) {
				fo=new FileOutputStream(path);
				wb=new XSSFWorkbook();
				wb.write(fo);
			}
			
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			
			if(wb.getSheetIndex(xlsheet)==-1) {
				sheet=wb.createSheet("Sheet1");
			}
			sheet=wb.getSheet(xlsheet);
			
			if(sheet.getRow(rownum)==null) {
				sheet.createRow(rownum);
			}
			row=sheet.getRow(rownum);
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			fo=new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
		
		public void fillGreenColor(String xlsheet,int rownum,int colnum) throws IOException {
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);		
			sheet=wb.getSheet(xlsheet);
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			
			style=wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			
			fo=new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
		
		public void fillRedColor(String xlsheet,int rownum,int colnum) throws IOException {
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);		
			sheet=wb.getSheet(xlsheet);
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			
			style=wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			
			fo=new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
		
}
