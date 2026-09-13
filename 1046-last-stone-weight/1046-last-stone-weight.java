class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            heap.add(i);
        }
        while(heap.size()>1){
           int heap1=heap.poll();
            int heap2=heap.poll();
            int x=heap1-heap2;
            heap.add(x);
 
        }
        return heap.peek();

    }
}