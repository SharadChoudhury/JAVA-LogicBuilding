package maps;

import java.util.ArrayList;

public class Map <K, V> {
	ArrayList<MapNode<K, V>> buckets;
	int size;
	int numBuckets;
	public Map() {
		numBuckets = 5;
		buckets = new ArrayList<>();
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		return hashCode % numBuckets;
	}
	
	public int size() {
		return size;
	}
	
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while (head != null) {
			if (head.key.equals(key)) {
				size--;
				if (prev == null) {
					buckets.set(bucketIndex, head.next);
				} else {
					prev.next = head.next;
				}
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
	
	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		while (head != null) {
			// case when element already exists in map, just update value
			if (head.key.equals(key)) {  //equals is used and not == as we are comparing the object
				//value not the address
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		//if not present create a new node
		head = buckets.get(bucketIndex);
		MapNode<K, V> newElementNode = new MapNode<K, V>(key , value);
		size++;
		newElementNode.next = head;
		buckets.set(bucketIndex, newElementNode);
	}
}
