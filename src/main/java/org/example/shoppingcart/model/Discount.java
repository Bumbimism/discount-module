package org.example.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.shoppingcart.model.discount.*;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FixedDiscount.class, name = "FIXED"),
        @JsonSubTypes.Type(value = PercentageDiscount.class, name = "PERCENTAGE"),
        @JsonSubTypes.Type(value = CategoryDiscount.class, name = "CATEGORY"),
        @JsonSubTypes.Type(value = PointDiscount.class, name = "POINTS"),
        @JsonSubTypes.Type(value = SeasonalDiscount.class, name = "SEASONAL")

})
public abstract class Discount {

    public abstract double applyDiscount(double total, List<Item> items);

    public abstract DiscountType getType();
}
