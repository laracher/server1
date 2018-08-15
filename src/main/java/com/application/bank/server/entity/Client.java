package com.application.bank.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long client_id;

//                 ФИО клиента
//    @Column(name = "last_name", nullable = false, length = 30)
//    private String lastName;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

//    @Column(name = "second_name", nullable = false, length = 30)
//    private String secondName;

//    @Column(name = "gender", nullable = false, length = 10)
//    private String gender;
//
    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(name = "risk_group", nullable = false, length = 30)
    private String riskGroup;

    @Column(name = "pasport_number", nullable = false)
    private long pasportNumber;

//    @Column(name = "city", nullable = false, length = 30)
//    private String city;
//
//    @Column(name = "country", nullable = false, length = 30)
//    private String country;
//
//    @Column(name = "email", nullable = false, length = 30)
//    private String email;

//    // отношение один ко многим. Клиент в "Истории Изменений" может состоять в нескольких группах
    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Collection<RiskGroupHistoryChange> historyChange;

//    public Collection<RiskGroupHistoryChange> getRiskGroupHistoryChangeList()
//    {
//        return historyChange;
//    }
//
//    public void setRiskGroupHistoryChangeList
//            (Collection<RiskGroupHistoryChange> riskGroupHistoryChangeList)
//    {
//        this.historyChange = riskGroupHistoryChangeList;
//    }


    public Collection<RiskGroupHistoryChange> getHistoryChange() {
        return historyChange;
    }

    public void setHistoryChange(Collection<RiskGroupHistoryChange> historyChange) {
        this.historyChange = historyChange;
    }

    public Client() {}

    public long getId() {
        return client_id;
    }

    public void setId(long id) {
        this.client_id = id;
    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
    public Date getDob() {
        return dob;
    }

    public void setDob(Date yearBirth) {
        this.dob = yearBirth;
    }

    public String getRiskGroup() {
        return riskGroup;
    }

    public void setRiskGroup(String riskGroup) {
        this.riskGroup = riskGroup;
    }

    public long getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(long pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
