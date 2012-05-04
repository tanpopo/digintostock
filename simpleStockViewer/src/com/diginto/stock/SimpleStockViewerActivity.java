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

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView stockListView = new ListView(this);
        stockListView = (ListView)this.findViewById(R.id.stockListView);

        StockListAdapter adapter = new StockListAdapter(this, R.layout.row_stock);
        adapter.add(new Stock(Integer.toString(6758), "T", "ソニー"));
        adapter.add(new Stock(Integer.toString(7267), "T", "ホンダ"));
        adapter.add(new Stock(Integer.toString(7203), "T", "トヨタ"));

        Stock stock = adapter.getItem(0);
        stock.setCurrentValue(1000);
        stock.setDiffValue(100);

        stock = adapter.getItem(1);
        stock.setCurrentValue(500);
        stock.setDiffValue(-10);

        stock = adapter.getItem(2);
        stock.setCurrentValue(10);
        stock.setDiffValue(2);

        stockListView.setAdapter(adapter);

        //setup button
        Button btn = (Button)findViewById(R.id.update_btn);
        btn.setOnClickListener(new View.OnClickListener() { //new View.OnClickListener()ではなく、
        	                                                //new OnClickListener()とすると、
        	                                                //「OnClickListener を型に解決できません」と怒られてしまう。

            @Override
            public void onClick(View v) {
            	FinantialDataUpdater updater = new FinantialDataUpdater();
            	//RBS.L: The Royal Bank of Scotland Group plc/London
            	//YHOO: Yahoo/Nasdaq
            	//GOOG: Google/Nasdaq
            	String text = updater.getData("GOOG");
            	StockQuote quote = FinantialDataUtil.getStockQuoteFromJson(text);


            	AlertDialog.Builder dlg = new AlertDialog.Builder(SimpleStockViewerActivity.this);
                dlg.setTitle("received response");
                dlg.setMessage(quote.toString());
                dlg.show();
            }
        });
    }
}