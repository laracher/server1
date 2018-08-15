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
    private long group_id;
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
    @JsonIgnore
    @OneToMany(mappedBy = "riskGroup", fetch = FetchType.EAGER)
    private Collection<RiskGroupHistoryChange> historyChange;



    public Collection<RiskGroupHistoryChange> getRiskGroupHistoryChangeList()
    {
        return historyChange;
    }

    public void setRiskGroupHistoryChangeList
            (Collection<RiskGroupHistoryChange> riskGroupHistoryChangeList)
    {
        this.historyChange = riskGroupHistoryChangeList;
    }

    public RiskGroup() {}

    public long getId() {
        return group_id;
    }

    public void setId(long id) {
        this.group_id = id;
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
