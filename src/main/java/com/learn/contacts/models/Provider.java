package com.learn.contacts.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String nameProvider;

    private String number;
}
