package com.lucas.github.financial_planning.model;

import com.lucas.github.financial_planning.model.enums.EnumRole;
import com.lucas.github.financial_planning.model.generic.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "role_id_gen")
    @SequenceGenerator(name = "role_seq", sequenceName = "role_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "role")
    private EnumRole roleDescription;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_role_to_users"))
    private User user;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
