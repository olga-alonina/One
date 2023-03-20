package io.fleet.load_ride;


import static io.fleet.load_ride.overriding.*;

public class SameClass {

    public static void main(String[] args) {
        new overriding();
        new overloading(25);
        overloading.overloading(25);
        anna(6);
        ola(78);
        dan(34);
    }
}
