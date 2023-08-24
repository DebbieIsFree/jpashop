package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {


    @Id
    @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    // ORDINAL-> 1,2,3,4.. 숫자로 들어감
    // >> 문제 : status가 추가되면 뒤로 밀려서 장애 발생 ORDINAL은 절대 사용하면 안됨.
    // STRING으로 써야 중간에 status 추가 가능
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;  // READY, COMP
}
