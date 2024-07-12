package ru.hehmdalolkek.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id;

        String username;

        String password;

        @CreationTimestamp
        @Column(name = "registration_date")
        LocalDateTime registrationDate;

        @ElementCollection(targetClass = Role.class)
        @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        Set<Role> roles;

}
