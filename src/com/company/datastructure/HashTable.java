package org.training.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO: singleton hash table
 */
public class HashTable<Integer, V> {
    private final int SIZE = 4231;
    private final ArrayList<Pair<Integer, V>>[] arr = new ArrayList[SIZE];

    final private static HashTable<Object, Object> hashTable = new HashTable<>();

    private HashTable() {
    }

    public static HashTable getInstance() {
        return hashTable;
    }

    private int my_hash(int key) {
        final int p1 = 2803;
        final int p2 = 1741;
        return ((key * p1) + p2) % arr.length;
    }

    public void insert(Pair<Integer, V> pair) {
        int hash = my_hash((int) pair.first());
        if (arr[hash] == null) {
            arr[hash] = new ArrayList<>();
        }
        arr[hash].add(pair);
    }

    public List<Pair<Integer, V>> getKey(int key) {
        int hash = my_hash(key);
        if (arr[hash] == null) {
            return List.of();
        }
        return arr[hash].stream().toList();
    }

}

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashTable<Integer, String> ht = HashTable.getInstance();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            Pair<Integer, String> temp = new Pair<>();
            temp.setPair(Integer.valueOf(line[0]), line[1]);
            ht.insert(temp.getPair());
        }
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            for (Pair<Integer, String> it : ht.getKey(scanner.nextInt())) {
                System.out.printf("[%s, %s] ", it.first(), it.second());
            }
            System.out.println();
        }
    }
}

class Pair<Integer, V> {
    private Integer key;
    private V value;

    public Pair() {
    }

    public void setPair(Integer key, V value) {
        this.key = key;
        this.value = value;
    }

    public Pair<Integer, V> getPair() {
        return this;
    }

    public Integer first() {
        return this.key;
    }

    public V second() {
        return this.value;
    }
}