package dev.dane.pond.event.domain.entity;

import dev.dane.pond.category.domain.entity.Category;
import dev.dane.pond.user.domain.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EVENT")
public class Event implements Serializable {

    private static final long serialVersionUID = 4874310372258360268L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "BIGINT(20)")
    private Long id;

    @Column(name = "EVENT_DATE", columnDefinition = "DATE", nullable = false)
    private LocalDate date;

    @Column(name = "AMOUNT", columnDefinition = "BIGINT(20)", nullable = false)
    private Long amount;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", insertable = false)
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
