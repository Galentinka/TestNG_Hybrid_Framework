package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporter {

    public static ExtentReports generateExtentReport() throws IOException {

        ExtentReports extentReport = new ExtentReports();

        File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreporter.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("TutorialsNinja Report Results");
        sparkReporter.config().setDocumentTitle("ReportTitle | TutorialsNinja Test Report");
        sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");

        extentReport.attachReporter(sparkReporter);

        Properties properties = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\TESTNG_HYBRID_FRAMEWORK\\src\\main\\java\\Config\\config.properties");
        properties.load(ip);

        extentReport.setSystemInfo("application url", properties.getProperty("url"));
        extentReport.setSystemInfo("validEmail", properties.getProperty("validEmail"));
        extentReport.setSystemInfo("validPassword", properties.getProperty("validPassword"));

        return extentReport;
    }
}
