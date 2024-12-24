// Scanner class 
// Working with scanner: next int, next, nextline
// nested interaface & access modification
// default function 
// - 1) when a class inmplements an interface that has a default method (can access)
// - 2) Override possible for the default functions 
// - 3) resolving same named functions residing in different interfaces 
// static function in interface + access, can not modifiy static attributes anywhere (by normal definition of interface attributes)
// static & private attributes are inherent to an interface, can not access it from outside. 
//  -- this is different from static access within a normal class based inheritance
import java.util.Scanner;

interface Outer{ // public / Default 
    void demoF(); 
}

interface Outer2 extends Outer{

}

class Base{
    interface Inner{ // public (Ok), private (NO), protected (Ok), default (Ok)
        void display();
    }
}

interface DefInfA{
    default void f() {
        System.out.println("Def Function A"); 
    }
    void display(); // not implemented 
    void displayA();
}

interface DefInfB{
    default void f() {
        System.out.println("Def Function B"); 
    }
    void display();// not implemented 
    void displayB();
}

class ImpDef implements DefInfA, DefInfB{
    public void displayA(){
        System.out.println("Imp DisplayA at ImpDef");
    }
    public void displayB(){
        System.out.println("Imp DisplayB at ImpDef");
    }

    public void f(){ // override 
        System.out.println("F function overriden"); 
    }

    public void display(){
        System.out.println("Imp Display at ImpDef");
    }
    
}


class B implements Base.Inner{
    public void display(){

    }
}


interface ShowStatic{ // static method 
    static int x = 10; 
    static void staticFunc(){
        System.out.println("static function"); 
    }
    static void staticFunc2(){
        ShowStatic.staticFunc();
    }
}


class ImpStaticInf implements ShowStatic{
    /*public void staticFunc(){
        x = 30; 
        System.out.println("static function overriden"); 
    }*/
}

class TempA{
    static void mA(){

    }
}

class TempB extends TempA{
}


public class Solution{
    public static void main (String [] args) {
        /*Scanner sc = new Scanner(System.in);
        //int v = sc.next(); // integer input
        //sc.next().charAt(0);
        String name = sc.next();
        String name2 = sc.nextLine();
        System.out.println("PRINT " + name2); */
        ImpDef imp = new ImpDef();
        imp.display(); // normal undefined function access 
        // can we access f() [which]
        imp.f(); 

        // accessing a static method 
        ShowStatic.staticFunc(); 
        ImpStaticInf stInfo = new ImpStaticInf();
        //stInfo.staticFunc();

        TempB b = new TempB();
        b.mA();

    }
}