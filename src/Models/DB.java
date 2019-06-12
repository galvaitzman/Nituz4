package Models;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    protected String DBName;

    public DB(String DBName) {

        this.DBName = DBName;

    }

    /**
     * This method create if doesn't exist a new database by the name which equal to the databaseName field.
     */
    public void connect(String databaseName) {
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
            connection.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

}
