package ca.jrvs.apps.trading.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class IexQuote {


        public String symbol;
        public String companyName;
        public String primaryExchange;
        public String calculationPrice;
        @JsonProperty("open")
        public double myopen;
        public long openTime;
        public String openSource;
        public double close;
        public long closeTime;
        public String closeSource;
        public double high;
        public long highTime;
        public String highSource;
        public double low;
        public long lowTime;
        public String lowSource;
        public double latestPrice;
        public String latestSource;
        public String latestTime;
        public long latestUpdate;
        public int latestVolume;
        public double iexRealtimePrice;
        public int iexRealtimeSize;
        public long iexLastUpdated;
        public double delayedPrice;
        public long delayedPriceTime;
        public double oddLotDelayedPrice;
        public long oddLotDelayedPriceTime;
        public double extendedPrice;
        public double extendedChange;
        public double extendedChangePercent;
        public long extendedPriceTime;
        public double previousClose;
        public int previousVolume;
        public double change;
        public double changePercent;
        public int volume;
        public double iexMarketPercent;
        public int iexVolume;
        public int avgTotalVolume;
        public int iexBidPrice;
        public int iexBidSize;
        public int iexAskPrice;
        public int iexAskSize;
        public double iexOpen;
        public long iexOpenTime;
        public double iexClose;
        public long iexCloseTime;
        public long marketCap;
        public double peRatio;
        public double week52High;
        public double week52Low;
        public double ytdChange;
        public long lastTradeTime;
        public String currency;
        public boolean isUSMarketOpen;


        public String getSymbol() {
                return symbol;
        }

        public void setSymbol(String symbol) {
                this.symbol = symbol;
        }

        public String getCompanyName() {
                return companyName;
        }

        public void setCompanyName(String companyName) {
                this.companyName = companyName;
        }

        public String getPrimaryExchange() {
                return primaryExchange;
        }

        public void setPrimaryExchange(String primaryExchange) {
                this.primaryExchange = primaryExchange;
        }

        public String getCalculationPrice() {
                return calculationPrice;
        }

        public void setCalculationPrice(String calculationPrice) {
                this.calculationPrice = calculationPrice;
        }

        public double getMyopen() {
                return myopen;
        }

        public void setMyopen(double myopen) {
                this.myopen = myopen;
        }

        public long getOpenTime() {
                return openTime;
        }

        public void setOpenTime(long openTime) {
                this.openTime = openTime;
        }

        public String getOpenSource() {
                return openSource;
        }

        public void setOpenSource(String openSource) {
                this.openSource = openSource;
        }

        public double getClose() {
                return close;
        }

        public void setClose(double close) {
                this.close = close;
        }

        public long getCloseTime() {
                return closeTime;
        }

        public void setCloseTime(long closeTime) {
                this.closeTime = closeTime;
        }

        public String getCloseSource() {
                return closeSource;
        }

        public void setCloseSource(String closeSource) {
                this.closeSource = closeSource;
        }

        public double getHigh() {
                return high;
        }

        public void setHigh(double high) {
                this.high = high;
        }

        public long getHighTime() {
                return highTime;
        }

        public void setHighTime(long highTime) {
                this.highTime = highTime;
        }

        public String getHighSource() {
                return highSource;
        }

        public void setHighSource(String highSource) {
                this.highSource = highSource;
        }

        public double getLow() {
                return low;
        }

        public void setLow(double low) {
                this.low = low;
        }

        public long getLowTime() {
                return lowTime;
        }

        public void setLowTime(long lowTime) {
                this.lowTime = lowTime;
        }

        public String getLowSource() {
                return lowSource;
        }

        public void setLowSource(String lowSource) {
                this.lowSource = lowSource;
        }

        public double getLatestPrice() {
                return latestPrice;
        }

        public void setLatestPrice(double latestPrice) {
                this.latestPrice = latestPrice;
        }

        public String getLatestSource() {
                return latestSource;
        }

        public void setLatestSource(String latestSource) {
                this.latestSource = latestSource;
        }

        public String getLatestTime() {
                return latestTime;
        }

        public void setLatestTime(String latestTime) {
                this.latestTime = latestTime;
        }

        public long getLatestUpdate() {
                return latestUpdate;
        }

        public void setLatestUpdate(long latestUpdate) {
                this.latestUpdate = latestUpdate;
        }

        public int getLatestVolume() {
                return latestVolume;
        }

        public void setLatestVolume(int latestVolume) {
                this.latestVolume = latestVolume;
        }

        public double getIexRealtimePrice() {
                return iexRealtimePrice;
        }

        public void setIexRealtimePrice(double iexRealtimePrice) {
                this.iexRealtimePrice = iexRealtimePrice;
        }

        public int getIexRealtimeSize() {
                return iexRealtimeSize;
        }

        public void setIexRealtimeSize(int iexRealtimeSize) {
                this.iexRealtimeSize = iexRealtimeSize;
        }

        public long getIexLastUpdated() {
                return iexLastUpdated;
        }

        public void setIexLastUpdated(long iexLastUpdated) {
                this.iexLastUpdated = iexLastUpdated;
        }

        public double getDelayedPrice() {
                return delayedPrice;
        }

        public void setDelayedPrice(double delayedPrice) {
                this.delayedPrice = delayedPrice;
        }

        public long getDelayedPriceTime() {
                return delayedPriceTime;
        }

        public void setDelayedPriceTime(long delayedPriceTime) {
                this.delayedPriceTime = delayedPriceTime;
        }

        public double getOddLotDelayedPrice() {
                return oddLotDelayedPrice;
        }

        public void setOddLotDelayedPrice(double oddLotDelayedPrice) {
                this.oddLotDelayedPrice = oddLotDelayedPrice;
        }

        public long getOddLotDelayedPriceTime() {
                return oddLotDelayedPriceTime;
        }

        public void setOddLotDelayedPriceTime(long oddLotDelayedPriceTime) {
                this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
        }

        public double getExtendedPrice() {
                return extendedPrice;
        }

        public void setExtendedPrice(double extendedPrice) {
                this.extendedPrice = extendedPrice;
        }

        public double getExtendedChange() {
                return extendedChange;
        }

        public void setExtendedChange(double extendedChange) {
                this.extendedChange = extendedChange;
        }

        public double getExtendedChangePercent() {
                return extendedChangePercent;
        }

        public void setExtendedChangePercent(double extendedChangePercent) {
                this.extendedChangePercent = extendedChangePercent;
        }

        public long getExtendedPriceTime() {
                return extendedPriceTime;
        }

        public void setExtendedPriceTime(long extendedPriceTime) {
                this.extendedPriceTime = extendedPriceTime;
        }

        public double getPreviousClose() {
                return previousClose;
        }

        public void setPreviousClose(double previousClose) {
                this.previousClose = previousClose;
        }

        public int getPreviousVolume() {
                return previousVolume;
        }

        public void setPreviousVolume(int previousVolume) {
                this.previousVolume = previousVolume;
        }

        public double getChange() {
                return change;
        }

        public void setChange(double change) {
                this.change = change;
        }

        public double getChangePercent() {
                return changePercent;
        }

        public void setChangePercent(double changePercent) {
                this.changePercent = changePercent;
        }

        public int getVolume() {
                return volume;
        }

        public void setVolume(int volume) {
                this.volume = volume;
        }

        public double getIexMarketPercent() {
                return iexMarketPercent;
        }

        public void setIexMarketPercent(double iexMarketPercent) {
                this.iexMarketPercent = iexMarketPercent;
        }

        public int getIexVolume() {
                return iexVolume;
        }

        public void setIexVolume(int iexVolume) {
                this.iexVolume = iexVolume;
        }

        public int getAvgTotalVolume() {
                return avgTotalVolume;
        }

        public void setAvgTotalVolume(int avgTotalVolume) {
                this.avgTotalVolume = avgTotalVolume;
        }

        public int getIexBidPrice() {
                return iexBidPrice;
        }

        public void setIexBidPrice(int iexBidPrice) {
                this.iexBidPrice = iexBidPrice;
        }

        public int getIexBidSize() {
                return iexBidSize;
        }

        public void setIexBidSize(int iexBidSize) {
                this.iexBidSize = iexBidSize;
        }

        public int getIexAskPrice() {
                return iexAskPrice;
        }

        public void setIexAskPrice(int iexAskPrice) {
                this.iexAskPrice = iexAskPrice;
        }

        public int getIexAskSize() {
                return iexAskSize;
        }

        public void setIexAskSize(int iexAskSize) {
                this.iexAskSize = iexAskSize;
        }

        public double getIexOpen() {
                return iexOpen;
        }

        public void setIexOpen(double iexOpen) {
                this.iexOpen = iexOpen;
        }

        public long getIexOpenTime() {
                return iexOpenTime;
        }

        public void setIexOpenTime(long iexOpenTime) {
                this.iexOpenTime = iexOpenTime;
        }

        public double getIexClose() {
                return iexClose;
        }

        public void setIexClose(double iexClose) {
                this.iexClose = iexClose;
        }

        public long getIexCloseTime() {
                return iexCloseTime;
        }

        public void setIexCloseTime(long iexCloseTime) {
                this.iexCloseTime = iexCloseTime;
        }

        public long getMarketCap() {
                return marketCap;
        }

        public void setMarketCap(long marketCap) {
                this.marketCap = marketCap;
        }

        public double getPeRatio() {
                return peRatio;
        }

        public void setPeRatio(double peRatio) {
                this.peRatio = peRatio;
        }

        public double getWeek52High() {
                return week52High;
        }

        public void setWeek52High(double week52High) {
                this.week52High = week52High;
        }

        public double getWeek52Low() {
                return week52Low;
        }

        public void setWeek52Low(double week52Low) {
                this.week52Low = week52Low;
        }

        public double getYtdChange() {
                return ytdChange;
        }

        public void setYtdChange(double ytdChange) {
                this.ytdChange = ytdChange;
        }

        public long getLastTradeTime() {
                return lastTradeTime;
        }

        public void setLastTradeTime(long lastTradeTime) {
                this.lastTradeTime = lastTradeTime;
        }

        public String getCurrency() {
                return currency;
        }

        public void setCurrency(String currency) {
                this.currency = currency;
        }

        public boolean isUSMarketOpen() {
                return isUSMarketOpen;
        }

        public void setUSMarketOpen(boolean USMarketOpen) {
                isUSMarketOpen = USMarketOpen;
        }

        @Override
        public String toString() {
                return "IexQuote{" +
                        "symbol='" + symbol + '\'' +
                        ", companyName='" + companyName + '\'' +
                        ", primaryExchange='" + primaryExchange + '\'' +
                        ", calculationPrice='" + calculationPrice + '\'' +
                        ", myopen=" + myopen +
                        ", openTime=" + openTime +
                        ", openSource='" + openSource + '\'' +
                        ", close=" + close +
                        ", closeTime=" + closeTime +
                        ", closeSource='" + closeSource + '\'' +
                        ", high=" + high +
                        ", highTime=" + highTime +
                        ", highSource='" + highSource + '\'' +
                        ", low=" + low +
                        ", lowTime=" + lowTime +
                        ", lowSource='" + lowSource + '\'' +
                        ", latestPrice=" + latestPrice +
                        ", latestSource='" + latestSource + '\'' +
                        ", latestTime='" + latestTime + '\'' +
                        ", latestUpdate=" + latestUpdate +
                        ", latestVolume=" + latestVolume +
                        ", iexRealtimePrice=" + iexRealtimePrice +
                        ", iexRealtimeSize=" + iexRealtimeSize +
                        ", iexLastUpdated=" + iexLastUpdated +
                        ", delayedPrice=" + delayedPrice +
                        ", delayedPriceTime=" + delayedPriceTime +
                        ", oddLotDelayedPrice=" + oddLotDelayedPrice +
                        ", oddLotDelayedPriceTime=" + oddLotDelayedPriceTime +
                        ", extendedPrice=" + extendedPrice +
                        ", extendedChange=" + extendedChange +
                        ", extendedChangePercent=" + extendedChangePercent +
                        ", extendedPriceTime=" + extendedPriceTime +
                        ", previousClose=" + previousClose +
                        ", previousVolume=" + previousVolume +
                        ", change=" + change +
                        ", changePercent=" + changePercent +
                        ", volume=" + volume +
                        ", iexMarketPercent=" + iexMarketPercent +
                        ", iexVolume=" + iexVolume +
                        ", avgTotalVolume=" + avgTotalVolume +
                        ", iexBidPrice=" + iexBidPrice +
                        ", iexBidSize=" + iexBidSize +
                        ", iexAskPrice=" + iexAskPrice +
                        ", iexAskSize=" + iexAskSize +
                        ", iexOpen=" + iexOpen +
                        ", iexOpenTime=" + iexOpenTime +
                        ", iexClose=" + iexClose +
                        ", iexCloseTime=" + iexCloseTime +
                        ", marketCap=" + marketCap +
                        ", peRatio=" + peRatio +
                        ", week52High=" + week52High +
                        ", week52Low=" + week52Low +
                        ", ytdChange=" + ytdChange +
                        ", lastTradeTime=" + lastTradeTime +
                        ", currency='" + currency + '\'' +
                        ", isUSMarketOpen=" + isUSMarketOpen +
                        '}';
        }
}
