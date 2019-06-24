package screenObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import functions.BaseTest;

public class TransactionsScreen extends BaseTest {

    public static void clickAddTransactionBtn() {
        click("Add Sub-Account btn", $(By.id("org.gnucash.android:id/fab_create_transaction")));
    }

    public static void clickTransactionItem(String accountItemName) {
        click("Account Item", $x("//android.widget.TextView[@text=\""+accountItemName+"\"]"));
    }

    public static void typeTransactionDescription(String description) {
        type("Transaction Description", $(By.id("org.gnucash.android:id/input_transaction_name")), description);
    }

    public static void typeTransactionAmount(String amount) {
        type("Transaction Amount field", $(By.id("org.gnucash.android:id/input_transaction_amount")), amount);
    }

    public static void clickTransactionType() {
        click("Transaction Type togle", $(By.id("org.gnucash.android:id/input_transaction_type")));
    }

    public static void clickTransactionDoubleEntryAccount() {
        click("Transaction Double Entry Account field", $(By.id("org.gnucash.android:id/input_transfer_account_spinner")));
    }

    public static void clickTransactionDoubleEntryAccountOption(String option) {
        click("Double Entry Account option", $x("android.widget.CheckedTextView[@text=\""+option+"\"]"));
    }

    public static void typeTransactionNote(String note) {
        type("Transaction Note field", $(By.id("org.gnucash.android:id/input_description")), note);
    }

    public static void clickSaveBtn() {
        click("Transaction Save btn", $(By.id("org.gnucash.android:id/menu_save")));
    }

    public static void clickOptionsBtnFromTransactionItem(String transactionItemName) {
        click("Account Item", $x("//android.widget.TextView[@text=\""+transactionItemName+"\"]/../../android.widget.ImageView[@index='4']"));
    }

    public static void clickEditBtnFromTransactionItem(String transactionItemName) {
        click("Edit Transaction btn", $x("//android.widget.TextView[@text=\""+transactionItemName+"\"]/../../android.widget.ImageView[@index='1']"));
    }

    public static void clickMoveTransactionOption() {
        click("Edit Sub-Account Option", $x("//android.widget.TextView[@text='Move...']"));
    }    

    public static void clickDuplicateTransactionOption() {
        click("Edit Sub-Account Option", $x("//android.widget.TextView[@text='Duplicate']"));
    }    

    public static void clickDeleteTransactionOption() {
        click("Delete Account Option", $x("//android.widget.TextView[@text='Delete']"));
    } 

    public static SelenideElement transactionItem(String transactionItemName) {
        return $x("//android.widget.TextView[@text=\""+transactionItemName+"\"]");
    }

    public static ElementsCollection transactionItens(String transactionItemName) {
        return $$x("//android.widget.TextView[@text=\""+transactionItemName+"\"]");
    }

    public static SelenideElement transactionAmout() {
        return $(By.id("org.gnucash.android:id/transaction_amount"));
    }

}