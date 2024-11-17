class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int curMax = Integer.MIN_VALUE;
        //initialise withtthe first element of each list to get the min from heap and max in curMax
        for(int i=0 ; i < nums.size() ; i++)
        {
            minHeap.add(new int[]{nums.get(i).get(0),i,0});
            curMax = Math.max(curMax,nums.get(i).get(0));
        }

        int[]smallRange = new int[]{0,Integer.MAX_VALUE};

        while(true)
        {
            //get the minimum value
            int[]curr = minHeap.poll();
            int curMin = curr[0],listIdx = curr[1],elemIdx = curr[2];


            if((curMax-curMin < smallRange[1]-smallRange[0]) || (curMax-curMin ==smallRange[1]-smallRange[0] && curMin < smallRange[0]))
            {
                smallRange[0] = curMin;
                smallRange[1] = curMax;
            }

            if(elemIdx + 1 < nums.get(listIdx).size())
            {
                int nextVal = nums.get(listIdx).get(elemIdx+1);
                minHeap.add(new int[]{nextVal,listIdx,elemIdx+1});
                curMax = Math.max(curMax,nextVal);
            }
            else
            {
                break;
            }

        }
        return smallRange;
    }
}
