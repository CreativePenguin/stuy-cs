public class RemoveSub {

    private void RemoveAll(ArrayList<String> list, String x) {
	for(String s : list) {
	    if(s.equals(x)) list.remove(s);
	}
    }

}
