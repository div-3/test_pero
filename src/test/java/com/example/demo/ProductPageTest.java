package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.example.demo.page.Message;
import com.example.demo.page.Product;
import com.example.demo.page.Shop;
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

//    @Test
//    public void search() throws InterruptedException {
//        Thread.sleep(1_000);
//    }

    /*Задание 1.
    Написать WEB-автотест на функциональность карточки товара. */
    @Test
    @DisplayName("Наличие элементов на странице Product")
    public void shouldBeVisibleAllElementsOnProductPage(){
        Product product = new Product();
        assertTrue(product.checkPage());
    }

    @Test
    @DisplayName("Открытие страницы Shop со страницы Product по кнопке 'Перейти в магазин'")
    public void shouldOpenShopPageOnGoToShopButtonOnProductPage(){
        Product product = new Product();
        String productSupplierName = product.getSupplierName().getText();

        Shop shop = product.goToShop();     //Открыть магазин по кнопке "Перейти в магазин"
        String shopSupplierName = shop.getSupplierName().getText();
        assertEquals(productSupplierName, shopSupplierName);
    }

    /*Задание 2.
    Написать WEB-автотест на функциональность главной сообщества. */


}
