import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class task1_with_omar {
    WebDriver driver;
        @BeforeMethod
        void mangement() {
           driver = new ChromeDriver();
            driver.get("https://www.spicejet.com/");
            driver.manage().window().maximize();
        }
//this explanation for how to locate the elements , , locate element is not easy due to
        @Test
        void test1()
        {
           List<WebElement> rediobuttons=driver.findElements(By.xpath("(//div[@class=\"css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa\"])"));
            System.out.println(rediobuttons.size());
           for (int i=0 ; i<rediobuttons.size() ;i++)
           {
               String reduiobuttontext=rediobuttons.get(i).getText();
              //String reduiobuttontext=driver.findElements(By.xpath("(//div[@class=\"css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa\"])")).get(i).getText();
               if (reduiobuttontext.contains("Armed Forces"))
               {
                   driver.findElements(By.xpath("(//div[@class=\"css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa\"])")).get(i).click();

               }
               else
               {
                   System.out.println("element not found");
               }
           }
        }

        @AfterMethod
       void finsh() throws InterruptedException {
            Thread.sleep(2000);
driver.quit();
        }
    }



