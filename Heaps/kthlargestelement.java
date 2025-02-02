class KthLargest {

    // private ArrayList<Integer> ls;
    // private int k;
    // public KthLargest(int k, int[] nums) {
    //     this.ls = new ArrayList<>();
    //     for(int i = 0 ; i < nums.length ; i++)
    //     {
    //         ls.add(nums[i]);
    //     }
    //     this.k = k;
    // }
    
    // public int add(int val) {
    //         ls.add(val);
    //         Collections.sort(ls);
    //         return ls.get(ls.size()-k);
    // }

      private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            pq.add(nums[i]);
        }
        this.k = k;
        while(pq.size()>k)
        {
            pq.remove();
        }
    }
    
    public int add(int val) {
            pq.add(val);
            if(pq.size()>k) pq.remove();
            return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
