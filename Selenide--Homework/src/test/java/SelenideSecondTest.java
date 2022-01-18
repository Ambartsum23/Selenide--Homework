import com.codeborne.selenide.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.assertionMode;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.testng.ScreenShooter;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertNotEquals;

@Listeners({ScreenShooter.class, SoftAsserts.class})
public class SelenideSecondTest {

     public SelenideSecondTest(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    Configuration.browserCapabilities =options;
    Configuration.browserSize =null;
    timeout=20000;
    holdBrowserOpen=false;
    screenshots=true;
    baseUrl ="http://the-internet.herokuapp.com";
   reopenBrowserOnFail =true;
    fastSetValue=true;
   assertionMode=AssertionMode.SOFT;
    fileDownload=FileDownloadMode.HTTPGET;
     reportsFolder="src/main/resources/Reports";
    downloadsFolder="src/main/resources/Reports";
    //vcade ro marto fotoebi shefinaxo ar gamovida(
}
    @Test
    public void booksFound() {
        SoftAssert soft= new SoftAssert();
        open("https://demoqa.com/books");
        ElementsCollection list = $(".rt-tbody").$$(".rt-tr-group").filterBy(text("O'Reilly Media")).filterBy(text("JavaScript"));
        soft.assertEquals(list.size(), 10,"failed case");
        List<String> result = list.texts();
        System.out.println(result);
        soft.assertEquals(list.get(0).getText(), "Learning JavaScript Design Padtterns");

        ElementsCollection a = $(".rt-tbody").$$(".rt-tr-group div div div span a");
        a.stream().forEach(el -> { el.click(); back();});
        /*for (int i = 0; i <list.size(); i++) {
         $$(byCssSelector(".rt-tr-group div > div > div > span >a")).stream().forEach(el -> el.click());
        }*/

}
    @Test
    public void isImage() {
        open("https://demoqa.com/books");
        ElementsCollection book = $(".ReactTable").$(".rt-tbody").findAll(".rt-tr-group").filterBy(text("O'Reilly Media")).filterBy(text("JavaScript"));
        ElementsCollection img = $(".ReactTable").$(".rt-tbody").findAll("img");
        assertNotEquals(img.size(), 0);
    }
    @AfterMethod
    public void closebrowser() {
         closebrowser();
    }

}
