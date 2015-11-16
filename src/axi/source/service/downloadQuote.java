package axi.source.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class downloadQuote
 */
@WebServlet("/downloadQuote")
public class downloadQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// size of byte buffer to send file
	private static final int BUFFER_SIZE = 4096;

	// database connection settings
	private String dbURL = "jdbc:mysql://localhost:3306/hibernatedb";
	private String dbUser = "root";
	private String dbPass = "123456";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public downloadQuote() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get upload id from URL's parameters
		int quoteId = Integer.parseInt(request.getParameter("quote_id"));
		Connection conn = null; // connection to the database

		try {
			// connects to the database
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

			// queries the database
			String sql = "SELECT * FROM quote WHERE quote_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, quoteId);

			ResultSet result = statement.executeQuery();
			System.out.println(result);
			if (result.next()) {
				Blob blob = result.getBlob("quote_pdf");
				InputStream inputStream = blob.getBinaryStream();				
				int fileLength = inputStream.available();
				System.out.println("fileLength = " + fileLength);
				ServletContext context = getServletContext();
				// sets MIME type for the file download
				String mimeType = "application/octet-stream";
				
				// set content properties and header attributes for the response
				response.setContentType(mimeType);
				response.setContentLength(fileLength);
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", "Quote.pdf");
				response.setHeader(headerKey, headerValue);

				// writes the file to the client
				OutputStream outStream = response.getOutputStream();

				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}

				inputStream.close();
				outStream.close();
			} else {
				// no file found
				response.getWriter().print(
						"File not found for the id: " + quoteId);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			response.getWriter().print("SQL Error: " + ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
			response.getWriter().print("IO Error: " + ex.getMessage());
		} finally {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
