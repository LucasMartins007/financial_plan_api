package com.lucas.github.financial_planning.model;

import com.lucas.github.financial_planning.model.generic.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "phone")
public class Phone extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_id_gen")
    @SequenceGenerator(name = "phone_seq", sequenceName = "phone_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_main_phone_number")
    private boolean isMainPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_phone_to_person"))
    private Person person;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
