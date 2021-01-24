package com.example;

import com.sun.istack.Nullable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Navneet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    String color;
    String address;

    int age;

    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany
    private List<Alien> alienList = new ArrayList<>();


    public Navneet(){

    }

    public Navneet(String color, String address, List<Alien> alienList) {
        this.id = id;
        this.color = color;
        this.address = address;
        this.alienList = alienList;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getAddress() {
        return address;
    }

    public List<Alien> getAlienList() {
        return alienList;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Navneet{" + "id=" + id + ", color='" + color + '\'' + ", address='" + address + '\'' + ", age=" + age +", alienList=" + alienList + '}';
    }
}