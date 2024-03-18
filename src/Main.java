import gb_collections.GbList;
import gb_collections.lists.GbArrayList;
import gb_collections.lists.GbLinkedList;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GbList<String> list = new GbLinkedList<>();
        list.add("5");
        list.add("4");
        list.add("6");
        list.add("7");
        list.add("8");

        System.out.println(list);
        list.removeByIndex(0);
        System.out.println(list);
        list.removeByIndex(0);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.add(3, "hello");
        System.out.println(list);
        list.add(2, "word");
        System.out.println(list);

    }
}
