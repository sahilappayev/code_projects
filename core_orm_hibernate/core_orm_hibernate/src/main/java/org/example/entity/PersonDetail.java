package org.example.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "person_details")
@Entity
public class PersonDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String about;
    private String address;

    @OneToOne
    private Person person;

}
