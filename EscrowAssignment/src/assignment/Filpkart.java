package assignment;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Filpkart {
		
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void link() throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream("./data/FilpkartTC.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String url = wb.getSheet("url").getRow(0).getCell(1).getStringCellValue();
	 driver=new ChromeDriver();
     wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	}
	
	@Test
	
	public void run() throws IOException, InterruptedException
	{
	
    WebElement search = driver.findElement(By.name("q"));
    search.sendKeys("Bluetooth Speaker");
    search.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//div[text()='Brand']/parent::div")).click();
	driver.findElement(By.xpath("//div[text()='boAt']/preceding-sibling::div")).click();
	WebElement ratings = driver.findElement(By.xpath("//div[text()='4★ & above']"));
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='4★ & above']")));
	Thread.sleep(2000);
	 ratings.click();Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[contains(text(),'Low to High')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'boAt')]")).click();
	Set<String> child = driver.getWindowHandles();
	String parent = driver.getWindowHandle();
	for (String ch : child) {
		driver.switchTo().window(ch);
		if(!ch.equals(parent))
		{
			break;
		}
		
	}
	wait.until(ExpectedConditions.urlContains("boat"));
	driver.findElement(By.xpath("//span[contains(text(),'more offers')]")).click();
	List<WebElement> offers = driver.findElements(By.xpath("//span[text()='T&C']"));
	int count=offers.size();
	System.out.println(count);
	WebElement addToCart = driver.findElement(By.xpath("//button[text()='Add to cart']"));	
	boolean cart = addToCart.isEnabled();
	if(cart)
	{
		addToCart.click();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./scr");
		FileHandler.copy(src, dest);
	}
	else
	{
		System.out.println("product unvailable-could not be added to cart ");
		 TakesScreenshot ts=(TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./scr/result.png");
		FileHandler.copy(scr, dest);
	}
	
	}
		
	@AfterClass
	public void afc()
	{
	
	driver.quit();
	}
	}
	
	
	
	
	

