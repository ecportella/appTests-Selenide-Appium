package screenObjects;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import functions.BaseTest;

public class MainScreen extends BaseTest {

    public static void clickAddAccountBtn() {
        click("Add Account btn", $(By.id("org.gnucash.android:id/fab_create_account")));
    }

    public static void clickSearchAccountBtn() {
        click("Search Account btn", $(By.id("org.gnucash.android:id/menu_search")));
    }

    public static void typeSearchAccount(String account) {
        type("Search Account field", $(By.id("org.gnucash.android:id/search_src_text")), account);
    }

    public static SelenideElement noAccountToDisplayText() {
        return $x("//android.widget.TextView[@text='No accounts to display']");
    }

    public static SelenideElement accountItem(String accountItemName) {
        return $x("//android.widget.TextView[@text=\""+accountItemName+"\"]");
    }

    public static void clickSearchGoBackBtn() {
        click("Search Close btn", $x("//android.view.ViewGroup[@resource-id='org.gnucash.android:id/toolbar']/android.widget.ImageButton"));
    }

    public static void clickAccountItem(String accountItemName) {
        click("Account Item", $x("//android.widget.TextView[@text=\""+accountItemName+"\"]"));
    }

    public static void clickOptionsBtnFromAccountItem(String accountItemName) {
        click("Account Item", $x("//android.widget.TextView[@text=\""+accountItemName+"\"]/../../android.widget.ImageView[@index='4']"));
    }

    public static void clickEditAccountOption() {
        click("Edit Account Option", $x("//android.widget.TextView[@text='Edit Account']"));
    }    

    public static void clickDeleteAccountOption() {
        click("Delete Account Option", $x("//android.widget.TextView[@text='Delete']"));
    }   

    public static void clickDeleteTransactionRadioOption() {
        click("Delete Transaction radio option", $(By.id("org.gnucash.android:id/radio_delete")));
    }

    public static void clickDeleteBtn() {
        click("Delete btn from confirmation window", $(By.id("org.gnucash.android:id/btn_save")));
    }

}