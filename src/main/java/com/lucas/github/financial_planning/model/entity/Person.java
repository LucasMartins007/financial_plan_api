package com.lucas.github.financial_planning.model.entity;


import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "person")
@EqualsAndHashCode(callSuper = true)
public class Person extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_id_gen")
    @SequenceGenerator(name = "person_seq", sequenceName = "person_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Email> emails;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Phone> phones;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bills> bills;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_person_to_user"))
    private User user;

    @Column(name = "include_date")
    @Temporal(TemporalType.DATE)
    private Date includeDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Column(name = "active")
    private boolean active;


}
