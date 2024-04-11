public class Countzeros {
    public static void main(String[] args) {
        System.out.println(count(1020340560));
    }
    static int count(int n)
    {
        return helper(n,0);
    }
    //how to pass a value to above calls
    public static int helper(int n,int c)
    {
        if(n==0)
        {
            return c;
        }
        if(n%10==0)
        {
            c++;
        }
        return helper(n/10,c);
    }
}
