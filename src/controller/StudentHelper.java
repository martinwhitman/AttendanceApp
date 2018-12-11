package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Student;

/**
 * @author martin whitman
 * student helper data access object class for executing persistence/queries on student entities
 *
 */
public class StudentHelper {
	static	EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("AttendanceApp");
	public void insertStudent(Student s) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * @return all students
	 */
	public List<Student> showAllStudents(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Student> typedQuery = em.createQuery("select s from Student s", Student.class);
		typedQuery.setHint("javax.persistence.cache.storeMode", "BYPASS");
		List<Student> allStudents = typedQuery.getResultList();
		em.close();
		return allStudents;
	}
	
	/**
	 * @param courseID
	 * @return enrollments by course
	 */
	public List<Student> showEnrollmentsByCourse(int courseID){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Student> typedQuery = em.createQuery("select distinct s from Course c LEFT JOIN c.students s where c.courseID= :courseID", Student.class);
		typedQuery.setParameter("courseID",courseID);
		typedQuery.setHint("javax.persistence.cache.storeMode", "BYPASS");
		List<Student> foundStudents = typedQuery.getResultList();
		
		em.close();
		return foundStudents;
	}
	
	public	void	cleanUp(){
		emfactory.close();
		}
}
