class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(Integer.compare(a[1],b[1])));
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            minHeap.offer(new int[]{key,val});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[minHeap.size()];
        int i =0 ;
        while(!minHeap.isEmpty()){
            
            int [] p = minHeap.poll(); 
            res[i++]=p[0];
        }
        return res;
    }
}