package axi.source.service;

import java.io.IOException;  
import java.io.InputStream;  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.MultipartConfig;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.Part;  
  
import axi.source.service.DbUtil;  
  
@WebServlet("/quoteUpload")  
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB  
public class UploadServlet extends HttpServlet {  
  
    private static final long serialVersionUID = -1623656324694499109L;  
    private Connection conn;  
  
    public UploadServlet() {  
        conn = DbUtil.getConnection();  
        System.out.print(conn);
        System.out.print("connection");
    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
          
        // gets values of text fields  
        String quoteDate = request.getParameter("quoteDate");  
        String datafile = request.getParameter("datafile");  
  
        InputStream inputStream = null;  
  
        // obtains the upload file part in this multipart request  
        Part filePart = request.getPart("datafile");  
        if (filePart != null) {  
            // debug messages  
            System.out.println(filePart.getName());  
            System.out.println(filePart.getSize());  
            System.out.println(filePart.getContentType());  
  
            // obtains input stream of the upload file  
            inputStream = filePart.getInputStream();  
        }  
  
        String message = null; // message will be sent back to client  
  
        try {  
            // constructs SQL statement  
            String sql = "INSERT INTO `hibernatedb`.`quote` (`quote_date`, `quote_pdf`) values (?, ?)"; 
            
            System.out.println(sql);
            PreparedStatement statement = conn.prepareStatement(sql);  
            statement.setString(1, quoteDate);  
            statement.setString(2, datafile);  
  
            if (inputStream != null) {  
                // fetches input stream of the upload file for the blob column  
                statement.setBlob(2, inputStream);  
            }  
  
            // sends the statement to the database server  
            int row = statement.executeUpdate();  
            if (row > 0) {  
                message = "Image is uploaded successfully into the Database";  
            }  
        } catch (SQLException ex) {  
            message = "ERROR: " + ex.getMessage();  
            ex.printStackTrace();  
        }  
        // sets the message in request scope  
        request.setAttribute("Message", message);  
  
        // forwards to the message page  
        getServletContext().getRequestDispatcher("/indexQuote").forward(  
                request, response);  
    }  
}  
