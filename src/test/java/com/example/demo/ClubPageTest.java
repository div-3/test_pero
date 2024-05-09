package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.example.demo.page.Club;
import com.example.demo.page.Market;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClubPageTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895");
    }

    /*Задание 2.
    Написать WEB-автотест на функциональность главной сообщества. */
    @Test
    @DisplayName("Наличие элементов на странице Club")
    @Description("Тест наличия всех необходимых элементов на странице Club.")
    @Story("Как пользователь, я могу использовать все необходимые элементы на странице Club")
    @Feature("ClubPage")
    @Tags({@Tag("Positive"), @Tag("CheckPage"), @Tag("ClubPage")})  //Теги для JUnit и Allure
    @Severity(SeverityLevel.BLOCKER)                     //Важность теста для Allure
    @Owner("Dudorov")
    public void shouldBeVisibleAllElementsOnClubPage(){
        Club club = new Club();
        assertTrue(club.checkPage());
    }

    @Test
    @DisplayName("Открытие страницы Market со страницы Club по кнопке 'Показать всё'")
    @Description("Тест открытия страницы Market со страницы Club по кнопке 'Показать всё' и " +
            "проверка совпадения наименования магазина на страницах.")
    @Story("Как пользователь, я могу открыть страницу Market со страницы Club по кнопке 'Показать всё'")
    @Feature("ClubPage")
    @Tags({@Tag("Positive"), @Tag("ClubPage")})  //Теги для JUnit и Allure
    @Severity(SeverityLevel.BLOCKER)                     //Важность теста для Allure
    @Owner("Dudorov")
    public void shouldOpenShopPageOnShowAllLinkOnProductPage(){
        Club club = new Club();

        String clubName = club.getSupplierName().getText();

        Market market = club.goToMarket();
        String shopName = market.getSupplierName().getText();
        assertEquals(clubName, shopName);
    }

    @Test
    @DisplayName("Счётчики количества товаров на страницах Market и Club должны совпадать")
    @Description("Тест совпадения количества товара на странице Market и странице Club.")
    @Story("Как пользователь, я могу быть уверен, что количество товара одинаковое на странице Market и Club")
    @Feature("ClubPage")
    @Tags({@Tag("Positive"), @Tag("ClubPage")})  //Теги для JUnit и Allure
    @Severity(SeverityLevel.BLOCKER)                     //Важность теста для Allure
    @Owner("Dudorov")
    public void shouldProductCountersBeEquals(){
        Club club = new Club();
        Integer clubProductCount = club.getProductCounter();

        Market market = club.goToMarket();
        Integer shopProductCount = Integer.parseInt(market.getProductCount().getText());

        assertEquals(clubProductCount, shopProductCount);
    }
}
