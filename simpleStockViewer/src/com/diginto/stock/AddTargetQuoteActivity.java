package com.diginto.stock;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.util.Log;
import java.util.*;

public class AddTargetQuoteActivity extends Activity {
	static final String TAG = "AddTargetQuoteActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);

        setContentView(R.layout.add_target_quote);

		Button checkAddQuoteSymbolBtn = (Button)findViewById(R.id.checkAddQuoteSymbol_btn);
		checkAddQuoteSymbolBtn.setOnClickListener(checkAddSymbolBtnClicked);

		Button getSymbolByCompanyNameBtn = (Button)findViewById(R.id.getSymbolByCompanyName_btn);
		getSymbolByCompanyNameBtn.setOnClickListener(getSymbolBtnClicked);

		Button addTargetQuoteBtn = (Button)findViewById(R.id.addTargetQuote_btn);
		addTargetQuoteBtn.setOnClickListener(addTargetQuotelBtnClicked);


	}

	private View.OnClickListener checkAddSymbolBtnClicked = new View.OnClickListener() {
		public void onClick(View v) {
			Log.v(TAG,"checkAddSymbolBtnClicked() -in");

			EditText editText = (EditText)findViewById(R.id.targetAddQuoteSymbol);
			if (editText == null) {
				Log.e(TAG, "checkAddSymbolBtnClicked() editText is null!!");
			}
			String symbol = editText.getText().toString();
			Log.i(TAG, "checkAddSymbolBtnClicked() symbol=" + symbol);
			if (symbol.length() > 0) {
				Uri uri = Uri.parse("http://finance.yahoo.com/q?s=" + symbol);
				Intent i = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(i);
			}
		}
	};

	private View.OnClickListener getSymbolBtnClicked = new View.OnClickListener() {
		public void onClick(View v) {
			Log.v(TAG,"getSymbolBtnClicked() -in");

			EditText editText = (EditText)findViewById(R.id.targetCompanyName);
			if (editText == null) {
				Log.e(TAG, "getSymbolBtnClicked() editText is null!!");
			}
			String name = editText.getText().toString();
			Log.i(TAG, "checkAddSymbolBtnClicked() symbol=" + name);
			if (name.length() > 0) {
				SymbolLookup lookup = new SymbolLookup();
				Set<HashMap<String, String>> symbols = lookup.getSymbols(name);
			}
		}
	};

	private View.OnClickListener addTargetQuotelBtnClicked = new View.OnClickListener() {
		public void onClick(View v) {
			int targetQuote_updated = 0;

			Log.v(TAG,"addTargetQuotelBtnClicked() -in");
			TargetQuoteList list = TargetQuoteList.getInstance();

			EditText editText = (EditText)findViewById(R.id.targetAddQuoteSymbol);
			if (editText == null) {
				Log.e(TAG, "addTargetQuotelBtnClicked() editText is null!!");
			} else {
				String symbol = editText.getText().toString();
				int added = list.add(symbol);
				if (added == 0) {
					targetQuote_updated = 1;
				}
				Log.i(TAG, "addTargetQuotelBtnClicked() -out targetQuoteList size=" + Integer.toString(list.size()));
			}
			setResult(targetQuote_updated, new Intent());
			finish();
		}
	};
}
