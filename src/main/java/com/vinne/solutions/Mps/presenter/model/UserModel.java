package com.vinne.solutions.Mps.presenter.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private Long id;
   private String email;
   private String password;
   private String firstName;
   private String lastName;
   private String cpf;
   private String uuid;
   @CreationTimestamp
   @Temporal(TemporalType.TIMESTAMP)
   private Date createdDate;
   @UpdateTimestamp
   @Temporal(TemporalType.TIMESTAMP)
   private Date updatedDate;

   public String getUuid() {
      return uuid;
   }

   public void setUuid(String uuid) {
      this.uuid = uuid;
   }

   public Long getId() {
      return id;
   }

   public String getEmail() {
      return email;
   }

   public String getPassword() {
      return password;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getCpf() {
      return cpf;
   }

   public Date getCreatedDate() {
      return createdDate;
   }

   public Date getUpdatedDate() {
      return updatedDate;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
   }

   public void setUpdatedDate(Date updatedDate) {
      this.updatedDate = updatedDate;
   }

}
