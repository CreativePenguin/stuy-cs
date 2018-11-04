public class ReverseString {

    private String reverseL(String input) {
        String val = "";
        for(int i = 0; i < input.length(); i++)
            val = input.substring(i, i+1) + val;
        return val;
    }

    private String reverseR(String input) {
        int len = input.length();
        return (len <= 1) ? input : 
            input.substring(len - 1) + reverseR(input.substring(0, len - 1));
    }

}
