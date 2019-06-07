package hw;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class WordCollection {

    private List<String> collection;

    public WordCollection() {
        this(new String[] {});
    }

    public WordCollection(String[] words) {
        collection = new ArrayList<>();
        for(String i : words) {
            collection.add(i);
        }
        collection.sort( (n, k) -> n.compareTo(k));
    }

    public String findKth(int k) {
        collection.sort( (n, a) -> n.compareTo(a));
        return collection.get(k);
    }

    //O(N)
    public void insert(String word) {
        collection.add(word);
        collection.sort( (n, k) -> n.compareTo(k));
    }

    //O(N)
    public int indexOf(String word) {
        int i = 0;
        for(ListIterator<String> iter = collection.listIterator(); iter.hasNext();) {
            if(iter.next().equals(word)) { return i; }
            i++;
        }
        return -1;
    }

    //O(n)
//    public void remove(String word) {
//        for(ListIterator<String> iter = collection.listIterator(); iter.hasNext(); ) {
//            if(iter.next().compareTo(word) == 0) { iter.remove(); }
//        }
//    }
//
    public void remove(String word) {
        collection.remove(word);
    }

    public String toString() {
        return collection.toString();
    }

    public ListIterator<String> listIterator() {
        return collection.listIterator();
    }

    public static int occurences(WordCollection C, String word) {
        WordCollection a = C;
        int i = 0;
        while(a.indexOf(word) != -1) {
            a.remove(word); i++;
        }
        return i;
    }

    public static void removeDuplicates(WordCollection C, String word) {
        while(occurences(C, word) > 1) {
            C.remove(word);
        }
    }
    
    public static String mostCommon(WordCollection C) {
        int i = 0;
        String val = "";
        for(ListIterator<String> iter = C.listIterator(); iter.hasNext();) {
            String next = iter.next();
            if(occurences(C, next) > i) {
                i = occurences(C, next);
                val = next;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        WordCollection wc = new WordCollection(new String[] {"Hi", "this", "sucks"});
        WordCollection wa = new WordCollection(new String[] {"a", "b", "c", "f", "d", "j", "a", "a", "c", "a", "b"});
        System.out.println(wc);
        System.out.println(wa);
        System.out.println(occurences(wa, "a"));
    }

}
