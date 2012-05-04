package com.diginto.stock;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import android.app.AlertDialog;
import android.util.Log;

//URL encoded
//diagnostics=true&q=SELECT%20*%20FROM%20yahoo.finance.quotes%20WHERE%20symbol%3D%22RBS.L%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&crumb=xxTFTblU5fy&_rand=342&_p=h
//URL decoded
//diagnostics=true&q=SELECT * FROM yahoo.finance.quotes WHERE symbol="RBS.L"&format=json&env=store://datatables.org/alltableswithkeys&crumb=xxTFTblU5fy&_rand=342&_p=h

public class FinantialDataUpdater {

	private final String TAG = "FinantialDataUpdater";

	public String getData(String symbol) {
		Log.i(TAG, "getData() -in");
		String resp = "";
        HttpClient client = null;
    	final String requestURL_YQL = "http://developer.yahoo.com/yql/console/proxy.php";
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
        nameValuePair.add(new BasicNameValuePair("diagnostics", "true"));
        nameValuePair.add(new BasicNameValuePair("q", "SELECT * FROM yahoo.finance.quotes WHERE symbol=\"" + symbol + "\""));
        nameValuePair.add(new BasicNameValuePair("format", "json"));
        nameValuePair.add(new BasicNameValuePair("env", "store://datatables.org/alltableswithkeys"));
        nameValuePair.add(new BasicNameValuePair("crumb", "xxTFTblU5fy"));
        nameValuePair.add(new BasicNameValuePair("_rand", "342"));
        nameValuePair.add(new BasicNameValuePair("_p", "h"));

		try {
	        client = new DefaultHttpClient();
	        HttpPost request = new HttpPost(requestURL_YQL);
	        request.setEntity(new UrlEncodedFormEntity(nameValuePair));
	        request.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

	        HttpResponse response = client.execute(request);
	        int status = response.getStatusLine().getStatusCode();

	        // 正常に取得できた場合
	        if(HttpStatus.SC_OK == status) {
	        	ByteArrayOutputStream os = new ByteArrayOutputStream();
	            response.getEntity().writeTo(os);
	            resp = os.toString();
	        } else {
	        	Log.e(TAG, "POST error: HttpStatus=" + Integer.toString(status));
	        }
		} catch (Exception e) {
        	Log.e(TAG, "Failed to get POST response");
        } finally {
        	client.getConnectionManager().shutdown();
        }

		Log.i(TAG, resp);
		Log.i(TAG, "getData() -out");

	 return resp;
	}
}
