package Module_3_1;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World");
        System.out.println(fib(5));
        System.out.println(fib_sum(5));
    }
    public static int fib(int n){
        if (n==1||n==2)
            return 1;
        else
            return fib(n-1)+fib(n-2);
    }
    public static int fib_sum(int n){
        if (n==1)
            return 1;
        else if(n==2)
            return 2;
        else
        return fib_sum(n-1)+fib_sum(n-2)+1;
    }
}
