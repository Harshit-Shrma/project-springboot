package com.hrsit.Student.Management.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = " Student")
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name = "Name", nullable = false)
    private String name;
   @Column(name = "Phone", nullable = false)
    private int phone;
   @Column(name="Marks", nullable = false)
    private float marks;


}
