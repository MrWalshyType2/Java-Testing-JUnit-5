# Testing Java Code with JUnit 5 (JUnit Jupiter)

1. Clone this repo
2. Complete the empty test files
3. Run your tests and verify they run correctly

## Commands
`git clone` to clone a project from GitHub

`mvn clean` to clean your project, removes all files from the **target** folder

`mvn clean package` cleans the project, then packages the application as a jar file

`mvn test` will run your tests

`mvn clean test` will clean the project, then run your tests

`java -jar ims-0.0.1-SNAPSHOT.jar`
`java -jar ims-0.0.1-SNAPSHOT-jar-with-dependencies.jar`

## JUnit 5 Annotations
`@Test` will denote a method as a Test method

`@DisplayName("custom test name")` will set a custom name for your test

`@BeforeEach` will signal that the annotated method should be executed before each test method

`@AfterEach` will cause the annotated method to execute after each test method

`@BeforeAll` will cause the annotated method to run before all methods only once, this is usually for initialisation.

`@AfterAll` will run the annotated method after everything else, typically used to clean up/close any values in the class.

`@Disabled` when used at the class level (above the class name) will disable the class for testing, at the method level it will disable the test

## JUnit 5 Methods
`assertTrue(boolean)` - Tests if the passed in condition is true

`assertEquals(expected, actual)` - Tests if the expected value matches the actual value

`assertThrows(throwable_exception, code_to_test)` - Tests if the exception was actually thrown

### Standard Assertions
```
@Test
void calculatorAddTest() {
	//          (expected, actual)
	assertEquals(2, calculator.add(1, 1));
	assertTrue(3 > 2); // true
}
```

### Grouped Assertions
```
@Test
void assertPersonTest() {
	// All assertions inside a group are executed
	assertAll("Person Tests",
		() -> assertEquals("Fred", person.getForename()),
		() -> assertEquals("Bob", person.getSurname())
	);
}
```

### Testing for Exceptions
```
@Test
void testForNullPointerException() {
	assertThrows(NullPointerException.class, () -> {
		getItem(454)
	};
}
```
