import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class changeSim {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void changeSim() {
        wd.get("http://rdpre.yota.ru/rd/login");
        wd.findElement(By.cssSelector("label.label_place")).click();
        wd.findElement(By.id("username_id")).click();
        wd.findElement(By.id("username_id")).clear();
        wd.findElement(By.id("username_id")).sendKeys("seller.ivan.kuzmin@yahoo.com");
        wd.findElement(By.name("_password")).click();
        wd.findElement(By.name("_password")).clear();
        wd.findElement(By.name("_password")).sendKeys("12345");
        wd.findElement(By.id("send_id")).click();
        wd.findElement(By.linkText("Замена SIM")).click();
        wd.findElement(By.id("change_sim_used_type")).click();
        wd.findElement(By.id("change_sim_contract_number")).click();
        wd.findElement(By.id("change_sim_contract_number")).clear();
        wd.findElement(By.id("change_sim_contract_number")).sendKeys("0212312312");
        wd.findElement(By.id("change_sim_replaced_sim_number")).click();
        wd.findElement(By.id("change_sim_replaced_sim_number")).clear();
        wd.findElement(By.id("change_sim_replaced_sim_number")).sendKeys("0212312312");
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
