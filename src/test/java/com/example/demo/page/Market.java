package com.example.demo.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public class Market {
    private SelenideElement supplierName = $(By.cssSelector("a.ui_crumb"));
    private SelenideElement productCount = $("#market_items_count");

    public boolean checkPage() {
        ArrayList<SelenideElement> errors = new ArrayList<>();

        boolean ok = true;

        if (!supplierName.shouldBe(Condition.visible).isDisplayed())      { ok = false; errors.add(supplierName);     }
        if (!productCount.shouldBe(Condition.visible).isDisplayed())      { ok = false; errors.add(productCount);     }
        return ok;
    }

    public SelenideElement getProductCount() {
        return productCount;
    }

    public SelenideElement getSupplierName() {
        return supplierName;
    }
}
