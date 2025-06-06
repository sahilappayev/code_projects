package org.example.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

//    @OneToOne
//    @JoinColumn(name = "person_id", referencedColumnName = "id")
//    private Person person;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

}
