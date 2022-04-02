package com.amdocs.engagewebgrabber.domain;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Array;


@Data
public class Stock {

        public String StockResponse;
        public String language;
        public String region;
        public String quoteType;
        public String quoteSourceName;
        public boolean triggerable;
        public String currency;
        public String marketState;
        public long firstTradeDateMilliseconds;
        public int priceHint;
        public double preMarketChange;
        public double preMarketChangePercent;
        public int preMarketTime;
        public double preMarketPrice;
        public double regularMarketChange;
        public double regularMarketChangePercent;
        public int regularMarketTime;
        public double regularMarketPrice;
        public double regularMarketDayHigh;
        public String regularMarketDayRange;
        public double regularMarketDayLow;
        public int regularMarketVolume;
        public double regularMarketPreviousClose;
        public double bid;
        public double ask;
        public int bidSize;
        public int askSize;
        public String fullExchangeName;
        public String financialCurrency;
        public double regularMarketOpen;
        public int averageDailyVolume3Month;
        public int averageDailyVolume10Day;
        public boolean tradeable;
        public String exchange;
        public String shortName;
        public String longName;
        public String messageBoardId;
        public String exchangeTimezoneName;
        public String exchangeTimezoneShortName;
        public int gmtOffSetMilliseconds;
        public String market;
        public boolean esgPopulated;
        public double fiftyTwoWeekLowChange;
        public double fiftyTwoWeekLowChangePercent;
        public String fiftyTwoWeekRange;
        public double fiftyTwoWeekHighChange;
        public double fiftyTwoWeekHighChangePercent;
        public double fiftyTwoWeekLow;
        public double fiftyTwoWeekHigh;
        public int dividendDate;
        public int earningsTimestamp;
        public int earningsTimestampStart;
        public int earningsTimestampEnd;
        public double trailingAnnualDividendRate;
        public double trailingAnnualDividendYield;
        public double epsTrailingTwelveMonths;
        public double epsForward;
        public double epsCurrentYear;
        public double priceEpsCurrentYear;
        public long sharesOutstanding;
        public double bookValue;
        public double fiftyDayAverage;
        public double fiftyDayAverageChange;
        public double fiftyDayAverageChangePercent;
        public double twoHundredDayAverage;
        public double twoHundredDayAverageChange;
        public double twoHundredDayAverageChangePercent;
        public long marketCap;
        public double forwardPE;
        public double priceToBook;
        public int sourceInterval;
        public int exchangeDataDelayedBy;
        public String averageAnalystRating;
        public String displayName;
        public String symbol;

}
