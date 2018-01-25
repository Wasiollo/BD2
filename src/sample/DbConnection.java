package sample;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mateusz
 */
public class DbConnection {

    private Connection connection;
    private DatabaseMetaData met;
    private Statement st;
    private ResultSet rs;

    DbConnection() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/wfbqjvbl", "wfbqjvbl", "Ob6WhSQiF8dLzKdEniO_FeFeIxWXuPw_");
            st = this.connection.createStatement();
            met = this.connection.getMetaData();
            System.out.println("connected");
            System.out.println(met);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
