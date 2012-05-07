package com.diginto.stock;

import java.util.*;

public class TargetQuoteList {

//	private static final String dummyTargetQuotes[] = {"GOOG", "YHOO", "SNE"};

	private static final TargetQuoteList instance = new TargetQuoteList();
	private HashSet<String> items = new HashSet<String>();

	private void dummySetup() {
		items.add("GOOG");
		items.add("YHOO");
		items.add("SNE");
	}
	private TargetQuoteList() {
		dummySetup();
	};

	public static TargetQuoteList getInstance() {
		return instance;
	}

	public Set<String> getAllItems() {
		return items;
	}
	public int add(String quote) {
		return items.add(quote) ? 0 : -1;//HashSet.add returns true if it is not already present and added successfully.
	}
	public int remove(String quote) {
		return items.remove(quote) ? 0 : -1;
	}
	public int size() {
		return items.size();
	}


}
