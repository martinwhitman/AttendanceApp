package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SessionAttendance;



/**
 * @author martin whitman session attendance helper dao class for queries on attendance and persistence on session entity
 *
 */
public class SessionAttendanceHelper {
	static	EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("AttendanceApp");
	public void insertSession(SessionAttendance a) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * @param studentID
	 * @return attendance by student id
	 */
	public List<SessionAttendance> getAttendanceByStudent(int studentID){
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SessionAttendance> typedQuery = em.createQuery("select a from SessionAttendance a where a.student.studentID = :selectedStudent",SessionAttendance.class);
		typedQuery.setParameter("selectedStudent",studentID);
		typedQuery.setHint("javax.persistence.cache.storeMode", "BYPASS");
		List<SessionAttendance> foundList= typedQuery.getResultList();
		
		em.close();
		
		return foundList;
		
	}
	
	/**
	 * @param courseID
	 * @return attendance by course id
	 */
	public List<SessionAttendance> getAttendanceByCourse(int courseID){
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SessionAttendance> typedQuery = em.createQuery("select a from SessionAttendance a where a.course.courseID = :selectedCourse",SessionAttendance.class);
		typedQuery.setParameter("selectedCourse",courseID);
		typedQuery.setHint("javax.persistence.cache.storeMode", "BYPASS");
		List<SessionAttendance> foundList = typedQuery.getResultList();
		
		em.close();
		return foundList;
	}
	
	/**
	 * @param studentID
	 * @param courseID
	 * @return attendance by student and course
	 */
	public List<SessionAttendance> getAttendanceByStudentAndCourse (int studentID, int courseID){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SessionAttendance> typedQuery = em.createQuery("select a from SessionAttendance a where a.course.courseID= :selectedCourse and a.student.studentID = :selectedStudent", SessionAttendance.class);
		typedQuery.setParameter("selectedCourse",courseID);
		typedQuery.setParameter("selectedStudent", studentID);
		typedQuery.setHint("javax.persistence.cache.storeMode", "BYPASS");
		List<SessionAttendance> foundAttendance = typedQuery.getResultList();
		
		em.close();
		return foundAttendance;
	}
	public	void	cleanUp(){
		emfactory.close();
		}
}
