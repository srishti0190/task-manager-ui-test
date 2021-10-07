package com.oracle.task.manager;

import org.openqa.selenium.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class TaskManagerTest {

    private static final String APP_URL = "http://146.56.54.28:8080/";
    private static WebDriver driver;

    public void taskManagerTest() throws InterruptedException {
        driver.get(APP_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        try {
            assertEquals(APP_URL, driver.getCurrentUrl());
            WebElement newButton = driver.findElement(By.id("new"));
            assertEquals("New", newButton.getText());
            newButton.click();
            Thread.sleep(1000);
            WebElement  headerTag = driver.findElement(By.tagName("h3"));
            assertNotNull(headerTag);
            assertEquals("Add Task", headerTag.getText());
            WebElement formDescription = driver.findElement(By.id("description"));
            assertNotNull(formDescription);
            Date todayDate = new Date();
            formDescription.sendKeys("test_description_" + todayDate);
            Thread.sleep(1000);
            WebElement saveBtn = driver.findElement(By.id("saveBtn"));
            saveBtn.click();
            Thread.sleep(2000);
            WebElement tglBtn = driver.findElement(By.id("tgl-0"));
            tglBtn.click();
            Thread.sleep(2000);
            WebElement dltBtn = driver.findElement(By.id("delete-0"));
            dltBtn.click();
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 3000)");
            Thread.sleep(3000);
            
        } catch (WebDriverException e) {
            System.out.println("Exception is: —" + e + "\n");
        }
    }

    public static void main(String[] args) {
        TaskManagerTest test = new TaskManagerTest();
        try {
            driver = BrowserSelection.usingChrome();
            test.taskManagerTest();
        } catch (InterruptedException e) {
            System.out.println("Exception when creatinf");
            e.printStackTrace();
        } catch(Exception e){
            System.out.println("skjdhflkjhD");
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
