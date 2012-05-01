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
        adapter.add(new Stock("ソニー", 2000));
        adapter.add(new Stock("ホンダ", 3000));
        adapter.add(new Stock("トヨタ", 4000));

        stockListView.setAdapter(adapter);
    }
}