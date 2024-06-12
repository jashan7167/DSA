class Solution {
    public boolean findsucessors(int [] hand , int groupSize , int i , int n)
    {
        int f = hand[i] + 1;
        hand[i] = -1; //make the card as used
        int count = 1; //initialise count to check if we can make upto group size or not
        i+=1; 
        while(i<n && count < groupSize)
        {
            if(hand[i]==f)
            {
                f = hand[i] + 1; //increase the card so we can search for other consec
                hand[i] = -1; //used
                count++;
            }
            i++;
        }
        if(count!=groupSize)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize!=0)
        {
            return false; // we cannot make the groups as the sizs of array is not enough
        }
        Arrays.sort(hand);
        int i = 0;
        for(;i<n;i++)
        {
            if(hand[i]>=0)
            {
                if(!findsucessors(hand,groupSize,i,n))
                { 
                    return false; //couldnt find the successors
                }
            }
        }

        return true;
    }
}
