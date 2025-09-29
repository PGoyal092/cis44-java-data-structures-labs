public class Main{
    public static void main(String[] args){
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        list.addFirst("London");
        list.addFirst("New York");
        list.addFirst("Washington");

        System.out.println(list);
        for(String s: list){
            System.out.println(s);
        }
        Position<String> posB = list.after(list.first());
        list.remove(posB);
        System.out.println(list);
    }
}
