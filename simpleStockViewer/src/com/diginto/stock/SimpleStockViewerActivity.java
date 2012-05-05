package com.diginto.stock;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Button;
import android.view.View;

//Yahoo! Financeから株価を取得する方法
//コンソール(http://developer.yahoo.com/yql/console/)から
//SELECT * FROM yahoo.finance.quotes WHERE symbol="RBS.L"とすると↓のリクエストが送信される
//POST /yql/console/proxy.php HTTP/1.1
//header
//Content-Type: application/x-www-form-urlencoded; charset=UTF-8
//body
//diagnostics=true&q=SELECT%20*%20FROM%20yahoo.finance.quotes%20WHERE%20symbol%3D%22RBS.L%22%0A%09%09&format=json&env=http%3A%2F%2Fdatatables.org%2Falltables.env&crumb=xxTFTblU5fy&_rand=125&_p=h

public class SimpleStockViewerActivity extends Activity {

	static final int QUOTES_NUM = 3;
	private static final String targetQuotes[] = {"GOOG", "YHOO", "SNE"};

	private StockQuote[] getDummyQuoteList() {
		StockQuote quotes[] = new StockQuote[QUOTES_NUM];
		for (int i = 0; i < quotes.length; i++) {
			quotes[i] = new StockQuote(targetQuotes[i]);
		}

			return quotes;
	}
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView stockListView = new ListView(this);
        stockListView = (ListView)this.findViewById(R.id.stockListView);

        StockListAdapter adapter = new StockListAdapter(this, R.layout.row_stock);
        StockQuote quotes[] = getDummyQuoteList();

        for (int i = 0; i < quotes.length; i++) {
	        adapter.add(quotes[i]);
        }
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
}