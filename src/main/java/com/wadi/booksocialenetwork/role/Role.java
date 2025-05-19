package com.wadi.booksocialenetwork.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wadi.booksocialenetwork.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role {
    @Id
    @GeneratedValue
    private Integer id ;
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
   private List<User> users;



    @CreatedDate
    @Column(nullable = false,updatable = false )
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column (insertable = false)
    private LocalDateTime lastModifiedDate;
}
