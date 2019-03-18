package hw;

public class Hw04 {

    public class Anagrams {

        public String randomString(int n) {
            String ans = "";
            for (int i = 0; i < n ; i++) {//O(n)
                int r = 'a' + (int)(Math.random() * ('z' - 'a')); //O(1)
                ans +=  (char)r; //O(1)
            }
            
            return ans;
        }

        public String shuffle(String s) {
            String ans = "";
            int n = s.length();
            for (int i = 0; i < n; i++) { //O(n)
                int r = (int)(Math.random() * s.length());//O(1)
                ans += s.substring(r,r+1); //O(1)
                s = s.substring(0,r) + s.substring(r+1); //O(1)
            }
            return ans;
        }



        public boolean isAnagram(String a, String b) {
            if(a.length() != b.length()) return false;
            for(int i = 0; i < b.length(); i++) {
                int tempVal = b.indexOf(a.substring(i, i + 1));
                if(tempVal ==  -1) return false;
                b = b.substring(0, tempVal) + (tempVal + 1);
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Hw04.Anagrams hw = new Hw04().new Anagrams();
        hw.isAnagram("tacocat", "cattaco");
        hw.isAnagram("Stuypulse", "StewiePlus");
        hw.isAnagram("door", "odor");
    }
}
