import java.util.*;

public class Huffman {

    class Node {
        int freq;
        String code;

        public void walk(String code) {
            this.code = code;
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        InternalNode(Node left, Node right) {
            this.left = left;
            this.right = right;
            this.freq = right.freq + left.freq;
        }

        @Override
        public void walk(String code) {
            super.walk(code);
            left.walk(code + "0");
            right.walk(code + "1");
        }
    }

    class Leaf extends Node {
        char letter;

        Leaf(char letter, int freq) {
            this.letter = letter;
            this.freq = freq;
        }

        @Override
        public void walk(String code) {
            if (code == "") {
                code = "0";
            }
            super.walk(code);
            System.out.println(letter + ": " + code);
        }
    }

    public void huffmanDecode(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else {
                map.put(c, 1);
            }
        }
        Map<Character, Node> nodes = new HashMap<>();
        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> a.freq - b.freq);
        for (Map.Entry<Character, Integer> set : map.entrySet()) {
            Leaf l = new Leaf(set.getKey(), set.getValue());
            q.add(l);
            nodes.put(set.getKey(), l);
        }
        while (q.size() > 1) {
            Node node1 = q.poll();
            Node node2 = q.poll();
            q.add(new InternalNode(node1, node2));
        }
        Node root = q.poll();
        System.out.println(nodes.size() + " " + s.length());
        String result = "";
        root.walk("");
        for (int i = 0; i<s.length(); i++) {
            result += nodes.get(s.charAt(i)).code;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        new Huffman().huffmanDecode(s);
    }
}
