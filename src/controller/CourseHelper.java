package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Course;


/**
 * @author martin whitman
 * course helper dao class for persistence on course entities
 *
 */
public class CourseHelper {
	static	EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("AttendanceApp");
	public void insertCourse(Course c) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * @return all courses
	 */
	public List<Course> showAllCourses(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Course> typedQuery = em.createQuery("select c from Course c", Course.class);
		typedQuery.setHint("javax.persistence.cache.storeMode", "BYPASS");
		List<Course> allCourses = typedQuery.getResultList();
		em.close();
		return allCourses;
	}
	
	/**
	 * @param studentID
	 * @return enrollments by student
	 */
	public List<Course> showEnrollmentsByStudent(int studentID){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Course> typedQuery = em.createQuery("select distinct c from Student s LEFT JOIN s.courses c where s.studentID= :studentID", Course.class);
		typedQuery.setParameter("studentID", studentID);
		typedQuery.setHint("javax.persistence.cache.storeMode", "BYPASS");
		List<Course> foundCourses= typedQuery.getResultList();
		
		em.close();
		return foundCourses;
	}
	public	void	cleanUp(){
		emfactory.close();
		}
}
