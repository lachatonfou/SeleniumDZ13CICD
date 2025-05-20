package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DialogBoxesTest extends BaseTest{

    @BeforeEach
    void setupDialogBoxes() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
    }

    @Test
    void proverkaLaunchAlert() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement launchAlertButton = driver.findElement(By.id("my-alert"));
        launchAlertButton.click();
        Alert launchAlert = wait.until(ExpectedConditions.alertIsPresent());
        String launchAllertText = launchAlert.getText();
        assertEquals(launchAllertText, "Hello world!");
        Thread.sleep(2000);
        launchAlert.accept();
        Thread.sleep(2000);
    }

    @Test
    void proverkaLaunchConfirm() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement launchConfirmButton = driver.findElement(By.id("my-confirm"));
        launchConfirmButton.click();
        Alert launchConfirm = wait.until(ExpectedConditions.alertIsPresent());
        String launchConfirmText = launchConfirm.getText();
        assertEquals(launchConfirmText, "Is this correct?");
        Thread.sleep(2000);
        launchConfirm.accept();
        Thread.sleep(2000);
        String launchConfirmFinalText = driver.findElement(By.id("confirm-text")).getText();
        assertEquals(launchConfirmFinalText, "You chose: true");
    }

    @Test
    void proverkaLaunchPrompt() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement launchPromptButton = driver.findElement(By.id("my-prompt"));
        launchPromptButton.click();
        Alert launchPrompt = wait.until(ExpectedConditions.alertIsPresent());
        String launchPromptText = launchPrompt.getText();
        assertEquals(launchPromptText, "Please enter your name");
        launchPrompt.sendKeys("Mariya");
        Thread.sleep(2000);
        launchPrompt.accept();
        Thread.sleep(2000);
        String launchPromptFinalText = driver.findElement(By.id("prompt-text")).getText();
        assertEquals(launchPromptFinalText, "You typed: Mariya");
    }

    @Test
    void proverkaLaunchModal() throws InterruptedException {
        WebElement launchModalButton = driver.findElement(By.id("my-modal"));
        launchModalButton.click();
        Thread.sleep(2000);
        String launchModalText = driver.findElement(By.className("modal-body")).getText();
        assertEquals(launchModalText, "This is the modal body");
        Thread.sleep(2000);
        driver.findElement(By.className("btn-primary")).click();
        Thread.sleep(2000);
        String launchModalFinalText = driver.findElement(By.id("modal-text")).getText();
        assertEquals(launchModalFinalText, "You chose: Save changes");
    }
}
