package com.javabydeveloper;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.javabydeveloper.domain.Student;
import com.javabydeveloper.domain.Teacher;

/**
 * JPA Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("jbd-pu");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

//			Student student = new Student();
//			student.setFirstName("John");
//			student.setLastName("Bloch");
//			student.setContactNo("+1-408-575-1317");
//
//			entityManager.persist(student);
			
			Teacher teacher = new Teacher();
			teacher.setTName("Ashok");
			teacher.setSubject("Data Structures");
			teacher.setDegree("M.E C.S.E");
			entityManager.persist(teacher);
					

			transaction.commit();
		
//			Query q = entityManager.createQuery("select s from Stu s");
			Query q= entityManager.createQuery("select t from teacher t");
//			List<Student> resultList = q.getResultList();
			List<Teacher> resultList = q.getResultList();
//			System.out.println("num of sudents:" + resultList.size());
//			for (Student next : resultList) {
//				System.out.println("Student:  " + next);
//			}
			System.out.println(Arrays.toString(resultList.toArray()));
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
	}
}
