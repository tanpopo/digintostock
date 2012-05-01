package com.diginto.stock;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

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
    }
}