import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectBar {
    protected final WebDriver webDriver;
    protected final WebElement selectBar;
    protected final SelectBarFluentInterface sbf;
    protected final Select select;

    public class SelectBarFluentInterface {
        protected final SelectBar sb;

        public SelectBarFluentInterface(SelectBar selectBar) {
            sb = selectBar;
        }

        public SelectBarFluentInterface selectByIndex(int index) {
            sb.selectByIndex(index);
            return this;
        }
    }

    public SelectBar(WebDriver driver) {
        webDriver = driver;
        By selectBarBy = By.xpath("//*[@id=\"select-language\"]");
        selectBar = webDriver.findElement(selectBarBy);
        select = new Select(selectBar);
        sbf = new SelectBarFluentInterface(this);
    }

    public List<WebElement> getOptions() {
        return select.getOptions();
    }

    public List<WebElement> getAllSelected() {
        return select.getAllSelectedOptions();
    }

    public void selectByIndex(int index) {
        select.selectByIndex(index);
    }

    public WebElement getWebElement() {
        return selectBar;
    }

    public SelectBarFluentInterface withFluent() {
        return sbf;
    }
}
