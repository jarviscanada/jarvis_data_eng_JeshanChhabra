package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExcecutor {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "hplussport","postgres","password");
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstname("George");
            customer.setLastname("washington");
            customer.setEmail("george.washington@wh.gov");
            customer.setPhone("(555)555-6503");
            customer.setAddress("1234 Main Street");
            customer.setCity("Mount vernon");
            customer.setState("VA");
            customer.setZipcode("22121");
            customerDAO.create(customer);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
