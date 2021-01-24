package com.example;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String color;

    public Alien(){
		
	}

    public Alien(int aid, String aname, String color) {
        this.aid = aid;
        this.aname = aname;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" + "aid=" + aid + ", aname='" + aname + '\'' + ", color='" + color + '\'' +'}';
    }

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public String getColor() {
        return color;
    }
}