class Solution {
    public void recur(int index,int target,Stack<Integer> stck,int[] candidates,List<List<Integer>> ans){  
        if(target==0){
              ans.add(new ArrayList<>(stck));
              return;
        }
        if(index==candidates.length||target<0){
            return;
        }
        if(target>=candidates[index]){
            stck.add(candidates[index]);
            recur(index,target-candidates[index],stck,candidates,ans);
            if(!stck.isEmpty())stck.pop();
        }    
        recur(index+1,target,stck,candidates,ans);        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Stack<Integer> stck=new Stack<>();
        recur(0,target,stck,candidates,ans);
        return ans;
    }
}