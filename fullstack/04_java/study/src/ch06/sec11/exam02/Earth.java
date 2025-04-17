package ch06.sec11.exam02;

public class Earth {
    static final double PI = 3.141592;
    static final double EARTH_RADIUS = 6400;
    static final double EARTH_SURFACE_AREA;

    static {
        EARTH_SURFACE_AREA = 4 * PI * EARTH_RADIUS * EARTH_RADIUS;
    }
}
