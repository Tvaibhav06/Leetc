class Pair {
    String a;
    int b;

    Pair(String a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public int compute(Set<String> words, String beginWord, String endWord) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        int k = beginWord.length();
        while (!q.isEmpty()) {
            Pair current = q.poll();
            String s = current.a;
            int lvl = current.b;
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < 26; j++) {
                    String p = new StringBuilder(s).replace(i, i + 1, String.valueOf((char) ('a' + j))).toString();

                    if (words.contains(p)) {
                        if (p.equals(endWord)) {
                            return lvl + 1;
                        }
                        words.remove(p);
                        q.add(new Pair(p, lvl + 1));
                    }
                }
            }
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        return compute(words, beginWord, endWord);
    }
}