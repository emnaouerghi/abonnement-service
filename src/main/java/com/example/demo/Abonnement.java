package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Abonnement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Abonnement_id")
  private Long id;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Long idActivity;

  @Transient
  private Activity activity;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Long idUser;

  @Transient
  private User user;

  private Date dateD, dateF;

  public Abonnement() {}

  public Abonnement(
    Long id,
    Long idUser,
    Long idActivity,
    Date dateD,
    Date dateF
  ) {
    super();
    this.id = id;
    this.idUser = idUser;
    this.idActivity = idActivity;
    this.dateD = dateD;
    this.dateF = dateF;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDateD() {
    return dateD;
  }

  public void setDateD(Date dateD) {
    this.dateD = dateD;
  }

  public Date getDateF() {
    return dateF;
  }

  public void setDateF(Date dateF) {
    this.dateF = dateF;
  }

  public Long getIdActivity() {
    return idActivity;
  }

  public void setIdActivity(Long idActivity) {
    this.idActivity = idActivity;
  }

  public Long getIdUser() {
    return idUser;
  }

  public void setIdUser(Long idUser) {
    this.idUser = idUser;
  }

  @Override
  public String toString() {
    return (
      "Abonnement [id=" +
      id +
      ", idActivity=" +
      idActivity +
      ", idUser=" +
      idUser +
      ", dateD=" +
      dateD +
      ", dateF=" +
      dateF +
      "]"
    );
  }
}
