class Solution {
    static class Node {
        char prefixChar, suffixChar;
        int prefixLen, suffixLen, maxLen, len;

        Node() {}

        Node(char c) {
            this.prefixChar = c;
            this.suffixChar = c;
            this.prefixLen = 1;
            this.suffixLen = 1;
            this.maxLen = 1;
            this.len = 1;
        }
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        this.chars = s.toCharArray();
        this.tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            chars[idx] = ch;
            update(1, 0, n - 1, idx, ch);
            ans[i] = tree[1].maxLen;
        }

        return ans;
    }

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.len = left.len + right.len;
        res.prefixChar = left.prefixChar;
        res.suffixChar = right.suffixChar;

        res.prefixLen = left.prefixLen;
        if (left.prefixLen == left.len && left.prefixChar == right.prefixChar) {
            res.prefixLen = left.len + right.prefixLen;
        }

        res.suffixLen = right.suffixLen;
        if (right.suffixLen == right.len && right.suffixChar == left.suffixChar) {
            res.suffixLen = right.len + left.suffixLen;
        }

        res.maxLen = Math.max(left.maxLen, right.maxLen);
        if (left.suffixChar == right.prefixChar) {
            res.maxLen = Math.max(res.maxLen, left.suffixLen + right.prefixLen);
        }

        return res;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(chars[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            tree[node] = new Node(ch);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, end, idx, ch);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
}