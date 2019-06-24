package tests;

import static com.codeborne.selenide.Condition.visible;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import functions.BaseTest;
import screenObjects.MainScreen;
import screenObjects.NewAccountScreen;
import screenObjects.SubAccountScreen;

public class SubAccountTests extends BaseTest {

	@Test(groups = "Sub-Account Tests", description = "Create new sub-account")
	public void createNewSubAccount() {

		//Creating a new sub-account, testing if it's visible and logging the result to the report
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickAddSubAccountBtn();
		NewAccountScreen.typeAccountName("Stock Market assets");
		NewAccountScreen.clickAccountColor();
		NewAccountScreen.clickColorOption();
		NewAccountScreen.typeAccountDescription("Sub-account to control my Stock Market assets");
		NewAccountScreen.clickPlaceholderAccountOption();
		NewAccountScreen.clickSaveBtn();
		SubAccountScreen.subAccountItem("Stock Market assets").shouldBe(visible);
		test.log(Status.PASS, "Sub-account created successfully");

	}

	@Test(groups = "Sub-Account Tests", description = "Edit sub-account")
	public void editSubAccount() {

		//Editing an sub-account, testing if it's visible and logging the result to the report
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickOptionsBtnFromSubAccountItem("Stock Market assets");
		SubAccountScreen.clickEditSubAccountOption();
		NewAccountScreen.typeAccountName("Stock assets");
		NewAccountScreen.typeAccountDescription("Sub-account to control my Stock assets");
		NewAccountScreen.clickSaveBtn();
		SubAccountScreen.subAccountItem("Stock assets").shouldBe(visible);
		test.log(Status.PASS, "Sub-account edited successfully");

	}

	@Test(groups = "Sub-Account Tests", description = "Delete sub-account")
	public void deleteSubAccount() {

		//Deleting an sub-account, testing if it's not visible and logging the result to the report
		MainScreen.clickAccountItem("Assets");
		SubAccountScreen.clickOptionsBtnFromSubAccountItem("Stock assets");
		SubAccountScreen.clickDeleteSubAccountOption();
		SubAccountScreen.subAccountItem("Stock assets").shouldNotBe(visible);
		test.log(Status.PASS, "Sub-account deleted successfully");

	}

}
