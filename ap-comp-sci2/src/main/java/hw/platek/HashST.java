import java.util.HashSet;
import java.util.Set;


public class HashST<Key,Value>{

    private static  class Node{
	private Object key;
	private Object value;
	private Node next;

	public Node(Object key, Object value, Node next){
	    this.key = key;
	    this.value = value;
	    this.next = next;
	}

    }

    // instance variables
    private int m;   // # of buckets
    private Node[] buckets;
    private HashSet<Key> keys;
   
    
    
    public HashST(int capacity){
	m = capacity;
	buckets = new Node[m];
	keys = new HashSet<Key> ();
    }


    public int size(){ return keys.size(); }


    public int hash(Object key){
	return Math.abs(key.hashCode()) % m;
    }


    public boolean containsKey(Key key){
	return keys.contains(key);
    }

    public Set<Key> getKeys(){
	return keys;
    }

   
    
    private Node getNode(Key key){
	return null;
    }

    public Value get(Key key){
	return null;
     }
    
    public Value put(Key key, Value value){
	return null;
     }


    public Value remove(Key key){
	return null;
    }

    
    public void printTable(){
	for (int i = 0; i < m; i++){
	    System.out.print("[" + i + "] : " );
	    for (Node p = buckets[i] ; p != null; p = p.next){
		System.out.print( p.key + " : " + p.value + " ");
	    }
	    System.out.println();
	}

    }

    public String toString(){
	String ans = "{";
	for (Key key: keys){
	    ans += "[" + key + "=" + get(key) + "],";
	}
	if (size() > 0) ans = ans.substring(0,ans.length() - 1);
	ans += "}";
	return ans;

    }
    
    public static void main(String [] args){
	HashST<String, Integer> d = new HashST<String, Integer> (5);
	d.printTable();
	System.out.println(d);
    }

    
    
    

}
