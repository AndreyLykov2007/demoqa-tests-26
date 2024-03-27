package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;


public class TextBoxTests {
    @BeforeAll
    static void BeforeAll() {
    Configuration.holdBrowserOpen = true;
    Configuration.browserSize = "1920x1180";
    Configuration.pageLoadStrategy = "normal";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.timeout = 5000;
    }
    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Ivan");
        $("#userEmail").setValue("ivan@poker.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Ivan"));
        $("#output #email").shouldHave(text("ivan@poker.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 2"));
    }

}
