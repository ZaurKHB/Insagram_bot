package com.zaurkhb.instagram_bot.services.bot.Impl;

import com.zaurkhb.instagram_bot.services.bot.AutoLikeService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AutoLikeServiceImpl implements AutoLikeService {


    @Override
    public void start(String username,String password) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver();

//        JBrowserDriver driver = new JBrowserDriver(Settings.builder().
//                timezone(Timezone.AMERICA_NEWYORK).build());

        driver.get("https://www.instagram.com/accounts/login/");

        WebElement web_username = null;
        WebElement web_password = null;
        WebElement btn_login = null;
        try {
            web_username = ((ChromeDriver) driver).findElementByCssSelector("[name='username']");

            web_password = ((ChromeDriver) driver).findElementByCssSelector("[name='password']");

            btn_login = ((ChromeDriver) driver).findElementByTagName("button");

        } catch (Exception e) {
            e.getMessage();
        }

        web_username.sendKeys((CharSequence) username);
        web_password.sendKeys((CharSequence) password);
//        username.sendKeys("hesennov_");
//        password.sendKeys("qarabag02");
        btn_login.click();

        List<WebElement> arrayLinkedList;

        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int max_like = 30;
        while (max_like != 0) {
            arrayLinkedList = ((ChromeDriver) driver).findElementsByTagName("button");

            arrayLinkedList.forEach(webElement -> {

                if (webElement.getText().equalsIgnoreCase("Like")) {
                    webElement.click();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Liked");
                }
            });
            System.out.println("Remain Likes: " + (--max_like));
            JavascriptExecutor js = (JavascriptExecutor) driver;
//        driver.manage().window().maximize();
            // This  will scroll down the page by  1000 pixel vertical
            js.executeScript("window.scrollBy(0,1000)");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
