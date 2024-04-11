package PatternQuestions;

public class Traingle {
    public static void main(String[] args) {
                pattern1(5,0);
                 pattern2(5,0);

    }

    static void pattern1(int r,int c)
    {
       if(r==0)
       {
           return;
       }
       if(c<r)
       {
           //print until it is equal to the column
           System.out.print("*");
           pattern1(r,c+1);
       }
       else
       {
           //reduce the row and move to the new line
           System.out.println();
           pattern1(r-1,0);
       }
    }

    static void pattern2(int r,int c)
    {
        if(r==0)
        {
            return;
        }
        if(c<r)
        {
            //print until it is equal to the column
            pattern2(r,c+1);
            System.out.print("*");
        }
        else
        {
            //reduce the row and move to the new line
            pattern2(r-1,0);
            System.out.println();
        }
    }
}
