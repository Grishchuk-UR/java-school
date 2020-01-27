package com.sbt.javaschool.rnd;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ManagementDatabase {
   // Connection getConnection() throws SQLException;
    boolean addStudent(Integer id, String name, String lastName);
    boolean removeStudent(Integer id);
    boolean removeStudent(String name);
    List<String> getVisit(Integer studentId, Integer lessonId);
    List<String> getStudent(Integer id);
    List<String> getLesson(Integer id);
    boolean addVisit(Integer studentId, Integer lessonId);
    boolean addLesson(Integer id, String lessonName, Data data);
    boolean removeLesson(Integer id);
    boolean removeLesson(String lessonName);

}
