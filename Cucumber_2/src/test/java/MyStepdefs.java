import io.cucumber.java.ru. * ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    private WebDriver driver;

    public MyStepdefs () {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.manage ().window ().maximize ();

    }

    @Когда("открываем сайт {string}")
    public void открываем_сайт (String string) {
        driver.get (string);

    }

    @Тогда("нажимаем кнопку {string}")
    public void нажимаем_кнопку(String string) {
        driver.findElement(By.id("navbarDropdown")).click();
    }
}