package com.example.middlecrud.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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


    @NotNull(message = "Non Empty")
    @Range(min = 1000,max = 9999,message = "Enter the valid passport serial!")
    @Column(name = "serial")
    private Integer serial;


    @NotNull(message = "Non Empty")
    @Range(min = 100000,max = 999999,message = "Enter the valid passport number!")
    @Column(name = "number")
    private Integer number;

    @Column(name = "date_created",updatable = false)
    @CreationTimestamp
    private LocalDateTime date_created;

    @Column(name = "date_last_updated")
    @UpdateTimestamp
    private LocalDateTime date_last_updated;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
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
