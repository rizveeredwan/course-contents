// overloading, overriding, object reference mapping
// runtime and compile time polymorphism
// Abstract class: object creation, factory design pattern, design analogy
// Final class 
// chain of abstraction 

class Inheritance{
    void A(){ // name, type signature
        System.out.println("calling parent's A method");
    }
    void A(int a){

    }
    void A(int a, int b){

    }
}

class Child extends Inheritance{
    int x; 
    void A(){
        System.out.println("calling child's A method");
    }
    void A(int a, int b, int arr[]){

    }
}

abstract class MainCar{
    int x;
    abstract void speedUp(double x); 
    /*abstract void absFunc(double x){
        // ERROR
        // DEFINITION OF THE METHOD
    }*/
    void m(){
        System.out.println("I am abstract class");
    }
    final void finalMethod(){
        System.out.println("A Final Metod can not be ovrrriden");
    }
}

class Toyota extends MainCar{
    void speedUp(double x) {
       System.out.println("Toyota" + x); 
    }
    /*void finalMethod(){
        System.out.println("A Final Metod modification in child class");
    }*/
}

class Ford extends MainCar{
    void speedUp(double x) {
        System.out.println("Ford " + x); 
     }
}

class Factory{
    MainCar construct(String s){
        MainCar m = null; 
        if(s.equals("ford")){
            m = new Ford();
        }
        if(s.equals("toyota")){
            m = new Toyota();
        }
        return m; 
    }
}


abstract class Level1{
    abstract void l1(); 
}

abstract class Level2 extends Level1{
    abstract void l2(); 
}

abstract class Level3 extends Level2{
    abstract void l3(); 
}

class Implement extends Level3{
    void l1(){

    }
    void l2(){
        
    }
    void l3(){
        
    }
}




public class Solution{
    static void playGame(MainCar mc, int maxSpeed){
            mc.speedUp(maxSpeed); // Ford, Toyota
    }
    public static void main (String [] args){
        
        /*Child c = new Child();
        Inheritance inh = new Inheritance();
        //Inheritance inh;
        //inh = c;
        inh.A(); 
        inh.A(10);
        inh.A(10, 20); */

        /*Toyota a = new Toyota();
        Ford b = new Ford();
        //MainCar nab;*/

        Factory f = new Factory();
        MainCar a = f.construct("ford");
        MainCar b = f.construct("toyota");



        Solution.playGame(a, 100);
        Solution.playGame(b, 120);


    }
}