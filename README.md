# The discount module

The discount module is to calculate the final price of an order by applying multiple discount campaigns to
items added to the shopping cart. The

## Business Requirements

- Take the list items in a shopping cart.
- Take the list of discount campaigns and their parameters to apply.
- Calculate the final price according to the rules.


## User Stories

### Story: EXP01

	* As a user, I want to apply a "50THB Discount" coupon in my cart, so that I can get a discount on my purchase.


#### Technical Details: EXP01

*  POST /carts/promotions

* Request Body

```json
{
  "items": [
    {
      "name": "T-Shirt",
      "category": "Clothing",
      "quantity": 1,
      "price": 350.00
    },
    {
      "name": "Hat",
      "category": "Clothing",
      "quantity": 1,
      "price": 250.00
    }
  ],
  "discounts": [
    {
      "type": "FIXED",
      "value": 50.00
    }
  ]
}
```

* Response Body

```json
{
      "totalPrice": 550.00 
}
```

### Story: EXP02
	* As a user, I want to apply a "10% discount" coupon in my cart, so that I can get a discount on my purchase.

#### Technical Details: EXP02

*  POST /carts/promotions

* Request Body

```json
{
  "username": "player",
  "items": [
    {
      "name": "T-Shirt",
      "category": "Clothing",
      "quantity": 1,
      "price": 350.00
    },
    {
      "name": "Hat",
      "category": "Clothing",
      "quantity": 1,
      "price": 250.00
    }
  ],
  "discounts": [
    {
      "type": "PERCENTAGE",
      "value": 10.00
    }
  ]
}
```

* Response Body

```json
{
      "totalPrice": 540.00 
}
```

### Story: EXP03
	* As a user, I want to apply a "15% Discount on Clothing" in my cart, so that I can get a discount on my purchase.

#### Technical Details: EXP03

*  POST /carts/promotions

* Request Body

```json
{
  "items": [
    {
      "name": "T-Shirt",
      "category": "Clothing",
      "quantity": 1,
      "price": 350.00
    },
    {
      "name": "Hoodie",
      "category": "Clothing",
      "quantity": 1,
      "price": 700.00
    },
    {
      "name": "Watch",
      "category": "Accessories",
      "quantity": 1,
      "price": 850.00
    },
    {
      "name": "Bag",
      "category": "Accessories",
      "quantity": 1,
      "price": 650.00
    }
  ],
  "discounts": [
    {
      "type": "CATEGORY",
      "percentage": 15.00,
      "category": [
        "Clothing"
      ]
    }
  ]
}
```

* Response Body

```json
{
      "totalPrice": 2392.50
}
```

### Story: EXP04
	* As a user, I want to apply a "68 Points" to discount in my cart, so that I can get a discount on my purchase.

#### Technical Details: EXP04

*  POST /carts/promotions

* Request Body

```json
{
  "items": [
    {
      "name": "T-Shirt",
      "category": "Clothing",
      "quantity": 1,
      "price": 350.00
    },
    {
      "name": "Hat",
      "category": "Accessories",
      "quantity": 1,
      "price": 250.00
    },
    {
      "name": "Belt",
      "category": "Accessories",
      "quantity": 1,
      "price": 230.00
    }
  ],
  "discounts": [
    {
      "type": "POINTS",
      "value": 68.00
    }
  ]
}
```

* Response Body

```json
{
      "totalPrice": 762.00 
}
```
### Story: EXP05
	* As a user, I want to apply a "Discount by points" seasonal coupon in my cart, so that I can get a discount on my purchase.

#### Technical Details: EXP05

*  POST /carts/promotions
* Request Body

```json
{
  "items": [
    {
      "name": "T-Shirt",
      "category": "Clothing",
      "quantity": 1,
      "price": 350.00
    },
    {
      "name": "Hat",
      "category": "Accessories",
      "quantity": 1,
      "price": 250.00
    },
    {
      "name": "Belt",
      "category": "Accessories",
      "quantity": 1,
      "price": 230.00
    }
  ],
  "discounts": [
    {
      "type": "SEASONAL",
      "every_X_THB": 300.00,
      "discount_Y_THB": 40.00
    }
  ]
}
```

* Response Body

```json
{
      "totalPrice": 750.00
}
```
### Story: EXP06
	* As a user, I want to apply a "COUPON", a "ON-TOP" and a "SEASONAL" discount type in my cart, so that I can get a discount on my purchase.

#### Technical Details: EXP06

*  POST /carts/promotions
* Request Body

```json
{
  "items": [
    {
      "name": "T-Shirt",
      "category": "Clothing",
      "quantity": 1,
      "price": 350.00
    },
    {
      "name": "Hat",
      "category": "Accessories",
      "quantity": 1,
      "price": 250.00
    },
    {
      "name": "Belt",
      "category": "Accessories",
      "quantity": 1,
      "price": 230.00
    }
  ],
  "discounts": [
    {
      "type": "FIXED",
      "value": 50.00
    },
    {
      "type": "CATEGORY",
      "percentage": 15.00,
      "category": [
        "Clothing"
      ]
    },
    {
      "type": "SEASONAL",
      "every_X_THB": 300.00,
      "discount_Y_THB": 40.00
    }
  ]
}
```

* Response Body

```json
{
      "totalPrice": 647.50
}
```



