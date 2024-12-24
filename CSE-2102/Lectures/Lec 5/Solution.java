// Nested class
// inheritance: super class, sub class 
// chain of constructors 

class Outer{ // Outer class 
    int a;
    Inner in;
    void useInner(){
        in = new Inner(37);
    }
    class Inner{ // Inner class 
        int b; 
        Inner(int v){
            b = v; 
        }
        void sumPrint(int x){
            a = x; 
            int sum = a + b; 
            System.out.println("Sum " + sum); 
            return; 
        }

        void testCase(){
            for(int i=1; i<=10; i++){
                // for each field you are testing the values 
                class Bug1{

                }
            }
        }
    }
}

// inheritance
class Par { // super/parent
    int a;
    private int x; 
    Par(){
        System.out.println("Par constructor 1");
    }
    Par(int a){
        System.out.println("Par constructor 2");
    }
    void aMethod(){
        System.out.println("in Par Class"); 
    };
}


class Child1 extends Par{ // child/subclass 
    int b;
    Child1(int temp){
        super();
        b = temp; 
        System.out.println("Child Constructor");
    }
    void aMethod(){
        System.out.println("in Child Class [Mod func 1]"); 
    };
    void aMethod(int AAA){
        System.out.println("in Child Class [Mod func 2]"); 
    };
    void bMethod(int temp){
        super.a = temp; 
        a = temp; 
        //x = temp;
        System.out.println("in Child Class" + a + " " + b); 
    }
}

public class Solution{
    public static void main (String [] args){
            /*Outer o = new Outer(); 
            o.useInner(); 
            o.in.sumPrint(45);*/
            Child1 ch1 = new Child1(20);
            ch1.bMethod(10);
            ch1.aMethod(23);

            Par p = ch1; 
            p.aMethod();

    }
} 