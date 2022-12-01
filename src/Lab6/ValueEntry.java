package Lab6;

public class ValueEntry {
    int key ;
    String value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ValueEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
