public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int sum = 0;
        char current = 'a';
        while (sum != k) {
            while ((k - sum - getValue(current) - (n - (stringBuilder.length() + 1)) * getValue('z')) <= 0) {
                sum += getValue(current);
                stringBuilder.append(current);
                if(sum - k == 0) {
                    break;
                }
            }
            current++;
        }
        return stringBuilder.toString();
    }

    int getValue(char current) {
        return current - 'a' + 1;
    }

    public static void main(String[] args) {
        new SmallestStringWithAGivenNumericValue().getSmallestString(5, 73);
    }
}
