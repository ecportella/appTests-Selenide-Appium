package tests;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import functions.BaseTest;
import screenObjects.MainScreen;
import screenObjects.NewAccountScreen;
import screenObjects.SubAccountScreen;
import screenObjects.TransactionsScreen;

public class TransactionsTests extends BaseTest {

	@Test(groups = "Transactions Tests", description = "Create new transaction")
	public void createNewTransaction() {

		//Creating a new transaction, testing if it's visible, if the value is correct and logging the result to the report
		MainScreen.clickAccountItem("Income");
		SubAccountScreen.clickSubAccountItem("Salary");
		TransactionsScreen.clickAddTransactionBtn();
		TransactionsScreen.typeTransactionDescription("Extra income");
		TransactionsScreen.typeTransactionAmount("300");
		TransactionsScreen.clickTransactionType();
		TransactionsScreen.typeTransactionNote("Extra income from this month");
		TransactionsScreen.clickSaveBtn();
		TransactionsScreen.transactionItem("Extra income").shouldBe(visible);
		TransactionsScreen.transactionAmout().shouldHave(text("$300"));
		test.log(Status.PASS, "Sub-account created successfully and the value is correct");

		//Testing if the transaction was created in the 'Double Entry' account, if the value is correct and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickSubAccountItem("Current Assets");
		SubAccountScreen.clickSubAccountItem("Cash in Wallet");
		TransactionsScreen.transactionItem("Extra income").shouldBe(visible);
		TransactionsScreen.transactionAmout().shouldHave(text("$300"));
		test.log(Status.PASS, "'Double Entry' account also have the transaction and the value is correct");

	}

	@Test(groups = "Transactions Tests", description = "Edit transaction")
	public void editTransaction() {

		//Editing an transaction, testing if it's visible with the new value and logging the result to the report
		MainScreen.clickAccountItem("Income");
		SubAccountScreen.clickSubAccountItem("Salary");
		TransactionsScreen.clickEditBtnFromTransactionItem("Extra income");
		TransactionsScreen.typeTransactionDescription("Bonus");
		TransactionsScreen.typeTransactionAmount("600");
		TransactionsScreen.clickSaveBtn();
		TransactionsScreen.transactionItem("Bonus").shouldBe(visible);
		TransactionsScreen.transactionAmout().shouldHave(text("$600"));
		test.log(Status.PASS, "Sub-account edited successfully and the value is correct");

		//Testing if the edited transaction was edited in the 'Double Entry' account, if the value is correct and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickSubAccountItem("Current Assets");
		SubAccountScreen.clickSubAccountItem("Cash in Wallet");
		TransactionsScreen.transactionItem("Bonus").shouldBe(visible);
		TransactionsScreen.transactionAmout().shouldHave(text("$600"));
		test.log(Status.PASS, "Transaction in the 'Double Entry' account was edited too and the value is correct");

	}

	@Test(groups = "Transactions Tests", description = "Duplicate transaction")
	public void duplicateTransaction() {

		//Duplicating an transaction, testing if there is two identical transactions and logging the result to the report
		MainScreen.clickAccountItem("Income");
		SubAccountScreen.clickSubAccountItem("Salary");
		TransactionsScreen.clickOptionsBtnFromTransactionItem("Bonus");
		TransactionsScreen.clickDuplicateTransactionOption();
		TransactionsScreen.transactionItens("Bonus").shouldHave(size(2));
		test.log(Status.PASS, "Transaction successfully duplicated");

		//Testing if there is two identical transactions in the 'Double Entry' account and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickSubAccountItem("Current Assets");
		SubAccountScreen.clickSubAccountItem("Cash in Wallet");
		TransactionsScreen.transactionItens("Bonus").shouldHave(size(2));
		test.log(Status.PASS, "Transaction successfully duplicated in the 'Double Entry' account");

	}

	@Test(groups = "Transactions Tests", description = "Delete transaction")
	public void deleteTransaction() {

		//Deleting an transaction, testing if there no transaction and logging the result to the report
		MainScreen.clickAccountItem("Income");
		SubAccountScreen.clickSubAccountItem("Salary");
		TransactionsScreen.clickOptionsBtnFromTransactionItem("Bonus");
		TransactionsScreen.clickDeleteTransactionOption();
		TransactionsScreen.clickOptionsBtnFromTransactionItem("Bonus");
		TransactionsScreen.clickDeleteTransactionOption();
		TransactionsScreen.transactionItens("Edited Transaction test").shouldHave(size(0));
		test.log(Status.PASS, "Transaction successfully deleted");

		//Testing if there no transaction in the 'Double Entry' account and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickSubAccountItem("Current Assets");
		SubAccountScreen.clickSubAccountItem("Cash in Wallet");
		TransactionsScreen.transactionItens("Bonus").shouldHave(size(0));
		test.log(Status.PASS, "Transaction successfully deleted from the 'Double Entry' account");

	}

	@Test(groups = "Transactions Tests", description = "Transaction Calculation")
	public void transactionCalculation() {

		//Creating a new transaction, testing if its visible, if the value is correct and logging the result to the report
		MainScreen.clickAccountItem("Income");
		SubAccountScreen.clickSubAccountItem("Salary");
		TransactionsScreen.clickAddTransactionBtn();
		TransactionsScreen.typeTransactionDescription("Extra income");
		TransactionsScreen.typeTransactionAmount("100");
		TransactionsScreen.clickTransactionType();
		TransactionsScreen.clickSaveBtn();
		TransactionsScreen.transactionItem("Extra income").shouldBe(visible);
		TransactionsScreen.transactionAmout().shouldHave(text("$100"));
		test.log(Status.PASS, "Transaction created successfully and the value is correct");

		//Creating another transaction, testing if its visible, if the value is correct and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickAccountItem("Expenses");
		SubAccountScreen.clickSubAccountItem("Books");
		TransactionsScreen.clickAddTransactionBtn();
		TransactionsScreen.typeTransactionDescription("How to become a good QA Engineer book");
		TransactionsScreen.typeTransactionAmount("50");
		TransactionsScreen.clickSaveBtn();
		TransactionsScreen.transactionItem("How to become a good QA Engineer book").shouldBe(visible);
		TransactionsScreen.transactionAmout().shouldHave(text("$50"));
		test.log(Status.PASS, "Second transaction created successfully and the value is correct");

		//Testing if the calculation is correct and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickSubAccountItem("Current Assets");
		SubAccountScreen.transactionAmoutFromSubAccountItem("Cash in Wallet").shouldHave(text("$50"));
		test.log(Status.PASS, "Calculation is correct");

		//Deleting both transactions for app cleanup and logging the result to the report
		SubAccountScreen.clickSubAccountItem("Cash in Wallet");
		TransactionsScreen.clickOptionsBtnFromTransactionItem("Extra income");
		TransactionsScreen.clickDeleteTransactionOption();
		TransactionsScreen.clickOptionsBtnFromTransactionItem("How to become a good QA Engineer book");
		TransactionsScreen.clickDeleteTransactionOption();
		test.log(Status.PASS, "Transactions deleted successfully");
		
		//Testing if both transactions were deleted from the 'Double Entry' account and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickSubAccountItem("Current Assets");
		SubAccountScreen.transactionAmoutFromSubAccountItem("Cash in Wallet").shouldHave(text("$0"));
		test.log(Status.PASS, "Transactions from the 'Double Entry' account deleted successfully");

	}

	@Test(groups = "Transactions Tests", description = "Delete account with Transaction")
	public void deleteAccountWithTransaction() {

		//Creating a new account, testing if it's visible and logging the result to the report
		MainScreen.clickAddAccountBtn();
		NewAccountScreen.typeAccountName("Freelance jobs");
		NewAccountScreen.clickAccountColor();
		NewAccountScreen.clickColorOption();
		NewAccountScreen.typeAccountDescription("Account to control my freelance jobs money");
		NewAccountScreen.clickPlaceholderAccountOption();
		NewAccountScreen.clickSaveBtn();
		MainScreen.accountItem("Freelance jobs").shouldBe(visible);
		test.log(Status.PASS, "Account created successfully");

		//Creating a new sub-account, testing if it's visible and logging the result to the report
		MainScreen.clickAccountItem("Freelance jobs");
		SubAccountScreen.clickAddSubAccountBtn();
		NewAccountScreen.typeAccountName("Test Automation jobs");
		NewAccountScreen.clickAccountColor();
		NewAccountScreen.clickColorOption();
		NewAccountScreen.typeAccountDescription("Sub-account to control meu Test Automation freelance jobs");
		NewAccountScreen.clickSaveBtn();
		SubAccountScreen.subAccountItem("Test Automation jobs").shouldBe(visible);
		test.log(Status.PASS, "Sub-account created successfully");

		//Creating a new transaction, testing if it's visible, if the value is correct and logging the result to the report
		SubAccountScreen.clickSubAccountItem("Test Automation jobs");
		TransactionsScreen.clickAddTransactionBtn();
		TransactionsScreen.typeTransactionDescription("N26 Home Task");
		TransactionsScreen.typeTransactionAmount("250");
		TransactionsScreen.clickSaveBtn();
		TransactionsScreen.transactionItem("N26 Home Task").shouldBe(visible);
		TransactionsScreen.transactionAmout().shouldHave(text("$250"));
		test.log(Status.PASS, "Transaction created and the value is correct");

		//Testing if the transaction was created in the 'Double Entry' account and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickSubAccountItem("Current Assets");
		SubAccountScreen.clickSubAccountItem("Cash in Wallet");
		TransactionsScreen.transactionItem("N26 Home Task").shouldBe(visible);
		TransactionsScreen.transactionAmout().shouldHave(text("$250"));
		test.log(Status.PASS, "Transaction in the 'Double Entry' account created and the value is correct");

		//Deleting the account with the transaction, testing if it's not listed and logging the result to the report
		returnToHomeScreen();
		MainScreen.clickOptionsBtnFromAccountItem("Freelance jobs");
		MainScreen.clickDeleteAccountOption();
		MainScreen.clickDeleteTransactionRadioOption();
		MainScreen.clickDeleteBtn();
		MainScreen.accountItem("Freelance jobs").shouldNotBe(visible);
		test.log(Status.PASS, "Account and Transaction deleted successfully");

		//Testing if the transaction were deleted from the 'Double Entry' account and logging the result to the report
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickSubAccountItem("Current Assets");
		SubAccountScreen.clickSubAccountItem("Cash in Wallet");
		TransactionsScreen.transactionItem("N26 Home Task").shouldNotBe(visible);
		test.log(Status.PASS, "Transaction deleted successfully from the 'Double Entry' account");

	}

}
