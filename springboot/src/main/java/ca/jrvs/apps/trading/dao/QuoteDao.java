package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class QuoteDao implements CrudRepository<Quote,String> {

    private static final String TABLE_NAME = "quote";
    private static final String ID_COLUMN_NAME = "ticker";



    private static final Logger logger = LoggerFactory.getLogger(QuoteDao.class);

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;


@Autowired
    public QuoteDao(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
    simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME);
    }

    @Override
    public Quote save(Quote quote) {
        if (existsById(quote.getId())){
            int updateRowNo = updateOne(quote);
            if (updateRowNo != 1){
                throw new DataRetrievalFailureException("Unable to update quote");
            }else{
                addOne(quote);
            }
        }
        return quote;
    }




    private void addOne(Quote quote){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(quote);
        int row = simpleJdbcInsert.execute(parameterSource);
        if (row != 1){
            throw new IncorrectResultSizeDataAccessException("Failed to insert",1,row);
        }
    }

    private int updateOne(Quote quote){
         String update_sql = "UPDATE quote SET last_price=?, bid_price=?, " +
                 "bid_size=?, ask_price=?, ask_size WHERE ticker=?";
        return jdbcTemplate.update(update_sql,makeUpdateValues(quote));
    }


    /**
     * helper method that makes sql update values object
     * @param quote
     * @return
     */
    private Object[] makeUpdateValues(Quote quote){
        Object[] values = new Object[]{quote.getLastPrice(),quote.getBidPrice(),quote.getBidSize()
        ,quote.getAskPrize(),quote.getAskSize(),quote.getId()};
        return values;
    }

    /**
     *
     * @return all quotes
     * @throws org.springframework.dao.DataAccessException if failed to update
     */
    @Override
    public List<Quote> findAll() {
        String selectSql = "select * from quote ";
        List<Quote> quotes =  jdbcTemplate
                .query(selectSql, BeanPropertyRowMapper.newInstance(Quote.class));

        return quotes;
    }

    @Override
    public <S extends Quote> Iterable<S> saveAll(Iterable<S> quotes) {
        quotes.forEach(quote -> {
            save(quote);
        });
        return quotes;
    }

    @Override
    public long count() {
        int tickerCount = this.jdbcTemplate.queryForObject("select count(*) FROM " + TABLE_NAME , Integer.class);

        return tickerCount;
    }

    @Override
    public boolean existsById(String ticker) {
        int tickerCount = this.jdbcTemplate.queryForObject("select count(*) FROM " + TABLE_NAME + " WHERE ticker = ?", Integer.class,ticker);
        if (tickerCount == 1){
            return true;
        }
        return false ;
    }

    @Override
    public Optional<Quote> findById(String ticker) {
        if (!existsById(ticker)){
            return Optional.empty();
        }

        String selectSql = "select * from quote where ticker =?";
        Quote quote = jdbcTemplate.queryForObject(selectSql,BeanPropertyRowMapper.newInstance(Quote.class),ticker);
        return Optional.of(quote);
    }

    @Override
    public void deleteById(String ticker) {
        String deleteSql = "DELETE FROM quote WHERE ticker" + " =?";
        jdbcTemplate.update(deleteSql,ticker);
    }



    @Override
    public void deleteAll() {
        String deleteSql = "DELETE FROM quote";
        jdbcTemplate.update(deleteSql);
    }

    @Override
    public Iterable<Quote> findAllById(Iterable<String> tickers) {

     throw new UnsupportedOperationException("Not implemented");
    }


    @Override
    public void delete(Quote quote) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends Quote> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }



}
