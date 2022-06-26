package com.example.learnspringjpa.entities;

import lombok.*;

import javax.persistence.*;

/**
 * Author saino
 * LastModify 8:09
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer age;
    private String school;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
