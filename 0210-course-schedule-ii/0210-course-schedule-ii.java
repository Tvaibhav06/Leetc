class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            arr.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int tip = q.peek();
            q.remove();
            for (int it : arr.get(tip)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
            order.add(tip);
        }
        if (order.size() != numCourses) {
            int[] trash = {};
            return trash;
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = order.get(i);
        }

        return ans;
    }
}