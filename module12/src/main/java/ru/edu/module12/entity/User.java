package ru.edu.module12.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    public User(Long id, String name, Integer age){
        this.id = id;
        this.name = name;
        this.age = age;

    }

    // Getter и Setter методы
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
