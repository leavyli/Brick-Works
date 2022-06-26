package com.example.learnspringjpa.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

/**
 * Author saino
 * LastModify 6:13
 */
@Entity
@Table(name = "user_json")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserJson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;
    @OneToOne(mappedBy = "userJson")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private UserInfoJson userInfoJson;
}
