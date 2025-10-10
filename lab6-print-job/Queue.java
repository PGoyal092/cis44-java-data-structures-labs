// You will need a functioning Queue implementation (like LinkedQueue) for this to work.
// interface Queue { ... }
// class LinkedQueue implements Queue { ... }
public interface Queue<T>{
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
}

