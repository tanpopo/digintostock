package com.diginto.stock;

import java.util.Set;
import java.util.Iterator;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Button;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;


//Yahoo! Financeから株価を取得する方法
//コンソール(http://developer.yahoo.com/yql/console/)から
//SELECT * FROM yahoo.finance.quotes WHERE symbol="RBS.L"とすると↓のリクエストが送信される
//POST /yql/console/proxy.php HTTP/1.1
//header
//Content-Type: application/x-www-form-urlencoded; charset=UTF-8
//body
//diagnostics=true&q=SELECT%20*%20FROM%20yahoo.finance.quotes%20WHERE%20symbol%3D%22RBS.L%22%0A%09%09&format=json&env=http%3A%2F%2Fdatatables.org%2Falltables.env&crumb=xxTFTblU5fy&_rand=125&_p=h

public class SimpleStockViewerActivity extends Activity {
	private final String TAG = "SimpleStockViewerActivity";

	static final int QUOTES_NUM = 3;

	static final int MENU_ID_TARGET_QUOTE_EDIT = 0;
	static final int MENU_ID_UPDATE_ALL = 1;

//	private static final String targetQuotes[] = {"GOOG", "YHOO", "SNE"};

//	private Set<StockQuote> getQuoteList(Set<String> symbols) {
//		StockQuote quotes[] = new StockQuote[symbols.size()];
//
//		for (Iterator i = symbols.iterator(); i.hasNext(); ) {
//			String symbol = (String)i.next();
//			quotes[j] = new StockQuote(symbol);
//		}
//		return quotes;
//	}
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView stockListView = new ListView(this);
        stockListView = (ListView)this.findViewById(R.id.stockListView);

        StockListAdapter adapter = new StockListAdapter(this, R.layout.quote_list_row);
        adapter.init();
        stockListView.setAdapter(adapter);

        //setup button
        Button btn = (Button)findViewById(R.id.update_btn);
        btn.setOnClickListener(new View.OnClickListener() { //new View.OnClickListener()ではなく、
        	                                                //new OnClickListener()とすると、
        	                                                //「OnClickListener を型に解決できません」と怒られてしまう。

            @Override
            public void onClick(View v) {
            	updateAllItem();
            }
        });
    }


    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_ID_TARGET_QUOTE_EDIT, 0, getString(R.string.target_quote_edit)).setIcon(android.R.drawable.ic_menu_edit); //Menu.add(int groupId, int itemId, int order, CharSequence title)
        menu.add(0, MENU_ID_UPDATE_ALL, 0, getString(R.string.update_all)).setIcon(android.R.drawable.ic_menu_set_as);
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
	    case MENU_ID_TARGET_QUOTE_EDIT:
	        Intent intent = new Intent();
	        intent.setClassName(
	                "com.diginto.stock",
	                "com.diginto.stock.EditTargetQuoteActivity");
//	        startActivity(intent);
	        startActivityForResult(intent, 0);
	        return true;
	    case MENU_ID_UPDATE_ALL:
	        return true;
	    default:
	        break;
	    }
	    return super.onOptionsItemSelected(item);
	}

	////////////////////////////////////////
	// private functions

	private int updateAllItem() {
//		ListView lv = (ListView)findViewById(R.id.stockListView);
//		for (int i = 0; i < lv.getCount(); i++) {
//			View view = (View)lv.getItemAtPosition(i);//[todo] ここで返るのはおそらくStockQuote
//														//ListView内の1アイテムをあらわすViewを取得する方法が分からない・・・
//			StockQuoteUpdateTask task = new StockQuoteUpdateTask(view);
//			task.execute();
//		}
		return 0;
    }
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i(TAG, "onActivityResult() resultCode=..." + Integer.toString(resultCode));
//		int updated = resultCode;
//		if (updated == 1) {
//			TargetQuoteList list = TargetQuoteList.getInstance();
//			Log.i(TAG, "onActivityResult() size=" + list.size());
//
//			ListView listView = (ListView)this.findViewById(R.id.stockListView);
//			StockListAdapter adapter = (StockListAdapter)listView.getAdapter();
//			adapter.init();
//			adapter.notifyDataSetChanged();
//		}
		super.onActivityResult(requestCode, resultCode, data);
	}


	@Override
	protected void onResume() {
		int updated = 1;
		if (updated == 1) {
			TargetQuoteList list = TargetQuoteList.getInstance();
			Log.i(TAG, "onActivityResult() size=" + list.size());

			ListView listView = (ListView)this.findViewById(R.id.stockListView);
			StockListAdapter adapter = (StockListAdapter)listView.getAdapter();
			adapter.init();
			adapter.notifyDataSetChanged();
		}

		super.onResume();
	}

}