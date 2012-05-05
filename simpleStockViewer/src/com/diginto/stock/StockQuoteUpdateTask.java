package com.diginto.stock;

import android.view.View;
import android.os.AsyncTask;
import android.util.Log;

public class StockQuoteUpdateTask extends AsyncTask<Void, Void, StockQuote> { //実行時引数(Param)、進捗単位(Progress)、処理結果(Result)
	static final String TAG = "UpdateTask";
    // アイコンを表示するビュー
    private View view;

    // コンストラクタ
    public StockQuoteUpdateTask(View view) {
        this.view = view;
    }

    // バックグラウンドで実行する処理
    @Override
//    protected StockQuote doInBackground(View... views) {
    protected StockQuote doInBackground(Void... arg0) {
    	//キャッシュを使う場合
//        Bitmap image = ImageCache.getImage(urls[0]);
//        if (image == null) {
//            image = HttpClient.getImage(urls[0]);
//            ImageCache.setImage(urls[0], image);
//        }
//        return image;

    	FinantialDataUpdater updater = new FinantialDataUpdater();
    	StockQuote quote = (StockQuote)this.view.getTag();
    	Log.i(TAG, "doInBackground(): update data target symbol=" + quote.getSymbol());
    	String text = updater.getData(quote.getSymbol());
    	int result = FinantialDataUtil.setupStockQuoteFromJson(quote, text);
    	return quote;
    }

    // メインスレッドで実行する処理
    @Override
    protected void onPostExecute(StockQuote quote) {
    	Log.i(TAG, "onPostExecute(): -in");
    	StockListAdapter.setupView(this.view, quote);
    	Log.i(TAG, "onPostExecute(): -out");
    }
}