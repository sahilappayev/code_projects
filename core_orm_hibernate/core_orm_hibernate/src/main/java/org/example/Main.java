package org.example;

import org.example.entity.User;
import org.example.repository.TeacherRepository;

public class Main {

    public static void main(String[] args) {

        User user = new User();

        user.setUsername("admin error");
        user.setPassword("123456");


//        UserRepository ur = new UserRepository();
//
//        User createUser = ur.create(user).orElseThrow(() -> new RuntimeException("Cant create user"));
////
//        System.out.println(createUser);
//
//
//        System.out.println(ur.findById(9));


//        PersonRepository personRepository = new PersonRepository();
//        PersonDetailRepository personDetailRepository = new PersonDetailRepository();
//
//
//        System.out.println(personRepository.findById(4));
//        System.out.println(personDetailRepository.findById(1));


        TeacherRepository teacherRepository = new TeacherRepository();

        System.out.println(teacherRepository.findById(2));

//        StudentRepository sr = new StudentRepository();
//        System.out.println(sr.findById(4));


    }


}
