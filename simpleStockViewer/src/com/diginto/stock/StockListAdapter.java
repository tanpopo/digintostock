package com.diginto.stock;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class StockListAdapter extends ArrayAdapter<Stock> {

	private int resourceId;

	public StockListAdapter(Context context, int resourceId) {
		super(context, resourceId);
		this.resourceId = resourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Stock stock = (Stock)getItem(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(resourceId, null);
		}
		TextView nameView = (TextView)convertView.findViewById(R.id.name);
		nameView.setText(stock.getName());

		TextView currentValueView = (TextView)convertView.findViewById(R.id.currentValue);
		currentValueView.setText(Integer.toString(stock.getCurrentValue()));
		return convertView;
	}

}
