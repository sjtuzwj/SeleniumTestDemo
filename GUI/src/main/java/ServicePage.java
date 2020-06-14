import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Page Object encapsulates the Service Page
 */
public class ServicePage {
    protected static WebDriver driver;

    // <span class="copy-to-clipboard" title="Copy to clipboard"></span>
    private By floatWindow = By.xpath("//*[@id=\"top-bar\"]/div[3]");
    private By guideIcon = By.xpath("//*[@id=\"toc-menu\"]/i");
    private By guideList = By.cssSelector("#TableOfContents > ul > li > a");
    private By secondGuideList = By.cssSelector("#TableOfContents > ul > li > ul > li > a");
    public ServicePage(WebDriver driver){
        this.driver = driver;
    }
    /*
    Domain Specific Language
     */
    public void showGuide() {
        Actions actionProvider = new Actions(driver);
        // Performs mouse move action onto the element
        actionProvider.moveToElement(driver.findElement(guideIcon)).build().perform();
    }
    public String getFloatWindowState(){
        return driver.findElement(floatWindow).getCssValue("display");
    }
    public List<String> getGuideList(){
        List<String> guideInfos = new ArrayList<String>();
        List<WebElement> guides = driver.findElements(guideList);
        for ( WebElement guide : guides){
            guideInfos.add(guide.getText());
        }
        return guideInfos;
    }
    public List<String> getSecondGuideList(){
        List<String> guideInfos = new ArrayList<String>();
        List<WebElement> guides = driver.findElements(secondGuideList);
        for ( WebElement guide : guides){
            guideInfos.add(guide.getText());
        }
        return guideInfos;
    }
    public void selectGuide(int index){
        driver.findElements(guideList).get(index).click();
    }
    public void selectSecondGuide(int index){
        driver.findElements(secondGuideList).get(index).click();
    }
}
