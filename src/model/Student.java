package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "studentID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentID;
	@OneToMany(targetEntity = SessionAttendance.class, mappedBy = "student", cascade = CascadeType.ALL)
	private List<SessionAttendance> sessionAttendance;
	@Column(name = "name")
	private String name;
	@Column(name = "dob", columnDefinition = "DATE")
	private Date dob;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "studentID", referencedColumnName = "studentID"), inverseJoinColumns = @JoinColumn(name = "courseID", referencedColumnName = "courseID"))
	private List<Course> courses;

	

	/**
	 * no arg constructor
	 */
	public Student() {
	}

	/**
	 * @param name
	 * @param dob
	 */
	public Student(String name, Date dob) {
		this.name = name;
		this.dob = dob;
	}
	public List<SessionAttendance> getSessionAttendance() {
		return sessionAttendance;
	}
	public void setSessionAttendance(List<SessionAttendance> sessionAttendance) {
		this.sessionAttendance = sessionAttendance;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", dob=" + dob + "]";
	}

}
