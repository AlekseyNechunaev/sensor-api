package ru.nechunaev.constants;

public final class Paths {

    private Paths() {

    }

    private static final String API = "/api/v1";

    public static class Sensors {

        public static final String SENSOR = API + "/sensor";

        public static final String GET_ONE = "/{id}";
    }

    public static class Measurements {

        public static final String MEASUREMENT = API + "/measurement";

        public static final String GET_ONE = "/{id}";

        public static final String RAINY = "/rainy";
    }
}
