package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.Quote;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//@Transactional
@Service
public class QuoteService {

    private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

    private QuoteDao quoteDao;

    private MarketDataDao marketDataDao;

    @Autowired
    public QuoteService(QuoteDao quoteDao, MarketDataDao marketDataDao){
        this.quoteDao = quoteDao;
        this.marketDataDao = marketDataDao;
    }

    public IexQuote findIexQuoteByTicker(String ticker){
        return marketDataDao.findById(ticker).orElseThrow(() -> new IllegalArgumentException(ticker + "is invalid"));
    }

    public List<IexQuote> findAllIexQuoteByTicker(List<String> tickers){
        return marketDataDao.findAllById(tickers);
    }

    /**
     * Update quote table against IEX source
     * -get all quotes from db
     * -foreach ticker get iex quote
     * -convert iexquote to quote entity
     * persist quote to db
     */
    public void updateMarketData(){
       List<Quote> quotes = quoteDao.findAll();
        quotes.forEach(quote -> {
            System.out.println(buildQuoteFromIexQuote(findIexQuoteByTicker(quote.getTicker())));
        });



       quotes.forEach(quote -> {
           quoteDao.save(buildQuoteFromIexQuote(findIexQuoteByTicker(quote.getTicker())));
       });

    }

    /**
     * helper method. Map a IexQuote to quote entity
     *
     * @param iexQuote
     * @return converted quote
     */
    protected static Quote buildQuoteFromIexQuote(IexQuote iexQuote){
       Quote quote = new Quote();

        quote.setTicker(iexQuote.getSymbol());
        quote.setLastPrice(iexQuote.getLatestPrice());
        quote.setAskPrice((double)iexQuote.getIexAskPrice());
        quote.setBidSize(iexQuote.getIexBidSize());
        quote.setBidPrice((double) iexQuote.getIexBidPrice());
        quote.setAskSize(iexQuote.getIexAskSize());

        return quote;
    }

    public List<Quote> saveQuotes(List<String> tickers){
        List<Quote> quotes = new ArrayList<>();
        tickers.forEach(ticker -> {
            quotes.add(saveQuote(ticker));
        });

        return quotes;
    }

    /**
     *
     * Helper method for above
     * @param ticker
     * @return quote
     */
    public Quote saveQuote(String ticker){
        Quote quote;
        try {
            IexQuote iexQuote = findIexQuoteByTicker(ticker);
            quote = buildQuoteFromIexQuote(iexQuote);
            quoteDao.save(quote);
        }catch(IllegalArgumentException e){
            throw new RuntimeException("Invalid input",e);
        }

        return quote;
    }

    /**
     * Sve quote without any validation
     * @param quote
     * @return quote
     */
    public Quote saveQuote(Quote quote){
        return quoteDao.save(quote);
    }

    /**
     * find all quotes
     * @return
     */
    public List<Quote> findAllQuotes(){
        return quoteDao.findAll();
    }

}
