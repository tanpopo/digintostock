package com.diginto.stock;

import org.json.*;
import android.util.Log;

/*
 * SELECT * FROM yahoo.finance.quotes WHERE symbol="GOOG"
 cbfunc({
 "query": {
  "count": 1,
  "created": "2012-05-03T23:30:53Z",
  "lang": "en-US",
  "diagnostics": {
   "publiclyCallable": "true",
   "url": [
    {
     "execution-start-time": "22",
     "execution-stop-time": "26",
     "execution-time": "4",
     "proxy": "DEFAULT",
     "content": "http://www.datatables.org/yahoo/finance/yahoo.finance.quotes.xml"
    },
    {
     "execution-start-time": "112",
     "execution-stop-time": "112",
     "execution-time": "0",
     "proxy": "DEFAULT",
     "content": "http://download.finance.yahoo.com/d/quotes.csv?f=aa2bb2b3b4cc1c3c6c8dd1d2ee1e7e8e9ghjkg1g3g4g5g6ii5j1j3j4j5j6k1k2k4k5ll1l2l3mm2m3m4m5m6m7m8nn4opp1p2p5p6qrr1r2r5r6r7ss1s7t1t7t8vv1v7ww1w4xy&s=GOOG"
    }
   ],
   "query": {
    "execution-start-time": "30",
    "execution-stop-time": "113",
    "execution-time": "83",
    "params": "{url=[http://download.finance.yahoo.com/d/quotes.csv?f=aa2bb2b3b4cc1c3c6c8dd1d2ee1e7e8e9ghjkg1g3g4g5g6ii5j1j3j4j5j6k1k2k4k5ll1l2l3mm2m3m4m5m6m7m8nn4opp1p2p5p6qrr1r2r5r6r7ss1s7t1t7t8vv1v7ww1w4xy&s=GOOG]}",
    "content": "select * from csv where url=@url and columns='Ask,AverageDailyVolume,Bid,AskRealtime,BidRealtime,BookValue,Change&PercentChange,Change,Commission,ChangeRealtime,AfterHoursChangeRealtime,DividendShare,LastTradeDate,TradeDate,EarningsShare,ErrorIndicationreturnedforsymbolchangedinvalid,EPSEstimateCurrentYear,EPSEstimateNextYear,EPSEstimateNextQuarter,DaysLow,DaysHigh,YearLow,YearHigh,HoldingsGainPercent,AnnualizedGain,HoldingsGain,HoldingsGainPercentRealtime,HoldingsGainRealtime,MoreInfo,OrderBookRealtime,MarketCapitalization,MarketCapRealtime,EBITDA,ChangeFromYearLow,PercentChangeFromYearLow,LastTradeRealtimeWithTime,ChangePercentRealtime,ChangeFromYearHigh,PercebtChangeFromYearHigh,LastTradeWithTime,LastTradePriceOnly,HighLimit,LowLimit,DaysRange,DaysRangeRealtime,FiftydayMovingAverage,TwoHundreddayMovingAverage,ChangeFromTwoHundreddayMovingAverage,PercentChangeFromTwoHundreddayMovingAverage,ChangeFromFiftydayMovingAverage,PercentChangeFromFiftydayMovingAverage,Name,Notes,Open,PreviousClose,PricePaid,ChangeinPercent,PriceSales,PriceBook,ExDividendDate,PERatio,DividendPayDate,PERatioRealtime,PEGRatio,PriceEPSEstimateCurrentYear,PriceEPSEstimateNextYear,Symbol,SharesOwned,ShortRatio,LastTradeTime,TickerTrend,OneyrTargetPrice,Volume,HoldingsValue,HoldingsValueRealtime,YearRange,DaysValueChange,DaysValueChangeRealtime,StockExchange,DividendYield'"
   },
   "javascript": {
    "execution-time": "93",
    "instructions-used": "66672",
    "table-name": "yahoo.finance.quotes"
   },
   "user-time": "122",
   "service-time": "4",
   "build-version": "26856"
  },
  "results": {
   "quote": {
    "symbol": "GOOG",
    "Ask": "612.00",
    "AverageDailyVolume": "2458890",
    "Bid": "610.00",
    "AskRealtime": "612.00",
    "BidRealtime": "610.00",
    "BookValue": "189.355",
    "Change_PercentChange": "+3.76 - +0.62%",
    "Change": "+3.76",
    "Commission": null,
    "ChangeRealtime": "+3.76",
    "AfterHoursChangeRealtime": "N/A - N/A",
    "DividendShare": "0.00",
    "LastTradeDate": "5/3/2012",
    "TradeDate": null,
    "EarningsShare": "32.998",
    "ErrorIndicationreturnedforsymbolchangedinvalid": null,
    "EPSEstimateCurrentYear": "43.21",
    "EPSEstimateNextYear": "50.52",
    "EPSEstimateNextQuarter": "10.93",
    "DaysLow": "608.95",
    "DaysHigh": "614.83",
    "YearLow": "473.02",
    "YearHigh": "670.25",
    "HoldingsGainPercent": "- - -",
    "AnnualizedGain": null,
    "HoldingsGain": null,
    "HoldingsGainPercentRealtime": "N/A - N/A",
    "HoldingsGainRealtime": null,
    "MoreInfo": "cnprmiIed",
    "OrderBookRealtime": null,
    "MarketCapitalization": "199.2B",
    "MarketCapRealtime": null,
    "EBITDA": "14.796B",
    "ChangeFromYearLow": "+138.00",
    "PercentChangeFromYearLow": "+29.17%",
    "LastTradeRealtimeWithTime": "N/A - <b>611.02</b>",
    "ChangePercentRealtime": "N/A - +0.62%",
    "ChangeFromYearHigh": "-59.23",
    "PercebtChangeFromYearHigh": "-8.84%",
    "LastTradeWithTime": "4:00pm - <b>611.02</b>",
    "LastTradePriceOnly": "611.02",
    "HighLimit": null,
    "LowLimit": null,
    "DaysRange": "608.95 - 614.83",
    "DaysRangeRealtime": "N/A - N/A",
    "FiftydayMovingAverage": "625.724",
    "TwoHundreddayMovingAverage": "612.91",
    "ChangeFromTwoHundreddayMovingAverage": "-1.89",
    "PercentChangeFromTwoHundreddayMovingAverage": "-0.31%",
    "ChangeFromFiftydayMovingAverage": "-14.704",
    "PercentChangeFromFiftydayMovingAverage": "-2.35%",
    "Name": "Google Inc.",
    "Notes": null,
    "Open": "609.62",
    "PreviousClose": "607.26",
    "PricePaid": null,
    "ChangeinPercent": "+0.62%",
    "PriceSales": "4.95",
    "PriceBook": "3.21",
    "ExDividendDate": null,
    "PERatio": "18.40",
    "DividendPayDate": null,
    "PERatioRealtime": null,
    "PEGRatio": "0.79",
    "PriceEPSEstimateCurrentYear": "14.05",
    "PriceEPSEstimateNextYear": "12.02",
    "Symbol": "GOOG",
    "SharesOwned": null,
    "ShortRatio": "1.10",
    "LastTradeTime": "4:00pm",
    "TickerTrend": " ====== ",
    "OneyrTargetPrice": "747.33",
    "Volume": "1868187",
    "HoldingsValue": null,
    "HoldingsValueRealtime": null,
    "YearRange": "473.02 - 670.25",
    "DaysValueChange": "- - +0.62%",
    "DaysValueChangeRealtime": "N/A - N/A",
    "StockExchange": "NasdaqNM",
    "DividendYield": null,
    "PercentChange": "+0.62%"
   }
  }
 }
});
 */
public class FinantialDataUtil {
	static private final String TAG = "FinantialDataUtil";

	public static int setupStockQuoteFromJson(StockQuote quote, String json) {
		int result = 0;
		double val = 0.0;
		try {
			JSONObject rootObject = new JSONObject(json);
			JSONObject queryObject = rootObject.getJSONObject("query");
			int count = queryObject.getInt("count");
			JSONObject resultsObject = queryObject.getJSONObject("results");
			JSONObject quoteObject = resultsObject.getJSONObject("quote");
			quote.setSymbol(quoteObject.getString("symbol"));
			quote.setLastTradePrice(quoteObject.getDouble("LastTradePriceOnly"));

			//Ask
			val = 0.0;
			if (!quoteObject.getString("Ask").equals("null")) { //null if the market is off
				Log.i(TAG, "getting Ask val for " + quote.getSymbol());
				val = quoteObject.getDouble("Ask");
			}
			quote.setAsk(val);

			//Bid
			val = 0.0;
			if (!quoteObject.getString("Bid").equals("null")) { //null if the market is off
				Log.i(TAG, "getting Bid val for " + quote.getSymbol());
				val = quoteObject.getDouble("Bid");
			}
			quote.setBid(val);
		} catch (JSONException e) {
			Log.e(TAG, "exception!!");
			result = -1;
		}
		return result;
	}

	public static StockQuote getStockQuoteFromJson(String json) {
		StockQuote quote = new StockQuote();
		int result = setupStockQuoteFromJson(quote, json);
		return (result == 0) ? quote : null;
	}
}
