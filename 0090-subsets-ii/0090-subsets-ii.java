class Solution {
    public void recur(int index,int[] nums,List<List<Integer>> ans,List<Integer> lst){
        ans.add(new ArrayList<>(lst));
        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1])continue;
            lst.add(nums[i]);
            recur(i+1,nums,ans,lst);
            lst.remove(lst.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> lst=new ArrayList<>();
        recur(0,nums,ans,lst);
        return ans;
    }
}