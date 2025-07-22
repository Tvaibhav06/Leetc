class Pair {
    long first;  
    int second;  
    public Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int[] i : roads) {
            arr.get(i[0]).add(new Pair(i[2], i[1]));
            arr.get(i[1]).add(new Pair(i[2], i[0]));
        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        int MOD = 1_000_000_007;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            long dist = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            if (dist > distance[node]) continue;

            for (Pair i : arr.get(node)) {
                int nxt = i.second;
                long edW = i.first;

                if (distance[nxt] > edW + dist) {
                    distance[nxt] = edW + dist;
                    pq.add(new Pair(distance[nxt], nxt));
                    ways[nxt] = ways[node];
                } else if (distance[nxt] == edW + dist) {
                    ways[nxt] = (ways[nxt] + ways[node]) % MOD;
                }
            }
        }

        return (int)(ways[n - 1] % MOD);
    }
}
