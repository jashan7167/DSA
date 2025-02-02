public class Printnorecursion {
    public static void main(String[] args) {
        // print(5);
        printreverse(5);
        // System.out.println("Print the nos in the calling and returning phase");
        // printrevandfor(5);
    }

    static void print(int n)
    {
        if(n==0)
        {
            return;
        }
        System.out.println(n);
        print(--n);
    }

    static void printreverse(int n)
    {
        if(n==0)
        {
            return;
        }
        printreverse(n-1);
        System.out.println(n);
    }

    static void printrevandfor(int n)
    {
        if(n==0)
        {
            return;
        }
        System.out.println(n);
        printrevandfor(n-1);
        System.out.println(n);
    }
}
