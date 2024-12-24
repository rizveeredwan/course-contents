// interface basic [define]
// implementations [public method & access]
// abstract + inheritance

package p1;

// public 
interface InnerA {
    int attrA=10; // final/static non changable
    void fA(); 
}
// public 
interface InnerB {
    int attrB=20; // final/static non changable
    void fB(); 
}

class ImpOne implements InnerA, InnerB{
    public void fA(){ // forced to be public 
        System.out.println("Implemented fA method()");
    }
    public void fB(){ // forced to be public 
        System.out.println("Implemented fB method()");
    }
}

abstract class Fuzzy implements InnerA, InnerB {
    abstract void fuzzy();
}

class FuzzyImp extends Fuzzy{
    void fuzzy(){
        System.out.println("Implemented Fuzzy");
    }
}

class ImpTwo implements InnerA, InnerB{
    public void fA(){ // forced to be public 
        System.out.println("Implemented fA method() V2");
    }
    public void fB(){ // forced to be public 
        System.out.println("Implemented fB method() V2");
    }
}


public class A{
    public static void main (String [] args){
        InnerA inA;
        InnerB inB; 
        inA = new ImpOne();
        inA.fA();

        inB = new ImpTwo();
        inB.fB();
    }
}