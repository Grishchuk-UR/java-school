package com.sbt.javaschool.rnd;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagementDatabaseImpl implements ManagementDatabase {
    private String pass;
    private String login;
    private String url;
    private Connection connection;

    public ManagementDatabaseImpl(String pass, String login, String url) {
        this.pass = pass;
        this.login = login;
        this.url = url;
        try {
            connection = DriverManager.getConnection(url, login, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addStudent(Integer id, String name, String lastName) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO STUDENTS (ID, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?)")) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, lastName);
            statement.executeUpdate();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeStudent(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM STUDENTS WHERE ID ==? ")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeStudent(String name) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM STUDENTS WHERE FIRST_NAME == ? ")) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<String> getVisit(Integer studentId, Integer lessonId) {
        if (studentId == null && lessonId == null) {

        }
        return null;
    }

    @Override
    public List<String> getStudent(Integer id) {
        List<String> listStudent = new ArrayList<String>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet;
            if (id != null)
                resultSet = stmt.executeQuery("SELECT * FROM STUDENTS");
            else {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENTS WHERE ID == ?");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getResultSet();
            }
            while (resultSet.next()) {
                listStudent.add(resultSet.getString(1));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listStudent;
}


    @Override
    public List<String> getLesson(Integer id) {
        return null;
    }


    @Override
    public boolean addVisit(Integer studentId, Integer lessonId) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO STUDENT_VISIT (STUDENT_ID, LESSON_ID) VALUES (?, ?)")) {
            statement.setInt(1, studentId);
            statement.setInt(1, lessonId);
            statement.executeUpdate();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addLesson(Integer id, String lessonName, Data data) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO LESSONS (ID, LESSON_NAME, DT) VALUES (?, ?, ?)")) {
            statement.setInt(1, id);
            statement.setString(2, lessonName);
            statement.setDate(3, (Date) data);
            statement.executeUpdate();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeLesson(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM LESSONS WHERE ID == ? ")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeLesson(String lessonName) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM LESSONS WHERE LESSON_NAME == ? ")) {
            statement.setString(1, lessonName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
