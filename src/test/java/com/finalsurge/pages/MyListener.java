package com.finalsurge.pages;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class MyListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        log.info(" -  STARTING TEST  - ");
        result.setStatus(ITestResult.STARTED);
    }

    public void onTestSuccess(ITestResult result) {
        log.info("=  FINISHED TEST  =");
        result.setStatus(ITestResult.SUCCESS);
    }

    public void onTestFailure(ITestResult result) {
        log.error("*     FAILED TEST    *");
        System.out.println();
        result.setStatus(ITestResult.FAILURE);
    }

    public void onTestSkipped(ITestResult result) {
        log.info("========= SKIPPING TEST ==============");
        result.setStatus(ITestResult.SKIP);
    }
}
