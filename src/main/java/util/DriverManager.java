package util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static Logger LOG = Logger.getLogger(DriverManager.class.getName());
    private static ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    private DriverManager() { }

    public static WebDriver getWebDriver() {
        LOG.info("New driver instantiated");
        if (DRIVER_POOL.get() == null) {
            DRIVER_POOL.set(createInstanseDriver());
        }
        return DRIVER_POOL.get();
    }

    public static WebDriver createInstanseDriver() {
        {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        }
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return driver ;
    }

    public static void closeDriver() {
        DRIVER_POOL.get().quit();
        DRIVER_POOL.set(null);
    }

    public static  void failed() {
        File scrFile = ((TakesScreenshot) DRIVER_POOL.get()).getScreenshotAs(OutputType.FILE);
        try {
            String currentDate = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date(System.currentTimeMillis()));
            FileUtils.copyFile(scrFile, new File("screenshots//screenshot.png",currentDate));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void refreshPage(){
        DRIVER_POOL.get().navigate().refresh();
    }
}

