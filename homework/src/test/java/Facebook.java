import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class Facebook {
    @Test
    public void test_case_2(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.facebook.com/");

        $(by("data-testid", "open-registration-form-button")).click();

        $(by("name", "firstname")).setValue("ali");
        $(by("name", "lastname")).setValue("breg");
        $(by("name", "reg_email__")).setValue("alin@test.ge");
        $(by("name", "reg_passwd__")).setValue("pass12334");

        $("#year").selectOptionByValue("1990");
        $("#day").selectOptionByValue("20");
        $("#month").selectOptionByValue("5");

        element(by("name", "sex"), 2).click();
        $("#custom_gender_container").shouldBe(Condition.visible);
        $(by("name","preferred_pronoun")).selectOption(2);

        element(by("name", "sex"), 1).click();
        $("#custom_gender_container").shouldNotBe(Condition.visible);

        $(by("name", "websubmit")).click();
    }
}
