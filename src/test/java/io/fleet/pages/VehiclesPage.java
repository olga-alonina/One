package io.fleet.pages;

import io.fleet.utilities.ConfigurationReader;
import io.fleet.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class VehiclesPage {

    public VehiclesPage() {
        PageFactory.initElements( Driver.getDriver(), this );
    }

    WebDriver driver = Driver.getDriver();

    WebDriverWait webDriverWait = new WebDriverWait( driver, 10);

    // region Elements
    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(xpath = "//a//span[normalize-space(text()) = 'Fleet' and contains(@class, title-level-1)]")
    public WebElement fleetModule;

    @FindBy(xpath = "//a//span[normalize-space(text()) = 'Customer' and contains(@class, title-level-1)]")
    public WebElement customerModule;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicles;

    @FindBy(xpath = "//span[.='Vehicle Odometer']")
    public WebElement vehicleOdometer;

    @FindBy(xpath = "//div[contains(@class, 'left grid-toolbar')]//div[@class = 'btn-group']//a[contains(@class, 'dropdown-toggle')]")
    public WebElement exportGrid;

    @FindBy(xpath = "//ul//li//a[@title='CSV']")
    public WebElement CSVdropdowmBtn;

    @FindBy(xpath = "//ul//li//a[@title='XLSX']")
    public WebElement XLSXdropdownBtn;

    @FindBy(css = "[class='oro-subtitle']")
    public WebElement subTitle;
    @FindBy(css = "a[title='Reset']")
    public WebElement reset;
    @FindBy(css = "a[title='Grid Settings']")
    public WebElement gridSettings;
    @FindBy(xpath = "//div[@class='actions-panel pull-right form-horizontal']//div//a")
    public List<WebElement> listOfFilters;
    //endregion


    // region Actions
    public void login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlFleet"));
        username.sendKeys(ConfigurationReader.getProperty("driverUsername"));
        password.sendKeys(ConfigurationReader.getProperty("driverPassword"));
        loginBtn.click();
    }

    public void hoverOverToModule(String moduleName) throws Exception {

        Actions action = new Actions( driver );
        switch (moduleName.toLowerCase()) {
            case "fleet":
                webDriverWait.until( ExpectedConditions.visibilityOf( fleetModule ) );
                action.moveToElement( fleetModule ).perform();
                break;
            case "customer":
                action.moveToElement( customerModule ).perform();
                break;
            default:
                throw new Exception( "Unknown module name:" + moduleName );
        }
    }

    public void clickSubModule(String vehicleName) throws Exception {

        switch (vehicleName.toLowerCase()) {
            case "vehicles":
                vehicles.click();
                break;
            case "vehicle odometer":
                vehicleOdometer.click();
                break;
            default:
                throw new Exception( "Unknown submodule name:" + vehicleName );
        }
    }

    public void clickDropdown(String dropdownName) throws Exception {

        switch (dropdownName.toLowerCase()) {
            case "export grid":
                exportGrid.click();
                break;
            default:
                throw new Exception( "Unknown dropdown name:" + dropdownName );
        }
    }

    //endregion

    // region Assertion
    public void assertPageTitle(String pageTitle)  {

        webDriverWait.until(ExpectedConditions.titleContains(pageTitle.substring(0, pageTitle.length()-1)));
        Assert.assertFalse( subTitle.getText().isEmpty() );

        Assert.assertEquals( pageTitle, subTitle.getText() );

    }

    public void assertDropdownOption(String dropdownOptionName) throws Exception {

        switch (dropdownOptionName.toLowerCase()) {
            case "csv":
                Assert.assertTrue( CSVdropdowmBtn.isDisplayed() );
                break;
            case "xlsx":
                Assert.assertTrue( XLSXdropdownBtn.isDisplayed() );
                break;
            default:
                throw new Exception( "Unknown dropdown option name:" + dropdownOptionName );
        }

    }

    public void assertOneButtonIsLeftToAnother(String one, String two) {
        int leftWebElement = 0;
        int rightWebElement = 0;

        for (WebElement eachFilter : listOfFilters) {
            if (eachFilter.getAttribute( "title" ).equalsIgnoreCase( one )) {
                leftWebElement= eachFilter.getLocation().getX();
                System.out.println( "leftWebElement = " + leftWebElement );
            }
        }
        for (WebElement eachFilter : listOfFilters) {
            if (eachFilter.getAttribute( "title" ).equalsIgnoreCase( two )) {
                rightWebElement= eachFilter.getLocation().getX();
                System.out.println( "rightWebElement = " + rightWebElement );

            }
        }
        Assert.assertTrue( "Test failed, check button position", leftWebElement< rightWebElement );
    }

//endregion


// region Helper Methods

//endregion


}
