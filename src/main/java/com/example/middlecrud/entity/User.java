package com.example.middlecrud.entity;


import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
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


    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "date_created",updatable = false)
    @CreationTimestamp
    private LocalDateTime date_created;

    @Column(name = "date_last_updated")
    @UpdateTimestamp
    private LocalDateTime date_last_updated;


    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY,mappedBy = "user")
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
