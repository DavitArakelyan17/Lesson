public class FibonacciWithoutRecursion {
    public static int Fibonacci(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        int first = 0;
        int second = 1;

        for (int i = 2; i <=n ; i++) {

            int next = first + second;
            first = second;
            second = next;

        }
        
        return second;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(8));
    }
}
