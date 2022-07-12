package com.finalsurge.pages;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("==== STARTING TEST %s ===");
        result.setStatus(ITestResult.STARTED);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("======= FINISHED TEST %s Duration: %ss ======");
        result.setStatus(ITestResult.SUCCESS);
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("=================== FAILED TEST %s Duration: %ss ================");
               result.setStatus(ITestResult.FAILURE);
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("========= SKIPPING TEST %s ==============");
        result.setStatus(ITestResult.SKIP);
    }

}
