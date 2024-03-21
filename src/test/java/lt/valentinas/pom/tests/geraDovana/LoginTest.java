package lt.valentinas.pom.tests.geraDovana;

import lt.valentinas.pom.pages.geraDovana.HomePage;
import lt.valentinas.pom.pages.geraDovana.LoginPage;
import lt.valentinas.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open("https://www.geradovana.lt/");
        HomePage.clickAcceptCookies();
        HomePage.closePopUpWindow();
    }

    @Test
    public void testLogin_ProvidedCorrectInput() {
        boolean expectedResult = true;

        String email = "valiuspus@gmail.com";
        String password = "slaptazodis123";

        HomePage.hoverOverProfileDropdownMenu();
        HomePage.clickPrisijungti();

        LoginPage.writeEmail(email);
        LoginPage.writePassword(password);
        LoginPage.clickButtonLogin();

        boolean actualResult = HomePage.checkLoginStatus();

        Assert.assertEquals(actualResult, expectedResult,
                "\nExpected: %s,\nActual: %s\n".formatted(expectedResult, actualResult)
        );
    }

    @Test
    public void testLogin_ProvidedIncorrectInput() {
        boolean expectedResult = true;

        String email = "valiuspus@gmail.com";
        String password = "neteisingas_slaptazodis";

        HomePage.hoverOverProfileDropdownMenu();
        HomePage.clickPrisijungti();

        LoginPage.writeEmail(email);
        LoginPage.writePassword(password);
        LoginPage.clickButtonLogin();

        boolean actualResult = LoginPage.checkForErrorMessage();

        Assert.assertEquals(actualResult, expectedResult,
                "\nExpected: %s,\nActual: %s\n".formatted(expectedResult, actualResult)
        );
    }


}
