package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropDownMenuTest extends BaseTest{

    @BeforeEach
    void setupDropDown() {
        driver.findElement(By.xpath("//a[@href = 'dropdown-menu.html']")).click();
    }

    @Test
    void proverkaDropdownMenu(){
        WebElement leftclick = driver.findElement(By.id("my-dropdown-1"));
        Actions actions = new Actions(driver);
        actions.click(leftclick).perform();
        List<WebElement> menuItems1 = driver.findElements(By.xpath("//ul[@class='dropdown-menu show']"));
        WebElement firstItem1 = menuItems1.get(0);
        String[] firstItemText1 = firstItem1.getText().split("\n");
        assertEquals("Action", firstItemText1[0]);
    }

    @Test
    void rightClick() {
        WebElement rightclick = driver.findElement(By.id("my-dropdown-2"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightclick).perform();
        List<WebElement> menuItems2 = driver.findElements(By.id("context-menu-2"));
        WebElement firstItem2 = menuItems2.get(0);
        String[] firstItemText2 = firstItem2.getText().split("\n");
        assertEquals("Action", firstItemText2[0]);
    }

    @Test
    void doubleClick() {
        WebElement doubleclick = driver.findElement(By.id("my-dropdown-3"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleclick).perform();
        List<WebElement> menuItems3 = driver.findElements(By.id("context-menu-3"));
        WebElement firstItem3 = menuItems3.get(0);
        String[] firstItemText3 = firstItem3.getText().split("\n");
        assertEquals("Action", firstItemText3[0]);
    }
}
