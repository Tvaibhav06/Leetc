class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int noch=g.length,nock=s.length;
        int p1=0,p2=0,max=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(p1<noch && p2<nock){
            if(g[p1]<=s[p2]){
                max++;
                p1++;
            }
            p2++;
        }
        return max;
    }
}