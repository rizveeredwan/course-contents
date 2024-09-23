
class PairValue{
    double x,y; 
    public PairValue(double x, double y){
        this.x = x;
        this.y = y; 
    }
    public void printResult(){
        System.out.println("x1 = " + this.x + ", x2 = " + this.y); 
    }
}

class EqnSolver{
    int a,b,c; 
    double x1,x2; 
    public EqnSolver(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c; 
    }
    public int makeSquare(int val){
        return val * val; 
    }
    public double squareRoot(int val){
        return (double) val; 
    }
    public PairValue solve(){
        double lob1 = -this.b + this.makeSquare(this.b)  - 4.0 * this.a * this.c; 
        double lob2 = -this.b - this.makeSquare(this.b)  - 4.0 * this.a * this.c; 
        PairValue result = new PairValue(lob1/(1.0 * this.a * 2), lob2/(1.0 * this.a * 2)); 
        return result; 
    }

}

public class SimpleMath{
    public static void main (String [] args){
        EqnSolver eqn = new EqnSolver(2, 5, 7); 
        PairValue result = eqn.solve(); 
        result.printResult();
    }
}