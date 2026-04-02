package com.scms.dao;

import com.scms.db.DBConnection;
import com.scms.model.Enrollment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

   
    public void enrollStudent(int studentId, int courseId) throws Exception {
        String sql = "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";
        Connection con = null;

        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();

            con.commit();
            System.out.println("Enrollment successful");

        } catch (Exception e) {
            if (con != null) con.rollback();
            throw e;
        } finally {
            if (con != null) con.close();
        }
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) throws Exception {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM enrollments WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Enrollment e = new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getString("grade")
                );
                enrollments.add(e);
            }
        }
        return enrollments;
    }

  
    public void updateGrade(int enrollmentId, String grade) throws Exception {
        String sql = "UPDATE enrollments SET grade=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, grade);
            ps.setInt(2, enrollmentId);
            ps.executeUpdate();
        }
    }

   
    public void deleteEnrollment(int enrollmentId) throws Exception {
        String sql = "DELETE FROM enrollments WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, enrollmentId);
            ps.executeUpdate();
        }
    }
}
