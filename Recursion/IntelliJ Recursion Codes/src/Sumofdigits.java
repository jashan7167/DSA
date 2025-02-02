public class Sumofdigits {
    public static void main(String[] args) {
        System.out.println(sumoddigits(1342));
        System.out.println(prod(1342));
    }
    static int sumoddigits(int n)
    {
        if(n==0)
        {
            return 0;
        }
        int rem = n%10;
        return n%10 + sumoddigits(n/10);
    }
    static int prod(int n)
    {
        if(n==0)
        {
            return 1;
        }
        int rem = n%10;
        return n%10 * prod(n/10);
    }
}
