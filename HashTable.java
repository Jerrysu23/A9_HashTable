package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a hash table of Strings (not generic). 
 * All operations are O(1).
 * Collisions are handled using linear probing.
 * 
 * @author Jiayu Luo & Junlin Su 
 * @version April 7, 2021
 */
public class HashTable<K, V> implements Map<K, V>{
	
	// backing array
	private ArrayList<LinkedList<MapEntry<K, V>>> table;

	// number of items in the hash table
	private int numOfItems;
	private int capacity = 16;

	/**
	 * Creates a new hash table with a user-provided capacity.
	 * 
	 */
	public HashTable() {
		
		table = new ArrayList<LinkedList<MapEntry<K, V>>>(capacity);
		for(int i = 0; i < capacity; i++)
			table.add(new LinkedList<MapEntry<K, V>>());
		numOfItems = 0;
	}
	
	/**
	 * @return the number of items stored in this hash table
	 */
	public int size() {
		return numOfItems;
	}	
	

	/**
	 * Removes all mappings from this map.
	 * 
	 * O(table length)
	 */
	@Override
	public void clear() {
		if(!this.isEmpty()) {
			for(int i = 0; i < capacity; i++)
			table.add(new LinkedList<MapEntry<K, V>>());
		}
		
		numOfItems = 0;
	}

	/**
	 * Determines whether this map contains the specified key.
	 * 
	 * O(1)
	 * 
	 * @param key
	 * @return true if this map contains the key, false otherwise
	 */
	@Override
	public boolean containsKey(K key) {
		if(this.isEmpty())
			return false;
		int index = Math.abs(key.hashCode()) % table.size();
		LinkedList<MapEntry<K,V>> list = table.get(index);
		if(list.size() == 0)
			return false;
		for(MapEntry<K,V> map: list) {
			if(map.getKey().equals(key))
				return true;
		}
		return false;
	}

	/**
	 * Determines whether this map contains the specified value.
	 * 
	 * O(table length)
	 * 
	 * @param value
	 * @return true if this map contains one or more keys to the specified value,
	 *         false otherwise
	 */
	@Override
	public boolean containsValue(V value) {
		if(this.isEmpty())
			return false;
		List<MapEntry<K, V>> entries = entries();
		for(MapEntry<K, V> map: entries) {
			if(map.getValue().equals(value))
				return true;
		}
		return false;
	}

	/**
	 * Returns a List view of the mappings contained in this map, where the ordering of 
	 * mapping in the list is insignificant.
	 * 
	 * O(table length)
	 * 
	 * @return a List object containing all mapping (i.e., entries) in this map
	 */
	@Override
	public List<MapEntry<K, V>> entries() {
		List<MapEntry<K,V>> entries = new ArrayList<>();
		for (LinkedList<MapEntry<K,V>> list: table) {
			 for (MapEntry<K,V> map: list) {
				 entries.add(map);
			 }
		}
		return entries;
	}

	/**
	 * Gets the value to which the specified key is mapped.
	 * 
	 * O(1)
	 * 
	 * @param key
	 * @return the value to which the specified key is mapped, or null if this map
	 *         contains no mapping for the key
	 */
	@Override
	public V get(K key) {
		int index = Math.abs(key.hashCode()) % table.size();
		LinkedList<MapEntry<K,V>> list = table.get(index);
		if(list.size() == 0) {
			return null;
		}
		for(MapEntry<K,V> map: list) {
			if(map.getKey().equals(key))
				return map.getValue();
		}
		return null;
	}

	/**
	 * Determines whether this map contains any mappings.
	 * 
	 * O(1)
	 * 
	 * @return true if this map contains no mappings, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return numOfItems == 0;
	}

	/**
	 * Associates the specified value with the specified key in this map.
	 * (I.e., if the key already exists in this map, resets the value; 
	 * otherwise adds the specified key-value pair.)
	 * 
	 * O(1)
	 * 
	 * @param key
	 * @param value
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key
	 */
	@Override
	public V put(K key, V value) {
		int remainder = Math.abs(key.hashCode()) % table.size();
		LinkedList<MapEntry<K,V>> list = table.get(remainder);
		
		if(list.size() == 0) {
			list.add(new MapEntry<K,V>(key, value));
			numOfItems++;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getKey().equals(key)) {
				V prevValue = list.get(i).getValue();
				list.get(i).setValue(value);
				return prevValue;
			}
			else {
				list.add(new MapEntry<K,V>(key, value));
				numOfItems++;
			}
		}

		if(numOfItems /(double) capacity >= 10.0) {
			rehash();
		}
		return null;
	}

	/**
	 * 
	 */
	private void rehash() {
		ArrayList<LinkedList<MapEntry<K, V>>> temp = table;
		capacity = capacity *2;
		table = new ArrayList<LinkedList<MapEntry<K, V>>>(capacity);	
		clear();
		for(LinkedList<MapEntry<K,V>> list : temp) {
			for(MapEntry<K,V> map : list) {
				this.put(map.getKey(), map.getValue());					
			}
		}
	}
	
	/**
	 * Removes the mapping for a key from this map if it is present.
	 * 
	 * O(1)
	 *
	 * @param key
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key
	 */
	@Override
	public V remove(K key) {
		int index = Math.abs(key.hashCode()) % table.size();
		LinkedList<MapEntry<K,V>> list = table.get(index);
		if(list.size() == 0) {
			return null;
		}
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getKey().equals(key)) {
				V prevValue = list.get(i).getValue();
				list.remove(list.get(i));
				numOfItems--;
				return prevValue;
			}
		}
		return null;
	}
}