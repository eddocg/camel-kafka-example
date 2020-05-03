package com.eddocg.db;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.SQLException;

public class OracleDS extends OracleDataSource {
    public OracleDS() throws SQLException {
        setServerName("localhost");
        setDatabaseName("xe");
        setPortNumber(1521);
        setDriverType("thin");
        setUser("system");
        setPassword("eddo552801");
    }
}
