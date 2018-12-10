package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@Column(name="courseID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseID;
	@OneToMany(targetEntity=SessionAttendance.class,mappedBy="course",cascade=CascadeType.ALL)
	private List<SessionAttendance> sessionAttendance;
	@Column(name="instructor")
	private String instructor;
	@Column(name="room")
	private String room;
	@ManyToMany(mappedBy="courses")
	private List<Student> students;
	
	
	/**
	 * no arg constructor
	 */
	public Course() {
	}
	
	
	
	/**
	 * @param instructor
	 * @param room
	 */
	public Course(String instructor, String room) {
		this.instructor = instructor;
		this.room = room;
	}



	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}



	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", instructor=" + instructor + ", room=" + room + "]";
	}



	public List<SessionAttendance> getSessionAttendance() {
		return sessionAttendance;
	}



	public void setSessionAttendance(List<SessionAttendance> sessionAttendance) {
		this.sessionAttendance = sessionAttendance;
	}



	public List<Student> getStudents() {
		return students;
	}



	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
