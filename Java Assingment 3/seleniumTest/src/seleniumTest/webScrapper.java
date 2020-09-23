package seleniumTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Strings;

public class webScrapper {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Downloads\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the url");
		String url=sc.next();
		driver.navigate().to("https:"+"//"+url+"/");
		driver.manage().window().maximize();
		List<WebElement> elements= new ArrayList<WebElement>();
		elements=driver.findElements(By.xpath("//*"));
		ArrayList<String> tags= new ArrayList<String>();
		int Elelength=elements.size();	
		for(int i=0;i<Elelength;i++) 
				tags.add((elements.get(i).getTagName()));
		
//		for(String tag:tags)
//		System.out.println(tag);
//		List<WebElement> elements= new ArrayList<WebElement>();
		Collections.sort(tags);
		Set<String> tagsCleaned=new LinkedHashSet<>(tags);		
		ArrayList<String> elementsCleaned = new ArrayList<String>();
		for(String tagCleaned:tagsCleaned) {
		elements=driver.findElements(By.tagName(tagCleaned));
		int length=elements.size();
		StringBuilder sb = new StringBuilder();
		sb.append("Tag");
		sb.append(",");
		sb.append("content");
		sb.append("\n");
		for(int i=0;i<length;i++) {
				
					elementsCleaned.add(elements.get(i).getText());
					}
		}
				

		driver.quit();
		
//tags arrayList contains all the tags
//elementsCleaned arrayList contains all the elements corresponding to the tags
		
		
		
		File file = new File("C:\\Users\\hp\\Desktop\\JAVA-Assignments\\Java Assingment 3\\seleniumTest\\test.xls");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			StringBuffer sb = new StringBuffer();
			sb.append("Tag and Corresponding Elements are:");
			sb.append("\n");
			for(int i=0;i<tags.size()&& i<elementsCleaned.size();i++) {
				if(elementsCleaned.get(i).length()==0)
					continue;
				sb.append(tags.get(i).toUpperCase());
				sb.append("\n");
				sb.append(elementsCleaned.get(i));
				sb.append("\n");
			}
			
			System.out.println("Wrote the data into file");
			
			fw.write(sb.toString());
			fw.close();
		}	
		catch(Exception e) {
			System.out.println("Error!");
		}
		
	}
}	

	


