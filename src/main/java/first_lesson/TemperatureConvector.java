package first_lesson;

public class TemperatureConvector {
    public static void main(String[] args) {
        System.out.println(toDel1(10));
        System.out.println(toKel(10));
        System.out.println(toNut(10));
        System.out.println(toRan(10));
        System.out.println(toReo(10));
        System.out.println("------------------------");
        System.out.println(toNut(1));
        System.out.println(toKel(1));
        System.out.println(toDel1(1));
        System.out.println(toRan(1));
        System.out.println(toReo(1));
    }

    private static double toDel1(double t) {
        return 100 - t / 1.5;
    }

    private static double toKel(double t) {
        return 273.15 + t;
    }

    private static double toNut(double t) {
        return t / 3.03;
    }

    private static double toRan(double t) {
        return 491.67 + t * 1.8;
    }

    private static double toReo(double t) {
        return t * 0.8;
    }

}
