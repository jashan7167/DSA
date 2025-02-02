class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        // interface var_name = new  class_that_implemntsit
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for(int i = 1; i < numRows ; i++)
        {
            List<Integer> prevRow = res.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for(int j = 1 ; j < i ; j++)
            {
                currentRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            currentRow.add(1);
            res.add(currentRow);
        }

        return res;

    }
}:
