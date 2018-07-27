package com.oocl.springBootSqlTest.OneToOne.DTO;

import com.oocl.springBootSqlTest.OneToOne.Enity.Klass;

import java.time.ZonedDateTime;

public class KlassDTO {
    private Long id;

    private String klass_name;

    private ZonedDateTime createDate = ZonedDateTime.now();

    private Long leader_id;

    public KlassDTO(Klass klass) {
        this.id = klass.getId();
        this.klass_name = klass.getKlass_name();
        this.createDate = klass.getCreateDate();
        this.leader_id = klass.getLeader().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKlass_name() {
        return klass_name;
    }

    public void setKlass_name(String klass_name) {
        this.klass_name = klass_name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(Long leader_id) {
        this.leader_id = leader_id;
    }
}
