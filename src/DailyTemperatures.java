import java.util.Scanner;
import java.util.Stack;

class Temprature {
    int temp;
    int number;

    Temprature(int t, int n) {
        this.number = n;
        this.temp = t;
    }
}

class Node {
    int number;
    int val;

    Node (int n, int v) {
        this.number = n;
        this.val = v;
    }

}
public class DailyTemperatures {

    public int[] nextLargerNodes(ListNode head) {

        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        Node[] nodes = new Node[size];
        for (int i = 0; i<size; i++) {
            nodes[i] = new Node(i, head.val);
            head = head.next;
        }
        int[] out = new int[size];
        Stack<Node> temp = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (temp.empty()) {
                temp.push(nodes[i]);
            }
            else {
                while (!temp.empty() && temp.peek().val < nodes[i].val) {
                    int number = temp.pop().number;
                    out[number] = nodes[i].val;
                }
                temp.push(nodes[i]);
            }
        }
        return out;
    }

    public int[] dailyTemperatures(int[] T) {
        int[] out = new int[T.length];
        Temprature[] t = new Temprature[T.length];
        for (int i = 0; i < T.length; i++) {
            t[i] = new Temprature(T[i], i);
        }
        Stack<Temprature> temp = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (temp.empty()) {
                temp.push(t[i]);
            }
            else {
                while (!temp.empty() && temp.peek().temp < t[i].temp) {
                    int number = temp.pop().number;
                    out[number] = t[i].number - number;
                }
                temp.push(t[i]);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] T = new int[n];
        for (int i = 0 ;i < n;i++) {
            T[i] = scanner.nextInt();
        }
        new DailyTemperatures().dailyTemperatures(T);
    }
}
