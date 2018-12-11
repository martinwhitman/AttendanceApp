package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAttendanceByStudentAndCourseServlet
 */
@WebServlet("/viewAttendanceByStudentAndCourseServlet")
public class viewAttendanceByStudentAndCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAttendanceByStudentAndCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		SessionAttendanceHelper dao = new SessionAttendanceHelper();
		
		request.setAttribute("attendance", dao.getAttendanceByStudentAndCourse(studentID, courseID));
		
		getServletContext().getRequestDispatcher("/viewAttendanceByStudentAndCourseResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
