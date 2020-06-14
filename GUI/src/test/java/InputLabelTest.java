import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.*;

//测试搜索输入框
public class InputLabelTest {
    //获取输入框构件
    //检测默认文本
    //输入前检测高亮，此时应该没有高亮元素
    //模拟输入
    //检测输入内容
    //检测高亮，此时应当有高亮元素
    //清空输入框
    //再次检测高亮，此时应该没有高亮元素
    @Test
    public void testInputLabel() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getTitle(),"Selenium 浏览器自动化项目 :: Selenium 文档");

        //获取输入框构件
        WebElement inputLabel = driver.findElement(By.id("search-by"));
        inputLabel.click();

        //检测默认文本
        String placeholderString = inputLabel.getAttribute("placeholder");
        assertEquals(placeholderString, "搜索...");

        //输入前检测高亮，此时应该没有mark标签的高亮元素
        List<WebElement> hightLightElements = driver.findElements(By.className("highlight"));
        for (WebElement element: hightLightElements) {
            if( element.getTagName().equals(new String("mark"))) {
                assertNotNull(null);
            }
        }

        //模拟输入
        Actions action = new Actions(driver);
        action.sendKeys(inputLabel, "sele").perform();

        //检测输入内容
        String valueString = driver.findElement(By.id("search-by")).getAttribute("value");
        assertEquals(valueString, "sele");

        //检测高亮，此时应当有高亮元素
        hightLightElements = driver.findElements(By.className("highlight"));
        assertEquals(hightLightElements.isEmpty(), false);
        boolean flag = false;
        for (WebElement element: hightLightElements) {
            if( element.getTagName().equals(new String("mark")) && element.getText().equals("Sele")) {
                flag = true;
            }
        }
        if(!flag) {
            assertNotNull(null);
        }

        //清空输入框
        action.sendKeys(inputLabel, Keys.BACK_SPACE).perform();
        action.sendKeys(inputLabel, Keys.BACK_SPACE).perform();
        action.sendKeys(inputLabel, Keys.BACK_SPACE).perform();
        action.sendKeys(inputLabel, Keys.BACK_SPACE).perform();

        //再次检测高亮，此时应该没有高亮元素
        hightLightElements = driver.findElements(By.className("highlight"));
        for (WebElement element: hightLightElements) {
            if( element.getTagName().equals(new String("mark"))) {
                assertNotNull(null);
            }
        }

        driver.quit();
    }
}
