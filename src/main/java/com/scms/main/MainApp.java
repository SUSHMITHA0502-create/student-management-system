package com.scms.main;

import com.scms.dao.CourseDAO;
import com.scms.dao.EnrollmentDAO;
import com.scms.dao.StudentDAO;
import com.scms.model.Course;
import com.scms.model.Enrollment;
import com.scms.model.Student;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    static StudentDAO studentDAO = new StudentDAO();
    static CourseDAO courseDAO = new CourseDAO();
    static EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Course Management System =====");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Select role: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    studentMenu();
                    break;
                case 3:
                    System.out.println("System terminated.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ================= ADMIN MENU =================
    public static void adminMenu() {
        while (true) {
            System.out.println("\n----- ADMIN MENU -----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add Course");
            System.out.println("6. View All Courses");
            System.out.println("7. Update Course");
            System.out.println("8. Delete Course");
            System.out.println("9. View All Enrollments (by student)");
            System.out.println("10. Assign Grade");
            System.out.println("11. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter DOB (yyyy-mm-dd): ");
                        Date dob = Date.valueOf(sc.nextLine());
                        studentDAO.addStudent(new Student(name, email, dob));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        List<Student> students = studentDAO.getAllStudents();
                        students.forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter student ID to update: ");
                        int sid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        System.out.print("Enter new DOB (yyyy-mm-dd): ");
                        Date newDob = Date.valueOf(sc.nextLine());
                        studentDAO.updateStudent(new Student(sid, newName, newEmail, newDob));
                        System.out.println("Student updated.");
                        break;

                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        studentDAO.deleteStudent(sc.nextInt());
                        System.out.println("Student deleted.");
                        break;

                    case 5:
                        System.out.print("Enter course name: ");
                        String cname = sc.nextLine();
                        System.out.print("Enter credits: ");
                        int credits = sc.nextInt();
                        courseDAO.addCourse(new Course(cname, credits));
                        System.out.println("Course added.");
                        break;

                    case 6:
                        List<Course> courses = courseDAO.getAllCourses();
                        courses.forEach(System.out::println);
                        break;

                    case 7:
                        System.out.print("Enter course ID to update: ");
                        int cid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new course name: ");
                        String newCname = sc.nextLine();
                        System.out.print("Enter new credits: ");
                        int newCredits = sc.nextInt();
                        courseDAO.updateCourse(new Course(cid, newCname, newCredits));
                        System.out.println("Course updated.");
                        break;

                    case 8:
                        System.out.print("Enter course ID to delete: ");
                        courseDAO.deleteCourse(sc.nextInt());
                        System.out.println("Course deleted.");
                        break;

                    case 9:
                        System.out.print("Enter student ID: ");
                        int stId = sc.nextInt();
                        List<Enrollment> enrollments = enrollmentDAO.getEnrollmentsByStudent(stId);
                        enrollments.forEach(System.out::println);
                        break;

                    case 10:
                        System.out.print("Enter enrollment ID: ");
                        int eid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter grade: ");
                        String grade = sc.nextLine();
                        enrollmentDAO.updateGrade(eid, grade);
                        System.out.println("Grade assigned.");
                        break;

                    case 11:
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // ================= STUDENT MENU =================
    public static void studentMenu() {
        while (true) {
            System.out.println("\n----- STUDENT MENU -----");
            System.out.println("1. Register (Add Profile)");
            System.out.println("2. Update Profile");
            System.out.println("3. Enroll in Course");
            System.out.println("4. View My Courses");
            System.out.println("5. View My Grades");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter DOB (yyyy-mm-dd): ");
                        Date dob = Date.valueOf(sc.nextLine());
                        studentDAO.addStudent(new Student(name, email, dob));
                        System.out.println("Registration successful.");
                        break;

                    case 2:
                        System.out.print("Enter your student ID: ");
                        int sid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        System.out.print("Enter new DOB (yyyy-mm-dd): ");
                        Date newDob = Date.valueOf(sc.nextLine());
                        studentDAO.updateStudent(new Student(sid, newName, newEmail, newDob));
                        System.out.println("Profile updated.");
                        break;

                    case 3:
                        System.out.print("Enter your student ID: ");
                        int stId = sc.nextInt();
                        System.out.print("Enter course ID: ");
                        int coId = sc.nextInt();
                        enrollmentDAO.enrollStudent(stId, coId);
                        break;

                    case 4:
                        System.out.print("Enter your student ID: ");
                        int sid2 = sc.nextInt();
                        List<Enrollment> enrollments = enrollmentDAO.getEnrollmentsByStudent(sid2);
                        enrollments.forEach(System.out::println);
                        break;

                    case 5:
                        System.out.print("Enter your student ID: ");
                        int sid3 = sc.nextInt();
                        List<Enrollment> list = enrollmentDAO.getEnrollmentsByStudent(sid3);
                        for (Enrollment e : list) {
                            System.out.println("Course ID: " + e.getCourseId() + ", Grade: " + e.getGrade());
                        }
                        break;

                    case 6:
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

