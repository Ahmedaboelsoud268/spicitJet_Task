import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class task_vois {
    public static void main(String[] args) throws IOException {

        //this code is used for reading and import data from excell sheet

        try (Workbook workbook = WorkbookFactory.create(new FileInputStream("C:\\\\Users\\\\20103\\\\IdeaProjects\\\\TaskData.xlsx"))) {
            File src = new File("C:\\\\Users\\\\20103\\\\IdeaProjects\\\\TaskData.xlsx");
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook xfs = new XSSFWorkbook(fis);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
            XSSFSheet sheet = xfs.getSheetAt(0);
            int rowcount = sheet.getLastRowNum();
            int colocount = sheet.getRow(1).getLastCellNum();
            System.out.println("the count of rows " + rowcount + " the count of columns " + colocount);
            for (int i = 1; i < rowcount; i++) {
                XSSFRow celldata = sheet.getRow(i);
                int id = (int) celldata.getCell(0).getNumericCellValue();
                String name = celldata.getCell(1).getStringCellValue();
                String joining_data = celldata.getCell(2).getStringCellValue();
                Cell manyYears = celldata.createCell(3);
                LocalDate JoiningDate = LocalDate.parse(joining_data, formatter);
                LocalDate CurrentDate = LocalDate.now();
                long yearSpent = ChronoUnit.YEARS.between(JoiningDate, CurrentDate);
                manyYears.setCellValue(yearSpent);
                //System.out.println(yearSpent);
                System.out.println(id + ": " + name + " :" + JoiningDate + " :" + manyYears);
            }
            try(FileOutputStream fos = new FileOutputStream(src))
            {
                xfs.write(fos);
                System.out.println("Excel file updated successfully!");
                WebDriver driver=new ChromeDriver();
                driver.get("https://www.microsoft.com/en-us/microsoft-365/outlook/email-and-calendar-software-microsoft-outlook");
                WebElement sign_in=driver.findElement(By.cssSelector("body.reimagine-page.page.basicpage.at-loaded div.root.responsivegrid:nth-child(7) div.aem-Grid.aem-Grid--12.aem-Grid--default--12 div.layout-container.responsivegrid.aem-GridColumn.aem-GridColumn--default--12 main.microsoft-template-layout-container div.aem-Grid.aem-Grid--12.aem-Grid--default--12 div.responsivegrid.aem-GridColumn.aem-GridColumn--default--12 div.aem-Grid.aem-Grid--12.aem-Grid--default--12 div.targeting-container.aem-GridColumn.aem-GridColumn--default--12:nth-child(7) div.section-master.theme-day.bg--supportive-fade.section-master--bg-image.section-master--layout-reverse.section-master--layout-header-vertical-alignment-middle.section-master--layout-slot-horizontal-alignment-right.section-master--blade-hero-slim.section-master--2-column-hero-rtl div.container div.row:nth-child(1) div.col div.layout.section-master__layout.section-master--layout-cols-2 div.layout__col:nth-child(1) div.section-master__layout-header div.block-heading.container.animation.animation--effect-2 div.block-heading__button-group div.button-group a.btn:nth-child(1) > span.btn__text"));
                sign_in.click();

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

