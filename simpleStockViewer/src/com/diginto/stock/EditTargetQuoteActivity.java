package com.diginto.stock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.util.Log;
import android.net.Uri;

import java.util.Set;
import java.util.Iterator;

public class EditTargetQuoteActivity extends Activity {
	private final String TAG = "EditTargetQuoteActivity";

	static final int MENU_ID_TARGET_QUOTE_ADD = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_target_quote);

//        ListView targetQuoteListView = new ListView(this);
//        targetQuoteListView = (ListView)this.findViewById(R.id.targetQuotelistView);
        ListView targetQuoteListView = (ListView)this.findViewById(R.id.targetQuotelistView);

        TargetQuoteListAdapter adapter = new TargetQuoteListAdapter(this, R.layout.edit_target_quote_row);
        adapter.init();
        //set adapter to the list
        targetQuoteListView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_ID_TARGET_QUOTE_ADD, 0, getString(R.string.target_quote_add)).setIcon(android.R.drawable.ic_menu_add);
        return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO 自動生成されたメソッド・スタブ
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case MENU_ID_TARGET_QUOTE_ADD:
	        Intent intent = new Intent();
	        intent.setClassName(
	                "com.diginto.stock",
	                "com.diginto.stock.AddTargetQuoteActivity");
//	        startActivity(intent);
	        startActivityForResult(intent, 0);
	        return true;
	    default:
	        break;
	    }
	    return super.onOptionsItemSelected(item);
	}

	@Override
	//遷移先から戻るときにfinish()をコールしない場合は、onActivityResult()はコールされない
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i(TAG, "onActivityResult() resultCode=..." + Integer.toString(resultCode));
		int updated = resultCode;
		if (updated == 1) {
			TargetQuoteList list = TargetQuoteList.getInstance();
			Log.i(TAG, "onActivityResult() size=" + list.size());

			ListView targetQuoteListView = (ListView)this.findViewById(R.id.targetQuotelistView);
			TargetQuoteListAdapter adapter = (TargetQuoteListAdapter)targetQuoteListView.getAdapter();
			adapter.init();
			adapter.notifyDataSetChanged();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onPause() {
		Log.i(TAG, "onPause()");

		//ここを実行すると遷移元にもどったときにホームに戻ってしまう？？
//		setResult(1, new Intent());
//		finish();
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, "onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, "onResume()");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.i(TAG, "onStart()");
		super.onStart();
	}


}
