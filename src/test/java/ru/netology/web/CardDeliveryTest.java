package ru.netology.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

class CardDeliveryTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    public String generateDate(int days, String pattern) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern(pattern));

    }

    @Test

    void shouldSendFormIfDataValid() {
        Selenide.open("http://localhost:9999");
        $("[data-test-id='city']").setValue("Ярославль");

        $$();
//        String datePlanning = generateDate(4, "dd.MM.yyy");
        $("[data-test-id='name']").setValue("Иванов Иван");
        $("[data-test-id='phone']").setValue("+79051369202");
        $("[data-test-id='agreement']").click();
        $(".button__content").click();
        WebElement result = $("[data-test-id='notification']").should(Condition.visible, ofSeconds(15));









    }


}
