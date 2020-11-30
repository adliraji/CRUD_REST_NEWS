package com.master.news.model;

import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "news")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class News implements Serializable{

@Id
@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
private String id;

@NotBlank
private String title;

@NotBlank
private String description;

//@NotBlank
//private java.text.SimpleDateFormat created_date = 
//     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


@Column(nullable = false, updatable = false)
@Temporal (TemporalType.TIMESTAMP)
@CreatedDate
private Date created_date;

@Column(nullable = false)
@Temporal(TemporalType.TIMESTAMP)
@LastModifiedDate
private Date updatedAt;

public String getId() {
return id;
}

public String getTitle() {
return title;
}

public String getDescription() {
return description;
}

//public java.text.SimpleDateFormat getCreatedDate() {
//return created_date;
//}

public Date getCreatedDate() {
return created_date;
}

public Date getUpdatedAt() {
return updatedAt;
}

public void setId(String id) {
this.id = id;
}

public void setTitle(String title) {
this.title = title;
}

public void setDescription(String description) {
this.description = description;
}


public void setCreatedDate(Date created_date) {
this.created_date = created_date;
}

public void setUpdatedAt(Date updatedAt) {
this.updatedAt = updatedAt;
}
}