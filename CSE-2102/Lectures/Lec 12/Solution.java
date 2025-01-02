
// isAlive(), isJoin()

class CustomThread extends Thread{
    CustomThread(String s){
        super(s); 
        //t  = new Thread(this, s);
    }
    public void run(){
        System.out.println("Custom Thread Started");
        for(int i=0; i<500; i++){
            if(i == 499){
                System.out.println(" thread now " + " " + i + " " + Thread.currentThread());
            }
            try {
                //Thread.sleep(1); // msecond
            }
            catch(Exception e){
                e.printStackTrace();
            }
            //Thread.sleep(5);
        }
    }
}

class CommonShare{
    void printMethod(String val){
        System.out.println("[");
        try{
            Thread.sleep(1000); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(val);
        try{
            Thread.sleep(1000); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("]");
    }
    synchronized void printMethodV2(String val){
        System.out.println("[");
        try{
            Thread.sleep(1000); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(val);
        try{
            Thread.sleep(1000); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("]");
    }
}

class SyncThread extends Thread{
    String val; 
    CommonShare cs; 
    SyncThread (String s, String val, CommonShare cs){
        super(s); 
        this.val = val; 
        this.cs = cs; 
    }
   
    public void run(){
        //cs.printMethod(this.val); 
        //cs.printMethodV2(this.val); 
        synchronized (cs){
            cs.printMethod(this.val); 
        }
    }
}

class Product{
    int i=0; 
    int j=0; 
    boolean empty = true; 
    synchronized void produce(){
        try{
            Thread.sleep(1000); 
        }
        catch(Exception e){
            e.printStackTrace(); 
        }
        i++; 
        System.out.println("Produced Product Number : " + i);
    }

    synchronized void produceV2(){
        while(empty == false){ // condition check 
            System.out.println("Producer empty " + empty); 
            try{
                wait();  // wait to get the verdict 
            }
            catch(Exception e){
                e.printStackTrace(); 
            }  
        }
        // product produce 
        try{
            Thread.sleep(1000); 
        }
        catch(Exception e){
            e.printStackTrace(); 
        }
        i++; 
        System.out.println("Produced Product Number : " + i);
        // empty is false, something is already produced 
        empty = false;  
        notify();  // notifying everyone 
    }

    synchronized void consume(){
        try{
            Thread.sleep(500); 
        }
        catch(Exception e){
            e.printStackTrace(); 
        }
        j++;
        System.out.println("Consumed Product Number : " + j);
    }

    synchronized void consumeV2(){
        while(empty == true){ // no product there 
            System.out.println("Consumer empty " + empty); 
            try{
                wait(); // halting to generate the product 
            }
            catch(Exception e){
                e.printStackTrace(); 
            }    
        }
        // consumption of the product 
        try{
            Thread.sleep(500); 
        }
        catch(Exception e){
            e.printStackTrace(); 
        }
        j++;
        System.out.println("Consumed Product Number : " + j);
        empty = true; // declaring basket is empty 
        notify(); 
    }
}

class MarketThreadProducer extends Thread{
    Product p; 
    MarketThreadProducer(String name, Product p){
        super(name); 
        this.p = p; 
    }

    public void run(){
        while(true){
            //p.produce();
            p.produceV2(); 
        }
    }
}

class MarketThreadConsumer extends Thread{
    Product p; 
    MarketThreadConsumer(String name, Product p){
        super(name); 
        this.p = p; 
    }
    public void run(){
        while(true){
            //p.consume(); 
            p.consumeV2(); 
        }
    }
}




public class Solution{
    public static void main (String [] args){
        CustomThread ctA = new CustomThread("Thread A");
        ctA.setPriority(9);
        ctA.start();
        CustomThread ctB = new CustomThread("Thread B");
        ctB.setPriority(1);
        ctB.start();
        CustomThread ctC = new CustomThread("Thread C");
        ctB.setPriority(7);
        ctC.start(); 
        for(int i=0; i<100; i++){
            if(i == 99) System.out.println("Current Thread " + Thread.currentThread());
            try{
                //Thread.sleep(2);
            }
            catch(Exception e){
                e.printStackTrace(); 
            }
            //Thread.sleep(10);
        }
        try{
            System.out.println(ctA.isAlive()); 
            ctA.join(); 
            ctB.join(); 
            ctC.join(); 
        }
        catch(Exception e){
            e.printStackTrace(); 
        }   
        System.out.println(ctA.isAlive()); 

        // Second portion 
        CommonShare cs = new CommonShare(); 
        SyncThread stA = new SyncThread("SyncThread A", "Happy", cs); 
        SyncThread stB = new SyncThread("SyncThread B", "New", cs); 
        SyncThread stC = new SyncThread("SyncThread C", "Year", cs); 
        stA.start(); 
        stB.start(); 
        stC.start(); 


        // third portion 
        Product p = new Product(); 
        MarketThreadProducer pr = new MarketThreadProducer("Producer", p);
        MarketThreadConsumer cons = new MarketThreadConsumer("Consumer", p); 
        pr.start();
        cons.start(); 
    }
    
}