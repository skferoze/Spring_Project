package com.controller;

import java.util.List;

import jakarta.persistence.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Student;

@Controller
public class StudentController {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(Student student) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(student);
        et.commit();

        return "success";
    }

    @RequestMapping("/disp")
    public String display(Model model) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> query = em.createQuery("from Student", Student.class);

        List<Student> list = query.getResultList();

        model.addAttribute("list", list);

        return "Fetch";
    }
}