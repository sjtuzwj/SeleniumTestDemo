import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollBarTest {
    private WebDriver webDriver;

    @Before
    public void before() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.selenium.dev/documentation/zh-cn/");
    }

    @After
    public void after() {
        webDriver.quit();
    }

    @Test
    public void doNothing() {
        ScrollBarRail sbr = new ScrollBarRail(webDriver);
        ScrollBar sb = new ScrollBar(webDriver);
        Assert.assertEquals("rgba(0, 0, 0, 0)", sbr.getCssValue("background-color"));
        Assert.assertEquals("rgba(170, 170, 170, 1)", sb.getCssValue("background-color"));
    }

    @Test
    public void moveToSide() throws InterruptedException {
        ScrollBarRail sbr = new ScrollBarRail(webDriver);
        ScrollBar sb = new ScrollBar(webDriver);
        sbr.moveTOScrollRail();
        Thread.sleep(100);
        Assert.assertEquals("rgba(238, 238, 238, 1)", sbr.getCssValue("background-color"));
        Assert.assertEquals("rgba(153, 153, 153, 1)", sb.getCssValue("background-color"));
    }

    @Test
    public void moveToScrollBar() throws InterruptedException {
        ScrollBarRail sbr = new ScrollBarRail(webDriver);
        ScrollBar sb = new ScrollBar(webDriver);
        sb.moveToScroll();
        Thread.sleep(100);
        Assert.assertEquals("rgba(238, 238, 238, 1)", sbr.getCssValue("background-color"));
        Assert.assertEquals("rgba(153, 153, 153, 1)", sb.getCssValue("background-color"));
    }

    @Test
    public void clickScrollBar() throws InterruptedException {
        ScrollBarRail sbr = new ScrollBarRail(webDriver);
        ScrollBar sb = new ScrollBar(webDriver);
        sb.clickAndHold();
        Thread.sleep(100);
        Assert.assertEquals("rgba(238, 238, 238, 1)", sbr.getCssValue("background-color"));
        Assert.assertEquals("rgba(153, 153, 153, 1)", sb.getCssValue("background-color"));
    }


    @Test
    public void dragAndMoveScrollBar() throws InterruptedException {
        ScrollBar sb = new ScrollBar(webDriver);
        sb.dragAndDropBy(100);
        Thread.sleep(100);
        Assert.assertEquals("100px", sb.getCssValue("top"));
    }
    @Test
    public void useFluentInterface() {
        ScrollBar sb = new ScrollBar(webDriver);
        sb.withFluent().moveToScroll().clickAndHold().dragAndDropBy(100); // Use  fluent API
        Assert.assertEquals("99px", sb.getCssValue("top")); // expect the bug result
    }
}
