public class DynamicArray<T>{
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public DynamicArray(){
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    public void add(T element){
        if(size == data.length){
            resize(2*data.length);
        }
        data[size] = element;
        size++;
    }

    private void resize(int newCapacity){
        T[] temp = (T[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public T get(int index) throws IndexOutOfBoundsException{
        return data[index];
    }
    public T remove(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        T temp = data[index];
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }
    public int size(){
        return size;
    }
}