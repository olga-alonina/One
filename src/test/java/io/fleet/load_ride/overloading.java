package io.fleet.load_ride;

public class overloading {
    private static final int number = 0;

    public overloading(int i) {
        System.out.println("its a overloading constructor");
    }


    public static String overloading(int num) {
        System.out.println("its mama");
        final String str = "ola";
        System.out.println("hello world");
        return str;
    }

    private static Integer overloading(String str) {
        Integer num = 0;
        return num;
    }

    protected static void overloading(String str, int num) {

    }

    static void overloading(String str, int num, double salary) {
    }
}
