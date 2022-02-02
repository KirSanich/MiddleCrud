package com.example.middlecrud.entity;


import com.example.middlecrud.validations.AgeValidationConstraint;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Size(min = 2, max = 10, message = "Incorrect length name!")
    @Pattern(regexp = "[a-zA-Z]+", message = "Only letters!")
    @NotBlank(message = "Non Empty")
    @Column(name = "name")
    private String name;



    @Range(min = 6, max = 100)
    @AgeValidationConstraint
    @Column(name = "age")
    private Integer age;

    @Column(name = "date_created", updatable = false)
    @CreationTimestamp
    private LocalDateTime date_created;

    @Column(name = "date_last_updated")
    @UpdateTimestamp
    private LocalDateTime date_last_updated;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Passport> passportList;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date_created=" + date_created +
                ", date_last_updated=" + date_last_updated +
                '}';
    }
}
