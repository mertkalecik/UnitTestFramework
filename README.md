# UnitTestFramework
Unit tests are a critical part of the software development process. They are automated tests that are designed to check the functionality of small, isolated pieces of code, known as units. The primary goal of unit testing is to ensure that each unit of code performs as expected, independently of other units. This allows developers to catch and fix issues early in the development process, reducing the likelihood of bugs and errors further down the line. Unit tests also make it easier to refactor code by providing a safety net that ensures that changes to one unit do not inadvertently affect other units. Overall, unit testing is an essential practice for any software development team looking to build reliable, maintainable code.

This UnitTestFramework using Kotlin that allows for accessing private fields and methods without using @VisibleForTesting Annotation. One of the primary advantages of this framework is that it enables developers to access private fields and methods without needing to modify the original code under the source code folder. The framework works by using reflection to access the private field/methods and modifying its accessibility, allowing the value to be retrieved or modified. While there are some potential security risks associated with accessing private fields, this framework can be a valuable tool for developers looking to streamline their development process and improve their code's functionality.

## Tech Stack
* Coroutine
* Kotlin
* Reflection
* JUnit

## @VisibleForTesting & Drawbacks of the usage
Denotes that the class, method or field has its visibility relaxed, so that it is more widely visible than otherwise necessary to make code testable. You can optionally specify what the visibility should have been if not for testing; this allows tools to catch unintended access from within production code.

<img width="546" alt="Screenshot 2023-04-20 at 00 34 21" src="https://user-images.githubusercontent.com/38656031/233205257-fd9cf473-abfa-4385-ad71-8fd6f58cf6fc.png">

There are several potential drawbacks to using the @VisibleForTesting annotation in Kotlin. Here are a few:

* **Security:** The @VisibleForTesting annotation allows tests to access private class members, which would normally not be used outside the class. This can create potential security vulnerabilities if a private member is accidentally used by code outside of the tests, which could affect the proper functioning of the application or even compromise its security.

* **Code complexity:** The @VisibleForTesting annotation grants access to a private member that would not normally be used by application code, which can make the code harder to understand and maintain. Depending on how much the private member is used in tests, this can add an extra layer of complexity to the code.

* **Collaboration:** The @VisibleForTesting annotation implies that private members of a class are accessible anywhere in the code, rather than just in test scenarios. This can make communication and collaboration between different teams or even different developers within the same team more difficult.

For these reasons, the @VisibleForTesting annotation should be used carefully, and unnecessary access permissions should be avoided in application code.

## UnitTestFramework Usage
**Get & Update a private field inside the System Under Test**

<img width="343" alt="Screenshot 2023-04-20 at 00 51 15" src="https://user-images.githubusercontent.com/38656031/233207983-0163973e-9786-4386-98d0-94d6174d9d29.png">

<img width="732" alt="Screenshot 2023-04-20 at 00 49 22" src="https://user-images.githubusercontent.com/38656031/233207715-5354b189-68b9-4f1f-83b7-bc642d642ce7.png">

## Usage:

<img width="664" alt="Screenshot 2023-04-20 at 00 52 11" src="https://user-images.githubusercontent.com/38656031/233208144-82a96f72-2aab-4228-903b-9e342677b7b3.png">

## Result:

<img width="1716" alt="Screenshot 2023-04-20 at 00 55 39" src="https://user-images.githubusercontent.com/38656031/233208676-c0cebc8f-a22a-41e1-93ef-2350ae627dd8.png">

## Version History

* v1.0.0
  * Initial Release

## Add it in your root build.gradle

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
