package com.diginto.stock;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.util.Log;

public class StockListAdapter extends ArrayAdapter<StockQuote> {

	private final String TAG = "StockListAdapter";

	private int resourceId;

	public StockListAdapter(Context context, int resourceId) {
		super(context, resourceId);
		this.resourceId = resourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(resourceId, null);//データ1つ分の表示領域
		}

		StockQuote quote = (StockQuote)getItem(position);
		if (quote != null) {
			convertView.setTag(quote);
			Log.i(TAG, "getView(): pos=" + position + ", symbol=" + quote.getSymbol());
		} else {
			Log.e(TAG, "getView(): quote is not found");
		}
		StockQuoteUpdateTask task = new StockQuoteUpdateTask(convertView);
		task.execute();
		return convertView;
	}

	static void setupView(View view, StockQuote quote) {
		TextView idView = (TextView)view.findViewById(R.id.id);
		idView.setText(quote.getSymbol());

		TextView currentValueView = (TextView)view.findViewById(R.id.currentValue);
		currentValueView.setText(Double.toString(quote.getLastTradePrice()));

		TextView diffValueView = (TextView)view.findViewById(R.id.diffValue);
		diffValueView.setText(Double.toString(quote.getChangeRealtime()));

		TextView diffRateView = (TextView)view.findViewById(R.id.diffRate);
		diffRateView.setText(Double.toString(quote.getChangePercent()));
	}

}
