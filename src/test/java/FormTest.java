import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class FormTest {

    String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    @Test
    void positiveFormTest() {
        String date = generateDate(4);
        open("http://localhost:9999");
        $("[data-test-id= city] input").setValue("Москва");
        $("[data-test-id= date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id= date] input").setValue(date);
        $("[data-test-id= name] input").setValue("Андрей");
        $("[data-test-id= phone] input").setValue("+79012345678");
        $("[data-test-id= agreement] ").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! " + "Встреча успешно забронирована на " + date), Duration.ofSeconds(15)).shouldBe(visible);
    }


    @Test
    void dropDownTest() {
        String date = generateDate(4);
        open("http://localhost:9999");
        $("[data-test-id= city] input").setValue("Москва");
        $("[data-test-id= date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id= date] input").setValue(date);
        $("[data-test-id= name] input").setValue("Андрей");
        $("[data-test-id= phone] input").setValue("+79012345678");
        $("[data-test-id= agreement] ").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! " + "Встреча успешно забронирована на " + date), Duration.ofSeconds(15)).shouldBe(visible);
    }
}

