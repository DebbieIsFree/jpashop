package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable   // 어딘 가에 내장될 수 있다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // reflection, proxy 등을 사용하기 위해 기본 생성자를 만들어야 한다.
    // @Embeddable -> 기본 생성자를 public 또는 protected
    protected Address(){
    }

    // 값 타입 -> setter()를 통한 변경이 불가하게 최초 한번만 설정
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
