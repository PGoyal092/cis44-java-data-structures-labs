import java.util.LinkedList;

class LinkedQueue<T> implements Queue<T>{
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T t){
        list.add(t);
    }
    public T dequeue(){
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}