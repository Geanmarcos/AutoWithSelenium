package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;


public class successPage extends util {

    //@FindBy(xpath = "//*[contains(text(),'successfull')]") protected WebElement lblsuccess;
    //@FindBy(xpath = "//*[text()='Order ID']//preceding::h2") protected WebElement lblsuccess;
    @FindBy(xpath = "//*[text()='Payment successfull!']") protected WebElement lblsuccess;
    @FindBy(xpath = "//*[text()='Order ID']//following::strong[1]") protected  WebElement lblorder ;

    public successPage() {
        PageFactory.initElements(driver, this);
    }

    public void success(String mensaje){
        wait.until(ExpectedConditions.visibilityOf(lblsuccess));
        Assert.assertEquals(mensaje,lblsuccess.getText());
    }

    public void mostrarCodigo(){
        System.out.println(lblorder.getText());
    }
}
