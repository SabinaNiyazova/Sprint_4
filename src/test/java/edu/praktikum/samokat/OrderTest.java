package edu.praktikum.samokat;

import edu.praktirum.samokat.pom.MainPage;
import edu.praktirum.samokat.pom.OrderInfo;
import edu.praktirum.samokat.pom.OrderPage;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderTest extends AllTests {

    // Тест заказа через кнопку в хедере
    @Test
    public void samokatOrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Кузя")
                .sendClientLastName("Пупокови")
                .sendDeliveryAddress("Москва, Кожевническая, 11")
                .selectMetroStation("Павелецкая")
                .sendDeliveryClientPhoneNumber("83333333333")
                .clickNextButton();

        boolean isDisplayed = new OrderInfo(driver)
                .sendRentalDate("28.03.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Папапапа")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Нет поп-ап с подтверждением заказа!", isDisplayed);
    }
    //Тест заказа через кнопку в середине страницы
    @Test
    public void samokatOrderingByMiddleOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Мария")
                .sendClientLastName("Иванова")
                .sendDeliveryAddress("Москва, Ореховая, 16")
                .selectMetroStation("Домодедовская")
                .sendDeliveryClientPhoneNumber("89993444444")
                .clickNextButton();

        boolean isDisplayed = new OrderInfo(driver)
                .sendRentalDate("07.07.2023")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Чтобы смог поехать")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Нет поп-ап с подтверждением заказа!", isDisplayed);
    }

}
