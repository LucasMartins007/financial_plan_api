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

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_main_phone_number")
    private boolean isMainPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_phone_to_person"))
    private Person person;
}
