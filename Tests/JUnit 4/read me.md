Defining test methods
JUnit uses annotations to mark methods as test methods and to configure them. 
The following table gives an overview of the most important annotations in JUnit for the 4.x and 5.x versions. 
All these annotations can be used on methods.

_______________________________________________________________________________________________________________________________
*******************************************************************************************************************************
TEST METHODS
*******************************************************************************************************************************
import org.junit.*

Import statement for using the following annotations.
-------------------------------------------------------------------------------------------------------------------------------
@Test

Identifies a method as a test method.
-------------------------------------------------------------------------------------------------------------------------------
@Before

Executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class).
-------------------------------------------------------------------------------------------------------------------------------
@After

Executed after each test. It is used to cleanup the test environment (e.g., delete temporary data, restore defaults).
It can also save memory by cleaning up expensive memory structures.
-------------------------------------------------------------------------------------------------------------------------------
@BeforeClass

Executed once, before the start of all tests. It is used to perform time intensive activities, for example,
to connect to a database. Methods marked with this annotation need to be defined as static to work with JUnit.
-------------------------------------------------------------------------------------------------------------------------------
@AfterClass

Executed once, after all tests have been finished. It is used to perform clean-up activities,
for example, to disconnect from a database. Methods annotated with this annotation need to be defined as static to work with JUnit.
-------------------------------------------------------------------------------------------------------------------------------
@Ignore or @Ignore("Why disabled")

Marks that the test should be disabled. This is useful when the underlying code has been changed and
the test case has not yet been adapted. Or if the execution time of this test is too long to be included.
It is best practice to provide the optional description, why the test is disabled.
-------------------------------------------------------------------------------------------------------------------------------
@Test (expected = Exception.class)

Fails if the method does not throw the named exception.
-------------------------------------------------------------------------------------------------------------------------------
@Test(timeout=100)

Fails if the method takes longer than 100 milliseconds.
_______________________________________________________________________________________________________________________________
*******************************************************************************************************************************
ASSERT STATEMENTS

JUnit provides static methods to test for certain conditions via the Assert class. These assert statements typically start with assert.
They allow you to specify the error message, the expected and the actual result. An assertion method compares the actual value returned by a test to the expected value. It throws an AssertionException if the comparison fails.
The following table gives an overview of these methods. Parameters in [] brackets are optional and of type String.
*******************************************************************************************************************************
fail([message])

Let the method fail. Might be used to check that a certain part of the code is not reached or to have a failing test before the test code is implemented. The message parameter is optional.
-------------------------------------------------------------------------------------------------------------------------------
assertTrue([message,] boolean condition)

Checks that the boolean condition is true.
-------------------------------------------------------------------------------------------------------------------------------
assertFalse([message,] boolean condition)

Checks that the boolean condition is false.
-------------------------------------------------------------------------------------------------------------------------------
assertEquals([message,] expected, actual)

Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.
-------------------------------------------------------------------------------------------------------------------------------
assertEquals([message,] expected, actual, tolerance)

Test that float or double values match. The tolerance is the number of decimals which must be the same.
-------------------------------------------------------------------------------------------------------------------------------
assertNull([message,] object)

Checks that the object is null.
-------------------------------------------------------------------------------------------------------------------------------
assertNotNull([message,] object)

Checks that the object is not null.
-------------------------------------------------------------------------------------------------------------------------------
assertSame([message,] expected, actual)

Checks that both variables refer to the same object.
-------------------------------------------------------------------------------------------------------------------------------
assertNotSame([message,] expected, actual)

Checks that both variables refer to different objects.
_______________________________________________________________________________________________________________________________
*******************************************************************************************************************************
JUnit test suites

If you have several test classes, you can combine them into a test suite. Running a test suite executes all test classes in that suite in the specified order. A test suite can also contain other test suites.
-------------------------------------------------------------------------------------------------------------------------------
*******************************************************************************************************************************
The following example code demonstrates the usage of a test suite. It contains two test classes (MyClassTest and MySecondClassTest). If you want to add another test class, you can add it to the @Suite.SuiteClasses statement.
-------------------------------------------------------------------------------------------------------------------------------
        package com.vogella.junit.first;

        import org.junit.runner.RunWith;
        import org.junit.runners.Suite;
        import org.junit.runners.Suite.SuiteClasses;

        @RunWith(Suite.class)
        @SuiteClasses({
                MyClassTest.class,
                MySecondClassTest.class })

        public class AllTests {
        
        }
_______________________________________________________________________________________________________________________________
*******************************************************************************************************************************
 Disabling tests
*******************************************************************************************************************************
The @Ignore annotation allow to statically ignore a test. Alternatively you can use Assume.assumeFalse or Assume.assumeTrue to define a condition for the test. Assume.assumeFalse marks the test as invalid, if its condition evaluates to true. Assume.assumeTrue evaluates the test as invalid if its condition evaluates to false. For example, the following disables a test on Linux:
-------------------------------------------------------------------------------------------------------------------------------
Assume.assumeFalse(System.getProperty("os.name").contains("Linux"));
_______________________________________________________________________________________________________________________________
*******************************************************************************************************************************
 Parameterized test
*******************************************************************************************************************************
JUnit allows you to use parameters in a tests class. This class can contain one test method and this method is executed with the different parameters provided.
-------------------------------------------------------------------------------------------------------------------------------
You mark a test class as a parameterized test with the @RunWith(Parameterized.class) annotation.

Such a test class must contain a static method annotated with the @Parameters annotation. That method generates and returns a collection of arrays. Each item in this collection is used as parameter for the test method.
-------------------------------------------------------------------------------------------------------------------------------
You can use the @Parameter annotation on public fields to get the test values injected in the test.
-------------------------------------------------------------------------------------------------------------------------------
The following code shows an example for a parameterized test. It tests the multiply() method of the MyClass class which is included as inner class for the purpose of this example.
-------------------------------------------------------------------------------------------------------------------------------
        package testing;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;
        import org.junit.runners.Parameterized.Parameters;

        import java.util.Arrays;
        import java.util.Collection;

        import static org.junit.Assert.assertEquals;
        import static org.junit.runners.Parameterized.*;

        @RunWith(Parameterized.class)
        public class ParameterizedTestFields {

        // fields used together with @Parameter must be public
        @Parameter(0)
        public int m1;
        @Parameter(1)
        public int m2;
        @Parameter(2)
        public int result;


        // creates the test data
        @Parameters
        public static Collection<Object[]> data() {
                Object[][] data = new Object[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
                return Arrays.asList(data);
        }


        @Test
        public void testMultiplyException() {
                MyClass tester = new MyClass();
                assertEquals("Result", result, tester.multiply(m1, m2));
        }


        // class to be tested
        class MyClass {
                public int multiply(int i, int j) {
                return i *j;
                }
        }

        }
Alternatively to using the @Parameter annotation you can use a constructor in which you store the values for each test. The number of elements in each array provided by the method annotated with @Parameters must correspond to the number of parameters in the constructor of the class. The class is created for each parameter and the test values are passed via the constructor to the class.
-------------------------------------------------------------------------------------------------------------------------------
        package de.vogella.junit.first;

        import static org.junit.Assert.assertEquals;

        import java.util.Arrays;
        import java.util.Collection;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;
        import org.junit.runners.Parameterized.Parameters;

        @RunWith(Parameterized.class)
        public class ParameterizedTestUsingConstructor {

        private int m1;
        private int m2;

        public ParameterizedTestUsingConstructor(int p1, int p2) {
                m1 = p1;
                m2 = p2;
        }

        // creates the test data
        @Parameters
        public static Collection<Object[]> data() {
                Object[][] data = new Object[][] { { 1 , 2 }, { 5, 3 }, { 121, 4 } };
                return Arrays.asList(data);
        }


        @Test
        public void testMultiplyException() {
                MyClass tester = new MyClass();
                assertEquals("Result", m1 * m2, tester.multiply(m1, m2));
        }


        // class to be tested
        class MyClass {
                public int multiply(int i, int j) {
                return i *j;
                }
        }

        }
If you run this test class, the test method is executed with each defined parameter. In the above example the test method is executed three times.
-------------------------------------------------------------------------------------------------------------------------------
A more flexible and easier to write approach is provided by the JUnitParams from https://github.com/Pragmatists/JUnitParams.
_______________________________________________________________________________________________________________________________
*******************************************************************************************************************************
JUnit Rules
*******************************************************************************************************************************
Via JUnit rules you can add behavior to each tests in a test class. You can annotate fields of type TestRule with the @Rule annotation. You can create objects which can be used and configured in your test methods. This adds more flexibility to your tests. You could, for example, specify which exception message you expect during the execution of your test code.
-------------------------------------------------------------------------------------------------------------------------------
        package de.vogella.junit.first;

        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.ExpectedException;

        public class RuleExceptionTesterExample {

        @Rule
        public ExpectedException exception = ExpectedException.none();

        @Test
        public void throwsIllegalArgumentExceptionIfIconIsNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negative value not allowed");
        ClassToBeTested t = new ClassToBeTested();
        t.methodToBeTest(-1);
        }
        }
JUnit already provides several useful rule implementations. For example, the TemporaryFolder class allows to setup files and folders which are automatically removed after each test run.

The following code shows an example for the usage of the TemporaryFolder implementation.

        package de.vogella.junit.first;

        import static org.junit.Assert.assertTrue;

        import java.io.File;
        import java.io.IOException;

        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.TemporaryFolder;

        public class RuleTester {

        @Rule
        public TemporaryFolder folder = new TemporaryFolder();

        @Test
        public void testUsingTempFolder() throws IOException {
        File createdFolder = folder.newFolder("newfolder");
        File createdFile = folder.newFile("myfilefile.txt");
        assertTrue(createdFile.exists());
        }
        }

For more examples of existing rules see https://github.com/junit-team/junit4/wiki/Rules.
_______________________________________________________________________________________________________________________________
*******************************************************************************************************************************
Writing custom JUnit rules
*******************************************************************************************************************************
To write your custom rule, you need to implement the TestRule interface. This interface defines the apply(Statement, Description) method which must return an instance of Statement. Statement represent the tests within the JUnit runtime and Statement#evaluate() run these. Description describes the individual test. It allows to read information about the test via reflection.
-------------------------------------------------------------------------------------------------------------------------------
The following is a simple example for adding a log statement to an Android application before and after test execution.
-------------------------------------------------------------------------------------------------------------------------------
package testing.android.vogella.com.asynctask;


    import android.util.Log;

    import org.junit.rules.TestRule;
    import org.junit.runner.Description;
    import org.junit.runners.model.Statement;

    public class MyCustomRule implements TestRule {
    private Statement base;
    private Description description;

    @Override
    public Statement apply(Statement base, Description description) {
        this.base = base;
        this.description = description;
        return new MyStatement(base);
    }

    public class MyStatement extends Statement {
        private final Statement base;

        public MyStatement(Statement base) {
            this.base = base;
        }

        @Override
        public void evaluate() throws Throwable {
            System.
            Log.w("MyCustomRule",description.getMethodName() + "Started" );
            try {
                base.evaluate();
            } finally {
                Log.w("MyCustomRule",description.getMethodName() + "Finished");
            }
        }
    }
}

To use this rule, simple add a field annotated with @Rule to your test class.
-------------------------------------------------------------------------------------------------------------------------------
@Rule
public MyCustomRule myRule = new MyCustomRule();
_______________________________________________________________________________________________________________________________
*******************************************************************************************************************************
Categories
*******************************************************************************************************************************
It is possible to define categories of tests and include or exclude them based on annotations. The following example is based on the JUnit 4.8 release notes.
-------------------------------------------------------------------------------------------------------------------------------
        public interface FastTests { /* category marker */
        }

        public interface SlowTests { /* category marker */
        }

        public class A {
        @Test
        public void a() {
                fail();
        }

        @Category(SlowTests.class)
            @Test
        public void b() {
        }
        }

        @Category({ SlowTests.class, FastTests.class })
        public class B {
        @Test
        public void c() {
        }
        }

        @RunWith(Categories.class)
        @IncludeCategory(SlowTests.class)
        @SuiteClasses({ A.class, B.class })
        // Note that Categories is a kind of Suite
        public class SlowTestSuite {
        // Will run A.b and B.c, but not A.a
        }

        @RunWith(Categories.class)
        @IncludeCategory(SlowTests.class)
        @ExcludeCategory(FastTests.class)
        @SuiteClasses({ A.class, B.class })
        // Note that Categories is a kind of Suite
        public class SlowTestSuite {
        // Will run A.b, but not A.a or B.c
        }
_______________________________________________________________________________________________________________________________
