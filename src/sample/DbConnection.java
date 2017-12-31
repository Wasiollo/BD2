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

    private static Connection con;
    private static DatabaseMetaData met;
    private static Statement st;
    private static ResultSet rs;

    public DbConnection() {
    }

    private static void getConnect() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/wfbqjvbl", "wfbqjvbl", "Ob6WhSQiF8dLzKdEniO_FeFeIxWXuPw_");
            st = con.createStatement();
            met = con.getMetaData();
            System.out.println("connected");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/wfbqjvbl", "wfbqjvbl", "Ob6WhSQiF8dLzKdEniO_FeFeIxWXuPw_");
            st = con.createStatement();
            met = con.getMetaData();
            System.out.println("connected");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static void disConnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public static ArrayList getAddressTable() {
        try {
            ArrayList<Address> addressArrayList = new ArrayList<>();

            getConnect();
            String query = "SELECT * FROM address";
            rs = st.executeQuery(query);
            while (rs.next()) {
                Integer idAddress = rs.getInt("idAddress");
                String city = rs.getString("city");
                String street = rs.getString("street");
                Integer number = rs.getInt("number");
                Integer code = rs.getInt("code");


                Address temp = new Address();

                temp.setId(idAddress);
                temp.setCity(city);
                temp.setStreet(street);
                temp.setNumber(number);
                temp.setCode(code);

                addressArrayList.add(temp);
            }

            return addressArrayList;

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disConnect();
        }
        return null;
    }
*/

    /**
     * @param id
     * @param from
     * @param idName
     * @return
     */
    public static Boolean deleteQuery(Integer id, String from, String idName) {
        try {


            getConnect();
            String query = "DELETE FROM " + from + " WHERE " + idName + " = " + id;
            st.executeUpdate(query);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disConnect();
        }
        return null;
    }

    /**
     * @param query
     */
    public static void executeQuery(String query) {
        try {
            getConnect();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disConnect();
        }

    }

}
