class Solution {
    private boolean DFS(ArrayList<ArrayList<Integer>> adj, int[] visited, int node, List<Integer> ans) {
        visited[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (visited[adj.get(node).get(i)] == 0) {
                if (DFS(adj, visited, adj.get(node).get(i), ans))
                    return true;
            } else if (visited[adj.get(node).get(i)] == 1) {
                return true;
            }
        }
        visited[node] = 2;
        ans.add(node);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] i : prerequisites) {
            adj.get(i[1]).add(i[0]);
        }
        int[] visited = new int[numCourses];
        int[] array = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                if (DFS(adj, visited, i, ans)) {
                    int[] arr = {};
                    return arr;
                }
            }
        }
         Collections.reverse(ans);
        for(int i=0;i<ans.size();i++){
            array[i]=ans.get(i);
        }
       
        return array;
    }
}