// Multiple values returning & Reference sharing across variables 
// Recursion
// operator precedence
// Access Modifier: public, private, protected, default 
// understanding static [global variable context, without object reference, static context access]
// understanding final

class Calculator{
    int x,y,z;
    Calculator(int a, int b){
        x = a;
        y = b; 
    }
    void sum(){
        z = x + y;
    }
}
class Experiment{
    Experiment(){}

    Calculator accessFunc(int a, int b){
        Calculator c = new Calculator(a, b);
        c.sum();
        return c; 
    }

    Calculator recursion(Calculator C, int n){
        // base case
        if (n==10) return C; 

        // local logical portion
        C.z = C.x + C.y;
        System.out.println("Current level: " + C.x + " " + C.y + " " + C.z);
        C.x = C.y; 
        C.y = C.z;

        // recursion calling 
        C = recursion(C,n+1); 
        return C; 
    }
}

class AccessModifier{
    int x;
    public int y;
    private int z; 
    AccessModifier(){
        x = 10;
        y = 20;
        z = 30; 
    }
    int getZ(){
        return z; 
    }
}

class LearnStatic{
    static int z;
    //int z;
    LearnStatic(){
        z = 25; 
    }
    static void aa(){}
    void ab(){}
    static void showZ(){
        z = 40;
        System.out.println("z = " + z); 
    }
}

class LearnFinal{
    final int XYZ=10; 
}

public class Solution{
    public static void main (String [] args) {
        Experiment e = new Experiment();
        /*Calculator nC = e.accessFunc(10, 20);
        Calculator nC1 = nC; 

        System.out.println("BEFORE CHANGE: " + nC.z + " " + nC.y + " " + nC.x);
        System.out.println("BEFORE CHANGE: " + nC1.z + " " + nC1.y + " " + nC1.x);
        
        nC.x = 35;
        nC1. y = 40;
        //nC.sum();

        System.out.println("AFTER CHANGE: " + nC.z + " " + nC.y + " " + nC.x);
        System.out.println("AFTER CHANGE: " + nC1.z + " " + nC1.y + " " + nC1.x);
        
        Calculator nC2 = e.accessFunc(10, 20);
        System.out.println("Calc Attr: " + nC.z); */
        
        /*Calculator fib = e.accessFunc(0, 1);
        Calculator nFib = e.recursion(fib, 2);
        System.out.println("Fib " + fib.x + " " + fib.y + " "  + fib.z);
        System.out.println(fib.x + fib.y + fib.z);
        System.out.println("nFib " + nFib.x + " " + nFib.y + " "  + nFib.z);*/
        
        /*AccessModifier ac = new AccessModifier();
        System.out.println("X " + ac.x);
        System.out.println("Y " + ac.y);
        //System.out.println("Z " + ac.z);// will not be accessible 
        System.out.println("Z " + ac.getZ());// will not be accessible */

        //LearnStatic ls = new LearnStatic();
        //ls.showZ(); 

        LearnStatic.showZ(); 

        LearnStatic ls1 = new LearnStatic();
        ls1.z = 35; 

        LearnStatic ls2 = new LearnStatic();
        ls2.z = 45; 

        System.out.println(ls1.z + " " + ls2.z);


    }
}