class Parent {

  public Parent () {
    doSomething();  // Noncompliant
  }

  public void doSomething () {  // not final; can be overridden
    System.out.println("doSomething Called Parent");
  }
}

public class Child  {

  private String foo;

  public Child(){}

  public Child(String foo) {
    super(); // leads to call doSomething() in Parent constructor which triggers a NullPointerException as foo has not yet been initialized
    this.foo = foo;
  }

  public void doSomething () {
    System.out.println("doSomething Called Child");
    System.out.println(this.foo.length());
  }
  public static void main(String[] args) {
	display(true);
	 System.out.println("formatted=="+String.format("%s..%s", "aa", "bb"));
  }

  public static boolean display(boolean flag) {
	  System.out.println("In display");
	  display1(true);
	  System.out.println("After display1 call");
	  return false;
  }

  public static boolean display1(boolean flag) {
	  System.out.println("In display1");
	  return true;
  }
}