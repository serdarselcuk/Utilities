package com.trycloudapp.utilities;

public class DBUtility {

    public static DatabaseMetaData metaData;
    private static Connection connection;
    private static Statement statement;

    /**
     * We used static block, so whenever we call the methods from the class this block will be executed first...
     * Basically connection and statement steps will be initialized
     */
    static {
        String url = ConfigurationReader.getProperty("database_url");
        String password = ConfigurationReader.getProperty("database_password");
        String username = ConfigurationReader.getProperty("database_username");

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            metaData = connection.getMetaData();
        } catch (SQLException e) {
            System.out.println("Connection failure!");
        }

    }


    /**
     * The method takes sql query and after executing the query returns result
     *
     * @param sql
     * @return A data manipulation language (DML) is a computer programming language
     * used for adding (inserting), deleting, and modifying (updating) data in a database.
     * A DML is often a sub-language of a broader database language such as SQL,
     * with the DML comprising some of the operators in the language.
     */
    public static ResultSet getResult(String sql) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Failure while executing the sql query!");
        }
        return resultSet;
    }

    /**
     * Data Definition Language (DDL) refers to the CREATE, ALTER and DROP statements.
     * DDL or Data Definition Language actually consists of the SQL commands that can be
     * used to define the database schema. DDL allows to add / modify / delete the logical
     * structures which contain the data or which allow users to access / maintain the data
     * (databases, tables, keys, views...). DDL is about "metadata".
     * <p>
     * For --> INSERT, UPDATE, DELETE, ALTER, TRUNCATE, DROP
     *
     * @param sql
     */
    public static void updateQuery(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Updating table was not successful!");
        }
    }

    public static void teardown() {
        try {
            connection.close();
        } catch (SQLException e) {

        }
    }

}
