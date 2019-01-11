public class TokenScanner{
    
    // private instance variables
    private String input;      // String to scan
    private int cp;	       // current position
    private boolean ignoreWhitespaceFlag;


    // default constructor
    public TokenScanner() {}
    
    // constructor
    public TokenScanner(String input) {
        this.input = input;
        cp = 0;
        ignoreWhitespaceFlag = false;
    }


    // resets the input and cp
    public void setInput(String input) {
        this.input = input;
        cp = 0;
    }

    // returns true when input contains unprocessed tokens
    public boolean hasMoreTokens() {
        return cp == input.length();
    }

    
     public void ignoreWhitespace() {
         ignoreWhitespaceFlag = true;
     }

    // Skips over any whitespace characters before the next token.
    private void skipWhitespace() {
        
    }

    // Assumes string does not contain a floating point number.
    // Returns the nextToken() if there is no next token then return
    // an empty string.
    public String nextToken() {
        if(input.substring(cp, cp + 1).equals(" ") && !ignoreWhitespaceFlag) return " ";
        String val = "";
        for(int i = cp; i < input.length(); i++) {
            if(input.substring(i, i + 1).equals(" ")) return val;
            val += input.substring(i, i + 1);
        }
        return val;
    }

}
