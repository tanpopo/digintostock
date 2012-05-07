package com.diginto.stock;

import java.util.Iterator;
import java.util.Set;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TargetQuoteListAdapter extends ArrayAdapter<String> {

	private final String TAG = "TargetQuoteListAdapter";
	private int resourceId;

	public TargetQuoteListAdapter(Context context, int resourceId) {
		super(context, resourceId);
		this.resourceId = resourceId;
	}

	public void init() {
		this.clear();
        Set<String> symbols = TargetQuoteList.getInstance().getAllItems();
        for (Iterator i = symbols.iterator(); i.hasNext();) {
	        this.add((String)i.next());
        }
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(resourceId, null);//データ1つ分の表示領域
		}

		String symbol = (String)getItem(position);
		if (symbol != null) {
			convertView.setTag(symbol);
			Log.i(TAG, "getView(): pos=" + position + ", symbol=" + symbol);
		} else {
			Log.e(TAG, "getView(): quote is not found");
		}

		TextView view = (TextView)convertView.findViewById(R.id.targetQuoteSymbol);
		view.setText(symbol);

		return convertView;
	}

}
