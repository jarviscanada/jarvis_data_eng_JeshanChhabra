package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//@Transactional
@Service
public class QuoteService {

    private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

   //  private QuoteDao quoteDao;
    private MarketDataDao marketDataDao;

    @Autowired
    public QuoteService(MarketDataDao marketDataDao){
        this.marketDataDao = marketDataDao;
    }

    public IexQuote findIexQuoteByTicker(String ticker){
        return marketDataDao.findById(ticker).orElseThrow(() -> new IllegalArgumentException(ticker + "is invalid"));
    }

    public List<IexQuote> findAllIexQuoteByTicker(List<String> tickers){
        return marketDataDao.findAllById(tickers);
    }

}
