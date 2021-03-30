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
		//int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		
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
		  /*  String qtext="Do you like " + rules.get(i) +"?";
			GUI.questiontext.setText(qtext);*/
	           
						
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
		//database.add("warm_weather");
		//database.add("culture");
		//database.add("oceasn");
		//conclusion();
	
		kbmap.forEach((key, value) -> System.out.println(key + ":" + value));
	 	
		System.out.println("\nRules:"); 
		for(int i=0; i < rules.size(); i++){
	            System.out.println(rules.get(i));
	        }
		//System.out.println("Oras recomandat:" + concluzie);
		
		xcel();
		GUI start=new GUI();
	    	    	    
	}  	
}



/*    if(!(concluzie==null)) {//break;}
} 
else if(buttonAct=="no") {
    buttonAct="wait";
    continue;
 }

}	
}*/

/*	System.out.println("Do you like " + rules.get(i) +"? Answer y for Yes and n for No");
Scanner reader = new Scanner(System.in);
String answer = "";
*/  
//int a=2;						
//while(a!=0){if(buttonAct=="yes"||buttonAct=="no") break;}

/*boolean stop = false;
while(stop == false) {
if(GUI.yesButton.getModel().isPressed()||GUI.noButton.getModel().isPressed()) stop=true;
}*/





/*

public static void conclusion() {
if(concluzie==null) {
for(int i=0; i < rules.size(); i++){
	String qtext="Do you like " + rules.get(i) +"?";
	GUI.questiontext.setText(qtext);

			
/*	System.out.println("Do you like " + rules.get(i) +"? Answer y for Yes and n for No");
 Scanner reader = new Scanner(System.in);
 String answer = "";
*/  
	//int a=2;						
 //while(a!=0){if(buttonAct=="yes"||buttonAct=="no") break;}
	
	/*boolean stop = false;
	while(stop == false) {
	    if(GUI.yesButton.getModel().isPressed()||GUI.noButton.getModel().isPressed()) stop=true;
	}
	
 if (buttonAct=="yes") {
     database.add(rules.get(i));
     Collections.sort(database);
     kbmap.forEach((key, value) -> {Collections.sort(value); if(value.equals(database)) concluzie=key;});
     buttonAct="wait";
     if(!(concluzie==null)) {break;}
 } else if(buttonAct=="no") {
    buttonAct="wait";
    continue;
 }
}
}		
}


if (buttonAct=="yes") {
database.add(rules.get(i));
Collections.sort(database);
kbmap.forEach((key, value) -> {Collections.sort(value); if(value.equals(database)) concluzie=key;});
buttonAct="wait";
if(!(concluzie==null)) {break;}
} else if(buttonAct=="no") {
buttonAct="wait";
continue;
}*/






