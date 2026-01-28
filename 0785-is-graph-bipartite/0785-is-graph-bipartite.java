class Solution {
    public boolean DFS(List<List<Integer>> adj,int node,int col,int[] color){
        color[node]=col;
        for(int i:adj.get(node)){
            if(color[i]==-1){
                if(DFS(adj,i,1-col,color)==false)return false;
            }
            else if(color[i]==col)return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] color=new int[V];
        for(int i=0;i<V;i++)color[i]=-1;
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(DFS(adj,i,0,color)==false)return false;
            }
        }
        return true;
    }
}