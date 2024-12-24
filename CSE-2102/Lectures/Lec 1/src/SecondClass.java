class ThirdClass{
    public int a, b; 
    public ThirdClass(int x, int y){
       // this.a = x;
        a = x;
        this.b = y;
    }
    public void printAll(){
        System.out.println(this.a + " " + this.b);
    }
}

public class SecondClass{
    public static void main (String [] args){
        System.out.println("Test"); 
        ThirdClass tc = new ThirdClass(19, 22);
        tc.printAll();
    }
}