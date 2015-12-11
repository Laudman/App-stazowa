package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author zama
 */
@Entity
@Table(name="userprofile")
public class UserProfile {
         @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_profile; 
 
  //  @Column(name="TYPE", length=15, unique=true, nullable=false)
    private String type = UserProfileType.USER.getUserProfileType();
     
    public Integer getId_profile() {
        return id_profile;
    }
 
    public void setId_profile(Integer id_profile) {
        this.id_profile = id_profile;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_profile == null) ? 0 : id_profile.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserProfile))
            return false;
        UserProfile other = (UserProfile) obj;
        if (id_profile == null) {
            if (other.id_profile != null)
                return false;
        } else if (!id_profile.equals(other.id_profile))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "UserProfile [id_profile=" + id_profile + ", type=" + type + "]";
    }
}
