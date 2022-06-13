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
            Customer customer = customerDAO.findById(10000);
            System.out.println(customer.getFirstname()+ " " + customer.getLastname() + " " + customer.getEmail());
            customer.setEmail("Gw234566@gmail.com");
            System.out.println(customer.getFirstname()+ " " + customer.getLastname() + " " + customer.getEmail());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
