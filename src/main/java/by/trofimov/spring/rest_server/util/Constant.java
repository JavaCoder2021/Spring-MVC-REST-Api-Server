package by.trofimov.spring.rest_server.util;

public class Constant {

    public static final String MY_CONFIG_PACKAGES_TO_SCAN = "by.trofimov.spring.rest_server";

    public static final String SESSION_FACTORY_PACKAGES_TO_SCAN = "by.trofimov.spring.rest_server.entity";
    public static final String SESSION_FACTORY_HIBERNATE_DIALECT = "hibernate.dialect";
    public static final String SESSION_FACTORY_MYSQL_DIALECT = "org.hibernate.dialect.MySQLDialect";
    public static final String SESSION_FACTORY_SHOW_SQL = "hibernate.show_sql";
    public static final String SESSION_FACTORY_TRUE = "true";

    public static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    public static final String DB_JDBC_URL = "jdbc:mysql://localhost:3306/my_db?useSSL=false&amp";
    public static final String DB_USER = "bestuser";
    public static final String DB_PASSWORD = "bestuser";

    public static final String NO_EMPLOYEE_WITH_ID = "There is no employee with id = ";
    public static final String IN_DATABASE = " in Database";
    public static final String EMPLOYEE_WITH_ID = "Employee with ID = ";
    public static final String WAS_DELETED = " was deleted" ;

    public static final String FROM_EMPLOYEE = "FROM Employee";
    public static final String DELETE_FROM_EMPLOYEE = "DELETE FROM Employee WHERE id = ";

}
