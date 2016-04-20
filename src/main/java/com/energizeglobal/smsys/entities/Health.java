package com.energizeglobal.smsys.entities;

import com.energizeglobal.smsys.entities.lcp.IllnessType;
import org.apache.tapestry5.beaneditor.NonVisual;

import javax.persistence.*;
import java.util.Date;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
@Entity
@Table(name = "health")
public class Health {

    @Id
    @NonVisual
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int(11)")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "value", nullable = false)
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private IllnessType type;

    public Health() {
    }

    public Health(Date date, int value, User user, IllnessType type) {
        this.date = date;
        this.value = value;
        this.user = user;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IllnessType getType() {
        return type;
    }

    public void setType(IllnessType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Health{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", value=").append(value);
        sb.append(", user=").append(user);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
