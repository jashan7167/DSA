class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        List<int[]>arrival = new ArrayList<>();
        //create arrival list and add arrival time with index of the friend
        for(int i = 0 ; i < n ; i++)
        {
            arrival.add(new int[]{times[i][0],i});
        }
        //sort it with respect to the arrival time and friend indexes will be adjusted automatically
        arrival.sort((a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        //available chairs are added to the pq
        for(int i = 0 ; i< n ; i++)
        {
            availableChairs.add(i);
        }
      //leaving queue is made with leaving time and chair which is to be freed on that leaving time
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
//traverse through the arrival list give the available chairs and add it to the leaving queue whemever you encounter a arrival time greater than the one on the leaving queues front we need to remove the chairs and make them available 
        for(int[] arrivals : arrival)
        {
            int at = arrivals[0];
            int friendindex = arrivals[1];

            while(!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= at)
            {
                availableChairs.add(leavingQueue.poll()[1]);
            }

            int chair = availableChairs.poll();

            if(friendindex==targetFriend)
            {
                return chair;
            }
            leavingQueue.add(new int[]{times[friendindex][1],chair});
        }

        return -1;
        }
    
    }

