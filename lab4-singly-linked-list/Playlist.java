public class Playlist {
    private static class Node {
        Song song;
        Node next;
        // Node constructor...
        Node(Song song){
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        // Your implementation here...
        Node newNode = new Node(song);
        if(head == null){
            head=tail=newNode;
        } else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }

    public void removeSong(String title) {
        // Handle two cases: removing the head and removing from elsewhere.
        // Don't forget to update the tail if the last song is removed.
        if(head == null){
            return;
        }
        if(head.song.getTitle().equals(title)){
            if(currentNode==head){
                currentNode=head.next;
                head=head.next;
            }
            if(head==null){
                tail = null;
            }
            size--;
            return;
        }
        Node prev=head;
        Node curr=head.next;
        while(curr!=null){
            if(curr.song.getTitle().equals(title)){
                if(currentNode==curr){
                    currentNode=curr.next;
                }
                prev.next = curr.next;
                if(curr==tail){
                    tail=prev;
                }
                size--;
                return;
            }
            prev=curr;
            curr=curr.next;
        }
    }

    public void playNext() {
        // If currentNode is null, start from the head.
        if(currentNode==null){
            currentNode=head;
        }
        // Otherwise, advance to the next node.
        else{
            currentNode=currentNode.next;
            if(currentNode==null){
                currentNode=head;
            }
        }
        // If you reach the end, loop back to the head.
        if(currentNode!=null){
            System.out.println("Playing: "+currentNode.song);
        }
        else{
            System.out.println("Nothing to play");
        }
    }

    public void displayPlaylist() {
        // Traverse from the head and print each song.
        Node temp = head;
        System.out.println("Playlist:");
        while(temp!=null){
            System.out.println("- "+temp.song);
            temp = temp.next;
        }
        if(size==0){
            System.out.println("Nothing");
        }
    }
}