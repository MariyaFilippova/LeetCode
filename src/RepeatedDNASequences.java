import java.util.*;

public class RepeatedDNASequences {
    Map<Character, Integer> map = new HashMap<>();
    Map<Integer, Character> reversedMap = new HashMap<>();

    public List<String> findRepeatedDnaSequences(String s) {
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        reversedMap.put(1, 'A');
        reversedMap.put(2, 'C');
        reversedMap.put(3, 'G');
        reversedMap.put(4, 'T');
        Set<String> result = new HashSet<>();
        if (s.length() < 10) return new ArrayList<>(result);
        int l = 1;
        int r = 10;
        Set<Long> hashes = new HashSet<>();
        long hash = hash(s.substring(0, 10));
        while (r < s.length()) {
            if (!hashes.add(hash)) {
                result.add(convertToString(hash));
            }
            hash = hash % (map.get(s.charAt(l - 1)) * (long) 1000000000) * 10 + map.get(s.charAt(r));
            l++;
            r++;
        }
        if (!hashes.add(hash)) {
            result.add(convertToString(hash));
        }
        return new ArrayList<>(result);
    }

    String convertToString(Long hash) {
        StringBuilder res = new StringBuilder();
        while (hash / 10 != 0) {
            int h = (int) (hash%10);
            res.append(reversedMap.get(h));
            hash /= 10;
        }
        res.append(reversedMap.get(hash.intValue()));
        return res.reverse().toString();
    }

    long hash(String s) {
        StringBuilder hash = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            hash.append(map.get(s.charAt(i)));
        }
        return Long.parseLong(hash.toString());
    }

    public static void main(String[] args) {
        new RepeatedDNASequences().findRepeatedDnaSequences("GAGAGAGAGAGA");
    }
}
