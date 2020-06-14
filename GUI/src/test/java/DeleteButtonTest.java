import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.*;

//测试搜索输入框
public class DeleteButtonTest {
    //获取输入框构件
    //模拟输入
    //测试点击清空输入框按键
    //获取输入框内容，检测其为空
    //检测高亮，此时应该没有高亮元素
    @Test
    public void testDeleteButton() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getTitle(),"Selenium 浏览器自动化项目 :: Selenium 文档");

        //获取输入框构件
        WebElement inputLabel = driver.findElement(By.id("search-by"));
        inputLabel.click();

        //模拟输入
        Actions action = new Actions(driver);
        action.sendKeys(inputLabel, "sele").perform();

        //测试点击清空输入框按键
        WebElement deleteButton = driver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/span"));
        deleteButton.click();

        //获取输入框内容，检测其为空
        String valueString = driver.findElement(By.id("search-by")).getAttribute("value");
        assertEquals(valueString, "");

        //检测高亮，此时应该没有高亮元素
        List<WebElement> hightLightElements = driver.findElements(By.className("highlight"));
        for (WebElement element: hightLightElements) {
            if( element.getTagName().equals(new String("mark"))) {
                assertNotNull(null);
            }
        }

        driver.quit();
    }
}
