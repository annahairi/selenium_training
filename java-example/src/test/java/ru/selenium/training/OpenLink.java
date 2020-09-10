package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OpenLink {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start()    {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void OpenLinkInBrowser(){
        driver.get("http://www.google.com/");
        wait.withTimeout(Duration.ofSeconds(1));
        driver.get ("https://music.yandex.ru");
        wait.withTimeout(Duration.ofSeconds(1));
        driver.get ("https://yandex.ru/");
        wait.withTimeout(Duration.ofSeconds(1));
        }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
