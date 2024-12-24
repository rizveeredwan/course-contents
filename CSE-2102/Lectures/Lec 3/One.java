// overloading & multiple constructor
// For use case
// Multi dimensional array 
// scope & lifetime of a variable 
// object - call by value - call by reference

class Secondary{
    int x, y;
    void printFunc(){
        System.out.println("Now " + x + " " + y);
    }
}
class Solution{
    Solution(){
        System.out.println("First");
    }
    Solution(int a, int b){
        System.out.println("Second");
    }
    Solution(int a, double b){
        System.out.println("Third");
    }
    Solution(int a, int b, int c){
        System.out.println("Fourth");
    }
    void learnFor(){
        int arr[] = {2, 6, 7, 8};
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        System.out.println("**************");
        for(var x: arr) {
            System.out.println(x);
        }
    }

    void multArr(){
        int v1[][] = new int[4][5]; 
        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                v1[i][j] = i*j;
            }
        }

        int v2[][] = new int[4][]; 
        for(int i=0; i<4; i++){
            v2[i] = new int[i+6];
            for(int j=0; j<5; j++){
                v2[i][j] = i*j;
            }
        }

        int v3[][][] = new int[4][][];
        v3[0] = new int[5][];
        v3[1] = new int[7][8];
    }

    void learnScope(){
        int y;
        for(int i=0; i<100; i++){
            y = i + 100 - 5*i;
            {
                int z = 15; 
            }
            //System.out.println(y+ " " + z);
        }
        
    }

    void valuePass(int x, int y){
        x = 13;
        y = 31;
        // doing something here
    }

    void valuePass(Secondary s, int x, int y){
        s.x = x;
        s.y = y; 
    }
}
public class One{
    public static void main (String [] args) {
       /*Solution sol = new Solution();
       Solution sol2 = new Solution(10, 20);
       Solution sol3 = new Solution(10, 20.6);*/
       Solution sol4 = new Solution(10, 20, 30);

       //sol4.learnFor();
       sol4.multArr();

       Secondary s = new Secondary();
       s.x = 25;
       s.y = 34;
       s.printFunc();

       int x = 27;
       int y = 47;
       sol4.valuePass(x, y);
       System.out.println("x " + x + " " + y);

       sol4.valuePass(s, 13, 31);
       s.printFunc();
    }
}