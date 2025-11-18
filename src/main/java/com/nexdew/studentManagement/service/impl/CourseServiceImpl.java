package com.nexdew.studentManagement.service.impl;

import com.nexdew.studentManagement.entity.Courses;
import com.nexdew.studentManagement.entity.Subject;
import com.nexdew.studentManagement.repository.CourseRepository;
import com.nexdew.studentManagement.repository.SubjectRepository;
import com.nexdew.studentManagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {


    private  final CourseRepository courseRepository;

    private final SubjectRepository subjectRepository;
    @Override
    public Courses getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("Course not found"));
    }

    @Override
    public Courses createCourse(Courses course) {
//        for (Courses course : courses) {
//            if (course.getSubjects() != null) {
//                for (Subject subject : course.getSubjects()) {
//                    subject.setCourse(course);
//                }
//            }
//        }


        course.getSubjects().forEach(course::addSubject);



        return courseRepository.save(course);
    }

    @Override
    public Courses updateCourse(Long courseId, Courses updatedCourse) {
        Courses existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setCode(updatedCourse.getCode());
        existingCourse.setCredits(updatedCourse.getCredits());

        return courseRepository.save(existingCourse);
    }

    @Override
    public Boolean deleteCourse(Long courseId) {
        Courses deletecourse = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(deletecourse);

        return true;
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }


}
