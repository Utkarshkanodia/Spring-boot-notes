package com.notes.jpa.inheritance.single_table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("client_st")
public class SingleTableClient {

    UserRepository userTPCRepository;
    StudentRepository studentTPCRepository;
    MentorRepository mentorTPCRepository;

    @Autowired
    SingleTableClient(UserRepository userTPCRepository, StudentRepository studentTPCRepository, MentorRepository mentorTPCRepository) {
        this.userTPCRepository = userTPCRepository;
        this.studentTPCRepository = studentTPCRepository;
        this.mentorTPCRepository = mentorTPCRepository;
    }

    public void saveStudent(String username, String password, String pass) {
        Student s = new Student();
        s.setUsername(username);
        s.setPassword(password);
        s.setCollegePass(pass);
        studentTPCRepository.save(s);
    }

    public void saveMentor(String username, String password, String pass) {
        Mentor m = new Mentor();
        m.setUsername(username);
        m.setPassword(password);
        m.setStaffPass(pass);
        mentorTPCRepository.save(m);
    }

    public void saveUser(String username, String password) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        userTPCRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userTPCRepository.findAll();
    }

    public List<Student> getAllStudentOnly() {
        return studentTPCRepository.findAll();
    }

    public List<Mentor> getAllMentorOnly() {
        return mentorTPCRepository.findAll();
    }
}
