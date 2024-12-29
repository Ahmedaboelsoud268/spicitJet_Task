import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task2_with_pmar {
    WebDriver driver;
    @BeforeMethod
    void mangement() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
    }

@Test
void test()  {
        int counter=0;
   List<WebElement> allProducts=driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
   String []productsNeeded={"Brocolli","Cucumber","Beetroot"};
    //int allProducts=driver.findElements(By.xpath("//h4.product-name")).size();

    for (int i=0 ;i<allProducts.size() ;i++)
    {

        String []productNames=allProducts.get(i).getText().split("-"); //[0].trim()
        String formating=productNames[0].trim();
        List proudectsList= Arrays.asList(productsNeeded);
        System.out.println(formating);
        if (proudectsList.contains(formating))
        {

            driver.findElements(By.cssSelector(".product-action button")).get(i).click();
            counter++;
            if(counter==productsNeeded.length)
           {
               break;
           }
        }
    }
}

    @AfterMethod
    void finsh() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
