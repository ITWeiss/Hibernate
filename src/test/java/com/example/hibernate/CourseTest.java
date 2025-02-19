package com.example.hibernate;

import com.example.hibernate.dao.CourseDao;
import com.example.hibernate.entity.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CourseTest {
    CourseDao courseDao = new CourseDao();

    @Test
    public void testSaveCourse() {
        Course course = new Course();
        course.setTitle("Java");
        courseDao.saveCourse(course);

        Course foundCourse = courseDao.findById(course.getId());
        Assertions.assertNotNull(foundCourse);
        Assertions.assertEquals("Java", foundCourse.getTitle());
    }

    @Test
    public void testFindById() {
        Course course = new Course();
        course.setTitle("Java");
        courseDao.saveCourse(course);

        Course foundCourse = courseDao.findById(course.getId());
        Assertions.assertNotNull(foundCourse);
        Assertions.assertEquals("Java", foundCourse.getTitle());
    }

    @Test
    public void testUpdateCourse() {
        Course course = new Course();
        course.setTitle("Java");
        courseDao.saveCourse(course);

        course.setTitle("Java developer. Junior level");
        courseDao.updateCourse(course);

        Course foundCourse = courseDao.findById(course.getId());
        Assertions.assertNotNull(foundCourse);
        Assertions.assertEquals("Java developer. Junior level", foundCourse.getTitle());
    }

    @Test
    public void testFindAllCourses() {
        Course course1 = new Course();
        course1.setTitle("Java developer. Junior level");
        courseDao.saveCourse(course1);

        Course course2 = new Course();
        course2.setTitle("The basics of Frontend development");
        courseDao.saveCourse(course2);

        List<Course> courses = courseDao.findAll();
        Assertions.assertNotNull(courses);
        Assertions.assertEquals(2, courses.size());
    }

    @Test
    public void testDeleteCourse() {
        Course course = new Course();
        course.setTitle("The basics of Frontend development");
        courseDao.saveCourse(course);

        courseDao.deleteById(course.getId());

        Course foundCourse = courseDao.findById(course.getId());
        Assertions.assertNull(foundCourse);
    }


}
