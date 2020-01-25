package ru.stqa.pft.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Issue {
    private int id;
    private String subject;
    private String description;

    public String getStatus() {
        return status;
    }

    @SerializedName("state_name")
    private String status;

    public Issue withId(int id) {
        this.id=id;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Issue withSubject(String subject) {
        this.subject=subject;
        return this;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id == issue.id &&
                Objects.equals(subject, issue.subject) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(status, issue.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, description, status);
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Issue withDescription (String description) {
        this.description=description;
        return this;

    }

    public void setDescription(String description) {
        this.description = description;
    }
}
