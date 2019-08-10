package com.wxluo.cache;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class SyncMap<TKey, TValue> implements Map<TKey, TValue>,Cloneable{

	private Lock syncLock = new ReentrantLock();
	
	private Map<TKey, TValue> map;
	
	public SyncMap() {
		map =  new HashMap<TKey, TValue>();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = map.containsKey(key);
		return result;
	}

	@Override
	public boolean containsValue(Object value) {
		boolean result = false;
		result = map.containsValue(value);
		return result;
	}

	@Override
	public synchronized TValue get(Object key) {
		TValue value = null;
		value = map.get(key);
		return value;
	}

	@Override
	public synchronized TValue put(TKey key, TValue value) {
		TValue result = null;
		result = map.put(key, value);
		return result;
	}

	@Override
	public synchronized TValue remove(Object key) {
		TValue result = null;
		result = map.remove(key);
		return result;
	}

	@Override
	public synchronized void putAll(Map<? extends TKey, ? extends TValue> m) {
		map.putAll(m);	
	}

	@Override
	public synchronized void clear() {
		map.clear();		
	}

	@Override
	public synchronized Set<TKey> keySet() {
		Set<TKey> result = null;
		map.keySet();
		return result;
	}

	@Override
	public synchronized Collection<TValue> values() {
		Collection<TValue> result = null;
		result = map.values();
		return result;
	}

	@Override
	public synchronized Set<java.util.Map.Entry<TKey, TValue>> entrySet() {
		Set<Map.Entry<TKey, TValue>> result = null;
		result = map.entrySet();
		return result;
	}	
}