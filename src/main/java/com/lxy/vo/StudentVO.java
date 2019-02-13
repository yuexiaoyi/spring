package com.lxy.vo;

import javax.persistence.*;

/**
 * JPA测试的实体
 * @author lxy
 * @time 2019-02-12 15:54
 **/
@Entity
@Table(name = "t_student")
public class StudentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;
    @Column(name = "t_name")
    private String name;
    @Column(name = "t_age")
    private int age;
    @Column(name = "t_score")
    private double score;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public StudentVO(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public StudentVO() {
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
