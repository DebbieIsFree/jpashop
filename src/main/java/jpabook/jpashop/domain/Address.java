package jpabook.jpashop.domain;


import jakarta.persistence.Embeddable;
import lombok.Getter;

// JPA 내장 타입
@Embeddable   // 어딘 가에 내장될 수 있다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
