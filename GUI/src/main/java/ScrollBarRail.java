import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollBarRail {
    protected final WebDriver webDriver;
    protected final WebElement scrollRail;

    public ScrollBarRail(WebDriver driver) {
        webDriver = driver;
        By scrollBarRailBy = By.xpath("//*[@id=\"sidebar\"]/div[2]/div[2]");
        scrollRail = driver.findElement(scrollBarRailBy);
    }

    public void moveTOScrollRail() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(scrollRail).perform();
    }

    public String getCssValue(String name) {
        return scrollRail.getCssValue(name);
    }
}
