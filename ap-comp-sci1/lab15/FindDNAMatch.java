public class FindDNAMatch {
    public int findDNAMatch(String s1, String s2, int start) {
	String s2u = s2.toUpperCase();
	int lens2 = s2.length();
	for(int i = start; i < s1.length() - lens2; i++) {
	    if(s1.substring(i, i + lens2).toUpperCase().equals(s2u))
		return i;
	}
	return -1;
    }

    public int findDNAMatch(String s1, String s2) {
	return findDNAMatch(s1, s2, 0);
    }

    private String DNAMatch(String s1) {
	String val = "";
	for(int i = 0; i < s1.length(); i++) {
	    String s = s1.substring(i, i + 1);
	    if(s.toUpperCase().equals("A")) val += "T";
	    if(s.toUpperCase().equals("T")) val += "A";
	    if(s.toUpperCase().equals("C")) val += "G";
	    if(s.toUpperCase().equals("G")) val += "C";
	}
	return val;
    }
}
