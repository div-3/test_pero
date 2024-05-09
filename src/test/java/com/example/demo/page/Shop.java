package com.example.demo.page;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public class Shop {
    private SelenideElement supplierName = $(By.cssSelector("a.ui_crumb"));

    public boolean checkPage() {
        Configuration.timeout = 6000;
        ArrayList<SelenideElement> errors = new ArrayList<>();
        boolean ok = true;

        if (!supplierName.isDisplayed())      { ok = false; errors.add(supplierName);     }
        return ok;
    }

    public SelenideElement getSupplierName() {
        return supplierName;
    }
}
