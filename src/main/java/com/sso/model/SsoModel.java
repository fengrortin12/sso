package com.sso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sso_sso", schema = "")
@SuppressWarnings("serial")
public class SsoModel  implements Serializable{
    private java.lang.String id;
    private java.lang.String name;
    private java.lang.String url;
    private SsoModel parent;
    private List<SsoModel> child;
    private java.lang.Double orders;

    private java.lang.String parentId;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "url", nullable = true)
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    public SsoModel getParent() {
        return parent;
    }

    public void setParent(SsoModel parent) {
        this.parent = parent;
    }

    //@JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "parent", fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    public List<SsoModel> getChild() {
        return child;
    }

    public void setChild(List<SsoModel> child) {
        this.child = child;
    }

    @Column(name = "orders", nullable = true)
    public Double getOrders() {
        return orders;
    }
    public void setOrders(Double orders) {
        this.orders = orders;
    }

    /**webservice有个问题，实体类里面放实体，转换失败，暂时不解决*/
    @Transient
    public String getParentId() {
        if(parent!=null){
            parentId = parent.getId();
        }
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
