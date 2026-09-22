class Solution {
    static class Node {
        int[] remain = new int[5];
        int prod = 1;
    }

    static class SegmentTree {
        private final int n;
        private final int k;
        private final Node[] tree;

        public SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.tree = new Node[4 * n];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node();
            }
            build(nums, 0, 0, n - 1);
        }

        private Node merge(Node left, Node right) {
            Node res = new Node();
            res.prod = (left.prod * right.prod) % k;

            // Include left child's prefix remainders
            for (int i = 0; i < k; i++) {
                res.remain[i] = left.remain[i];
            }

            // Scale right child's prefix remainders by the total product of the left child
            for (int i = 0; i < k; i++) {
                int newRem = (left.prod * i) % k;
                res.remain[newRem] += right.remain[i];
            }

            return res;
        }

        private void build(int[] nums, int cur, int left, int right) {
            if (left == right) {
                int val = nums[left] % k;
                tree[cur].remain[val] = 1;
                tree[cur].prod = val;
                return;
            }
            int mid = left + (right - left) / 2;
            build(nums, 2 * cur + 1, left, mid);
            build(nums, 2 * cur + 2, mid + 1, right);
            tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
        }

        public void update(int cur, int lo, int hi, int idx, int val) {
            if (lo == hi) {
                for (int j = 0; j < k; j++) {
                    tree[cur].remain[j] = 0;
                }
                int modVal = val % k;
                tree[cur].remain[modVal] = 1;
                tree[cur].prod = modVal;
                return;
            }
            int mid = lo + (hi - lo) / 2;
            if (idx <= mid) {
                update(2 * cur + 1, lo, mid, idx, val);
            } else {
                update(2 * cur + 2, mid + 1, hi, idx, val);
            }
            tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
        }

        public Node query(int cur, int lo, int hi, int ql, int qr) {
            if (ql <= lo && hi <= qr) {
                return tree[cur];
            }
            int mid = lo + (hi - lo) / 2;
            if (qr <= mid) {
                return query(2 * cur + 1, lo, mid, ql, qr);
            }
            if (ql > mid) {
                return query(2 * cur + 2, mid + 1, hi, ql, qr);
            }

            Node left = query(2 * cur + 1, lo, mid, ql, qr);
            Node right = query(2 * cur + 2, mid + 1, hi, ql, qr);
            return merge(left, right);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(nums, k);
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // 1. Update element at index
            tree.update(0, 0, n - 1, index, value);

            // 2. Query prefix remainders starting from `start` to end of array
            Node resNode = tree.query(0, 0, n - 1, start, n - 1);
            result[i] = resNode.remain[x];
        }

        return result;
    }
}