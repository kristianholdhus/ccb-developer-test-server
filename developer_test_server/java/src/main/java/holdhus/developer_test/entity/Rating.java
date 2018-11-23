package holdhus.developer_test.entity;

public enum Rating {

    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private final String value;

    Rating(String value) {
        this.value = value;
    }

    public String getStringValue() {
        return value;
    }

    public static Rating fromStringValue(String string) {
        for (Rating rating: Rating.values()) {
            if (rating.getStringValue().equals(string)) {
                return rating;
            }
        }
        throw new IllegalStateException("Encountered unknown Rating string: " + string);
    }
}
