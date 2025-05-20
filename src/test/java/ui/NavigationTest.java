package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest extends BaseTest {

    @Test
    void proverkaNavigation() throws InterruptedException {

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html");

        WebElement secondButton = driver.findElement(By.xpath("//li[normalize-space(.)='2']"));
        secondButton.click();
        assertThat(driver.getCurrentUrl()).contains("navigation2.html");
        WebElement textSecondPage = driver.findElement(By.xpath("//p[@class='lead']"));
        assertTrue(textSecondPage.getText().contains("Ut enim ad minim veniam"));
        Thread.sleep(200);

        WebElement nextButton = driver.findElement(By.xpath("//li[normalize-space(.)='Next']"));
        nextButton.click();
        assertThat(driver.getCurrentUrl()).contains("navigation3.html");
        WebElement textThirdPage = driver.findElement(By.xpath("//p[@class='lead']"));
        assertTrue(textThirdPage.getText().contains("Excepteur sint occaecat"));
        Thread.sleep(2000);

        WebElement previousButton = driver.findElement(By.xpath("//li[normalize-space(.)='Previous']"));
        previousButton.click();
        assertThat(driver.getCurrentUrl()).contains("navigation2.html");
        WebElement textPreviousPage = driver.findElement(By.xpath("//p[@class='lead']"));
        assertTrue(textPreviousPage.getText().contains("Ut enim ad minim veniam"));
        Thread.sleep(2000);

    }

}
