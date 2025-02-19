package com.example.hibernate;

import com.example.hibernate.dao.StudentDao;
import com.example.hibernate.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentTest {
    StudentDao studentDao = new StudentDao();

    @Test
    public void testSaveStudent() {
        Student student = new Student();
        student.setName("John Smith");
        studentDao.saveStudent(student);

        Student foundStudent = studentDao.findById(student.getId());
        Assertions.assertNotNull(foundStudent);
        Assertions.assertEquals("John Smith", foundStudent.getName());
    }

    @Test
    public void testFindById() {
        Student student = new Student();
        student.setName("Jane Smith");
        studentDao.saveStudent(student);

        Student foundStudent = studentDao.findById(student.getId());
        Assertions.assertNotNull(foundStudent);
        Assertions.assertEquals("Jane Smith", foundStudent.getName());
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setName("John Smith");
        studentDao.saveStudent(student);

        student.setName("Jane Smith");
        studentDao.updateStudent(student);

        Student foundStudent = studentDao.findById(student.getId());
        Assertions.assertNotNull(foundStudent);
        Assertions.assertEquals("Jane Smith", foundStudent.getName());
    }

    @Test
    public void testFindAllStudents() {
        Student student1 = new Student();
        student1.setName("John Smith");
        studentDao.saveStudent(student1);

        Student student2 = new Student();
        student2.setName("Jane Smith");
        studentDao.saveStudent(student2);

        List<Student> students = studentDao.findAll();
        Assertions.assertNotNull(students);
        Assertions.assertEquals(2, students.size());
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student();
        student.setName("John Smith");
        studentDao.saveStudent(student);

        studentDao.deleteById(student.getId());

        Student foundStudent = studentDao.findById(student.getId());
        Assertions.assertNull(foundStudent);
    }
}


