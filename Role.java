package com.example.clinic.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "RoleID")
  private Long roleId;

  @Column(name = "Name")
  private String name;

  @Column(name = "Description")
  private String description;

  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<UserRole> userRoles = new HashSet<>();

  public Role() {}

  public Long getRoleId() { return roleId; }
  public void setRoleId(Long roleId) { this.roleId = roleId; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public Set<UserRole> getUserRoles() { return userRoles; }
  public void setUserRoles(Set<UserRole> userRoles) { this.userRoles = userRoles; }
}
