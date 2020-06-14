import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage {
    protected static WebDriver driver;

    // <span class="copy-to-clipboard" title="Copy to clipboard"></span>
    private By clipboard = By.xpath("//*[@id=\"javacode2\"]/div/pre/span");
    private By webdriver = By.xpath("//*[@id=\"body-inner\"]/p[2]/a");
    // JS code to get the cotent of Pseudo element
    private String pEleScript = "return window.getComputedStyle(document.getElementsByClassName(\"copy-to-clipboard tooltipped tooltipped-w\").item(0),':after').getPropertyValue('content')";
    private By logoBackground = By.xpath("//*[@id=\"header-wrapper\"]");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    /*
    Domain Specific Language
    not clickCopyButton but copyCode
     */
    public void copyCode() {
        driver.findElement(clipboard).click();
    }
    public String getCopyInfo(){
        //fxxking 伪元素
        //::before and ::after are css pseudo elements. And Selenium cannot identify CSS pseudo elements.
        // You should try using JavaScriptExecutor to perform the actions you want.
        //or You can try to perform a context click on the element and then try.
        // But ensure that you use CSS Selector to identify the CSS Pseudo Elements. Xpath is not going to work for these elements at all.
        //https://groups.google.com/forum/#!searchin/selenium-users/pseudo|sort:date/selenium-users/9Vb_Rla2El0/NrYj6ubqBAAJ
        String script = pEleScript;
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = (String) js.executeScript(script);
        return content;
    }
    public Color getBGColor(){
        return Color.fromString(driver.findElement(logoBackground).getCssValue("background-color"));
    }
    public void goToWebDriver(){
        driver.findElement(webdriver).click();
    }

}
