package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestCaseOne {
  @Test
  public void f() {
	  System.out.println("one");
  }
  @Test
  public void title() {
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("two");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("three");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("four");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("five");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("six");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("seven");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("eight");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("nine");
  }

}
