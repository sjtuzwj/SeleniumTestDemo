import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class ImgClickTest {


    public WebDriver driver;

    @Before
    public void Before(){
        driver=new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/zh-cn/getting_started_with_webdriver/locating_elements/");

    }

    @After
    public void After(){
        driver.quit();
    }

    //检查图片点击放大
    @Test
    public void ImgClickTest(){
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/getting_started_with_webdriver/locating_elements/");
        assertEquals(driver.getTitle(),"定位元素 :: Selenium 文档");

        PicturePage pp = new PicturePage(driver);
        pp.pictureFocus();
        assertEquals("✕",pp.pictureFocusedText());

    }


}
