import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

//测试代码复制按钮
public class CopyButtonTest {


    //1. 检查是否访问目标网站
    //2. 检查点击复制按钮后是否真的复制了代码在剪切框
    //3. 检查点击复制按钮后网站的内容是否正确更新(更新的部分为伪元素)
    @Test
    public void testCopy() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/");
        assertEquals(driver.getTitle(),"Selenium 浏览器自动化项目 :: Selenium 文档");
        HomePage hp = new HomePage(driver);
        hp.copyCode();
        assertEquals(ClickBoard.getSysClipboardText(),"\n" +
                "import org.openqa.selenium.By;\n" +
                "import org.openqa.selenium.Keys;\n" +
                "import org.openqa.selenium.WebDriver;\n" +
                "import org.openqa.selenium.WebElement;\n" +
                "import org.openqa.selenium.firefox.FirefoxDriver;\n" +
                "import org.openqa.selenium.support.ui.WebDriverWait;\n" +
                "import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;\n" +
                "import java.time.Duration;\n" +
                "\n" +
                "public class HelloSelenium {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        WebDriver driver = new FirefoxDriver();\n" +
                "        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));\n" +
                "        try {\n" +
                "            driver.get(\"https://google.com/ncr\");\n" +
                "            driver.findElement(By.name(\"q\")).sendKeys(\"cheese\" + Keys.ENTER);\n" +
                "            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector(\"h3>div\")));\n" +
                "            System.out.println(firstResult.getAttribute(\"textContent\"));\n" +
                "        } finally {\n" +
                "            driver.quit();\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "  ");
        assertEquals(hp.getCopyInfo(),"\"Copied to clipboard!\"");

        driver.quit();

    }
}
