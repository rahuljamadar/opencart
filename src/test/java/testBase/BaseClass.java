package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties prop;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		FileInputStream file = new FileInputStream(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);

		logger = LogManager.getLogger(this.getClass());

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid browser name...");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	public String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String randomNumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomAlpaNumeric() {
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return (generatedstring + "@" + generatednumber);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
