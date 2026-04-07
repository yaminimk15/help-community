package com.help.community.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HelpRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String userName;
    private String phone;
    private String urgency;
    private String status;

    public HelpRequest() {
        this.status = "Pending";
    }

    // getters & setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getUserName() { return userName; }
    public String getPhone() { return phone; }
    public String getUrgency() { return urgency; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setLocation(String location) { this.location = location; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setUrgency(String urgency) { this.urgency = urgency; }
    public void setStatus(String status) { this.status = status; }
}