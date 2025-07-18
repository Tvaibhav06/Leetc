class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList< ArrayList<Integer>> adjrev=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adjrev.add(new ArrayList<Integer>());
        }
        int[] indegree=new int[graph.length];
       for(int i=0;i<graph.length;i++){
        for(int j:graph[i]){
            adjrev.get(j).add(i);
            indegree[i]++;
        }
       }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)q.offer(i);
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int poll=q.poll();
            for(int i:adjrev.get(poll)){
                indegree[i]--;
                if(indegree[i]==0)q.offer(i);
            }
            ans.add(poll);
        }
        Collections.sort(ans);
        return ans;
    }
}