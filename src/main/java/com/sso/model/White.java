package com.sso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sso_white", schema = "")
@SuppressWarnings("serial")
public class White implements Serializable{
    private String id;
    private String url;
    private String other;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Column(name = "url", nullable = true)
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "other", nullable = true)
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
