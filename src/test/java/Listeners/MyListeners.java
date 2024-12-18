package Listeners;

import Utilities.ExtentReporter;
import Utilities.ScreenRecorderUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyListeners implements ITestListener {

    public WebDriver driver;
    public String testName;
    public String result;
    public ScreenRecorderUtil screenRecorder;
    public ExtentReports extentReport;
    public ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {

        try {
            extentReport = ExtentReporter.generateExtentReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Test Execution started!");
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();

        extentTest = extentReport.createTest(testName);

        System.out.println(testName + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String testName = result.getName();
        System.out.println(testName + " passed");

        extentTest.log(Status.PASS, testName + " --> Executed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        driver = null;

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        testName = result.getName();

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFile = "C:\\Users\\Admin\\IdeaProjects\\TESTNG_HYBRID_FRAMEWORK\\test-output\\Screenshots\\" + testName + ".png";
        try {
            FileHandler.copy(source, new File(destinationFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extentTest.addScreenCaptureFromPath(destinationFile);
        extentTest.log(Status.FAIL, testName + " --> Execution failed.");

        System.out.println(testName + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        String testName = result.getName();

        System.out.println(testName + " skipped");

        if (result.getStatus() == ITestResult.SKIP) {
            try {
                System.out.println(testName + " Start recording");

                ScreenRecorderUtil.startRecord("Start recording");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        extentTest.log(Status.SKIP, testName + " --> Execution skipped.");

    }

    @Override
    public void onFinish(ITestContext context) {

        try {
            System.out.println("Stop recording!");
            ScreenRecorderUtil.stopRecord();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        extentReport.flush();

        String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreporter.html";

        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Test Execution finished!");
    }
}
