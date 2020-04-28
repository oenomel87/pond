package dev.dane.pond.user.domain.entity;

import dev.dane.pond.category.domain.entity.Category;
import dev.dane.pond.event.domain.entity.Event;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User implements Serializable {

    private static final long serialVersionUID = -8666870689189046364L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "BIGINT(20)")
    private Long id;

    @Column(name = "USERNAME", columnDefinition = "VARCHAR(50)", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(512)", nullable = false)
    private String password;

    @Column(name = "NAME", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @Column(name = "USERCODE", columnDefinition = "VARCHAR(100)", unique = true, nullable = false)
    private String usercode;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "user")
    private List<Event> events;

    @OneToMany(mappedBy = "user")
    private List<Category> categories;
}
