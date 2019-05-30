import java.util.HashSet;
import java.util.Set;


public class HashST<K,V>{

  private static class Node{
    private Object key;
    private Object value;
    private Node next;

    public Node(Object key, Object value, Node next){
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public Object getKey() {
      return key;
    }

    public Object getValue() {
      return value;
    }

    public Node getNext() {
      return next;
    }

    public void setValue(Object val) {
      value = val;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    @Override
    public String toString() {
      if(getNext() == null) return key + " : " + value;
      return key + " : " + value + getNext().toString();
    }
  }

  // instance variables
  private int m;   // # of buckets
  private Node[] buckets;
  private HashSet<K> keys;
    
  public HashST(int capacity){
    m = capacity;
    buckets = new Node[m];
    keys = new HashSet<K> ();
  }

  public int hash(Object key){
    return Math.abs(key.hashCode()) % m;
  }

  public int size() {
    return m;
  }

  public boolean containsKey(K key) {
    return keys.contains(key);
  }

  public Set<K> getKeys() {
    return keys;
  }

  private Node getNode(K key) {
    return buckets[hash(key)];
  }

  public V get(K key) {
    if(keys.contains(key)) {
      Node tmp = buckets[hash(key)];
      if(tmp.getKey() == key) {
        return (V) tmp.getValue();
      }
      else {
        return get(key, tmp.getNext());
      }
    }
    return null;
  }

  public V get(K key, Node node) {
    if(node.getKey() == key) return (V) node.getValue();
    else return get(key, node.getNext());
  }

  public V put(K key, V value) {
    Node tmp = buckets[hash(key)];
    if (tmp == null) buckets[hash(key)] = new Node(key, value, null);
    return put(key, value, tmp);
  }

  private V put(K key, V value, Node node) {
    if(node.getKey() == key) {
      node.setValue(value);
      return (V) node.getValue();
    }
    if(node.getNext() == null) {
      node.setNext(new Node(key, value, null));
      keys.add(key);
      return null;
    }
    return put(key, value, node.getNext());
  }

  public void printTable() {
    int counter = 0;
    for(var i : buckets) {
      System.out.print("[" + counter + "]" + " : ");
      System.out.println(buckets);
    }
  }
    
  public static void main(String [] args){
    HashST<String, Integer> d = new HashST<String, Integer> (13);
  }

}
