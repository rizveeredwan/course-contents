// nested exception 
// chain of caused exceptions: initcause and getcause 
// throws from method exception

class MyException0 extends Exception{
    String des; 
    MyException0(String s){
        des = s; 
    }
    public String toString(){
        return "Occurred Exception: " + des; 
    }
}

class MyException1 extends Exception{
    String des; 
    MyException1(String s){
        des = s; 
    }
    public String toString(){
        return "Occurred Exception: " + des; 
    }
}

class MyException2 extends Exception{
    String des; 
    MyException2(String s){
        des = s; 
    }
    public String toString(){
        return "Occurred Exception: " + des; 
    }
}

class Base{
    void insiderException(){
        try {
            MyException1 mex1 = new MyException1("My Exception 1"); 
            MyException2 mex2 = new MyException2("My Exception 2");
            mex1.initCause(mex2);
            throw mex1; 
            //throw mex2; 
        }
        catch (Exception e){
            System.out.println(e.getCause());
            e.printStackTrace(); 
        }

    }
    void chain(){
        try{
            MyException2 mex2 = new MyException2("My Exception 2");
            throw mex2; 
        }
        catch(MyException2 e){
            MyException1 mex1 = new MyException1("My Exception 1"); 
            mex1.initCause(e);
            try {
                throw mex1; 
            }
            catch(MyException1 e1){
               MyException0 mex0 = new MyException0("My Exception 0"); 
               mex0.initCause(e1);
               try {
                 throw mex0;
               }
               catch(Exception e2){
                e2.printStackTrace();
               }
            }
        }
    }
    void methodException() throws MyException1, ArithmeticException{
        System.out.println("BLAH BLAH");
        int v  = 2/0; 
        throw new MyException1("My Exception 1");
    }
}

class BaseTwo{
    void insiderException(){
        try {
            MyException1 mex1 = new MyException1("My Exception 1"); 
            MyException2 mex2 = new MyException2("My Exception 2");
            mex1.initCause(mex2);
            throw mex1; 
            //throw mex2; 
        }
        catch (Exception e){
            System.out.println(e.getCause());
            e.printStackTrace(); 
        }
    }
}

public class Solution{
    public static void main (String [] args){
        Base b = new Base();
        //b.insiderException(); 
        b.chain();
        try{
            b.methodException(); 
        }
        catch(ArithmeticException e){

        }
        catch(MyException1 e){

        }
        catch(Exception e){

        }
    }
}