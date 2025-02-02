class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int n = quality.length;
            double minCost = Double.MAX_VALUE;
            double qualityTillNow = 0;

            List<Worker> workers = new ArrayList<>();

            for(int i = 0 ; i < n ; i++)
            {
                workers.add(new Worker(wage[i]/(double)quality[i],quality[i]));
            }
            //sort the workers on the basis of ratio
            Collections.sort(workers);
            
            //max heap to store the highquality workers for removal from the window
            PriorityQueue<Integer> highQualityWorkers  = new PriorityQueue<>(Comparator.reverseOrder());



            //check each of the workers and add into the heap which sorts them in max order keep the size of heap k at all times now if the size exceeds k remove the highest quality worker
            for(Worker worker : workers)
            {
                double ratio = worker.ratio;
                int qua = worker.quality;

                qualityTillNow+=qua;
                highQualityWorkers.add(qua);

                if(highQualityWorkers.size() > k)
                {
                    qualityTillNow -= highQualityWorkers.poll();
                }

                if(highQualityWorkers.size()==k)
                {
                    minCost = Math.min(minCost,qualityTillNow*ratio);
                }
            }

            return minCost;
 
    }
    public class Worker implements Comparable<Worker>
    {
        double ratio;
        int quality;

        Worker(double ratio,int quality)
        {
            this.ratio = ratio;
            this.quality = quality;
        }

        @Override
        public int compareTo(Worker other)
        {
            return Double.compare(this.ratio,other.ratio);
        }
    }

}
