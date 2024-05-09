package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.example.demo.page.Club;
import com.example.demo.page.Market;
import com.example.demo.page.Product;
import io.qameta.allure.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPageTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895?w=product-225299895_10044406");
    }

    /*Задание 1.
    Написать WEB-автотест на функциональность карточки товара. */
    @Test
    @DisplayName("Наличие элементов на странице Product")
    @Description("Тест наличия всех необходимых элементов на странице Product.")
    @Story("Как пользователь, я могу использовать все необходимые элементы на странице Product")
    @Feature("ProductPage")
    @Tags({@Tag("Positive"), @Tag("CheckPage"), @Tag("ProductPage")})  //Теги для JUnit и Allure
    @Severity(SeverityLevel.BLOCKER)                     //Важность теста для Allure
    @Owner("Dudorov")
    public void shouldBeVisibleAllElementsOnProductPage(){
        Product product = new Product();
        assertTrue(product.checkPage());
    }

    @Test
    @DisplayName("Открытие страницы Market со страницы Product по кнопке 'Перейти в магазин'")
    @Description("Тест открытия страницы Market со страницы Product по кнопке 'Перейти в магазин' и " +
            "проверка совпадения наименования магазина на страницах.")
    @Story("Как пользователь, я могу открыть страницу Market со страницы Product по кнопке 'Перейти в магазин'")
    @Feature("ProductPage")
    @Tags({@Tag("Positive"), @Tag("ProductPage")})  //Теги для JUnit и Allure
    @Severity(SeverityLevel.BLOCKER)                     //Важность теста для Allure
    @Owner("Dudorov")
    public void shouldOpenShopPageOnGoToShopButtonOnProductPage(){
        Product product = new Product();
        String productSupplierName = product.getSupplierName().getText();

        Market market = product.goToMarket();     //Открыть магазин по кнопке "Перейти в магазин"
        String shopSupplierName = market.getSupplierName().getText();
        assertEquals(productSupplierName, shopSupplierName);
    }
}
