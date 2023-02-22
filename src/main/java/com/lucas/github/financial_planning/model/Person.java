package com.lucas.github.financial_planning.model;


import com.lucas.github.financial_planning.model.generic.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "person")
public class Person extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_id_gen")
    @SequenceGenerator(name = "person_seq", sequenceName = "person_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Email> email;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Phone> phone;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bills> bills;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
