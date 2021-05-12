import java.util.LinkedList;
import java.util.Queue;

class HitCounter {
    Queue<Integer> hits;
    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        hits = new LinkedList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        if (hits.isEmpty()) {
            return 0;
        }
        int diff = timestamp - hits.peek();
        while (diff >= 300) {
            hits.poll();
            if (hits.isEmpty()) {
                return 0;
            }
            diff = timestamp - hits.peek();
        }
        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */