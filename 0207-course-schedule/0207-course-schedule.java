class Solution {
    public boolean Topo(ArrayList<ArrayList<Integer>> arr, int[] visited, int node) {
        visited[node] = 1;
        for (int it : arr.get(node)) {
            if (visited[it] == 0) {
                if (Topo(arr, visited, it) == true)
                    return true;
            } else if (visited[it] == 1)
                return true;
        }
        visited[node]=2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (Topo(arr, visited, i) == true)
                    return false;
            }

        }
        return true;
    }
}