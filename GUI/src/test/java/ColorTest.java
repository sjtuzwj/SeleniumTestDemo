import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import static org.junit.Assert.*;

//测试logo背景渲染颜色是否符合css文件
public class ColorTest {


    //1. 检查背景颜色渲染是否正确符合CSS
    @Test
    public void testColor() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getTitle(),"Selenium 浏览器自动化项目 :: Selenium 文档");
        HomePage hp = new HomePage(driver);
        Color color = Color.fromString("#43B02A");
        assert color.equals(hp.getBGColor());
        driver.quit();

    }
}
