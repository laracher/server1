package com.application.bank.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history_change")
public class RiskGroupHistoryChange
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @JsonIgnore
//    @JoinColumn(name = "Client", nullable = false)
    @JoinColumn(name = "client_id")
    @ManyToOne
    private Client client;

    @JsonIgnore
//    @JoinColumn(name = "RiskGroup", nullable = false)
    @JoinColumn(name = "group_id")
    @ManyToOne
    private RiskGroup riskGroup;

    @Column(name = "JoinDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;


    public RiskGroupHistoryChange() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RiskGroup getRiskGroup() {
        return riskGroup;
    }

    public void setRiskGroup(RiskGroup riskGroup) {
        this.riskGroup = riskGroup;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
