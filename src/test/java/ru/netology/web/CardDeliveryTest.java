package ru.netology.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.Duration.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.of;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardDeliveryTest {

    public String generateDate(int days, String pattern) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test

    void shouldSendFormIfDataValid() {
        Selenide.open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Уфа");
        $("[data-test-id='date'] input").press(Keys.chord(Keys.CONTROL, "a"));
        $("[data-test-id='date'] input").press(Keys.BACK_SPACE);
        String datePlanning = generateDate(4, "dd.MM.yyy");
        $("[data-test-id='date'] input").setValue(datePlanning);
        $("[data-test-id='name'] input").setValue("Иванов Иван");
        $("[data-test-id='phone'] input").setValue("+79051369202");
        $("[data-test-id='agreement']").click();
        $(".button__content").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.text("Встреча успешно забронирована на " + datePlanning));













    }


}
