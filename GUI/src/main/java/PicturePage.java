import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

/**
 * Page Object encapsulates the Home Page
 */
public class PicturePage {
    protected static WebDriver driver;

    private By picture = By.xpath("//*[@id=\"body-inner\"]/p[19]/a/img");

    public  PicturePage(WebDriver driver){
        this.driver = driver;
    }
    /*
    Domain Specific Language
    not clickCopyButton but copyCode
     */
    public void pictureFocus() {
        driver.findElement(picture).click();
    }
    public String pictureFocusedText(){
        return driver.findElement(By.className("featherlight-content")).getText();
    }

}
