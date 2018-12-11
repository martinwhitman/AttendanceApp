package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Student;

public class StudentHelper {
	static	EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("AttendanceApp");
	public void insertStudent(Student s) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Student> showAllStudents(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Student> typedQuery = em.createQuery("select s from Student s", Student.class);
		typedQuery.setHint("javax.persistence.cache.storeMode", "BYPASS");
		List<Student> allStudents = typedQuery.getResultList();
		em.close();
		return allStudents;
	}
	
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
