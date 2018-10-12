package enums;

public enum CompareValues {
    BIGGER(" ^^^Bigger"), LOWER(" ...lower"), EQUALS(" = equals"), NOT_A_NUMBER(" ?? not a number");
    public final String value;

    CompareValues(String value) {
        this.value = value;
    }
}
