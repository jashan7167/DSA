class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls = new ArrayList<>();
        combination(ls,new ArrayList<>(),candidates,target,0);
        return ls;
    }
    public void combination(List<List<Integer>> res,List<Integer> cursub,int[]candidates,int target,int i)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(cursub));
            return;
        }
        for(int k = i ; k < candidates.length ; k++)
        {
            if(k>i && candidates[k]==candidates[k-1]) continue;
            if(candidates[k]>target) break;

            cursub.add(candidates[k]);
            combination(res,cursub,candidates,target-candidates[k],k+1);
            cursub.remove(cursub.size()-1);
        }
        
    }
}
