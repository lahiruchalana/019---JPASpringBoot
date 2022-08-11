package com.example.springboottutes.entity;

import javax.persistence.*;

@Entity
@Table(name = "course_material_tbl")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
//            cascade = CascadeType.ALL       // using to create a course material instance when there is no existing course instance related to the course material
            // then first create the course instance and second create the course material instance
            // when using this you can not use existing course to create a course material

//            fetch = FetchType.LAZY      // provide only course material data (does not provide relevant course data)
            fetch = FetchType.EAGER     // provide all the data (with course data)

    )
    @JoinColumn(
            name = "course_id",             // identify the foreign key -->> course_id (courseId)
            referencedColumnName = "courseId"
    )
    private Course course;

    public CourseMaterial() {
    }

    public CourseMaterial(Long courseMaterialId, String url, Course course) {
        this.courseMaterialId = courseMaterialId;
        this.url = url;
        this.course = course;
    }

    public Long getCourseMaterialId() {
        return courseMaterialId;
    }

    public void setCourseMaterialId(Long courseMaterialId) {
        this.courseMaterialId = courseMaterialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseMaterial{" +
                "courseMaterialId=" + courseMaterialId +
                ", url='" + url + '\'' +
                ", course=" + course +
                '}';
    }
}
