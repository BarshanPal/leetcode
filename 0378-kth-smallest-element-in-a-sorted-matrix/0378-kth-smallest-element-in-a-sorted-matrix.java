class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int[] i : matrix) {
            for (int x : i) {
                heap.add(x);

                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }

        return heap.peek();
    }
}