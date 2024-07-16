package com.notes.jpa.inheritance.joined_table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("client_jt")
public class JoinedTableClient {

    UserRepository userRepository;
    StudentRepository studentRepository;
    MentorRepository mentorRepository;

    @Autowired
    JoinedTableClient(UserRepository userTPCRepository, StudentRepository studentTPCRepository, MentorRepository mentorTPCRepository) {
        this.userRepository = userTPCRepository;
        this.studentRepository = studentTPCRepository;
        this.mentorRepository = mentorTPCRepository;
    }

    public void saveStudent(String username, String password, String pass) {
        Student s = new Student();
        s.setUsername(username);
        s.setPassword(password);
        s.setCollegePass(pass);
        studentRepository.save(s);
    }

    public void saveMentor(String username, String password, String pass) {
        Mentor m = new Mentor();
        m.setUsername(username);
        m.setPassword(password);
        m.setStaffPass(pass);
        mentorRepository.save(m);
    }

    public void saveUser(String username, String password) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Student> getAllStudentOnly() {
        return studentRepository.findAll();
    }

    public List<Mentor> getAllMentorOnly() {
        return mentorRepository.findAll();
    }

    public void deleteUser(String username) {
        Users defaultUser = new Users();
        Users user = userRepository.findByUsername(username).orElse(defaultUser);
        userRepository.delete(user);
    }

}
