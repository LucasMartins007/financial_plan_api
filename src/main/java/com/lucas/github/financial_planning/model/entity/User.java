package com.lucas.github.financial_planning.model.entity;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_gen")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_users_to_role"))
    private Role role;

    @Column(name = "include_date")
    @Temporal(TemporalType.DATE)
    private Date includeDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Column(name = "active")
    private boolean active;

}
