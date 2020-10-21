import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        if (n == 0) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(asteroids[0]);
        int i = 1;
        while (i < n) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                i++;
                continue;
            }
            if (asteroids[i] * stack.peek() > 0) {
                stack.push(asteroids[i]);
            } else {
                if (asteroids[i] < 0) {
                    while (!stack.empty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                        stack.pop();
                    }
                    if (stack.empty()) {
                        stack.push(asteroids[i]);
                    } else if (stack.peek() == -asteroids[i]) {
                        stack.pop();
                    }
                    else if (stack.peek() > -asteroids[i]){
                        i++;
                        continue;
                    }
                    else {
                        stack.push(asteroids[i]);
                    }
                }
                else {
                    stack.push(asteroids[i]);
                }
            }
            i++;
        }
        if (stack.size() == 0) {
            return new int[]{};
        }
        int[] res = new int[stack.size()];
        for (int k = stack.size() - 1; k >= 0; k--) {
            res[k] = stack.pop();
        }
        return res;
    }
}
