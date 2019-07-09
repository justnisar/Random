class HitCounter {

    Map<Integer,Integer> map;
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap<>();
        queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!map.containsKey(timestamp)){
            update(timestamp);
            map.put(timestamp,1);
        }
        else{
            map.put(timestamp,map.get(timestamp) + 1);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        update(timestamp);
        int count = 0;
        for(int i = timestamp - 300 + 1; i <= timestamp ; i++){
            if(map.containsKey(i)){
                count += map.get(i);
            }
        }
        return count;
    }

    public void update(int timeStamp){
        while(!queue.isEmpty() && queue.peek() <= timeStamp - 300){
            int key = queue.poll();
            map.remove(key);
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
