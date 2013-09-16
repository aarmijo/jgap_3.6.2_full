package com.tecnalia.epes.tamoin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tecnalia.epes.tamoin.util.cmis.CMISConnector;

public class XLSReader {

	/**
	 * @param args	 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String weekNumber = "11";
		
		ArrayList<XLSTask> xlsTasksArrayList = readXLSTasks(weekNumber, false);
		
		System.out.println("Tasks read from the xls file: " + xlsTasksArrayList);
		
		XLSTasksAdaptor xta = new XLSTasksAdaptor(xlsTasksArrayList);
		
		ArrayList<GATask> gatal = xta.getGaTasks();
		
		System.out.println("Tasks adapted to GA: " + gatal);

	}
	
	public static ArrayList<XLSTask> readXLSTasks (String weekNumber, boolean readXlsFromVCN) {
		
		ArrayList<XLSTask> xlsTasksArrayList = new ArrayList<XLSTask>();
		ArrayList<XLSTask> filteredXlsTasksArrayList = new ArrayList<XLSTask>();
		
		try {
			InputStream file = null;
			if (readXlsFromVCN == false) {
				file = new FileInputStream(new File("/home/epes/git/jgap_3.6.2_full/jgap_3.6.2_full/Seguimiento Planificación PROTOTYPE AREA 2013.xlsx"));
			} else if (readXlsFromVCN == true) {
				CMISConnector connector = new CMISConnector();			
				file  = connector.readXlsFileFromVCN();
			}		    
		     
		    //Get the workbook instance for XLS file
		    XSSFWorkbook workbook = new XSSFWorkbook(file);
		 
		    //Get first sheet from the workbook
		    XSSFSheet sheet = workbook.getSheetAt(1);
		    		    
		    //Iterate through each row from first sheet. 
		    Iterator<Row> rowIterator = sheet.iterator();
		    
		    while(rowIterator.hasNext()) {
		        Row row = rowIterator.next();

		        if (row.getRowNum() < 6) continue;		        
		        if (row.getCell(1) == null) break;
		        if (row.getCell(1).getStringCellValue().equals(weekNumber)) {
			        //For each row, iterate through each columns
			        Iterator<Cell> myCellIterator = row.cellIterator();
			        XLSTask xlsTask = new XLSTask();
			        while(myCellIterator.hasNext()) {		            
			                  
			        	Cell cell = myCellIterator.next();		        	
			        	
			        	if (cell.getColumnIndex() > 5) break;
			             
			            switch(cell.getCellType()) {
			                case Cell.CELL_TYPE_BOOLEAN:
			                    System.out.print(cell.getBooleanCellValue() + "\t\t");
			                    break;
			                case Cell.CELL_TYPE_NUMERIC:
			                    System.out.print(cell.getNumericCellValue() + "\t\t");
			                    break;
			                // General format
			                case Cell.CELL_TYPE_STRING:
			                    if (cell.getColumnIndex() == 1) {			                    	
			                    	xlsTask.setWeekNumber(cell.getStringCellValue().trim());
			                    } else if (cell.getColumnIndex() == 2) {
			                    	String windFarm = cell.getStringCellValue();
			                    	windFarm = windFarm.split("\\s+")[1].trim();
			                    	xlsTask.setWindFarmNumber(windFarm);
			                    } else if (cell.getColumnIndex() == 3) {			                    	
			                    	xlsTask.setMaintenanceTeamName(cell.getStringCellValue().trim());
			                    } else if (cell.getColumnIndex() == 4) {
			                    	xlsTask.setTaskName(cell.getStringCellValue().trim());
			                    } else if (cell.getColumnIndex() == 5) {
			                    	String windTurbine = cell.getStringCellValue();
			                    	windTurbine = windTurbine.split("\\s+")[1].trim();
			                    	xlsTask.setWindTurbineNumber(windTurbine);
			                    } 
			                	System.out.print(cell.getStringCellValue() + "\t\t");			                    
			                    break;
			            }
			        }
			        xlsTasksArrayList.add(xlsTask);
			        System.out.println();
		        }		        
		    }
		    file.close();		
		    //System.out.println(xlsTasksArrayList);
		    // Remove tasks that are not filled in		 		    		       
		    for (XLSTask task : xlsTasksArrayList) {
		    	if (task.getWindTurbineNumber() == null || 
		    			task.getMaintenanceTeamName() == null ||
		    			task.getWindFarmNumber() == null || 
		    			task.getTaskName() == null ||
		    			//task.getTaskName().equals("GC GENERADOR") ||
		    			//task.getTaskName().equals("GC MULTI") ||
		    			task.getTaskName().equals("GC ROTOR") ||
		    			task.getTaskName().equals("COP")) continue;		    	
		    	filteredXlsTasksArrayList.add(task);
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		// Filtered tasks
		System.out.println("Filtered Tasks: " + filteredXlsTasksArrayList);
		return filteredXlsTasksArrayList;
	}

}
