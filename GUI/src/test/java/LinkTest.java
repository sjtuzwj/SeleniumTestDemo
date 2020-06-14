import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class LinkTest {

    private WebDriver driver;

    @Before
    public void Before(){
        driver=new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/zh-cn/");

    }

    @After
    public void After(){
        driver.quit();
    }

    //测试链接跳转及前进后退
    @Test
    public void LinkTest()
    {
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getTitle(),"Selenium 浏览器自动化项目 :: Selenium 文档");

        //链接跳转
        HomePage hp = new HomePage(driver);
        hp.goToWebDriver();
        assertEquals(driver.getCurrentUrl(),"https://www.w3.org/TR/webdriver/");
        assertEquals(driver.getTitle(),"WebDriver");

        //后退
        driver.navigate().back();
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getTitle(),"Selenium 浏览器自动化项目 :: Selenium 文档");

        //前进
        driver.navigate().forward();
        assertEquals(driver.getCurrentUrl(),"https://www.w3.org/TR/webdriver/");
        assertEquals(driver.getTitle(),"WebDriver");
    }

}
