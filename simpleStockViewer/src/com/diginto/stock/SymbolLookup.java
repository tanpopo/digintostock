package com.diginto.stock;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;

import android.util.Log;
import android.net.Uri;
import java.util.*;

public class SymbolLookup {

	private final String TAG = "SymbolLookup";

	//How to get symbol from company name
	//http://stackoverflow.com/questions/885456/stock-ticker-symbol-lookup-api
	//request
	//http://d.yimg.com/autoc.finance.yahoo.com/autoc?query=yahoo&callback=YAHOO.Finance.SymbolSuggest.ssCallback
	//response
	//YAHOO.Finance.SymbolSuggest.ssCallback({"ResultSet":{"Query":"ya","Result":[{"symbol":"YHOO","name": "Yahoo! Inc.","exch": "NMS","type": "S","exchDisp":"NASDAQ"},{"symbol":"AUY","name": "Yamana Gold, Inc.","exch": "NYQ","type": "S","exchDisp":"NYSE"},{"symbol":"YZC","name": "Yanzhou Coal Mining Co. Ltd.","exch": "NYQ","type": "S","exchDisp":"NYSE"},{"symbol":"YRI.TO","name": "YAMANA GOLD INC COM NPV","exch": "TOR","type": "S","exchDisp":"Toronto"},{"symbol":"8046.TW","name": "NAN YA PRINTED CIR TWD10","exch": "TAI","type": "S","exchDisp":"Taiwan"},{"symbol":"600319.SS","name": "WEIFANG YAXING CHE 'A'CNY1","exch": "SHH","type": "S","exchDisp":"Shanghai"},{"symbol":"1991.HK","name": "TA YANG GROUP","exch": "HKG","type": "S","exchDisp":"Hong Kong"},{"symbol":"1303.TW","name": "NAN YA PLASTIC TWD10","exch": "TAI","type": "S","exchDisp":"Taiwan"},{"symbol":"0294.HK","name": "YANGTZEKIANG","exch": "HKG","type": "S","exchDisp":"Hong Kong"},{"symbol":"YAVY","name": "Yadkin Valley Financial Corp.","exch": "NMS","type": "S","exchDisp":"NASDAQ"}]}})

	public Set getSymbols(String name) {
		Log.i(TAG, "getSymbol() -in");

		String resp = getResponse(name);
		Set symbols = getSymbolsByString(resp);
		Log.i(TAG, "getData() -out");
		return symbols;
	}

	private String getResponse(String name) {
		String resp = "";
        HttpClient client = null;

    	Uri.Builder builder = new Uri.Builder();
    	builder.scheme("http");
    	builder.encodedAuthority("d.yimg.com");
    	builder.path("/autoc.finance.yahoo.com/autoc");
    	builder.appendQueryParameter("query", name);
    	builder.appendQueryParameter("callback", "YAHOO.Finance.SymbolSuggest.ssCallback");

		try {
	        client = new DefaultHttpClient();
	        HttpGet request = new HttpGet(builder.build().toString());
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
		return resp;
	}

	private Set getSymbolsByString(String jsonString) {
		Set<HashMap<String, String>> symbols = new HashSet<HashMap<String, String>>();

		try {
			JSONObject rootObject = new JSONObject(jsonString);
			JSONObject resultsetObject = rootObject.getJSONObject("ResultSet");
			if (resultsetObject != null) {
				JSONArray resultObject = resultsetObject.getJSONArray("Result");

				for (int i=0; i < resultObject.length(); i++ ) {
					JSONObject obj = resultObject.getJSONObject(i);
					HashMap<String, String> item = new HashMap<String, String>();
					Iterator keys = obj.keys();
					while (keys.hasNext()) {
						String key = (String)keys.next();
						Log.i(TAG, "getSymbolsByString() key=" + key);
						item.put(key, obj.getString(key));
					}
					symbols.add(item);
				}
			}
		} catch (JSONException ex) {

		}

		return symbols;
	}
}
