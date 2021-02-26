package q3;

public class q3TryCatch {
    public static void isNotPrime(int n) throws Exception {
        int i = 3;
        if (n == 1) {
            System.out.println(n);
            return;
        }
        if (n == 2)
            throw new Exception(n + " is prime number");
        if (n % 2 == 0) {
            System.out.println(n);
            return;
        }
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                System.out.println(n);
                return;
            }
            i += 2;
        }
        throw new Exception(n + " is prime number");
    }

    public static void counter(int num) {
        int i = 1;
        while (i <= num) {
            try {
                isNotPrime(i++);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        counter(100);
    }
}
