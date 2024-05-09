package com.example.demo.page;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Product {
    private SelenideElement writeButton = $(By.xpath("//button[contains(., 'Написать')]")).should(Condition.exist);
    private SelenideElement subscribeIconButton = $(By.xpath("//button[contains(@class, 'ItemAuthor-module__iconSubscribe')]")).should(Condition.exist);
    private SelenideElement subscribeButton = $(By.className("MarketItemCardShopInfo__buttonToggleSubscribeGroup")).should(Condition.exist);
    private SelenideElement goToShopButton = $(By.className("MarketItemCardShopInfo__buttonGoToShop")).should(Condition.exist);
    private ElementsCollection avatarList = $$(By.className("vkuiImageBase__img"));
    private SelenideElement aboutSupplierName = $(By.className("MarketItemCardShopInfo__label")).should(Condition.exist);
    private SelenideElement supplierName = $(By.xpath("//a[contains(@class, 'ItemAuthor-module__label')]")).should(Condition.exist);
    private SelenideElement itemGalleryMainImage = $(By.className("ItemGallery__main")).should(Condition.exist);

    public SelenideElement getWriteButton() {
        return writeButton;
    }

    public SelenideElement getSubscribeIconButton() {
        return subscribeIconButton;
    }

    public SelenideElement getSubscribeButton() {
        return subscribeButton;
    }

    public SelenideElement getGoToShopButton() {
        return goToShopButton;
    }

    public ElementsCollection getAvatarList() {
        return avatarList;
    }

    public SelenideElement getAboutSupplierName() {
        return aboutSupplierName;
    }

    public SelenideElement getSupplierName() {
        return supplierName;
    }

    public SelenideElement getItemGalleryMainImage() {
        return itemGalleryMainImage;
    }

    public Message writeSupplier() {
        writeButton.click();
        return new Message();
    }

    public Shop goToShop(){
        goToShopButton.scrollIntoView(true).click();
        changePageIntoBrowser();        //Сменить страницу, т.к. по кнопке открывается в новой вкладке
        return new Shop();
    }

    private static void changePageIntoBrowser() {
        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
//        System.out.println("URL: " + driver.getCurrentUrl() + ", Title: " + driver.getTitle());
        List<String> handles = driver.getWindowHandles().stream().toList();
        String newHandle = handles.get(handles.size() - 1);
        driver.switchTo().window(newHandle);
//        System.out.println("URL: " + driver.getCurrentUrl() + ", Title: " + driver.getTitle());
    }

    public boolean checkPage() {
        Configuration.timeout = 6000;
        ArrayList<SelenideElement> errors = new ArrayList<>();
        boolean ok = true;

        if (!writeButton.isDisplayed())             { ok = false; errors.add(writeButton);          }
        if (!subscribeButton.isDisplayed())         { ok = false; errors.add(subscribeButton);      }
        if (!subscribeIconButton.isDisplayed())     { ok = false; errors.add(subscribeIconButton);  }
        if (!goToShopButton.isDisplayed())          { ok = false; errors.add(goToShopButton);       }
        if (!itemGalleryMainImage.isDisplayed())    { ok = false; errors.add(itemGalleryMainImage); }
        if (avatarList.size() < 2)                  { ok = false; errors.addAll(avatarList);        }
        if (!(supplierName.getText().equals(aboutSupplierName.getText()))) {
            ok = false;
            errors.add(supplierName);
            errors.add(aboutSupplierName);
        }

        if (!ok) System.out.println("Errors on Product Page: " + errors);
        return ok;
    }
}
