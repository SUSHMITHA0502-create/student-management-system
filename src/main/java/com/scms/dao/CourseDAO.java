package com.scms.dao;

import com.scms.db.DBConnection;
import com.scms.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

 
    public void addCourse(Course course) throws Exception {
        String sql = "INSERT INTO courses(name, credits) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getName());
            ps.setInt(2, course.getCredits());
            ps.executeUpdate();
        }
    }

    public List<Course> getAllCourses() throws Exception {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Course c = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("credits")
                );
                courses.add(c);
            }
        }
        return courses;
    }

  
    public void updateCourse(Course course) throws Exception {
        String sql = "UPDATE courses SET name=?, credits=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getName());
            ps.setInt(2, course.getCredits());
            ps.setInt(3, course.getId());
            ps.executeUpdate();
        }
    }

 
    public void deleteCourse(int id) throws Exception {
        String sql = "DELETE FROM courses WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
