package ru.nechunaev.constants;

public final class Paths {

    private Paths() {

    }

    public static class Sensors {

        public static final String SENSOR = "/sensor";

        public static final String ADD = SENSOR + "/registration";

        public static final String GET_ONE = SENSOR + "{id}";
    }

    public static class Measurements {

        public static final String MEASUREMENT = "/measurement";

        public static final String GET_ONE = MEASUREMENT + "/{id}";

        public static final String RAINY = MEASUREMENT + "/rainy";
    }
}
