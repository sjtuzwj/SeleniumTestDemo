
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

//测试导航悬浮框
public class FloatWindowTest {
    //1. 检查是否访问目标网站
    //2. 检查悬浮框是否隐藏
    //3. 检查悬浮框在移入鼠标是否正确显示
    //4. 检查悬浮框的列表内容
    //5. 检查悬浮框的二级列表内容
    //6. 检查悬浮框的两级列表是否能够正常跳转
    @Test
    public void testFloat() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/zh-cn/grid/setting_up_your_own_grid/#%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B");
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/grid/setting_up_your_own_grid/#%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B");
        assertEquals(driver.getTitle(),"配置自己的服务网格 :: Selenium 文档");
        ServicePage sp = new ServicePage(driver);
        assertEquals(sp.getFloatWindowState(),"none");
        sp.showGuide();
        assertEquals(sp.getFloatWindowState(),"block");
        List<String> guides = sp.getGuideList();
        List<String> secondGuides = sp.getSecondGuideList();
        assertEquals(guides.get(0),"快速开始");
        assertEquals(guides.get(1),"故障排查");
        assertEquals(guides.get(2),"提醒");
        assertEquals(guides.get(3),"Docker Selenium");
        assertEquals(secondGuides.get(0),"第一步: 启动转发器(hub)");
        assertEquals(secondGuides.get(1),"第二部: 启动节点");
        assertEquals(secondGuides.get(2),"使用日志文件");
        assertEquals(secondGuides.get(3),"使用 -debug 参数");
        assertEquals(secondGuides.get(4),"前提");
        sp.selectGuide(0);
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/grid/setting_up_your_own_grid/#%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B");
        sp.selectSecondGuide(0);
        assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/documentation/zh-cn/grid/setting_up_your_own_grid/#%E7%AC%AC%E4%B8%80%E6%AD%A5-%E5%90%AF%E5%8A%A8%E8%BD%AC%E5%8F%91%E5%99%A8hub");

        driver.quit();

    }
}
