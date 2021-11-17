## Unit Testing with JUnit5

- Create small tests (Unit) - Validate smallest units of Class - 1 thing only per test
- Given-When-Then (Good pattern for designing a good unit test)
> Given - Initialize class to test with specific data to test condition.
>
> When - Add the valid test data and execute action
>
> Then - Assert the expected outcome
 
- Use <code>Assertions (org.junit.jupiter.api.*)</code> to Test (Pass/Fail)
- Use Assumptions (org.junit.jupiter.api.*) to Run or Abort a Test
#### Make test method executable
- Use @Test annotation 
#### Create readable Test reports
- Use @DisplayName annotation 
#### Control order of execution of methods
- Use @TestMethodOrder(MethodOrderer.OrderAnnotation.class) and @Order
#### Creating and executing Nested classes to control flow
- Use @Nested annotation to execute nested classes.
#### To do Dependency Injection for common objects
- Inherit/implement ParameterResolver then use @ExtendWith annotation to inject classes into Tests
#### To Repeat a test multiple times
-Use @RepeatedTest annotation to repeat a test eg testing endpoint performance or need to use different parameters by combining with ParameterResolver
#### To extract Repetition information use RepetitionInfo Object
- Use @ParameterizedTest annotation to parameterized data to the test.
- Use @ValueSource to pass specific values eg ints
- Use @EnumSource to pass some enumeration data source
- Use @CsvSource to pass comma separated data
- Use @CsvFileSource to pass data from an external file
#### Control or Specify duration for a test using timeouts
- Use @Timeout annotation to specify max execution time for a test either at class level or method level
- Use assertTimeout for more precise control.
#### Running multiple tests in Parallel
- Create config file with the following properties

```junit.jupiter.execution.parallel.enabled = true```
```junit.jupiter.execution.parallel.config.strategy = dynamic```
#### Annotate Class with
- @Execution(ExecutionMode.CONCURRENT)
- @ExtendWith(Resolver.class)
#### To produce reports add below plugins to pom and run 
- $ mvn surefire-report:report
```xml
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.2</version>
    </plugin>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-failsafe-plugin</artifactId>
        <version>2.22.2</version>
    </plugin>
</plugins>
```
### Other types of Tests
- System Testing
- Integration Testing
- Acceptance Testing
- Performance Testing
- Regression Testing
- Security Testing
- Load Testing
- End-To-End Testing
