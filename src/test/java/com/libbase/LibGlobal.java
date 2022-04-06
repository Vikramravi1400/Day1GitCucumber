package com.libbase;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import javax.swing.text.Utilities;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class LibGlobal {
		
		 public static WebDriver  driver; 
	    
		 public static Actions a ; 
		 
		 public static Robot r;
		 
		 public static Alert alt;
		 
		 public static JavascriptExecutor js;
		 
		 public static Select s;
		 
		 
		 public static void getDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		 public static void getUrl(String url) {
		    driver.get(url);
		}//1
		 public static String getText(WebElement ele) {
			 String text = ele.getText();
			 System.out.println(text);
			return text;	 
	    } //2
		 public static String getAttribute(WebElement ele, String value) {
			String attribute = ele.getAttribute(value);
			System.out.println(attribute);
			return attribute;		
		}//3
		 public static boolean isDisplayed(WebElement ele) {
		    boolean displayed = ele.isDisplayed();
			return displayed;
		}//4
		 public static boolean isSelected(WebElement ele) {
			boolean selected = ele.isSelected();
			return selected;
		}//5
		 public static boolean isEnabled(WebElement ele) {
			boolean enabled = ele.isEnabled();
			return enabled;
		}//6
		 public static void navigateTo(String url) {
			driver.navigate().to(url);
		}
		 public static void waits_Implicit(int sec) {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		}//7
		 public static void navigateBack() {
			driver.navigate().back();
		}//8
		 public static void navigateForward() {
				driver.navigate().forward();
		 }//9		
		 public static void navigateRefresh() {
				driver.navigate().refresh();
		 }//10
		 public static void getActions() {
		    a = new Actions(driver);
		}//11
		 public static void mouseHover(WebElement ele) {
		    a.moveToElement(ele).perform();		 
		}//12
		 public static void dragAndDrop(WebElement ele1, WebElement ele2) {
	        a.dragAndDrop(ele1, ele2).perform();;
		}//13
		 public static void rightClick(WebElement ele) {
			a.contextClick(ele).perform();
		}//14
		 public static void doubleClick(WebElement ele) {
		    a.doubleClick(ele).perform();
		}
		//15
		 public static void keyDown(WebElement ele, Keys keys) {
			a.keyDown(ele, keys).perform();
		}//16	
		 public static void keyUp(WebElement ele, Keys keys) {
			a.keyUp(ele, keys).perform();
		}//17		
		 public static void getAlert() {
		    alt = driver.switchTo().alert();	    
		}//18
		 public static void singleAlert() {
		    alt.accept();
		}//19
		 public static void confirmAlert() {
		    alt.dismiss();
		}//20
		 public static void promtAlert(String value) {
			alt.sendKeys("value");
		}//21
		 public static void getRobot() throws AWTException {
				r=new Robot();
		} //22
		 public static void copyValue() {
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
		}//23
		 public static void pasteValue() {
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
				
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
	   }//24
		 public static void cutValue() {
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_X);
					
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_X);
	   }//25
		 public static String getTitle() {
			    String title = driver.getTitle();
			    System.out.println(title);
				return title;
		}//26
		 public static String getCurrentUrl() {
		        String currentUrl = driver.getCurrentUrl();
		        System.out.println(currentUrl);
				return currentUrl;
		}//27
		 public static void closeBrowser() {
			    driver.close();
		}//28
		 public static void quitBrowser() {
		        driver.quit();
		}//29
		 public static void insertValue(WebElement ele, String value) {
			    ele.sendKeys(value);
		}//30
		 public static void click(WebElement ele) {
			    ele.click(); 
		}//31
		 public static void getSize(WebElement ele) {
			    ele.getSize();
		}//32
		 public static void javaScript() {
		        js = (JavascriptExecutor) driver;
		}//33
		 public static void setAttribute_Js(WebElement ele, String given) {
		        js.executeScript("arguments[0].setAttribute('value','given')",ele); 
		}//34
		 public static void getAttribute_Js(WebElement ele) {
		        String userName = (String) js.executeScript("return arguments[0].getAttribute('value')", ele);
		        System.out.println(userName);
		}//35
		 public static void click_Js(WebElement ele) {
			js.executeScript("arguments[0].click()", ele);
		}//36
		 public static void scrollDown_Js(WebElement ele) {
			js.executeScript("arguments[0].scrollIntoView(true)", ele);
		}//37
		 public static void scrollUp_Js(WebElement ele) {
			js.executeScript("arguments[0].scrollIntoView(false)", ele);
		}//38
		 public static void highlights_js(WebElement ele, String colour) {
			js.executeScript("arguments[0].setAttribute('style','colour')",ele);
		}//39
		 public static void frameSize() {
		    List<WebElement> frameSize = driver.findElements(By.xpath("//iframe"));
		       int size = frameSize.size();
		       System.out.println(size);
		}//40
		 public static void switchFrame_string(String value) {
			driver.switchTo().frame(value);
		}//41
		 public static void switchFrame_index(int index) {
			driver.switchTo().frame(index);
		}//42
		 public static void switchWebElelment(WebElement ele) {
			driver.switchTo().frame(ele);
		}//43
		 public static void screenShot(String path) throws IOException {
			 
			  TakesScreenshot tk = (TakesScreenshot) driver;
				
		        File source = tk.getScreenshotAs(OutputType.FILE);
		        
		        System.out.println(source);
		        
		        File destiny = new File(path);
		       
		        FileUtils.copyFile(source, destiny);
		}//44
		 public static void getOptions_Dd(WebElement ele) {
			    s = new Select(ele);
				
				List<WebElement> list = s.getOptions();
				for (WebElement options : list) {
					getText(options);
				}
		}//45
		  public static void selectByValue_Dd(String value) {
			    s.selectByValue(value); 
		}//46
		  public static void selectByIndex_Dd(int value) {
			    s.selectByIndex(value); 
		}//47
		  public static void selectBy_Dd(String value) {
			    s.selectByValue(value); 
		}//48
		 public static void selectAll_Dd(WebElement ele) {
			 s = new Select(ele);
			List<WebElement> options = s.getOptions();
			for (int i = 0; i < options.size(); i++) {
				s.selectByIndex(i);
		}}
		 public static String getData(int row, int cell) throws IOException {	
		       File loc =  new File("C:\\Users\\rv\\eclipse-workspace\\MavenDay1\\input\\New Microsoft Office Excel Worksheet.xlsx");
		       FileInputStream fi =  new FileInputStream(loc);
		       Workbook w = new XSSFWorkbook(fi);
		       Sheet s = w.getSheet("Sheet1");
		       Row r = s.getRow(row);
		       Cell c = r.getCell(cell);
		       
		       int cellType = c.getCellType();
		       
		       String value = null;
		       
		       if(cellType==1) {
		           value = c.getStringCellValue();
		           System.out.println(value);
		       }
		       else if (cellType==0) {
		    	   if(DateUtil.isCellDateFormatted(c)) {
		    	   Date dateCellValue = c.getDateCellValue();
		    	   SimpleDateFormat sim = new SimpleDateFormat("dd/MM/YYYY");
		    	   value = sim.format(dateCellValue);
		    	   System.out.println(value);
		    	   }
		    	   else {
		    	   double numericCellValue = c.getNumericCellValue();
		    	   Long l = (long) numericCellValue;
		    	   value = String.valueOf(l);
		    	   System.out.println(value);
		     	   }
	           }
			return value;
		    	
	   	   }
		  public static void Pause(long mills) throws InterruptedException {
			  Thread.sleep(mills);
			
		}
	  }
		       
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 




