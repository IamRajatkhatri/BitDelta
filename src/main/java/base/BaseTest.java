package base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.FrameworkConfig;

public class BaseTest {
	public static WebDriver driver;
	private ExtentReports extent;
	private ExtentTest logger;
	public FrameworkConfig config;

	private static String getBaseDirectory() {
		return System.getProperty("user.dir");
	}

	@BeforeTest
	public void beforeTest() {

		String relativePath = "/src/main/resources/config.properties";

		// Set the system property for the config path
		System.setProperty("config.path", "file:" + getBaseDirectory() + relativePath);

		System.out.println("Configuration loaded: " + (config != null));
		// Load the configuration
		config = ConfigFactory.create(FrameworkConfig.class);

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Framework");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Framework Test");
	}

	@BeforeMethod
	@Parameters({ "browser", "environment" })
	public void beforeMethod(@Optional("chrome") String browser, @Optional("dev") String environment, Method method) {
		logger = extent.createTest(method.getName());

		// Call setupDriver method to configure WebDriver with ChromeOptions
		setupDriver(browser);
		driver.manage().window().maximize();

		// Print debug information for parameters
		System.out.println("Browser: " + browser);
		System.out.println("Environment: " + environment);
		driver.get(config.url());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, result.getName() + " - Test case failed");
			logger.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, result.getName() + " - Test case skipped");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, result.getName() + " - Test case pass");
		}
		driver.quit();
	}

	@AfterMethod
	public void afterTest() {

		extent.flush();
	}

	private void setupDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			// Initialize ChromeDriver with options
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions eoptions = new EdgeOptions();
			eoptions.addArguments("--inprivate");
			eoptions.addArguments("--disable-infobars");
			driver = new EdgeDriver(eoptions);
		} else {
			throw new IllegalArgumentException("Invalid browser specified: " + browser);
		}
	}

	public static WebDriver getDriver() {

		return driver;
	}

}
