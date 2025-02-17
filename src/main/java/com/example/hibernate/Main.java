package com.example.hibernate;

import com.example.hibernate.dao.CourseDao;
import com.example.hibernate.dao.StudentDao;
import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        CourseDao courseDao = new CourseDao();

        Student student1 = new Student();
        student1.setName("John Snow");
        studentDao.saveStudent(student1);

        Student student2 = new Student();
        student2.setName("Luke Skywalker");
        studentDao.saveStudent(student2);

        Student student3 = new Student();
        student3.setName("Henry Smith");
        studentDao.saveStudent(student3);

        studentDao.deleteById(3L);

        Course course1 = new Course();
        course1.setTitle("Java developer. Junior level");
        courseDao.saveCourse(course1);

        Course course2 = new Course();
        course2.setTitle("The basics of Frontend development");
        courseDao.saveCourse(course2);

        Student findByIdStudent = studentDao.findById(1L);
        System.out.println(findByIdStudent);
        Course findByIdCourse = courseDao.findById(1L);
        System.out.println(findByIdCourse);


        studentDao.updateStudent(student1);
        courseDao.updateCourse(course2);

        List<Student> students = studentDao.findAll();
        if (students != null && !students.isEmpty()) {
            System.out.println("Найдены студенты:");
            for (Student student : students) {
                System.out.printf("ID: %d, Name: %s\n", student.getId(), student.getName());
            }
        } else {
            System.out.println("Студенты не найдены.");
        }

        List<Course> courses = courseDao.findAll();
        if (courses != null && !courses.isEmpty()) {
            System.out.println("Найдены курсы:");
            for (Course course : courses) {
                System.out.printf("ID: %d, Title: %s\n", course.getId(), course.getTitle());
            }
        } else {
            System.out.println("Курсы не найдены.");
        }


        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        studentDao.updateStudent(student1);


    }
}

