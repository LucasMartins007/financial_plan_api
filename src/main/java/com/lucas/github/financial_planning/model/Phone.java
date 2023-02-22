package com.lucas.github.financial_planning.model;

import com.lucas.github.financial_planning.model.generic.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "phone")
public class Phone extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "phoneSeq", sequenceName = "phone_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_main_phone_number")
    private boolean isMainPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_phone_to_person"))
    private Person person;
}
