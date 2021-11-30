package epam.Sasha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GlobalPage extends BasePage {

    private By title= new By.ByXPath("//span[@class='title-slider__slide-row']");
    private By careersButton= new By.ByXPath("(//a[@class='top-navigation__item-link'])[6]");

    public GlobalPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }

    public MainPage goBack() {
        driver.findElement(careersButton).click();
        return new MainPage(driver);
    }
}
