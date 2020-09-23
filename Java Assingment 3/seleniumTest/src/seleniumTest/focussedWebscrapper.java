package seleniumTest;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class focussedWebscrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Downloads\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Departments availabe are:"+"\n"+"cse "+"\n"+"ee "+"\n"+"civil "+"\n"+"ece "+"\n"+"me "+"\n"+"metta "+"\n"+"pie "+"\n"+"applied-sciences "+"\n"+"aero "+"\n");
			System.out.println("Enter the faculty");
			String dept = sc.next();
			dept.toLowerCase();
			
			ArrayList<String> facultyList = new ArrayList<String>();
			facultyList.add("cse");
			facultyList.add("ee");
			facultyList.add("civil");
			facultyList.add("ece");
			facultyList.add("me");
			facultyList.add("metta");
			facultyList.add("pie");
			facultyList.add("applied-sciences");
			facultyList.add("aero");
			if(facultyList.contains(dept)) {
				driver.navigate().to("https:"+"//"+"pec.ac.in"+"/"+"faculty/"+dept);
				driver.manage().window().maximize();
				List<WebElement> elements= new ArrayList<WebElement>();
				elements=driver.findElements(By.xpath("//*"));
				ArrayList<String> tags= new ArrayList<String>();
				int Elelength=elements.size();	
				for(int i=0;i<Elelength;i++) 
						tags.add((elements.get(i).getTagName()));
			
			Collections.sort(tags);
			Set<String> tagsCleaned=new LinkedHashSet<>(tags);		
			ArrayList<String> elementsCleaned = new ArrayList<String>();
			for(String tagCleaned:tagsCleaned) {
			elements=driver.findElements(By.tagName(tagCleaned));
			int length=elements.size();

			for(int i=0;i<length;i++) {
					
						elementsCleaned.add(elements.get(i).getText());
						}
			}
			File file1 = new File("C:\\Users\\hp\\Desktop\\JAVA-Assignments\\Java Assingment 3\\seleniumTest\\focused.xls");
			FileWriter fw = null;
			fw= new FileWriter(file1);
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
			else
				System.out.println("faculty entered is invalid");
		}
		catch(Exception e) {
			System.out.println("Error!"+e);
		}
		
	}

}
