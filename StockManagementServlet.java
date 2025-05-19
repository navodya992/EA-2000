package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/stockAction")
public class StockManagementServlet extends HttpServlet {

   private Connection getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ Load MySQL Driver class
    } catch (ClassNotFoundException e) {
        throw new SQLException("MySQL JDBC Driver not found!", e);
    }

    String url = "jdbc:mysql://localhost:3306/stock_management?useSSL=false&serverTimezone=UTC";
    String username = "root";
    String password = ""; // change as per your DB password
    return DriverManager.getConnection(url, username, password);
}


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String productName = request.getParameter("product_name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = getConnection()) {
            switch (action) {
                

                case "Update Product":
                    try (PreparedStatement stmt = conn.prepareStatement(
                            "UPDATE stock SET quantity = ? WHERE product_name = ?")) {
                        stmt.setInt(1, quantity);
                        stmt.setString(2, productName);
                        stmt.executeUpdate();
                        out.println("<h1>Product Updated Successfully</h1>");
                    }
                    break;
                    case "Add Product":
    try (PreparedStatement stmt = conn.prepareStatement(
        "INSERT INTO stock (product_name, quantity) VALUES (?, ?)")) {
        stmt.setString(1, productName);
        stmt.setInt(2, quantity);
        stmt.executeUpdate();

        response.getWriter().write("<h1>Product Added Successfully</h1>");
    }
    break;


                case "Delete Product":
                    try (PreparedStatement stmt = conn.prepareStatement(
                            "DELETE FROM stock WHERE product_name = ?")) {
                        stmt.setString(1, productName);
                        stmt.executeUpdate();
                        out.println("<h1>Product Deleted Successfully</h1>");
                    }
                    break;

                default:
                    out.println("<h1>Invalid Action</h1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h1>Database Error: " + e.getMessage() + "</h1>");
        }
    }
}
