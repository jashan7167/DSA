class Solution {
    public int compareVersion(String version1, String version2) {
        String[]arr1 = version1.split("\\.");
        String[]arr2 = version2.split("\\.");
       int i = 0;
       int j = 0;
       while(i<arr1.length && j<arr2.length)
       {
        int val1 = Integer.parseInt(arr1[i]);
        int val2 = Integer.parseInt(arr2[j]);
        if(val1>val2)
        {
            return 1;
        }
        else if(val1<val2)
        {
            return -1;
        }
        i++;
        j++;
       }
       while(i<arr1.length)
       {
        int val1 = Integer.parseInt(arr1[i]);
        if(val1>0)
        {
            return 1;

        }
        i++;
       }
       while(j<arr2.length)
       {
        int val2 = Integer.parseInt(arr2[j]);
        if(val2>0)
        {
            return -1;
        }
        j++;
       }
       return 0;
    }
}