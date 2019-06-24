package screenObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import org.openqa.selenium.By;
import functions.BaseTest;

public class NewAccountScreen extends BaseTest {

    public static void typeAccountName(String accountName) {
        type("Account Name field", $(By.id("org.gnucash.android:id/input_account_name")), accountName);
    }

    public static void clickAccountColor() {
        click("Account Color btn", $(By.id("org.gnucash.android:id/input_color_picker")));
    }

    public static void clickColorOption() {
        click("Colour option", $x("//android.widget.TableRow[@index='4']/android.widget.FrameLayout[@index='0']"));
    }

    public static void typeAccountDescription(String description) {
        type("Account Description field", $(By.id("org.gnucash.android:id/input_account_description")), description);
    }

    public static void clickPlaceholderAccountOption() {
        click("Placeholder Account option", $(By.id("org.gnucash.android:id/checkbox_placeholder_account")));
    }

    public static void clickSaveBtn() {
        click("Save btn", $(By.id("org.gnucash.android:id/menu_save")));
    }

}