package ca.jrvs.apps.trading;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages ={"ca.jrvs.apps.trading.dao","ca.jrvs.apps.trading.service"} )
public class TestConfig {

    @Bean
    public MarketDataConfig marketDataConfig(){
    MarketDataConfig marketDataConfig = new MarketDataConfig();
    marketDataConfig.setHost("https://cloud.iexapis.com/v1/");
    marketDataConfig.setToken(System.getenv("IEX_PUB_TOKEN"));
        System.out.println();

    return marketDataConfig;
}

    @Bean
    public DataSource dataSource(){

    System.out.println("Creating apacheDatasource");
//    String url = "jdbc:postgresql://" +
//                    System.getenv("PSQL_HOST") + ":" +
//                    System.getenv("PSQL_PORT") +
//                    "/" +
//                    System.getenv("PSQL_DB");
//
//    String user = System.getenv("PSQL_USER");
//    String password = System.getenv("PSQL_PASSWORD");

    String url = "jdbc:postgresql://localhost"+ ":5432" +
            "/tradingtest";

    String user = "postgres";
    String password = "password";

    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setUrl(url);
    basicDataSource.setUsername(user);
    basicDataSource.setPassword(password);
    return basicDataSource;

}

    @Bean
    public MarketDataDao marketDataDao(MarketDataConfig marketDataConfig){
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);
        cm.setDefaultMaxPerRoute(50);
        return new MarketDataDao(cm,marketDataConfig);
    }

//@Bean
//public HttpClientConnectionManager httpClientConnectionManager(){
//    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
//    cm.setMaxTotal(50);
//    cm.setDefaultMaxPerRoute(50);
//    return cm;
//}

}