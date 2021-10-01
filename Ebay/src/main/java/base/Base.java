package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base
{
	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void setUp() throws FileNotFoundException, IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		prop = new Properties();
		prop.load(new FileInputStream("src/main/java/config/config.properties"));

		System.out.println("Main Screen");
	}

	@AfterSuite
	public void CloseBrowser()
	{
		driver.close();
	}
}
