package steps;

import io.cucumber.java.ru.Дано;

import java.sql.*;
public class ProductPageActionsSteps {


    Connection connection = DriverManager.getConnection
            ("jdbc:h2:tcp://localhost:9092/mem:testdb",
                    "user", "pass");
    private final Statement statement = connection.createStatement ();

    public ProductPageActionsSteps () throws SQLException {
    }

    @Дано("заходим на сайт {string}, вводим логин {string} и пароль {string}")
    public void заходимНаСайтВводимЛогинИПароль (String url, String user, String pass) throws SQLException {
        DriverManager.getConnection
                (url, user, pass);


    }


    @Дано("Выборка всех строк таблицы FOOD индексом >={int}")
    public void выборкаВсехСтрокТаблицыFOODИндексом (int arg0) throws SQLException {
        String query = "SELECT  *  FROM FOOD WHERE FOOD_ID >= 5";
        ResultSet resultSet = statement.executeQuery (query);
        if (resultSet.next ()) {
            throw new IllegalStateException ("Таблица не является изначальной.");
        } else {
            System.out.println ("Таблица является базовой.");
        }

    }



    @Дано("Добавление новых товаров в таблицу FOOD {int},{string},{string}, {int}")
    public void добавлениеНовыхТоваровВТаблицуFOOD (int arg0, String arg1, String arg2, int arg3) throws SQLException {
        PreparedStatement statement1 = connection.prepareStatement
                ("INSERT INTO FOOD (FOOD_ID, FOOD_NAME, FOOD_TYPE, FOOD_EXOTIC) VALUES (?, ?, ?, ?)");
        statement1.setInt (1, arg0);
        statement1.setString (2, arg1);
        statement1.setString (3, arg2);
        statement1.setInt (4, arg3);

        statement1.executeUpdate ();
    }

    @Дано("Удаление всех строк таблицы FOOD с индексом >={int}")
    public void удалениеВсехСтрокТаблицыFOODСИндексом (int arg0) throws SQLException {
        String delete = "DELETE from FOOD where FOOD_ID >= 5";
        statement.executeUpdate (delete);
    }
}

