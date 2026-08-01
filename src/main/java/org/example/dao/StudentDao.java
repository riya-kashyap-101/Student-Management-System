package org.example.dao;

import org.example.model.Student;
import org.example.util.DBConnection;

import java.sql.*;

public class StudentDao {

    public void addStudent(Student student) {

        String query = "INSERT INTO student(name,email,course,age) VALUES(?,?,?,?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getAge());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {
        String query = "SELECT * FROM student";
        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("---------------------------------------");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Course : " + rs.getString("course"));
                System.out.println("Age : " + rs.getInt("age"));


            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String course, int age) {

        String q = "UPDATE student SET course = ?, age = ? WHERE id = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, course);
            ps.setInt(2, age);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dltStudent(int id) {

        String sql = "DELETE FROM student WHERE id=?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            int r = ps.executeUpdate();
            if(r>0){
                System.out.println("Student deletes Succesfully");
            }
            else{
                System.out.println("Student not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
