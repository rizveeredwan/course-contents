// Exception 
// multiple exception, chain and order of exception
// 

class MyException extends Exception{
    String des;
    MyException(String s) {
        des = s; 
    }
    public String toString(){
        System.out.println("Exception nomal print  " + des);
        return "Exception here  " + des; 
    }
}

class ExceptionHandling{
    static void createError(int a, int b){
        try{
            int c = a/b;
            System.out.println("c " + c);
            //throw new ArithmeticException("Created my exception"); 
            throw new MyException("Created my exception object"); 
        }
        
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception captured " );
            e.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out of Bound Exception " );
            e.printStackTrace();
        }
        catch(NullPointerException e){
            System.out.println("Null Pointer Exception " );
            e.printStackTrace();
        }
        catch(RuntimeException e){
            System.out.println("Runtime Exception " );
            e.printStackTrace();
        }
        catch (MyException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("Finally executed"); 
        }
    }
}

public class Solution{
    public static void main (String [] args){
        System.out.println("print"); 
        ExceptionHandling.createError(20, 10);
    }
}