class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] arr = new int[nums.length][2];

        for(int i = 0 ; i < nums.length ; i++)
        {
            int originalno = nums[i];
            int mappedNo = originalno==0?mapping[0]:0;
            int placeval = 1;
        //construct the mapped no
            while(originalno>0)
            {
                int digit = originalno%10;
                mappedNo+= placeval*mapping[digit];
                placeval*=10;
                originalno/=10;
            }

            arr[i][0] = mappedNo;
            arr[i][1] = i;
        }
        //create a custom comparator to compare the index and the new mapped values
        Arrays.sort(arr,(a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int[]res= new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++)
        {
            res[i] = nums[arr[i][1]];
        }

        return res;
    }
}