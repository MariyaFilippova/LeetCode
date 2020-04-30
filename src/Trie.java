import java.util.ArrayList;

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    boolean search(String key) {
        TrieNode start = root;
        int n = key.length();
        for (int i = 0; i < n; i++) {
            int c = key.charAt(i) - 'a';
            if (start == null) {
                return false;
            }
            if (start.children[c] == null) {
                return false;
            }
            start = start.children[c];
        }
        return !(start == null) && start.endOfTheWorld;
    }

    void insert(String key) {
        TrieNode start = root;
        if (!search(key)) {
            int n = key.length();
            for (int i = 0; i < n; i++) {
                int c = key.charAt(i) - 'a';
                if (start.children[c] == null) {
                    start.children[c] = new TrieNode();
                }
                start = start.children[c];
            }
            start.endOfTheWorld = true;
        }
    }

    boolean startsWith(String prefix) {
        TrieNode start = root;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            int c = prefix.charAt(i) - 'a';
            if (start == null) {
                return false;
            }
            if (start.children[c] == null) {
                return false;
            }
            start = start.children[c];
        }
        return !(start == null);
    }
}

class TrieNode {
    boolean endOfTheWorld;
    TrieNode[] children = new TrieNode[26];
}