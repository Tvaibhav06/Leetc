class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> revarr = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revarr.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                revarr.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        List<Integer> lst = new ArrayList<>();
        while (!q.isEmpty()) {
            int p = q.peek();
            q.remove();
            lst.add(p);
            for (int it : revarr.get(p)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            } 
        }
        Collections.sort(lst);
        return lst;
    }
}