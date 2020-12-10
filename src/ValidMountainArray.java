public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        int n = arr.length;
        if (n <= 2) {
            return false;
        }
        int i = 0, j = n - 1;
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        while (j > 0 && arr[j - 1] > arr[j]) {
            j--;
        }
        return i != 0 && i == j && j != n - 1;
    }

}
