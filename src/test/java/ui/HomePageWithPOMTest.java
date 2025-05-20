package ui;

import org.junit.jupiter.api.Test;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomePageWithPOMTest extends BaseTestWithPOM{

    @Test
    void OpenHomePageTest() {
        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}
