import com.codeborne.selenide.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.type;

        public class SelenideTest{
    public SelenideTest() {
        baseUrl = "http://the-internet.herokuapp.com";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
    }
    @Test
    public void checkbox() {
        open("/checkboxes");
        $(byTagName("input"), 0).setSelected(true);
        $(byTagName("input"), 1).setSelected(false);
        $(byTagName("input"), 0).shouldHave(type("checkbox"));
        $(byTagName("input"), 1).shouldHave(type("checkbox"));
        sleep(9999);
    }
    @Test
    public void dropdown() {
        Selenide.open("/dropdown");
        SelenideElement dropelement= $("#dropdown");
        $("#dropdown").shouldHave(text("Please select an option"));
        System.out.println(dropelement.getText());
        String firstText="Please select an option";
        if(dropelement.getText().equals(firstText)){
            System.out.println("first text is fine");}
        dropelement.selectOption("Option 2");
        sleep(15000);
        $("#dropdown").shouldHave(text("Option 2"));
    }
    @Test
    public void textboxes() {
        Configuration.baseUrl = "https://demoqa.com";
       open("/text-box");
        $(by("id", "userName")).setValue("Ambartsum Karapetyan");
        $(byXpath("//input[@type='email']")).setValue("ambartsumkarapetyan@gmail.com");
        $(by("placeholder","Current Address")).setValue("Akhalkalaki");
        $("textarea#permanentAddress").setValue("Kartsaki");
        $(byXpath("//*[@id=\"userForm\"]/div[5]/div")).click();
        sleep(15000);
        ElementsCollection collection = $$("#output .border p");
        collection.shouldHave(texts("Ambartsum Karapetyan","ambartsumkarapetyan@gmail.com","Akhalkalaki","Kartsaki"));
    }
}