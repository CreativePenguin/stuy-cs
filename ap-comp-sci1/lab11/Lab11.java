public class Lab11 {
    
    private boolean endsWith(String str, String suffix) {
        return str.substring(
                str.length() - suffix.length()
            ).equals(suffix);
    }

    private int indexOf(String receiver, String sub, int fromIndex) {
        for(int i = fromIndex; i < receiver.length() - sub.length(); i++) {
            String idealString = receiver.substring(i, i + sub.length());
            if(idealString.equals(sub)) return i;
        }
        return -1;
    }

    private int indexOf(String receiver, String sub) {
        return indexOf(receiver, sub, 0);
    }

    private boolean contains(String receiver, String sub) {
        return !(indexOf(receiver, sub) == -1);
    }

    private String createOrdinalForm(int input) {
        if(input == 1) return input + "st";
        if(input == 2) return input + "nd";
        if(input == 3) return input + "rd";
        else return input + "th";
    }

    public static void main(String[] args) {
        Lab11 lab = new Lab11();
        System.out.println(lab.endsWith("lab.txt", "txt"));
        System.out.println(lab.endsWith("lab.txt", "TXT"));
        System.out.println(lab.endsWith("lab.txt", ".txt"));

        System.out.println();

        System.out.println(lab.indexOf("chicken", "ick"));
        System.out.println(lab.indexOf("mississippi", "i"));
        System.out.println(lab.indexOf("mississippi", "ip"));
        System.out.println(lab.indexOf("cat", "A"));
        System.out.println(lab.indexOf("mississippi", "i", 2));

        System.out.println();

        System.out.println(lab.contains("cat", "a"));
        System.out.println(lab.contains("stuypulse", "stuy"));
        System.out.println(lab.contains("stuyvesant", "bs"));

        System.out.println();

        System.out.println(lab.createOrdinalForm(1));
        System.out.println(lab.createOrdinalForm(2));
        System.out.println(lab.createOrdinalForm(3));
        System.out.println(lab.createOrdinalForm(4));
    }
}
