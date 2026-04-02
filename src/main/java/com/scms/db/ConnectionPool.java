package com.scms.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {

    private static List<Connection> list = new ArrayList<>();
    private static String url;
    private static String user;
    private static String password;
    private static int size = 5;

    static {
        try {
         
            Properties props = new Properties();
            InputStream input = ConnectionPool.class.getClassLoader()
                    .getResourceAsStream("db.properties");
            props.load(input);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

            Class.forName("org.postgresql.Driver");

            for (int i = 1; i <= size; i++) {
                Connection c = createConnection();
                list.add(c);
            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection createConnection() {
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static synchronized Connection getconnection() {
        if (!list.isEmpty()) {
            return list.remove(0);
        } else {
            return createConnection();
        }
    }

    public static synchronized void recieveconnection(Connection c) {
        if (c != null) {
            if (list.size() < size) {
                list.add(c);
            } else {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}