package com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "status")
public class StatusEntity {
    @Id
    @Column(name = "statuskey", nullable = false, length = 20)
    private String statuskey;
    private String statusid;
    private String statusname;
    public String getStatuskey() {
        return statuskey;
    }

    public void setStatuskey(String statuskey) {
        this.statuskey = statuskey;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }
}
