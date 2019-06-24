package functions;

import java.io.File;
import java.lang.reflect.Method;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static AndroidDriver<MobileElement> driver;

	@BeforeSuite
	public void setUp(ITestContext context) {
		//Setting up the Report
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/reports/N26 Home Task - GnuCash Android Report.html");
		htmlReporter.config().setDocumentTitle("N26 Home Task");
		htmlReporter.config().setReportName("GnuCash Android Automated Tests");
		htmlReporter.config().setEncoding("ISO-8859-1");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.setSystemInfo("Company", "N26");
		extent.setSystemInfo("Project", "GnuCash Android");
		extent.setSystemInfo("Author", "Eugenio Portella");
		extent.attachReporter(htmlReporter);

		//Setting up the APK file and the Appium Server
		File apkFile = new File(getClass().getClassLoader().getResource("GnucashAndroid_v2.4.0.apk").getFile());
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			WebDriverRunner.setWebDriver(driver);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void beforeMethod(Method method, ITestResult result) {
		//Creating the Test Title in the Report
		test = extent.createTest(result.getMethod().getDescription()).assignCategory(result.getMethod().getGroups());

		//Mobile object search timeout
		Configuration.timeout = 10000;
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		//Logging the result of the test in the Report
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(MarkupHelper.createLabel("Teste case " + result.getName() + " failed", ExtentColor.RED));
			test.fail(result.getThrowable());
			test.fail("Screenshot at time of error can be viewed below:").addScreenCaptureFromPath(
					screenshot(result.getMethod().getDescription() + " " + result.getStartMillis()));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel("Test case " + result.getName() + " executed successfully",
					ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip(MarkupHelper.createLabel("Test case" + result.getName() + " skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}

		//After each test run, return to the Home Screen for the next test
		returnToHomeScreen();
	}

	@AfterSuite
	public void tearDown() {
		//Finish the Report and close the automation driver
		extent.flush();
		WebDriverRunner.closeWebDriver();
	}

	//Wrapper for typing created to avoid repeated log lines.
	public static void type(String element, SelenideElement selector, String content) {
		try {
			selector.setValue(content);
			test.log(Status.PASS, element + " filled.");
		} catch (com.codeborne.selenide.ex.ElementNotFound e) {
			test.log(Status.FAIL, "Could not fill: " + element);
			throw(e);
		}
	}

	//Wrapper for clicking created to avoid repeated log lines.
	public static void click(String element, SelenideElement selector) {
		try {
			selector.click();
			test.log(Status.PASS, element + " clicked.");
		} catch (com.codeborne.selenide.ex.ElementNotFound e) {
			test.log(Status.FAIL, "Could not click: " + element);
			throw(e);
		}
	}

	//Function to return to the Home Screen
	public static void returnToHomeScreen() {
		click("Hamburger btn", $x("//android.view.ViewGroup[@resource-id='org.gnucash.android:id/toolbar']/android.widget.ImageButton"));
		click("GnuCash Title", $(By.id("org.gnucash.android:id/drawer_title")));
	}
}
