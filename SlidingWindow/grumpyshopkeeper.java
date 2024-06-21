class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unsatisfiedcust = 0;
        int totalsat = 0;

        //first calculate the initial window unsatisfied value and initialsatisfaction also in one loop to optimise the solution
        for(int i = 0 ; i < n ; i++)
        {
            //this works as we need grumpy[i] 1 value customers;
            totalsat += customers[i] * (1-grumpy[i]);
            if(i<minutes)
            {
            unsatisfiedcust+= customers[i] * grumpy[i];
            }
        }

        int max = unsatisfiedcust;
        

        for(int i = minutes ; i < n ; i++)
        {
            unsatisfiedcust +=customers[i]*grumpy[i];
            unsatisfiedcust-=customers[i-minutes] * grumpy[i-minutes]; 
            max = Math.max(unsatisfiedcust,max);
        }

        return (totalsat + max);
        
    }
}