import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollBar {
    protected final WebDriver webDriver;
    protected final WebElement scroll;
    protected final SBFluentInterface sbf;

    public class SBFluentInterface {
        protected final ScrollBar sb;

        public SBFluentInterface(ScrollBar scrollBar) {
            sb = scrollBar;
        }

        public SBFluentInterface moveToScroll() {
            sb.moveToScroll();
            return this;
        }

        public SBFluentInterface clickAndHold() {
            sb.clickAndHold();
            return this;
        }

        public SBFluentInterface dragAndDropBy(int y) {
            sb.dragAndDropBy(y);
            return this;
        }
    }

    public ScrollBar(WebDriver driver) {
        webDriver = driver;
        By scrollBarBy = By.xpath("//*[@id=\"sidebar\"]/div[2]/div[2]/div");
        scroll = webDriver.findElement(scrollBarBy);
        sbf = new SBFluentInterface(this);
    }

    public void moveToScroll() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(scroll).perform();
    }

    public void clickAndHold() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(scroll).perform();
        actions.clickAndHold().perform();
    }

    public String getCssValue(String name) {
        return scroll.getCssValue(name);
    }

    public void dragAndDropBy(int y) {
        Actions actions = new Actions(webDriver);
        actions.dragAndDropBy(scroll, 0, y).perform();
    }

    public SBFluentInterface withFluent() {
        return sbf;
    }
}
