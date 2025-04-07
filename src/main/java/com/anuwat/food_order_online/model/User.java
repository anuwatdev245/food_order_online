package com.anuwat.food_order_online.model;

import com.anuwat.food_order_online.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;

    private String password;

    private   USER_ROLE role;

    @JsonIgnore //ไม่มีกาโชว์ฟิวน์นี้
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto> favorites = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //ใช้สำหรับระบุว่า entity ที่ถูกกำหนด
                                          //แล้ว child entity ทั้งหมดที่เกี่ยวข้องก็จะทำการถูกกระทำด้วย
                                          //ALL คือใช้ Operation ทั้งหมดนั้นคือ PERSIST, MERGE, REMOVE,
                                          //REFRESH, DETACH
                                          //orphanRemoval = true คือ Entity แม่ถูกลบ ลูกก็จะถูกลบด้วย
    private List<Address> addresses = new ArrayList<>();

}
