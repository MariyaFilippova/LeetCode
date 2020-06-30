public class AngleBetweenHandsofaClock {
    public double angleClock(int hour, int minutes) {
        double a = hour % 12 * 30;
        double b = minutes * 6;
        a += (double)minutes/60 * 30;
        return Math.abs(a - b) < 180 ? Math.abs(a - b) : 360 - Math.abs(a - b);
    }

    public static void main(String[] args) {
        new AngleBetweenHandsofaClock().angleClock(12, 30);
    }
}
