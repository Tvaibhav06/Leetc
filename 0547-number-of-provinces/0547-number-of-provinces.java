class Solution {
     public void traverse(int[][] isConnected,int[] visited,int node) {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        visited[node]=1;
        while(!q.isEmpty()){
            int poll=q.poll();
            for(int i=0;i<isConnected[poll-1].length;i++){
                if((visited[i+1]==0&&isConnected[poll-1][i]!=0)&&poll-1!=i){
                    visited[i+1]=1;
                    q.offer(i+1);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        // ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        // for(int i=1;i<=isConnected.length;i++){
        //     list.add(new ArrayList<>());
        // }
        // int j=1;
        // for(int conn[]:isConnected){
        //     for(int i=1;i<=conn.length;i++){
        //         if(conn[i-1]!=0&&i!=j)list.get(j-1).add(i);
        //     }
        //     j++;
        // }

        int[] visited=new int[isConnected.length+1];
        int cnt=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i+1]==0){
            cnt++;
            traverse(isConnected,visited,i+1);}
        }
        return cnt;
    }
}