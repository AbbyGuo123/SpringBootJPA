package com.oocl.springBootSqlTest.NToN.Enity;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;

    @CreatedDate
    private ZonedDateTime createDate = ZonedDateTime.now();

    @ManyToMany
    @JoinTable(name = "user_group",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<GroupT> groupTS =new ArrayList<>();;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public List<GroupT> getGroupTS() {
        return groupTS;
    }

    public void setGroupTS(List<GroupT> groupTS) {
        this.groupTS = groupTS;
    }
}

