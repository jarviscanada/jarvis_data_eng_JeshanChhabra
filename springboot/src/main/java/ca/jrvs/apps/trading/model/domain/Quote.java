package ca.jrvs.apps.trading.model.domain;

public class Quote implements Entity<String>{

    private String ticker;
    private Double lastPrice;
    private Double bidPrice;
    private Integer bidSize;
    private Double askPrice;
    private Integer askSize;


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public String getId() {
        return ticker;
    }

    @Override
    public void setId(String ticker) {
        this.ticker = ticker;

    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Integer getBidSize() {
        return bidSize;
    }

    public void setBidSize(Integer bidSize) {
        this.bidSize = bidSize;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrize) {
        this.askPrice = askPrize;
    }

    public Integer getAskSize() {
        return askSize;
    }

    public void setAskSize(Integer askSize) {
        this.askSize = askSize;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "ticker='" + ticker + '\'' +
                ", lastPrice=" + lastPrice +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                '}';
    }
}
