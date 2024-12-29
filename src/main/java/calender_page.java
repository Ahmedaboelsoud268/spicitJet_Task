import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class calender_page {
    public WebElement acceptCookies(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("#cn-accept-cookie"));
    }
    public WebElement inputFailed(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("input[id=\"txtStartDate\"]"));
    }
    public WebElement nextBtn(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("div[class=\"datepicker-years\"] th[class=\"next\"]"));
    }
    public WebElement prevBtn(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("div[class=\"datepicker-years\"] th[class=\"prev\"]"));
    }
    public WebElement getMonths(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("div[class=\"datepicker-days\"] [class=\"datepicker-switch\"]"));
    }
    public WebElement getYears(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("div[class=\"datepicker-months\"] [class=\"datepicker-switch\"]"));
    }
    public List<WebElement> listOfYears(WebDriver driver)
    {
        return driver.findElements(By.cssSelector(".datepicker-years span"));
    }
    public List<WebElement> listOfMonths(WebDriver driver)
    {
        return driver.findElements(By.cssSelector(".datepicker-months  span"));
    }
    public List<WebElement> listDays(WebDriver driver)
    {
        return driver.findElements(By.cssSelector("div[class=\"datepicker-days\"] td[class=\"day\"]"));
    }




}
