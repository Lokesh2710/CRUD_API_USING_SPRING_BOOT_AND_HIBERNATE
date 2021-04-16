package com.lokeshDev.crud_app.Service;

import org.springframework.stereotype.Service;

import com.lokeshDev.crud_app.entity.Student;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@Service
public class StudentService {
	
	
	static Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
	static ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	static SessionFactory sf = config.buildSessionFactory(registry);
		
	public Student saveStudent(Student student) //Create Student Data
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		return student;
	}

	public List<Student> getStudents() //Get Student(list) Data
	{
		Session get_data = sf.openSession();
		get_data.beginTransaction();
		Query q  = get_data.createQuery("from Student");
		List<Student> stud = q.list();
		get_data.getTransaction().commit();
		return stud;
	}
	
	public String deleteStudent(int id)
	{
		Session delete_data = sf.openSession();
		delete_data.beginTransaction();
        Student studObj = (Student) delete_data.load(Student.class,id);
        delete_data.delete(studObj);
        delete_data.getTransaction().commit();
		return "Student Having "+id+" Deleted ";
	}
	

	public Student updateStudentInfo(Student student)
	{
		Session update_data = sf.openSession();
		update_data.beginTransaction();
		Student studObj = (Student) update_data.load(Student.class,student.getId());
		studObj.SetName(student.getName());
		studObj.SetSubject(student.getSubject());
		studObj.SetScore(student.getScore());
		update_data.save(studObj);
		update_data.getTransaction().commit();
		return studObj;	
	}

	/*public Student getStudentById(int Id) 
	{
		int k = Id;
		Session get_data_by_id = sf.openSession();
		get_data_by_id.beginTransaction();
		//Query q  = get_data_by_id.createQuery("from Student where rollno='+id'");
		Query query = get_data_by_id.createQuery("from Student e where e.id=:k");
		query.setParameter("id", k);
		
		List<Student> stud = query.list();
		Student stud1 = (Student)query.uniqueResult();
		get_data_by_id.getTransaction().commit();
		return stud1;
	}
	*/
	
	/*public List<Student> saveStudents(List<Student> students)
	{
		return repository.saveAll(students);
	}*/
	
	/*
	public Student getStudentByName(String name)
	{
		return repository.findByName(name);
	}
	*/
}
