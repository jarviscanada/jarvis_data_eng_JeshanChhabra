package ca.jrvs.apps.trading.dao;


import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.domain.Quote;
import ca.jrvs.apps.trading.service.QuoteService;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {TestConfig.class})
//@Sql({"classpath:schema.sql"})
public class QuoteDaoIntTest {

    @Autowired
    private QuoteDao quoteDao;
    private Quote savedQuote = new Quote();

    @Test
    public void insertOne(){
        System.out.println("before");
        savedQuote.setAskPrice(10d);
        savedQuote.setAskSize(10);
        savedQuote.setBidPrice(10.2d);
        savedQuote.setBidSize(10);
        savedQuote.setId("FB");
        savedQuote.setLastPrice(10.1d);
        quoteDao.save(savedQuote);
    }

    @Test
    public void findAll(){

    }


//    @After
//    public void deleteOne(){
//        quoteDao.deleteById(savedQuote.getId());
//    }


}
