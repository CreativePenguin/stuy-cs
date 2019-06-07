package hw;

public final class Lab065MathSet<K> {

    private int size;
    private K[] universe;

    public Lab065MathSet(K[] universe) {
        size = universe.length;
        this.universe = universe;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(K key) {
        for(K i : universe) {
            if(i == key) return true;
        }
        return false;
    }

    public boolean add(K key) {
        if(contains(key)) return false;
        universe[++size] = key;
        return true;
    }

    public boolean delete(K key) {
        int index = 0;
        for(K i : universe) {
            if(i == key) {
                swap(index, size - 1);
                universe[size - 1] = null;
                size--;
                return true;
            }
            index++;
        }
        return false;
    }

    public void union(Lab065MathSet<K> a) {
        for(K i : universe) {
            if(!a.contains(i)) a.add(i);
        }
    }

    private void swap(int i1, int i2) {
        K tmp = universe[i1];
        universe[i1] = universe[i2];
        universe[i2] = tmp;
    }

}
