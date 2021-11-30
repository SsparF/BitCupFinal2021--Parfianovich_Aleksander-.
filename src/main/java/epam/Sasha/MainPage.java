package epam.Sasha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    private By title= new By.ByXPath("(//h1)[1]");
    private By languageButton= new By.ByXPath("//button[@class='location-selector__button']");
    private By chooseLanguage= new By.ByXPath("//li[@class='location-selector__item']");

    public MainPage (WebDriver driver) {
        super(driver);
    }

    public void open(String url){
        driver.get(url);
    }


    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public GlobalPage changeLanguage(String lang) {
        List<WebElement> languages = driver.findElements(chooseLanguage);
        for (int i=0; i<languages.size(); i++) {
            if (languages.get(i).getText().contains(lang)) {
                languages.get(i).click();
                break;
            }
        }
        return new GlobalPage(driver);
    }
}
