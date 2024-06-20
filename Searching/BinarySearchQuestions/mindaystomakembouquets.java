class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k > bloomDay.length)
        {
            return -1;
        }
        int low = 1 , high = (int)1e9;
        while(low<high)
        {
            int mid = low + (high-low)/2;
            if(isPossibleBouquets(bloomDay,m,k,mid))
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        };

        return low;
    }

    private boolean isPossibleBouquets(int[]bloomDay,int m,int k,int day)
    {
            int bouquets = 0;
            for(int j = 0 ; j < bloomDay.length ; j++)
            {
              int count=0;
              while(j<bloomDay.length && day>=bloomDay[j] && count<k)
              {
                count++;
                j++;
              }
              if(count==k)
              {
                bouquets++;
                j--;
              }
                if(bouquets>=m)
                {
                return true;
                }
        }
        return false;
    }
}
