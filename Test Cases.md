# Monefy Task

## Test Cases ideas

- Expenses

  - Add a new expense on 'New Expense' screen. Check if the value inserted is added on the main screen chart, if it's connected to the category selected, is displayed on main screen list and if it was deducted from the total balance.   
  Priority: **High**

  - Add a new expense tapping directly on a category icon in the main screen. Check if the value inserted is added on main screen chart, if it's added to the category selected, is displayed on main screen list and if it was deducted from the total balance.   
  Priority: **High**

  - Edit the value of an expense in the main screen list. Check if the the value was altered on main screen list, if the changes ocurred in the main screen chart and in the total balance.  
  Priority: **High**

  - Delete an expense on the main screen list. Check if the value of the expense was removed from main screen list, if the chart and total balance was updated.  
  Priority: **High**

- Incomes

  - Add new income on 'New Income' screen. Check if the value inserted is added on the main screen chart, if is displayed on main screen list and is augmented on total balance.  
  Priority: **High**

  - Edit the value of an income in the main screen list. Check if the value was altered on main screen list, if the changes ocurred in the main screen chart and the total balance was updated.  
  Priority: **High**

  - Delete an income on the main screen list. Check if the value of the income was removed from main screen list, if the chart and total balance was updated.  
  Priority: **High**

- Categories

  - As a free user, create a new category. Check if the Monefy Pro features screen is displayed.  
  Priority: **High**

  - As a paid user, create a new category. Check if the new category is present on categories list, icon is displayed on main screen and listed as an option on 'New Expense/Income' screen.  
  Priority: **High**

  - Edit the name and icon of an existing category. Check if the changes were saved.  
  Priority: **Medium**

  - Edit the category of an expense in the main screen list. Check if the value of the expense of the old category no longer exist and was passed to the new category selected.  
  Priority: **Medium**

  - Delete a category. Check if the category no longer exists in the categories list, icon is not displayed on main screen chart, all of the expenses/incomes of that category was also deleted, and the total balance is correct.  
  Priority: **High**

  - Tap and hold an category icon on main screen chart. Check if the value of that category is displayed in the center of the chart.  
  Priority: **Low**

- Currencies

  - As a free user, add a new currency. Check if the Monefy Pro features screen is displayed.  
  Priority: **High**

  - As a paid user, add a new currency. Check if the new currency is listed as an option of use.  
  Priority: **High**

  - As a paid user, remove a currency. Check if the currency no longer is listed as an option of use.  
  Priority: **High**

- Accounts

  - Add a new account on 'New Account' screen. Check if the new account is listed on account menu, if it's listed as an option on 'New Transfer' screen, if it's listed on filters menu and if it's an option on 'New Expense/Income' screen.  
  Priority: **Medium**

  - Edit an account name and icon. Check if the changes were saved.  
  Priority: **Medium**

  - Delete an account. Check if the account is no longer listed on account menu, in the filters, in the 'New Transfer' screen and 'New Expense/Income' screen.  
  Priority: **Medium**

  - Transfers

  - Make a new transfer on 'New Transfer' screen. Check if the transfer is displayed on main screen chat, on the main screen list and the total balance is correct.  
  Priority: **High**

  - Edit a transfer on the mais screen list. Check if the changes were saved, the chart was updated and the total balance is correct.  
  Priority: **High**

  - Delete a transfer on the main screen list. Check if transfer was removed from main screen list, if the main screen chart and total balance were updated.  
  Priority: **High**

- Filters

  - Filter by account on 'Filters' menu. Check if only the expenses and incomes of the account selected is displayed on main screen and main screen list.  
  Priority: **Medium**

  - Filter by Day/Week/Month/Year/All on 'Filters' menu. Check if only the expenses and incomes of the period selected is displayed on main screen and main screen list.  
  Priority: **Medium**

  - Choose a date to filter by. Check if only the expenses and incomes of the period selected is displayed on main screen and main screen list.  
  Priority: **Medium**

- Settings

  - Change languague on 'Settings' menu. Check if the entire app language was changed.  
  Priority: **Low**

  - Change currency on 'Settings' menu. Check if the currency selected is now default on entire app.  
  Priority: **Low**

  - Select the 'Budget Mode' option on 'Settings' menu. Check if the app is based on deduction of the value inserted on budget mode.  
  Priority: **Medium**

  - As a free user change to 'Dark theme' on settings. Check if the Monefy Pro features screen is displayed.  
  Priority: **High**

  - As a paid user change to 'Dark theme' on settings. Check if the theme of the app was changed.  
  Priority: **High**

  - Export data to file from 'Settings' menu. Check if a file was created with the data from the Monefy App.  
  Priority: **Medium**

  - As a free user, protect the Monefy App with a passcode from 'Settings' menu. Check if the Monefy Pro features screen is displayed.  
  Priority: **High**

  - As a paid user, protect the Monefy App with a passcode from 'Settings' menu. Check if the Monefy App asks for the passcode as soon as you open the App.  
  Priority: **High**

- Currency Rate

  - As a free user, on the 'New Account' screen, add a currency rate. Check if the Monefy Pro features screen is displayed.  
  Priority: **High**

  - As a paid user, on the 'New Account' screen, add a currency rate and create the new account. Make a new transfer from one accout with different currency to this new account and check if the currency rate was applied.  
  Priority: **High**

  - As a paid user, edit an account and change/delete the currency rate. Check if the changes were saved.  
  Priority: **High**

***

Priorities were divided into High, Medium and Low as follows:

    - High: features that involve calculations and definitely cannot contain errors, Pro version features that people pay to have and features that lead the user to make the purchase of the app as it is the way to monetize.

    - Medium: Features that give the application meaning and organization.

    - Low: Features that do not directly impact the operation of the application.

***
<br><br>

# GnuCash Android

## Test Cases ideas

- Accounts

   - Create a new account. Check if the new account is listed on 'Accounts' screen.  
   Priority: **Medium**

   - Edit an account. Check if the changes were saved.  
   Priority: **Medium**

   - Delete an account. Check if the account is no longer listed on 'Accounts' screen.  
   Priority: **Medium**

   - Search for accounts and sub-accounts. If no accounts/sub-accounts is found, the message 'No accounts to display' must be displayed, if the account/sub-account is found, it must be listed.  
   Priority: **Low**

- Sub-Accounts

   - Create a new sub-account. Check if the new sub-account is listed on the account list where it was created.  
   Priority: **Medium**

   - Edit an sub-account. Check if the changes were saved.  
   Priority: **Medium**

   - Delete an sub-account. Check if the sub-account is no longer listed on the account list where it was created.  
   Priority: **Medium**

- Transactions

   - Create a new transaction. Check if the new transaction is listed on the account/sub-account where it was created and if 'Double Entry' is activated, check if a second transaction was created on the account/sub-account selected for the double entry.  
   Priority: **High**

   - Edit an transaction. Check if the changes were saved in the account/sub-account it was created and if 'Double Entry' is activated, check if the changes were mande in the second transaction.  
   Priority: **High**

   - Delete an transaction. Check if the transaction is no longer listed on the account/sub-account it was created and if 'Double Entry' is activated, check if the second transaction was deleted too.  
   Priority: **High**

   - Duplicate an transaction. Check if a new identical transaction was created in the actual account/sub-account and if 'Double Entry' is activated, check if the second transaction was duplicated too.  
   Priority: **High**

   - Create an income transaction and an expense transaction. Check if the calculation was made over the two transactions made.   
   Priority: **High**

   - Create an income transaction and delete the account who haves the transaction inside. Check if account is no longer listed and if 'Double Entry' is activated, check if the value of the transaction was excluded from the 'Double Entry' account too.   
   Priority: **High**

***

Priorities were divided into High, Medium and Low as follows:

    - High: features that involve calculations.

    - Medium: Features that give the application meaning and organization.

    - Low: Features that do not directly impact the operation of the application.

***

## Possibilities of Automation

- Unit test and Integration test  
    - Pros:   
        - Cheaper to find bugs
        - Fastest test run time
        - Less maintenance is required
    - Cons:
        - Usually depends more on devs
        - Does not guarantee the front end

- e2e tests
    - Pros:
        - Ensures testing from the user's point of view
        - Tests the operation of the app as a whole
    - Cons:
        - It takes longer to run the tests
        - Usually needs more maintenance

- Device Farm
    - Pros:
        - Enables testing on a wider range of different devices and configurations
    - Cons:
        - Too expensive to implement
