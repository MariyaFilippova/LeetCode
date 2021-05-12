public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder new_a = new StringBuilder(a).reverse();
        StringBuilder new_b = new StringBuilder(b).reverse();
        int q = 0;
        int r = 0;
        int i = 0;
        StringBuilder res = new StringBuilder();
        for (i = 0; i < Math.min(a.length(), b.length()); i++) {
            int x = new_a.charAt(i) - '0';
            int y = new_b.charAt(i) - '0';
            q = x ^ y;
            q ^= r;
            r = (x & y) | (r & y) | (r & x);
            res.append(q);
        }
        StringBuilder stringBuilder = null;
        while (i < Math.max(a.length(), b.length())) {
            if (a.length() > b.length()) {
                stringBuilder = new_a;
            }
            else {
                stringBuilder = new_b;
            }
            q = r ^ (stringBuilder.charAt(i) - '0');
            r = (stringBuilder.charAt(i) - '0') & r;
            i++;
            res.append(q);
        }
        if (r != 0) {
            res.append(r);
        }
        return res.reverse().toString();
    }
}
