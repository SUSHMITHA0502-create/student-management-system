package com.scms.db;

import java.sql.Connection;


public class DBConnection {
	public static Connection getConnection() {
        return ConnectionPool.getconnection();
    }

    public static void releaseConnection(Connection con) {
        ConnectionPool.recieveconnection(con);
    }

}
