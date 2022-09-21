package ca.jrvs.apps.trading.dao;


import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.utils.JsonUtil;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



public class MarketDataDao implements CrudRepository<IexQuote,String> {

    private static String IEX_BATCH_PATH = "stock/market/batch?symbols=%s&types=quote&token=";
    private final String IEX_BATCH_URL;

    private Logger logger = LoggerFactory.getLogger(MarketDataDao.class);


    private HttpClientConnectionManager httpClientConnectionManager;


    public MarketDataDao(HttpClientConnectionManager httpClientConnectionManager,
                         MarketDataConfig marketDataConfig){
        this.httpClientConnectionManager = httpClientConnectionManager;
        this.IEX_BATCH_URL = marketDataConfig.getHost() + IEX_BATCH_PATH + marketDataConfig.getToken();
    }


    @Override
    public <S extends IexQuote> S save(S s) {
        return null;
    }

    @Override
    public <S extends IexQuote> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<IexQuote> findById(String ticker) {
        Optional<IexQuote> iexQuote;
        List<IexQuote> quotes = findAllById(Collections.singletonList(ticker));
        if(quotes.size() == 0){
            return Optional.empty();
        }else if(quotes.size() == 1) {
            iexQuote = Optional.of(quotes.get(0));
        }else{
            throw new DataRetrievalFailureException("Unexpected Number of quotes");
        }

        return iexQuote;
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<IexQuote> findAll() {
        return null;
    }

    @Override
    public List<IexQuote> findAllById(Iterable<String> tickers) {
        IexQuote quote;
        List<IexQuote> iexQuote = new ArrayList();
        StringBuffer tickersInString = new StringBuffer();

        tickers.forEach(tickersInString :: append); // method reference

        String joinedString = String.join(",", tickers);
        String uri = String.format(IEX_BATCH_URL, joinedString);


        String response = excecuteHttpGet(uri).orElseThrow(()-> new IllegalArgumentException("Invalid Ticker") );

        //Array of JSON documents
        JSONObject IexQuotesJson = new JSONObject(response);

  // looping the tickers to add them in arraylist
        for (String ticker : tickers) {

            try {
                String jstr = IexQuotesJson.getJSONObject(ticker).getJSONObject("quote").toString();
                quote = JsonUtil.toObjectFromJson(jstr, IexQuote.class);
            }
            catch(Exception e){
                throw new IllegalArgumentException("Invalid input");
            }
            iexQuote.add(quote);
        }
        return iexQuote ;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(IexQuote iexQuote) {

    }

    private Optional<String> excecuteHttpGet(String url){
        CloseableHttpClient httpClient = getHttpClient();

        HttpUriRequest request = new HttpGet(url);
        try {

            HttpResponse response = httpClient.execute(request);

            String jsonStr = EntityUtils.toString(response.getEntity());




            return Optional.of(jsonStr);
        }catch(IOException e){
            throw new DataRetrievalFailureException("HttpRequest failed to execute",e);
        }

    }

    private CloseableHttpClient getHttpClient(){
        /**
         * Borrowed a http custom client by borrowing it from HttpclientConnectionManager
         */
        return HttpClients.custom().setConnectionManager(httpClientConnectionManager)
                .setConnectionManagerShared(true).build();
    }

    @Override
    public void deleteAll(Iterable<? extends IexQuote> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
