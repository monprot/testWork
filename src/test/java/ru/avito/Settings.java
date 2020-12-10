package ru.avito;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

@Log4j
public class Settings {
    @Getter
    WebDriver driver;


    @BeforeClass
    public void beforeTest() {
        log.info("Запуск вебдрайвера и открытие браузера");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterTest() {
        log.info("Закрытие вебдрайвера");
        driver.quit();
        if (driver != null) {
            driver.quit();
        }
    }
}
