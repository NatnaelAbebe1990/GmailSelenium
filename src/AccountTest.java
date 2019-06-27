import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class AccountTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "Driver/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://mail.google.com");
        System.out.println(" ");
        System.out.println("Gmail Website.");
        System.out.println(" ");


        /*log to gmail*/
        driver.findElement(By.id("identifierId")).sendKeys("natnaelabebe1990@gmail.com");
        driver.findElement(By.id("identifierNext")).click();/*next button*/
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("NatiAbebe1990");
        driver.findElement(By.id("passwordNext")).click();

        System.out.println(" ");
        System.out.println("Logged In.");
        System.out.println(" ");
        /****************************/

        /*Get unread messages*/
        List<WebElement> recentinboxes = driver.findElements(By.className("zE"));
        StringBuilder emails;
        emails = new StringBuilder();

        String unreadinboxes = "Number of Unread Inboxes: " + recentinboxes.size() + "\n\n";
        emails.append(unreadinboxes);

        for (WebElement message:
                recentinboxes) {
            emails.append(message.getText());
        }

        //writing to a file
        Inboxes i = new Inboxes();
        i.getRecentInboxes(emails.toString());

    }
}

