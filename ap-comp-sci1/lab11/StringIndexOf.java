public class StringIndexOf {
    
    private int indexOf(String receiver, String sub, int fromIndex) {
        for(int i = fromIndex; i < receiver.length(); i++) {
            String idealString = receiver.substring(i, i + sub.length());
            if(idealString.equals(sub)) return i;
        }
        return -1;
    }

    private int indexOf(String receiver, String sub) {
        return indexOf(receiver, sub, 0);
    }

}
