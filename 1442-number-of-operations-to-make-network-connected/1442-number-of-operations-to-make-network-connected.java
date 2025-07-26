class Disjoint {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int find(int node) {
        if (node == parent.get(node)) return node;
        int ultParent = find(parent.get(node));
        parent.set(node, ultParent);  
        return ultParent;
    }

    public void unionBySize(int u, int v) {
        int ulpU = find(u);
        int ulpV = find(v);
        if (ulpU == ulpV){
             return;}
        if (size.get(ulpU) < size.get(ulpV)) {
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpV) + size.get(ulpU));
        } else {
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m=connections.length;
         int cnt=0;
        if(n-1>m)return -1;
        else{
            Disjoint dsu=new Disjoint(n-1);
            for(int[] i:connections){
                dsu.unionBySize(i[0],i[1]);
            }
            int ULT_parent=dsu.find(connections[0][0]);
            for(int i=0;i<=n-1;i++){
                if(dsu.parent.get(i)==i)cnt++;
            }
        }
        return cnt-1;
    }
}