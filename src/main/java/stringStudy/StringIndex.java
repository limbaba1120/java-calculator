package stringStudy;

public class StringIndex {

    private String value;


    public StringIndex(String value) {
        this.value = value;
    }

    public char findCharAt(int index) {
        return this.value.charAt(index);
    }

}
