package configpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testbase {

	private static WebDriver driver;
	static String key;
	static String value;
	static String browser;
	static String str;
	public static Properties prop;
	static String file;
	
	public static WebDriver getInstance() throws InterruptedException, IOException {
		file="C:\\Users\\raj\\eclipse-workspace\\MavenSeleniumProject2019\\src\\main\\java\\configpackage\\config.properties";
		prop=new Properties();
		FileInputStream instream=new FileInputStream(file);
		prop.load(instream);
		browser=prop.getProperty("browser");
		str=prop.getProperty("url");
		if(browser.equalsIgnoreCase("chrome")) 
		{
			key="webdriver.chrome.driver";
			value="./drivers/chromedriver.exe";
			System.setProperty(key, value);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get(str);
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("firefox")) 
		{
				key="webdriver.gecko.driver";
				value="./drivers/geckodriver.exe";
				System.setProperty(key, value);
				driver=new FirefoxDriver();
				//driver.get(str);
				Thread.sleep(2000);
			
		}else if(browser.equalsIgnoreCase("edge")) 
		{
			/*key="webdriver.gecko.driver";
			value="./drivers/geckodriver.exe";*/
			//System.setProperty(key, value);
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			//driver.get(str);
			Thread.sleep(2000);
		
		}else {
			Throwable throwable = null;
			throwable.initCause(null);
		}
		driver.get(str);
		driver.manage().window().maximize();
		
		//Dimension dim = new Dimension(414,736);
		//driver.manage().window().setSize(dim);
		//Point point = new Point(200, 400);
		//driver.manage().window().setPosition(point);
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void scrollToElement(WebElement e) {
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false)", e);
		je.executeScript("window.scrollBy(0,400)", "");
	}
	
	public static void waitForElement(WebElement e) {
		
		WebDriverWait wait = new WebDriverWait(driver, 1);
		System.out.println("Wait time triggered");
		wait.pollingEvery(5, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(e));
		//wait.withMessage("Wait time triggered!!!!");
	}
	
	public static void captureScreen(String str) throws IOException {
		File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println(System.getProperty("user.home")+"/Downloads/Images/");
		FileHandler.copy(file, new File(System.getProperty("user.home")+"/Downloads/Images/"+str+".jpg"));
	}
		}

