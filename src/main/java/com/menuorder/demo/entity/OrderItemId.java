package com.menuorder.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemId  implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "food_id")
    private Long foodId;

    public OrderItemId(){}

    public OrderItemId(Long orderId, Long foodId){
        this.orderId = orderId;
        this.foodId = foodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OrderItemId that = (OrderItemId) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(foodId, that.foodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, foodId);
    }

}
