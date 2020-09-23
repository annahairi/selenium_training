package ru.selenium.training;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class OpenDashboardEdge {
    private WebDriver driver;
    private WebDriverWait wait;



    @Before
    public void start() {
        System.setProperty("webdriver.MicrosoftWebDriver.driver", "C:\\workspace\\MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void openDashboardEdge() {
    driver.get("http://localhost:8090/litecart/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("/html/body/div/main/div[1]/section/h2"));
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}