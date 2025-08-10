class Solution {
    public void recur(int index, int target, Stack<Integer> stck, int[] candidates, List<List<Integer>> ans) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(stck);
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;
            stck.add(candidates[i]);
            recur(i + 1, target - candidates[i], stck, candidates, ans);
            if (!stck.isEmpty())
                stck.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        Stack<Integer> stck = new Stack<>();
        recur(0, target, stck, candidates, ans);
        return ans;
    }
}