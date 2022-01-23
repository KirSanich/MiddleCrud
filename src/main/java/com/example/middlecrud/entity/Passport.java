package com.example.middlecrud.entity;


import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "passports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "serial")
    private int serial;

    @Column(name = "number")
    private int number;

    @Column(name = "date_created",updatable = false)
    @CreatedDate
    private LocalDateTime date_created;

    @Column(name = "date_last_updated")
    @LastModifiedDate
    private LocalDateTime date_last_updated;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", serial=" + serial +
                ", number=" + number +
                ", date_created=" + date_created +
                ", date_last_updated=" + date_last_updated +
                '}';
    }
}
