import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

public class Facebook {
    @Test
    public void test_case_2(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://www.adjarabet.com/ka";
        Selenide.open("/SignUp/ThreeSteps/First");


    }
}
