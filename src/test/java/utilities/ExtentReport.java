package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	private static ExtentReports extent;
	protected ExtentReports report;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Functional Test Report");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Your Name");
        }
        return extent;
    }
    
    public void onStart(ITestContext context) {
        System.out.println("Test execution on start---------");
		
	  }
	public void onTestStart(ITestResult result) {
		System.out.println("Test started---------");
	  }

	 public void onTestSuccess(ITestResult result) {
		 System.out.println("Test execution passed---------");
		  }

	 public void onTestFailure(ITestResult result) {
		 System.out.println("Test execution failed---------");
		/*String s = result.getName();
		String time = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		System.out.println("--->" + s);
		TakesScreenshot t = (TakesScreenshot) driver;

		File srcFile = t.getScreenshotAs(OutputType.FILE);
		File dcs = new File("C:\\Users\\Admin\\eclipse-workspace\\Opencart\\screenshots" + s
				+ "-" + time + ".png");

		try {
			FileUtils.copyFile(srcFile, dcs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot capture successfully");
		*/
		
	}

	public void onTestSkipped(ITestResult result) {
	    System.out.println("Test execution skipped--------");
	  }
	
	public void onFinish(ITestContext context) {
	    System.out.println("Test execution is completed--------");
	  }
    
    public void flushReport() {
    	report.flush();
    }

}
