package src;
import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  



public class SistemExpert {

private static Map<String, List<String>> kbmap = new HashMap<String, List<String>>();
public static 	ArrayList<String> rules = new ArrayList<String>();
public static 	ArrayList<String> database = new ArrayList<String>();
public static String concluzie="I couldn't find a recommendation";
public String qtext;
public static String buttonAct;
public static int i=0;

	public static void xcel() throws IOException{
		try {
		String excelPath=("C:\\Users\\user\\eclipse-workspace\\ExcelUtility\\data\\database.xlsx");   
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);   
		XSSFSheet sheet = workbook.getSheet("Sheet1");    
		
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		for (int i=0;i<rowcount;i++) {
			String value1=sheet.getRow(i).getCell(0).getStringCellValue();
			String value2=sheet.getRow(i).getCell(1).getStringCellValue();
			String[] words = value2.split(" ");
			
			for(int c=0;c<words.length;c++) {
				if(!rules.contains(words[c])) {
				rules.add(words[c]);
				}
			}
			
			ArrayList<String> list=new ArrayList<String>();
			list.addAll(Arrays.asList(words));
			kbmap.put(value1,list);
		}
		
		
		
		}
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  
	}
	
	
	public static void conclusion() {
		if(i+1<rules.size()){
		
						
	        if (buttonAct=="yes") {
	           database.add(rules.get(i));
	           Collections.sort(database);
	           kbmap.forEach((key, value) -> {Collections.sort(value); if(value.equals(database)) concluzie=key;});
	           buttonAct="wait";
	           GUI.setLabelText();
	        }
	        else if(buttonAct=="no") {buttonAct="wait";GUI.setLabelText();}
	        
	        if(concluzie!="I couldn't find a recommendation") {GUI.stop();}
	        i=i+1;
		}
		else GUI.stop();
	}
	     
	
	public static void main(String[] args) throws IOException   
	{  
	
		/*kbmap.forEach((key, value) -> System.out.println(key + ":" + value));
	 	
		System.out.println("\nRules:"); 
		for(int i=0; i < rules.size(); i++){
	            System.out.println(rules.get(i));
	        }
		 */	
		xcel();
		GUI start=new GUI();
	    	    	    
	}  	
}


