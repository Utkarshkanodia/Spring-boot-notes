package com.notes.jpa.inheritance.mapped_super_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("client_msc")
public class MappedSuperClassClient {
    MentorRepository mentorMSCRepository;
    StudentRepository studentMSCRepository;

    @Autowired
    MappedSuperClassClient(MentorRepository mentorMSCRepository, StudentRepository studentMSCRepository) {
        this.mentorMSCRepository = mentorMSCRepository;
        this.studentMSCRepository = studentMSCRepository;
    }

    public void saveMentor(String username, String password, String pass) {
        Mentor m = new Mentor();
        m.setUsername(username);
        m.setPassword(password);
        m.setStaffPass(pass);
        mentorMSCRepository.save(m);
    }

    public void saveStudent(String username, String password, String pass) {
        Student s = new Student();
        s.setUsername(username);
        s.setPassword(password);
        s.setCollegePass(pass);
        studentMSCRepository.save(s);
    }
}
