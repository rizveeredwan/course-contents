package example;

class A{
  public void sum(int a, int b) {
  	System.out.println("sum " + (a + b));
    System.out.println("sum " + a + b);
  }
}

class B extends A{
  public void mul(int a, int b) {
    int v = a * b;
    System.out.println("sum " + (a * b));
  	//System.out.println("sum " + a * b);
  }
}

public class FirstProgram {
    public static void main (String [] args) {
        System.out.println("Here First Program");
    	SecondProgram obj = new SecondProgram();
        A a = new A();
        a.mul(25, 6);
        B b = new B();
        b.sum(10, 3);
        b.mul(10, 3);
    }
}