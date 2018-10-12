package mvc;

public enum CompareValues {
    BIGGER(" ^^^Bigger"),LOWER(" ...lower"),EQUALS(" = equals"), NOT_A_NUMBER (" ?? not a number");
    String value;
    CompareValues(String value){
        this.value=value;
    }
}
