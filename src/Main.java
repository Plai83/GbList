import gb_collections.GbList;
import gb_collections.lists.GbArrayList;

public class Main {
    public static void main(String[] args) {
        GbList<Integer> list = new GbArrayList<>();
        list.add(5);
        list.add(6);
        list.add(77);
        list.add(8);
        System.out.println(list.size());
        System.out.println(list);
        list.remove(77);
        System.out.println(list);
//        list.removeByIndex(67);
    }
}
