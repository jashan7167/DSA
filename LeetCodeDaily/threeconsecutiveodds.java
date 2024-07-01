class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int[]arr1 = new int[arr.length];
        int countodd = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {        
            if(arr[i]%2!=0)
            {
                countodd++;
            if(countodd==3)
            {
                return true;
            }
                continue;
            }
            countodd = 0;
        }

        return false;


    }
}