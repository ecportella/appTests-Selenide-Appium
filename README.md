# eugenio-portella
Home Challenge

Hello, this is the project for the test automation of the N26 Home Challenge.
It was written in __Java__ and the technologies used was __Maven__, __Appium__, __Selenide__ (Selenium wrapper), __TestNG__, and __ExtentReport__.

- With __Maven__ we control dependencies and we can run the project from the terminal.
- __Appium__ is the responsible for the communication with the Mobile Emulator.
- __Selenide__ is a wrapper of the Selenium WebDriver and was used in this project to automate the app.
- __TestNG__ was used to organize the project with annotations.
- Lastly, __ExtentReport__ is used to create a report from the tests runned.

Shall we prepare our machine to run those scripts?

### 1. Preparing

- In order to run the scripts, we need to install on our machines the __Java JDK__, __Android SDK__, __Appium Server__ and __Maven__ technologies.
- Make sure to install the latest version of each technology.
- After you do install, make sure you can use those technologies from wherever you are, adding then to your local path variable.
- You'll need to have __Android Emulator__ and __ADB services__ ready to use. You can achieve this easily just installing __Android Studio__ and creating your device in the __AVD Manager__ menu inside __Android Studio__. I had a little of trouble setting up an AVD device in API 29, so just to make sure it works, select API 28.

### 2. Project Architecture

- The project is splitted in 3 folders inside the src file of the project.
- In the __functions__ folder we have the __base test__ that represents the test set up, configurations and report creation.
- In the __screenObjects__ we have mapped all the elements that we want to control over the app.
- The __tests__ folder is where we find our tests itself.
- Lastly, in the root of the automated project, we have a file called __tests.xml__ who tells maven which tests to run.

### 3. Running the scripts

- Firstly, start your AVD device.
- Now you should start Appium server in the default ip:port which is 0.0.0.0:4723.
- In order to run the scripts, we need to open our terminal in the root folder of the Automation Project where we can find the file __pom.xml__. This file is the one who tells maven what to do.
- Now, all we need to do is run the following line from the terminal: `mvn test`
- If it's the first time you're running the scripts, the app will be installed in the Mobile Emulator. Since there is a First Run Wizzard in this app, you should go through this manually and the scripts will certainly fail. The second time we run the Automated Tests the magic will happen.

### 4. Test Report

- After our test run, we can see that a new file was created on the reports folder in the root of the automated project. Open that html file and see the entire logged run.
- If the test fail, we can se what happened, what exception we got and we can see a ScreenShot from the moment of the fail. Nice, ins't?

<br>
What do you think of this project?
Please let me know your thoughts.
Thank you.
