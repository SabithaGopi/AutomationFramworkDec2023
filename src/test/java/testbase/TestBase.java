package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase extends Base{
	
	WebDriver dr;
	static WebDriver sdr;
	public Properties prop;
	public static Properties sprop;
	
	public String browser;
	public static String sbrowser;
	
	public WebDriver getDriver() throws IOException
	{
		
		String confile= "./src/test/resources/config/config.properties";
		File f = new File(confile);
		FileInputStream inStream= new FileInputStream(f);
		prop= new Properties();
		prop.load(inStream);
		
		
		browser= sprop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
		dr = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			dr = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			dr = new EdgeDriver();
		}else 
		{
			Throwable thr= new Throwable();
			thr.initCause(null);
		}
		
		//dr.get("https://toolsqa.com/");
		dr.get(prop.getProperty("url"));
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return dr;

}
	
	
	public static WebDriver getDriverInstance()throws IOException 
	{
		
		String confile= "./src/test/resources/config/config.properties";
		File f = new File(confile);
		FileInputStream inStream= new FileInputStream(f);
		sprop= new Properties();
		sprop.load(inStream);
		
		
		sbrowser= sprop.getProperty("browser");
		if(sbrowser.equalsIgnoreCase("chrome")) {
		sdr = new ChromeDriver();
		}
		
		else if(sbrowser.equalsIgnoreCase("firefox")) 
		{
			sdr = new FirefoxDriver();
		}else if(sbrowser.equalsIgnoreCase("edge"))
		{
			sdr = new EdgeDriver();
		}else 
		{
			Throwable thr= new Throwable();
			thr.initCause(null);
		}
		
		//dr.get("https://toolsqa.com/");
		sdr.get(sprop.getProperty("url"));
		sdr.manage().window().maximize();
		sdr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return sdr;
		
		
	}
	}

