package controller;

import java.io.IOException;

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

/**
 * Servlet implementation class Add_Student_To_Course_Servlet
 */
@WebServlet("/Add_Student_To_Course_Servlet")
public class Add_Student_To_Course_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static EntityManagerFactory emfactory = new PersistenceProvider().createEntityManagerFactory("AttendanceApp",null);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Student_To_Course_Servlet() {
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
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("select s from Student s where s.studentID= :studentID",Student.class);
		typedQuery.setParameter("studentID", Integer.parseInt(request.getParameter("studentID")));
		Student resultS = typedQuery.getSingleResult();
		TypedQuery<Course> typedQuery2 = em.createQuery("select c from Course c where c.courseID= :courseID", Course.class);
		typedQuery2.setParameter("courseID", Integer.parseInt(request.getParameter("courseID")));
		Course resultC = typedQuery2.getSingleResult();
		resultS.getCourses().add(resultC);
		resultC.getStudents().add(resultS);
		em.persist(resultC);
		em.persist(resultS);
		em.getTransaction().commit();
		em.close();
		getServletContext().getRequestDispatcher("/addStudentToCourse.jsp").forward(request, response);
	}

}
