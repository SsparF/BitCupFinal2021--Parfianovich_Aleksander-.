package epam.Sasha;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JobTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage=new MainPage(driver);
        mainPage.open("https://www.epam.com/careers");
        GlobalPage globalPage=mainPage.changeLanguage("Global");
        Assert.assertTrue(globalPage.isOpened());
        mainPage=globalPage.goBack();
        Assert.assertTrue(mainPage.isOpened());
    }
}
