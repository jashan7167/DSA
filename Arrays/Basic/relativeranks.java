class Solution {

    
    public String[] findRelativeRanks(int[] score) {
        String[]arr = new String[score.length];
        int[]scoresort = score.clone();
        Arrays.sort(scoresort);
        
       
        int medalno = 1;
        int k = score.length-1;
        int i = 0;
       while(medalno!=score.length+1)
       {
            if(medalno == 1 && score[i]==scoresort[k]) {
            System.out.println(i);
            arr[i] = "Gold Medal";
            k--;
            medalno++;
        } else if(medalno == 2 && score[i]==scoresort[k]) {
            arr[i] = "Silver Medal";
            medalno++;
            k--;
        } else if(medalno  == 3 && score[i]==scoresort[k]) {
            arr[i] = "Bronze Medal";
            medalno++;
            k--;
        } else if(medalno>3 && score[i]==scoresort[k]){
            arr[i] = Integer.toString(medalno);
            medalno++;
            k--;
        }
        i = (i+1)%score.length;
       }
       
        
        return arr;
    }
    }
