package ru.selenium.training;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class OpenDashboardFF {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        driver = new FirefoxDriver();

    }
    @Test
    public void openDashboardInFF() {
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://localhost:8090/litecart");
        driver.findElement(By.xpath("/html/body/div/main/div[1]/section/h2"));
        //String text = "My Store | Online Store";
       // wait.until(titleIs(text));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}