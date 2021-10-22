import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Selenide;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Adjarabet {
    @Test
    public void test_case_1(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://www.adjarabet.com/ka";
        Selenide.open("/SignUp/ThreeSteps/First");

        $(by("data-id", "signUpFormFirstOfThree_firstname")).setValue("alina");
        $(by("data-id", "signUpFormFirstOfThree_lastname")).setValue("breg");
        $("._css_check-radio__desc", 1).click();
        $(by("data-id", "signUpFormFirstOfThree_day")).setValue("10");
        $(by("data-id", "signUpFormFirstOfThree_month")).setValue("10");
        $(by("data-id", "signUpFormFirstOfThree_year")).setValue("1990");
        $(by("data-id", "signUpFormFirstOfThree_address")).setValue("georgia");
        $(by("data-id", "signUpFormFirstOfThree_email")).setValue("alin@at.ge");
        $(byText("გთხოვთ, სწორად შეიყვანეთ ელ-ფოსტა")).shouldNotBe(Condition.visible);
        $(by("data-id", "signUpFormFirstOfThree_username")).setValue("alin1234");
        $(by("data-id", "signUpFormFirstOfThree_password")).setValue("1234qwerA");
        $(byText("პაროლი უნდა შეიცავდეს 6-30 სიმბოლოს. მინიმუმ ერთ დიდ ასოს, ერთ პატარა ასოს და ერთ ციფრს")).shouldNotBe(Condition.visible);
        $(by("href", "/ka/SignUp/ThreeSteps/Second")).click();

        Selenide.open("https://www.adjarabet.com/ka/SignUp/ThreeSteps/Second");
    }

}
