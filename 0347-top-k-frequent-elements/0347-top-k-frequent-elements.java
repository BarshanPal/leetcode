class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Max heap: key with highest frequency comes first
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Put keys into heap
        for (int key : map.keySet()) {
            pq.add(key);
        }

        int[] ans = new int[k];

        // Get top k keys
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}