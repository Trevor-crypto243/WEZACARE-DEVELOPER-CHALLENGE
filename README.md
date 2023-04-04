<h1>WEZACARE DEVELOPER CHALLENGE: ANDROID DEVELOPER INTERNSHIP</h1>

<h2>Description</h2>
This is an android application built with kotlin using the harry potter public api. The application gets the json data from the API and renders them in a recyclerview. If a recycler view item is clicked, another activity is opened that displays the full deatils of a single entry. The app seeks to show network request, API usage, good code quality, functional tests and understanding of kotlin own code.


<h2>Programming Language</h2>
Kotlin has been used as the programming language for this application due to its efficiency, versatility, and widespread use in software development. The performance benefits of kotlin  make it a suitable choice for this type of application. In addition, kotlin is widely used and has a large user community, providing a wealth of resources for development and troubleshooting. The object-oriented programming features of kotlin also make it easy to maintain and extend the codebase in the future.

<h2>Running the application</h2>
Download and install the application from the link below
https://drive.google.com/file/d/1cbo9W-9Z5vVa9OZJkYwQ_bSxUwSMAF5y/view?usp=sharing


<h2>Testing the API</h2>
This section provides information on how to run the unit test for `getCharacters()` method in `CharacterApiService` class, 
located in package `com.example.wezacare_developer_challenge.network_data` package.

<h3>API testing</h3>
To run this test, you need to have:

Android Studio or any other IDE that supports Kotlin and Android development
An Android emulator or device running Android API level 28 or higher

<h3>How to run the test</h3>
To run the test, follow these steps:

1. Open the project in Android Studio or your preferred IDE.
2. Build and sync the project to ensure that all dependencies are downloaded.
3. Open the `CharacterApiServiceTest` class located in the `src/test/java/com/example/wezacare_developer_challenge/viewmodels` directory. 
   under the tests folder in the `API_testing.kt` class
4. Right-click on the test `getCharacters()` method and select `Run 'test getCharacters()'`.
5. Expected result
   The test should pass successfully.
   The output should show the number of characters returned from the getCharacters method. which is `402` in number

<h3>Available UI Tests</h3>
The following tests are available in the ExampleInstrumentedTest class:
1. `actionBarTitleIsDisplayed()` - This test checks whether the action bar is displayed correctly.
2. `statusTextIsDisplayedCorrectly()` - This test checks whether the network state text is displayed correctly.
3. `recyclerViewIsDisplayed()` - This test checks whether the RecyclerView is displayed correctly.

<h3>How to run the tests</h3>
To run the tests, follow these steps:

1. Open the project in Android Studio or your preferred IDE.
2. Build and sync the project to ensure that all dependencies are downloaded.
3. Open the `ExampleInstrumentedTest` class located in the `src/androidTest/java/com/example/wezacare_developer_challenge directory`.
4. Right-click on the test method you want to run and select `Run 'test <method-name>'`.
5. Ensure you are connected to an android emulator or a physical android device
6. Expected result:
The test should pass successfully, and the output should show the expected result.

<h3>Troubleshooting</h3>
If the test fails, please check your internet connection and ensure that the server is up and running. You can also try to increase the timeout value for the test. If you are still facing issues, please contact the developer for further assistance.

      


