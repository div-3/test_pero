package com.example.demo.page;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Product {
    private SelenideElement writeButton = $(By.xpath("//button[contains(., 'Написать')]"));
    private SelenideElement subscribeIconButton = $(By.xpath("//button[contains(@class, 'ItemAuthor-module__iconSubscribe')]"));
    private SelenideElement subscribeButton = $(By.className("MarketItemCardShopInfo__buttonToggleSubscribeGroup"));
    private SelenideElement goToMarketButton = $(By.className("MarketItemCardShopInfo__buttonGoToShop"));
    private ElementsCollection avatarList = $$(By.className("vkuiImageBase__img"));
    private SelenideElement aboutSupplierName = $(By.className("MarketItemCardShopInfo__label"));
    private SelenideElement supplierName = $(By.xpath("//a[contains(@class, 'ItemAuthor-module__label')]"));
    private SelenideElement itemGalleryMainImage = $(By.className("ItemGallery__main"));


    public Message writeSupplier() {
        writeButton.click();
        return new Message();
    }

    public Market goToMarket() {
        goToMarketButton.scrollIntoView(true).click();
        changePageIntoBrowser();        //Сменить страницу, т.к. по кнопке открывается в новой вкладке
        return new Market();
    }

    //Смена страницы, при открытии новой вкладки
    private static void changePageIntoBrowser() {
        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
//        System.out.println("URL: " + driver.getCurrentUrl() + ", Title: " + driver.getTitle());
        List<String> handles = driver.getWindowHandles().stream().toList();
        String newHandle = handles.get(handles.size() - 1);
        driver.switchTo().window(newHandle);
//        System.out.println("URL: " + driver.getCurrentUrl() + ", Title: " + driver.getTitle());
    }

    public Club goToClub() {
        supplierName.scrollIntoView(true).click();
        return new Club();
    }

    public boolean checkPage() {
        ArrayList<SelenideElement> errors = new ArrayList<>();
        boolean ok = true;

        if (!writeButton.shouldBe(Condition.visible).isDisplayed())             { ok = false; errors.add(writeButton);          }
        if (!subscribeButton.shouldBe(Condition.visible).isDisplayed())         { ok = false; errors.add(subscribeButton);      }
        if (!subscribeIconButton.shouldBe(Condition.visible).isDisplayed())     { ok = false; errors.add(subscribeIconButton);  }
        if (!goToMarketButton.shouldBe(Condition.visible).isDisplayed())        { ok = false; errors.add(goToMarketButton);     }
        if (!itemGalleryMainImage.shouldBe(Condition.visible).isDisplayed())    { ok = false; errors.add(itemGalleryMainImage); }
        if (avatarList.size() < 2)                                              { ok = false; errors.addAll(avatarList);        }
        if (!(supplierName.getText().equals(aboutSupplierName.getText()))) {
            ok = false;
            errors.add(supplierName);
            errors.add(aboutSupplierName);
        }

        if (!ok) System.out.println("Errors on Product Page: " + errors);
        return ok;
    }

    public SelenideElement getWriteButton() {
        return writeButton;
    }

    public SelenideElement getSubscribeIconButton() {
        return subscribeIconButton;
    }

    public SelenideElement getSubscribeButton() {
        return subscribeButton;
    }

    public SelenideElement getGoToMarketButton() {
        return goToMarketButton;
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
}
