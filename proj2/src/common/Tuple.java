package common;

import java.util.HashSet;
import java.util.Set;

public class Tuple<T,S,U,V> {
    private T field1;
    private S field2;
    private U field3;
    private V field4;
    public Tuple(T field1, S field2, U field3,V field4){
        this.field1=field1;
        this.field2=field2;
        this.field3=field3;
        this.field4=field4;
    }

    public T getField1() {
        return field1;
    }

    public S getField2() {
        return field2;
    }

    public U getField3() {
        return field3;
    }

    public V getField4() {
        return field4;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                ", field3=" + field3 +
                ", field4=" + field4 +
                '}';
    }
}
