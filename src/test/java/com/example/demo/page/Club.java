package com.example.demo.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public class Club {

    private SelenideElement showAllLink = $(By.xpath("//a[@data-role='show-all']"));
    private SelenideElement showAllWithProductCounterText = $(By.xpath("//a[@data-role='show-all']//span[contains(@class, 'FlatButton__content')]"));
    private SelenideElement supplierName = $(By.className("page_name"));
    private Integer productCounter;

    public Market goToMarket() {
        showAllLink.scrollIntoView(true).click();
        return new Market();
    }

    public Integer getProductCounter() {
        productCounter = Integer.parseInt(showAllWithProductCounterText.getText().split(" ")[2]);
        return productCounter;
    }

    public boolean checkPage() {
        ArrayList<SelenideElement> errors = new ArrayList<>();
        boolean ok = true;

        if (!showAllLink.shouldBe(Condition.visible).isDisplayed())      { ok = false; errors.add(showAllLink);   }
        if (!supplierName.shouldBe(Condition.visible).isDisplayed())         { ok = false; errors.add(supplierName);      }

        if (!ok) System.out.println("Errors on Product Page: " + errors);
        return ok;
    }

    public SelenideElement getShowAllLink() {
        return showAllLink;
    }

    public SelenideElement getSupplierName() {
        return supplierName;
    }

    public SelenideElement getShowAllWithProductCounterText() {
        return showAllWithProductCounterText;
    }
}
