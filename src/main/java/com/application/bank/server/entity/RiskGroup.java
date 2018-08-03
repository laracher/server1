package com.application.bank.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "RiskGroup")
public class RiskGroup
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
//                          название группы риска
    @Column(name = "group_name", nullable = false, length = 30)
    private String groupName;
//                          нижний предел
    @Column(name = "lower_limit", nullable = false)
    private double lowerLimit;
//                          верхний предел
    @Column(name = "upper_limit", nullable = false)
    private double upperLimit;

//    // отношение один ко многим. Группа риска в "Истории Изменений" может содержать нескольких клиентов
//    @OneToMany(mappedBy = "RiskGroup", fetch = FetchType.EAGER)
//    @JsonIgnore
//    private Collection<RiskGroupHistoryChange> riskGroupHistoryChangeList;
//
//
//
//    public Collection<RiskGroupHistoryChange> getRiskGroupHistoryChangeList() {
//        return riskGroupHistoryChangeList;
//    }
//
//    public void setRiskGroupHistoryChangeList
//            (Collection<RiskGroupHistoryChange> riskGroupHistoryChangeList) {
//        this.riskGroupHistoryChangeList = riskGroupHistoryChangeList;
//    }

    public RiskGroup() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }
}
