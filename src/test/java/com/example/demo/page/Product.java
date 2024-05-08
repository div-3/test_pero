package com.example.demo.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Product {
    private SelenideElement writeButton = $(By.xpath("//button[contains(., 'Написать')]"));
    private ElementsCollection avatarList = $$(By.className("vkuiImageBase__img"));
    private SelenideElement aboutSupplierName = $(By.className("MarketItemCardShopInfo__label"));
//    private SelenideElement supplierName = $(By.className("ItemAuthor-module__categoryLink--RLlov"));
    private SelenideElement supplierName = $(By.cssSelector("[class='ItemAuthor-module__label.*'"));
//    private SelenideElement supplierName = $(By.xpath("//a[contains(@class, 'vkuiLink')]"));

    public Message writeSupplier(){
        writeButton.click();
        return new Message();
    }


    public boolean checkPage(){
        boolean a = writeButton.exists()
                && avatarList.size() == 2
                && supplierName.getText().equals(aboutSupplierName.getText());
        System.out.println("1");
        System.out.println(supplierName.getText() + "   |   " + aboutSupplierName.getText());
                return a;
    }
}
