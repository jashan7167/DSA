class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // int genmean = 0;
        // int j = 0;
        // int[]missingobs = new int[n];
        // int sum = Arrays.stream(rolls).sum();
        // while(n!=0)
        // {
        //     int min = 0;
        //     int minmean = Integer.MAX_VALUE;
        //     for(int i = 1 ; i <= 6 ; i++)
        //     {
        //         genmean = (sum + i)/(rolls.length+n);
        //         if(mean-genmean==0)
        //         {
        //             min = i;
        //             break;
        //         }
        //         if(mean-genmean < minmean)
        //         {
        //             minmean = mean-genmean;
        //             min = i;
        //         }
        //     }
        //     sum+=min;
        //     missingobs[j] = min;
        //     n--;
        //     j++;
        // }
    // return missingobs;
    int m = rolls.length;
    int sum = Arrays.stream(rolls).sum();
    int totalsum = (n+m)*mean;
    int missingsum = totalsum - sum;
    
    if(missingsum<n || missingsum>n*6)
    {
        return new int[]{};
    }
    int base = missingsum/n;
    int remainder = missingsum%n;
    int[]result = new int[n];
    for(int i = 0 ; i < n ; i++)
    {
        result[i] = base + (i<remainder?1:0);
    }

    return result;
    }
}
