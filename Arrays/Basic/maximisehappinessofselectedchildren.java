class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int i;
        int minus = 1;
            for(i = happiness.length-1;i>0;i--)
            {
                if(k==0)
                {
                    break;
                }
                if(happiness[i]>0)
                {
                sum+=happiness[i];
                }
                happiness[i-1]-=minus;
                k--;
                minus++;
            }
            if(k!=0 && happiness[i]>0)
            {
                sum+=happiness[i];
            }
   
        return sum;
    }
}