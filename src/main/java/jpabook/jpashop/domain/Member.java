package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter     // Lombok으로 getter, setter 생성 // get@@(), set@@() 대체
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 한 명의 member가 물건 다수 구매
    @OneToMany(mappedBy = "member")     // mappedBy : 연관 관계에서 주인이 아닌 것, 'member'에 의해 매핑됨
    private List<Order> orders = new ArrayList<>();
}
