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
      "price": 350
    },
    {
      "name": "Hat",
      "category": "Clothing",
      "quantity": 1,
      "price": 250
    }
  ],
  "codes": [
    {
      "type": "FIXED",
      "value": 50
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
      "price": 350
    },
    {
      "name": "Hat",
      "category": "Clothing",
      "quantity": 1,
      "price": 250
    }
  ],
  "codes": [
    {
      "type": "PERCENTAGE",
      "value": 10
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
      "price": 700.00
    },
    {
      "name": "Bag",
      "category": "Accessories",
      "quantity": 1,
      "price": 700.00
    }
  ],
  "codes": [
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
      "totalPrice": 2382.50 
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
      "price": 350
    },
    {
      "name": "Hat",
      "category": "Accessories",
      "quantity": 1,
      "price": 250
    },
    {
      "name": "Belt",
      "category": "Accessories",
      "quantity": 1,
      "price": 230
    }
  ],
  "codes": [
    {
      "type": "POINTS",
      "value": 68
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
      "price": 350
    },
    {
      "name": "Hat",
      "category": "Accessories",
      "quantity": 1,
      "price": 250
    },
    {
      "name": "Belt",
      "category": "Accessories",
      "quantity": 1,
      "price": 230
    }
  ],
  "codes": [
    {
      "type": "SEASONAL",
      "every_X_THB": 40,
      "discount_Y_THB": 300
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
      "price": 350
    },
    {
      "name": "Hat",
      "category": "Accessories",
      "quantity": 1,
      "price": 250
    },
    {
      "name": "Belt",
      "category": "Accessories",
      "quantity": 1,
      "price": 230
    }
  ],
  "codes": [
    {
      "type": "FIXED",
      "value": 50
    },
    {
      "type": "CATEGORY",
      "percentage": 15,
      "category": [
        "Clothing"
      ]
    },
    {
      "type": "SEASONAL",
      "every_X_THB": 40,
      "discount_Y_THB": 300
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



