package screenObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import functions.BaseTest;

public class SubAccountScreen extends BaseTest {

    public static void clickAddSubAccountBtn() {
        click("Add Sub-Account btn", $(By.id("org.gnucash.android:id/fab_create_transaction")));
    }

    public static void clickSubAccountItem(String accountItemName) {
        click("Account Item", $x("//android.widget.TextView[@text=\""+accountItemName+"\"]"));
    }

    public static void clickOptionsBtnFromSubAccountItem(String subAccountItemName) {
        click("Account Item", $x("//android.widget.TextView[@text=\""+subAccountItemName+"\"]/../../android.widget.ImageView[@index='4']"));
    }

    public static void clickEditSubAccountOption() {
        click("Edit Sub-Account Option", $x("//android.widget.TextView[@text='Edit Account']"));
    }    

    public static void clickDeleteSubAccountOption() {
        click("Delete Account Option", $x("//android.widget.TextView[@text='Delete']"));
    } 

    public static SelenideElement subAccountItem(String subAccountItemName) {
        return $x("//android.widget.TextView[@text=\""+subAccountItemName+"\"]");
    }

    public static SelenideElement transactionAmoutFromSubAccountItem(String subAccountItemName) {
        return $x("//android.widget.TextView[@text=\""+subAccountItemName+"\"]/../../android.widget.TextView");
    }

}