package kz.aitu.Universityms.Controllers;

import java.sql.*;

public class dbms {

    public static void addCourse(String courseName, String courseCode, Integer credits) {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionURL, "postgres", "tLhtitom5@");

            String sqlCourse = "INSERT INTO course (course_name, course_code, credits) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sqlCourse);

            stmt.setString(1, courseName);
            stmt.setString(2, courseCode);
            stmt.setInt(3, credits);

            stmt.executeUpdate();
            System.out.println("Course added: " + courseName);

        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database error occurred while adding course.");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources.");
                e.printStackTrace();
            }
        }
    }

    public static String getCourseInfo() {
        StringBuilder result = new StringBuilder();
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionURL, "postgres", "tLhtitom5@");

            String sql = "SELECT * FROM course";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            // Формируем текст с данными
            while (rs.next()) {
                String name = rs.getString("course_name");
                String location = rs.getString("course_code");
                int rating = rs.getInt("credits");

                result.append("Course name: ").append(name).append("\n");
                result.append("Course code: ").append(location).append("\n");
                result.append("Course credits: ").append(rating).append("\n");
                result.append("-------------------------\n");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result.toString(); // Возвращаем текстовый результат
    }

    public static void updateCourseCredits(String courseName, Integer newCredit) {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionURL, "postgres", "tLhtitom5@");

            String sql = "UPDATE course SET credits = ? WHERE course_name = ?";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, newCredit);
            stmt.setString(2, courseName);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Rating for " + courseName + " updated to " + newCredit);
            } else {
                System.out.println("University not found or no rows were updated.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dropCourse(String CourseName) {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionURL, "postgres", "tLhtitom5@");

            String sql = "DELETE FROM course WHERE course_name = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, CourseName);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("University " + CourseName + " was deleted.");
            } else {
                System.out.println("No rows were deleted.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void addUni(String universityName, String location, Integer rating) {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionURL, "postgres", "tLhtitom5@");

            String sqlUniver = "INSERT INTO univer (name, location, rating) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sqlUniver);


            stmt.setString(1, universityName);
            stmt.setString(2, location);
            stmt.setInt(3, rating);

            stmt.executeUpdate();

            System.out.println("University added: " + universityName);

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dropUni(String universityName) {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionURL, "postgres", "tLhtitom5@");

            String sql = "DELETE FROM univer WHERE name = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, universityName);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("University " + universityName + " was deleted.");
            } else {
                System.out.println("No rows were deleted.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateUniRating(String uniName, Integer newRat) {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionURL, "postgres", "tLhtitom5@");

            String sql = "UPDATE univer SET rating = ? WHERE name = ?";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, newRat);
            stmt.setString(2, uniName);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Rating for " + uniName + " updated to " + newRat);
            } else {
                System.out.println("University not found or no rows were updated.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getUniversityInfo() {
        StringBuilder result = new StringBuilder();
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionURL, "postgres", "tLhtitom5@");

            String sql = "SELECT * FROM univer";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            // Формируем текст с данными
            while (rs.next()) {
                String name = rs.getString("name");
                String location = rs.getString("location");
                int rating = rs.getInt("rating");

                result.append("University Name: ").append(name).append("\n");
                result.append("Location: ").append(location).append("\n");
                result.append("Rating: ").append(rating).append("\n");
                result.append("-------------------------\n");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result.toString(); // Возвращаем текстовый результат
    }


}


