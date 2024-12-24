// accessing a public class from different package on different access modifier
package p2;
import p1.Parent; 

class C extends p1.Parent{
    void newmc(){
        mC(); // protected 
    }
}

public class B{
    public static void main (String [] args){
        p1.Parent temp = new p1.Parent();
        temp.mA(); // public 

        //temp.mB(); // default
        //temp.mC(); // protected
        C c = new C();
        c.newmc();
    }
}