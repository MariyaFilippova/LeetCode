public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int windowEnd = 0;
        int windowStart = 0;
        int max = 0;
        int maxLen = 0;
        for (windowEnd = 0; windowEnd < A.length; windowEnd++) {
            max += A[windowEnd];
            while (windowEnd - windowStart + 1 - max > K) {
                max -= A[windowStart++];
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new MaxConsecutiveOnesIII().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
    }
}
