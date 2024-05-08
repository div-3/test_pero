package com.example.demo.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Message {
    private SelenideElement sendButton = $(By.xpath("//div/button[contains(., 'Отправить')]"));
    private SelenideElement messageBox = $(By.id("mail_box_editable"));

    public boolean setMessageToBox(String message) {
        return true;
    }
    public String getMessageFromBox(String message) {
        return messageBox.getText();
    }

    public boolean checkPage(){
        return messageBox.exists()
                && sendButton.exists();
    }
}
