package model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author martin whitman
 * class definition and annotation
 */
@Entity
@Table(name="session")
public class SessionAttendance {
	@Id
	@Column(name="sessionDate", columnDefinition="DATE")
	private Date sessionDate;
	@ManyToOne
	@JoinColumn(name="courseID")
	private Course course;
	@ManyToOne
	@JoinColumn(name="studentID")
	private Student student;
	@Column(name="present", columnDefinition = "TINYINT(1)")
	private boolean present;
	
	
	/**
	 * no arg constructor
	 */
	public SessionAttendance() {
	}
	
	
	
	/**
	 * @param sessionDate
	 * @param course
	 * @param student
	 * @param present
	 */
	public SessionAttendance(Date sessionDate, Course course, Student student, boolean present) {
		this.sessionDate = sessionDate;
		this.course = course;
		this.student = student;
		this.present = present;
	}


	//getters and setters
	public Date getSessionDate() {
		return sessionDate;
	}
	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}
	
	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}

	
	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}


	@Override
	public String toString() {
		return "SessionAttendance [sessionDate=" + sessionDate + ", course=" + course + ", student=" + student
				+ ", present=" + present + "]";
	}

	
}
