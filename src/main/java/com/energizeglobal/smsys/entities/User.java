package com.energizeglobal.smsys.entities;

import com.energizeglobal.smsys.entities.converter.UserAvatarConverter;
import com.energizeglobal.smsys.entities.converter.UserStatusConverter;
import com.energizeglobal.smsys.entities.lcp.Gender;
import com.energizeglobal.smsys.entities.lcp.UserStatus;
import com.energizeglobal.smsys.entities.lcp.UserType;
import com.energizeglobal.smsys.entities.converter.UserTypeConverter;
import org.apache.tapestry5.beaneditor.DataType;
import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

import javax.persistence.*;
import java.io.File;
import java.util.Date;
import java.util.Set;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonVisual
    @Column(name = "id", columnDefinition = "int(11)", nullable = false)
    private Long id;

    @Validate(value = "required, minLength=3, maxLength=50")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Validate(value = "required, minLength=3, maxLength=50")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Validate(value = "required, email")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Validate(value = "required")
    @Column(name = "dob", nullable = false)
    private Date dob;

    @Validate(value = "required")
    @Convert(converter = UserTypeConverter.class)
    @Column(name = "user_type", columnDefinition = "int(1) default 2", nullable = false)
    private UserType userType;

    @Validate(value = "required")
    @Convert(converter = UserStatusConverter.class)
    @Column(name = "status", columnDefinition = "int(1) default 1", nullable = false)
    private UserStatus status;

    @Validate(value = "required")
    @Column(name = "gender", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Convert(converter = UserAvatarConverter.class)
    @Column(name = "avatar", nullable = false)
    private File avatar;

    @Validate(value = "required, minLength=4")
    @DataType("password")
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Health> healths;

    @Inject
    public User() {
    }

    public User(String firstName, String lastName, String email, Date dob, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.password = password;
    }

    public Set<Health> getHealths() {
        return healths;
    }

    public void setHealths(Set<Health> healths) {
        this.healths = healths;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public File getAvatar() {
        return avatar;
    }

    public void setAvatar(File avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", dob=").append(dob);
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id.equals(user.id);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
