package com.lucas.github.financial_planning.model;

import com.lucas.github.financial_planning.model.generic.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "email")
public class Email extends AbstractEntity<Integer> {

    @Column(name = "description")
    private String description;

    @Column(name = "isMainEmail")
    private boolean isMainEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_email_to_person"))
    private Person person;

}
