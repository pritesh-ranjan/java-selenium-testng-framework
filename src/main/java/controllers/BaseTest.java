package controllers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class BaseTest {
    protected static final String CUSTOM_DOWNLOAD_PATH = Paths.get("download").toString();

    protected BaseTest(){

    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        // setup code here
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        // teardown and cleanup
    }
}
