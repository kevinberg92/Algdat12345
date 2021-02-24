import java.util.ArrayList;

//Ex02
public class ImmutableList<T> {

    private final int size;
    private final int index;
    private final Object[] data;


    public ImmutableList() {
        this(10, 0,0);
    }

    public ImmutableList(int capacity, int size, int index) {
        data = new Object[capacity];
        this.size = size;
        this.index = index;
    }

    public int size() {
        return size;
    }

    public ImmutableList<T> delete(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        data[index]=null;

        for(int i = index; i < size-1; i++){
            data[i] = data[i+1];
        }

        return new ImmutableList<T>(10, size, index);
    }

    //Exercise 2 states that this is the correct method signature.
    public ImmutableList<T> add(T value) {
       if(index < 0 || index > size) {
           throw new IndexOutOfBoundsException();
       }

       for(int j=size-1; j>=index; j--){
           data[j+1] = data[j];
       }
       data[index] = value;

       return new ImmutableList<T>(10, size, index);
    }

    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }

}
