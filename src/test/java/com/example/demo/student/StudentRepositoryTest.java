package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailExists() {
        //given
        String email = "huydinh01@gmail.com";
        Student student = new Student(
                "HuyDinh",
                email,
                Gender.MALE
        );
        underTest.save(student);
        //when
        Boolean expected = underTest.selectExistsEmail(email);
        //then
        assertThat(expected).isTrue();
    }
    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        //given
        String email = "huydinh01@gmail.com";

        //when
        Boolean expected = underTest.selectExistsEmail(email);
        //then
        assertThat(expected).isFalse();
    }
}