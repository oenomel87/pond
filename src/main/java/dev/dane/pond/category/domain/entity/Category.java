package dev.dane.pond.category.domain.entity;

import dev.dane.pond.event.domain.entity.Event;
import dev.dane.pond.user.domain.entity.User;
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
@Table(name = "CATEGORY")
public class Category implements Serializable {

    private static final long serialVersionUID = 8726973805859806239L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "BIGINT(20)")
    private Long id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "category")
    private List<Event> events;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;
}
