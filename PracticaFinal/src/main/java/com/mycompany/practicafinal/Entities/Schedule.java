/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "SCHEDULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findByUser", query = "SELECT s FROM Schedule s WHERE s.user = :user")
    , @NamedQuery(name = "Schedule.findByTypeOfRegister", query = "SELECT s FROM Schedule s WHERE s.typeOfRegister = :typeOfRegister")
    , @NamedQuery(name = "Schedule.findByDate", query = "SELECT s FROM Schedule s WHERE s.date = :date")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user")
    private Integer user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "typeOfRegister")
    private String typeOfRegister;
    @Size(max = 8)
    @Column(name = "date")
    private String date;
    @JoinColumn(name = "user", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user1;

    public Schedule() {
    }

    public Schedule(Integer user) {
        this.user = user;
    }

    public Schedule(Integer user, String typeOfRegister) {
        this.user = user;
        this.typeOfRegister = typeOfRegister;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getTypeOfRegister() {
        return typeOfRegister;
    }

    public void setTypeOfRegister(String typeOfRegister) {
        this.typeOfRegister = typeOfRegister;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.practicafinal.Entities.Schedule[ user=" + user + " ]";
    }
    
}
