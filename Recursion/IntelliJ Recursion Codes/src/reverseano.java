public class reverseano {
    public static void main(String[] args) {
        rev1(1824);
        rev2(1234);
        System.out.println();
        System.out.println(sum);
        System.out.println(rev3(1234));

        System.out.println(palin(1111));
    }

    static void rev1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n % 10);
        rev1(n / 10);
    }

    static int sum = 0;

    static void rev2(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        rev2(n / 10);
    }

    static int rev3(int n) {
        //sometimes you might need some additional elements in the arguments in that case make a helper function
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, digits - 1)) + helper(n / 10, digits-1);
    }

    static boolean palin(int n)
    {
        return n == rev3(n);
    }

}
