package com.igor.decorator.element;

import com.igor.model.LetterModel;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class LetterElement extends Element {
    private By receiverInLetter = By.xpath("./td[5]/div[2]/span[@email]");
    private By topicInLetter = By.xpath(".//span[@class='bog']");

    public LetterElement(WebElement webElement) {
        super(webElement);
    }

    public LetterModel getLetter(){
        String receiver = retryingFindEmailValue(receiverInLetter);
        String topic = retryingFindText(topicInLetter).trim();
        //it doesn't matter which message, because topic is uniq hashcode
        return new LetterModel(receiver, topic, "");
    }

    private String retryingFindText(By by) {
        String result = "";
        int attempts = 0;
        while(attempts < 2) {
            try {
                result = webElement.findElement(by).getText();
                break;
            } catch(StaleElementReferenceException ignored) {
            }
            attempts++;
        }
        return result;
    }

    private String retryingFindEmailValue(By by) {
        String result = "";
        int attempts = 0;
        while(attempts < 2) {
            try {
                result = webElement.findElement(by).getAttribute("email");
                break;
            } catch(StaleElementReferenceException ignored) {
            }
            attempts++;
        }
        return result;
    }

}
