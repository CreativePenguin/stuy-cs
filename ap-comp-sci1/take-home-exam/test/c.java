public class CommentedFile {
    //This here is a test comment that will hopefully be removed.
    public static void main(String[] args) {
	/*This here is a multi-
line comment that the editor shouldn't
have a problem removing*/
	System.out.println("generic statement");
	//Woah it's a print line statement
	System.out.println("generic statement"); /*whaaaat that line doesn't seem to  make sense*/
 woah	System.out.println("generic statement");//waoh, we got a shakespeare in the house
	System.out.println("generic statement");
	/*woah!
	  that was an amazing essay*/
	System.out./*woops*/println("generic statement");
    }
}
