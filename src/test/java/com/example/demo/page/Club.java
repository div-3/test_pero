package com.example.demo.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Club {
    private SelenideElement writeButton = $(By.xpath("//button[contains(., 'Написать')]")).should(Condition.exist);
    private SelenideElement subscribeIconButton = $(By.xpath("//button[contains(@class, 'ItemAuthor-module__iconSubscribe')]")).should(Condition.exist);
    private SelenideElement subscribeButton = $(By.className("MarketItemCardShopInfo__buttonToggleSubscribeGroup")).should(Condition.exist);
    private SelenideElement goToShopButton = $(By.className("MarketItemCardShopInfo__buttonGoToShop")).should(Condition.exist);
    private ElementsCollection avatarList = $$(By.className("vkuiImageBase__img"));
    private SelenideElement aboutSupplierName = $(By.className("MarketItemCardShopInfo__label")).should(Condition.exist);
    private SelenideElement supplierName = $(By.xpath("//a[contains(@class, 'ItemAuthor-module__label')]")).should(Condition.exist);
    private SelenideElement itemGalleryMainImage = $(By.className("ItemGallery__main")).should(Condition.exist);
}
