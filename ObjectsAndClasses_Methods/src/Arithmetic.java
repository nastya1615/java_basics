public class Arithmetic {
    int a;
    int b;

    public Arithmetic (int a, int b){
        this.a = a;
        this.b = b;

    }

    public int sum ( ){
        return a+b;
    }

    public int multiplication(){
        return a*b;
    }

    public int maxNum() {
        int max = a> b ? a: b;
        return max;
    }

    public int minNum() {
        int min = a< b ? a: b;
        return min;
    }
}
