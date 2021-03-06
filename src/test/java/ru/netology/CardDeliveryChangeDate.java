package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.registration.RegistrationInfo;
import ru.netology.utilits.DataGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryChangeDate {
    RegistrationInfo info;

    @BeforeEach
    void setUpAll() {
        info = DataGenerator.Registration.generateInfo("ru");
    }

    @Test
    void shouldTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue(info.getCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(info.getDateOne());
        $("[data-test-id='name'] input").setValue(info.getName());
        $("[data-test-id='phone'] input").setValue(info.getPhone());
        $("[data-test-id='agreement'] .checkbox__box").click();
        $$("button").find(exactText("Запланировать")).click();
        $("[data-test-id='success-notification']").shouldBe(appear);
        $("[data-test-id='success-notification']").shouldHave(text(info.getDateOne()));
        $("[data-test-id='success-notification'] .icon_name_close").click();
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(info.getDateTwo());
        $$("button").find(exactText("Запланировать")).click();
        $("[data-test-id='replan-notification']").shouldBe(appear);
        $$("button").find(exactText("Перепланировать")).click();
        $("[data-test-id='success-notification']").shouldBe(appear);
        $("[data-test-id='success-notification']").shouldHave(text(info.getDateTwo()));
    }
}
