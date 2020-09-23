package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPageTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void LoginTest() {
        //открываем Login Page
        driver.get("http://localhost:8090/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        //ищем поле Login и вводим логин пользователя
        driver.findElement(By.xpath("/html/body/div[@id='box-login-wrapper']/div[@id='box-login']/form/div[@class='content']/div[@class='form-group'][1]/div[@class='input-group']/input[@class='form-control']")).sendKeys("admin");
        //ищем поле Password и вводим пароль пользователя
        driver.findElement(By.xpath("/html/body/div[@id='box-login-wrapper']/div[@id='box-login']/form/div[@class='content']/div[@class='form-group'][2]/div[@class='input-group']/input[@class='form-control']")).sendKeys("admin");
        //ищем кнопку Login и кликаем
        driver.findElement(By.xpath("/html/body/div[@id='box-login-wrapper']/div[@id='box-login']/form/div[@class='footer']/button[@class='btn btn-default']")).click();
        //проверяем, что пользователь залогинился - по наличию логотипа в левом верхнем углу
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/a/img")));
        //жмем кнопку Sign Out
        driver.findElement(By.xpath("/html/body/div/main/ul/li[10]/a")).click();
        //проверяем, что пользователь разлогинился - по кнопки Login
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/form/div[2]/button")));
       }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
