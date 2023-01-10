package ua.hillel.homeTask_16_17.TheInternetSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.hillel.homeTask_16_17.Base.BasePage;

import java.io.File;

public class UploadPage extends BasePage {
    @FindBy(xpath = "//input[@name='file']")
    private WebElement chooseButton;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement uploadButton;
    @FindBy(tagName = "h3")
    private static WebElement successMessage;
    public UploadPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public UploadPage uploadFile(){
        File[] filesInFolder = new File("target/downloads").listFiles();
        chooseButton.sendKeys((CharSequence) filesInFolder[0].getAbsolutePath());
        uploadButton.click();
        return this;
    }
    public String checkSuccessText(){
       return successMessage.getText();
    }
}
