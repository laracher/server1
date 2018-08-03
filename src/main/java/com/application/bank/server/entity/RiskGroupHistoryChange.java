package com.application.bank.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "risk_group_history_change")
public class RiskGroupHistoryChange
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @JoinColumn(name = "client", nullable = false)
    @ManyToOne
    private Client client;

    @JoinColumn(name = "risk_group", nullable = false)
    @ManyToOne
    private RiskGroup riskGroup;

    @Column(name = "join_date", nullable = false)
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
