class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1;
        //maximum distance for the m balls division
        int hi = (position[position.length-1]-position[0])/(m-1);
        int ans =1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(canWePlace(position,mid,m))
            {
                ans = mid;
                lo = mid+1;
            }
            else
            {
                hi = mid-1;
            }
        }
        return ans;
    }

    private boolean canWePlace(int[]arr,int dist,int balls)
    {
        // [ 1 2 3 4 7]
        //start from the 0th position trying to place the ball
        // cnt increase when the i - last > dist
        int placement = 1;
        int last = arr[0];
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i]-last>=dist)
            {
                placement++;
                last = arr[i]; //move the position of the last ball placed
            }
            if(placement>=balls)
            {
                return true;
            }
        }

        return false;
    }
}
