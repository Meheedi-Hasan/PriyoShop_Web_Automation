package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    @FindBy(css = ".search-box-text")
    public WebElement searchField;
    @FindBy(xpath = "//input[@value = 'Search']")
    public WebElement searchBtn;
    @FindBy(xpath = "//a[normalize-space()='Colorful Polo Shirt for Men-RB (E)']")
    public WebElement test1;
    // Add cart
    @FindBy(xpath = "//img[@title='Burberry Colorful Polo Shirt for Men-RB (E)']")
    public WebElement imgBox;
    @FindBy(id = "product_attribute_59433_809728")
    public WebElement radioSizeBtn;
    @FindBy(xpath = "//input[@class='qty-input'][contains(@id,'EnteredQuantity')]")
    public WebElement qtyBox;
    @FindBy(id = "add-add-to-cart-button-143465")
    public WebElement cartBtn;

    @FindBy(xpath = "//span[@class='product-subtotal']")
    public WebElement totalPrice;
//    @FindBy(xpath = "//input[contains(@class,'qty-input valid')]")
//    public WebElement qtybox2;
    @FindBy(css = "#add-add-to-cart-button-143465")
    public WebElement cartBtn2;
    @FindBy(css = "#flyout-cart")
    public WebElement cartBox;
    @FindBy(css = ".fa.fa-trash")
    public WebElement dltBtn;
    @FindBy(css = ".no-data")
    public WebElement dltAsrt;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String doSearch() throws InterruptedException {
        searchField.sendKeys("Shirt");
        Thread.sleep(1000);
        searchBtn.click();
        Thread.sleep(1000);
        String txt = test1.getText();
        return txt;
    }
    public String addToCartWithInvalidInput() throws InterruptedException {
        imgBox.click();
        Thread.sleep(1000);
        radioSizeBtn.click();
        Thread.sleep(1000);
        qtyBox.clear();
        qtyBox.sendKeys("0");
        cartBtn.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        alert.accept();
        return alertMessage;
    }
    public String addToCartWithValidInput() throws InterruptedException {
        imgBox.click();
        Thread.sleep(1000);
        radioSizeBtn.click();
        Thread.sleep(1000);
        qtyBox.clear();
        Thread.sleep(1000);
        qtyBox.sendKeys("2");
        Thread.sleep(1000);
        cartBtn2.click();
        Thread.sleep(1000);
        cartBox.click();
        Thread.sleep(1000);
        String txt = totalPrice.getText();
        return txt;
    }
    public String deleteProduct() throws InterruptedException {
        cartBox.click();
        Thread.sleep(1000);
        dltBtn.click();
        String txt = dltAsrt.getText();
        return txt;
    }

}
