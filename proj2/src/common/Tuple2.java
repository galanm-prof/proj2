package common;

public class Tuple2<T,S> {
    private T field1;
    private S field2;
    public Tuple2(T field1, S field2){
        this.field1=field1;
        this.field2=field2;
    }

    public T getField1() {
        return field1;
    }

    public S getField2() {
        return field2;
    }


    @Override
    public String toString() {
        return "Tuple{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                '}';
    }
}
