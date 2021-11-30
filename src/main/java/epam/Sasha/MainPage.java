package epam.Sasha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    private By title= new By.ByXPath("(//h1)[1]");
    private By languageButton= new By.ByXPath("//button[@class='location-selector__button']");
    private By chooseLanguage= new By.ByXPath("//li[@class='location-selector__item']");
    private By keyWord= new By.ByXPath("//input[@id='new_form_job_search_1445745853_copy-keyword']");
    private By location= new By.ByXPath("//span[@class='select2-selection__rendered']");
    private By skills= new By.ByXPath("//div[@class='selected-params ']");
    private By chooseSkills= new By.ByXPath("//span[@class='checkbox-custom-label']");
    private By selectedSkill= new By.ByXPath("//div[@class='selected-params selected']");
    private By selectWhere= new By.ByXPath("//input[@id='id-ce1e74aa-e69b-3bd2-9f9f-41628029ec68-remote']");
    private By jobs= new By.ByXPath("//div[@class='search-result__item-info']");
    private By jobInfo= new By.ByXPath("//ul[@class='bullet-list']//li");

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
        driver.findElement(languageButton).click();
        List<WebElement> languages = driver.findElements(chooseLanguage);
        for (int i=0; i<languages.size(); i++) {
            if (languages.get(i).getText().contains(lang)) {
                languages.get(i).click();
                break;
            }
        }
        return new GlobalPage(driver);
    }

    public void fillKeyWord(String key) {
        WebElement keyword=driver.findElement(keyWord);
        keyword.click();
        keyword.sendKeys(key);
    }

    public void fillLocation(String loc) {
        WebElement locat=driver.findElement(location);
        locat.click();
        locat.sendKeys(loc);
    }

    public void fillSkills(String scl) {
        driver.findElement(skills).click();
        List<WebElement> skills = driver.findElements(chooseSkills);
        for (int i=0; i<skills.size(); i++) {
            if (skills.get(i).getText().contains(scl)) {
                skills.get(i).click();
                break;
            }
        }
        driver.findElement(selectedSkill).click();
    }

    public void fillWhere() {
        driver.findElement(selectWhere).click();
    }

    public boolean CheckJobs() {
        List<WebElement> job = driver.findElements(jobs);
        List<WebElement> jobInf = driver.findElements(jobInfo);
        boolean k=true;
        for (int i=0; i<job.size(); i++) {
            driver.findElement(new By.ByXPath("(//a[@class='search-result__item-apply'])["+i+"]"));
            for (int j=0; j<jobInf.size(); j++) {
                if (jobInf.get(i).getText().contains("Jenkins")) {
                    jobInf.get(i).click();
                    break;
                }
                else
                {
                    k=false;
                    break;
                }
            }
        }
        return k;
    }
}
