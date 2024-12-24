class CustomThread implements Runnable{
    Thread t;
    CustomThread(String s){
        t  = new Thread(this, s);
    }
    public void run(){
        System.out.println("Custom Thread Started");
        for(int i=0; i<50; i++){
            System.out.println(" thread now " + t + " " + i);
            try {
                Thread.sleep(1); // msecond
            }
            catch(Exception e){
                e.printStackTrace();
            }
            //Thread.sleep(5);
        }
    }
}

public class Solution{
    public static void main (String [] args){
        CustomThread ctA = new CustomThread("Thread A");
        ctA.t.start();
        CustomThread ctB = new CustomThread("Thread B");
        ctB.t.start();
        CustomThread ctC = new CustomThread("hread C");
        ctC.t.start();
        for(int i=0; i<100; i++){
            System.out.println("Current Thread " + Thread.currentThread());
            try{
                Thread.sleep(2);
            }
            catch(Exception e){
                e.printStackTrace(); 
            }
            //Thread.sleep(10);
        }
    }
}