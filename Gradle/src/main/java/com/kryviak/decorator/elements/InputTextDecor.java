package com.kryviak.decorator.elements;

import com.kryviak.decorator.MyElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class InputTextDecor extends MyElement {

    private static Logger logger = LogManager.getLogger(InputTextDecor.class);

    public InputTextDecor(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String keysToSend) {
        logger.info("Input Text Area");
        webElement.sendKeys(keysToSend);
    }

    public boolean isDisplayed(){
        logger.info("Text Area is displayed");
        return webElement.isDisplayed();
    }
}
