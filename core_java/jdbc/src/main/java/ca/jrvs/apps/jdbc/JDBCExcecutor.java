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
            customer.setFirstname("jeshan");
            customer.setLastname("Chhabra");
            customer.setEmail("jc20@gmail.com");
            customer.setCity("ASR");
            customer.setPhone("23456644");
            customer.setState("Punj");
            customer.setZipcode("143001");
            customer.setAddress("loharka road");

            Customer dbCustomer = customerDAO.create(customer);

            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("Jc@yahoo.com");
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
