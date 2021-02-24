package Tasks.lesson_12.by.yurachel.methodichka_28.entity;

public class Values<T extends Number> {
    private T[] array;

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public T getAnyNumber(int index) {
        if (index < 0 || index >= array.length) {
            System.out.println("Wrong index.");
        } else {
            return array[index];
        }

        return null;
    }


    //    private List<T> values;
//
//    {
//        values = new ArrayList<>();
//    }
//
//    public List<T> getValues() {
//        return values;
//    }
//
//    public void setValues(List<T> values) {
//        this.values = values;
//    }
//
//    public void addValues(T value) {
//        values.add(value);
//    }
//
//    public void getAnyValue(int index) {
//        if (index > values.size() || index < 0) {
//            System.out.println("Wrong index.");
//        } else {
//            System.out.println(values.get(index));
//        }
//    }

}
