package seleniumTest;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pdfCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Downloads\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the url");
		String url=sc.next();
		driver.navigate().to("https:"+"//"+url+"/");
		driver.manage().window().maximize();
		List<WebElement> anchor = new ArrayList<WebElement>();
		anchor= driver.findElements(By.tagName("a"));
		File file1 = new File("C:\\Users\\hp\\Desktop\\JAVA-Assignments\\Java Assingment 3\\seleniumTest\\pdfCrawler.xls");
		FileWriter pdf=null;
		try {
		pdf = new FileWriter(file1);
		StringBuffer links = new StringBuffer();
		links.append("Anchor Tags :");
		links.append("\n");
		for(int i=0;i<anchor.size();i++){
			if(anchor.get(i).getText().length()==0) {
				continue;
			}
			else {
				if(anchor.get(i).getAttribute("href").contains(".pdf")) {
					links.append(anchor.get(i).getAttribute("href"));
				};
				links.append("\n");
			}
		}
		pdf.write(links.toString());
		pdf.close();
		System.out.println("Wrote Anchor tags");
	}
		catch(Exception e) {
			System.out.println("Error!"+e);
		}
	}
	

}
