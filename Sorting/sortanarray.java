class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length==1)
        {
            return nums;
        }
        return mergesort(nums);
    }
    public int[] mergesort(int[]arr)
    {
        if(arr.length<=1)
        {
            return arr;
        }
        int mid = arr.length/2;
        int[]left = mergesort(Arrays.copyOfRange(arr,0,mid));
        int[]right = mergesort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    public int[] merge(int[]left,int[]right)
    {
        int[]combined = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i<left.length && j<right.length)
        {
            if(left[i]<right[j])
            {
                combined[k] = left[i];
                k++;
                i++;
            }
            else
            {
                combined[k]= right[j];
                k++;
                j++;
            }
        }
        if(i<left.length)
        {
            for(;i<left.length;i++,k++)
            {
                combined[k] = left[i];
                
            }
        }
          if(j< right.length)
        {
            for(;j<right.length;j++,k++)
            {
                combined[k] = right[j];
                
            }
        }
        return combined;
    }
}
