package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.jpa.PersistenceProvider;
import model.Course;
import model.Student;
import model.SessionAttendance;

/**
 * Servlet implementation class takeAttendance
 */
@WebServlet("/takeAttendanceServlet")
public class takeAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static EntityManagerFactory emfactory = new PersistenceProvider().createEntityManagerFactory("AttendanceApp",null);

	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public takeAttendanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseID = request.getParameter("courseID");
		String studentID= request.getParameter("studentID");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("select s from Student s where s.studentID= :studentID",Student.class);
		typedQuery.setParameter("studentID", Integer.parseInt(studentID));
		Student resultS = typedQuery.getSingleResult();
		TypedQuery<Course> typedQuery2 = em.createQuery("select c from Course c where c.courseID= :courseID", Course.class);
		typedQuery2.setParameter("courseID", Integer.parseInt(courseID));
		Course resultC = typedQuery2.getSingleResult();
		boolean present;
		if(request.getParameter("present")!=null) {
			present = true;
		}
		else {
			present = false;
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		try {
			Date sessionDate=format.parse(request.getParameter("sessionDate"));
			SessionAttendanceHelper dao = new SessionAttendanceHelper();
			SessionAttendance session = new SessionAttendance(sessionDate, resultC, resultS, present);
			dao.insertSession(session);
			getServletContext().getRequestDispatcher("/attendance.jsp").forward(request, response);
		}
		 catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
