package tests;

import static com.codeborne.selenide.Condition.visible;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import functions.BaseTest;
import screenObjects.MainScreen;
import screenObjects.NewAccountScreen;

public class AccountTests extends BaseTest {

	@Test(groups = "Account Tests", description = "Create new Account")
	public void createNewAccount() {

		//Creating a new account, testing if it's visible and logging the result to the report
		MainScreen.clickAddAccountBtn();
		NewAccountScreen.typeAccountName("Freelance jobs");
		NewAccountScreen.clickAccountColor();
		NewAccountScreen.clickColorOption();
		NewAccountScreen.typeAccountDescription("Account to control my freelance jobs");
		NewAccountScreen.clickPlaceholderAccountOption();
		NewAccountScreen.clickSaveBtn();
		MainScreen.accountItem("Freelance jobs").shouldBe(visible);
		test.log(Status.PASS, "Account created successfully");

	}
	
	@Test(groups = "Account Tests", description = "Edit Account")
	public void editAccount() {

		//Editing an account, testing if it's visible and logging the result to the report
		MainScreen.clickOptionsBtnFromAccountItem("Freelance jobs");
		MainScreen.clickEditAccountOption();
		NewAccountScreen.typeAccountName("Freelance bills");
		NewAccountScreen.typeAccountDescription("Account to control the bills from my freelance jobs");
		NewAccountScreen.clickSaveBtn();
		MainScreen.accountItem("Freelance bills").shouldBe(visible);
		test.log(Status.PASS, "Account edited successfully");

	}

	@Test(groups = "Account Tests", description = "Delete Account")
	public void deleteAccount() {

		//Deleting an account, testing if it's not visible and logging the result to the report
		MainScreen.clickOptionsBtnFromAccountItem("Freelance bills");
		MainScreen.clickDeleteAccountOption();
		MainScreen.accountItem("Freelance bills").shouldNotBe(visible);
		test.log(Status.PASS, "Account deleted successfully");

	}	

	@Test(groups = "Account Tests", description = "Search Account")
	public void searchAccount() {

		//Searching an account non-existent and one that exists, testing and logging the result to the report
		MainScreen.clickSearchAccountBtn();
		MainScreen.typeSearchAccount("Non-existent account");
		MainScreen.noAccountToDisplayText().shouldBe(visible);
		test.log(Status.PASS, "Message 'No accounts to display' successfully exhibited");

		MainScreen.typeSearchAccount("Salary");
		MainScreen.accountItem("Salary").shouldBe(visible);
		MainScreen.clickSearchGoBackBtn();
		test.log(Status.PASS, "Account successfully exhibited");

	}		
}
