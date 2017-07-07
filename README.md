# food-ordering-system

## Rest APIs
### 1. Restaurant Service
Search Restaurant by Name
    
    GET localhost:8001/restaurants/{restaurant_name}

Delete Restaurant by restaurantId

    DELETE  localhost:8001/restaurant/{restaurant_id}
    
Create a new Restaurant

    Post  /localhost:8001/restaurants
    Request Body
    {
        "name": <restaurant_name>
    }
    Return HttpStatus.CREATED

Get all menu items by restaurant id
     
     GET localhost:8001/restaurants/{restaurantId}/menuItems
     Return
     [
         {
             "id": <menu_item_id>,
             "restaurantId": <restaurantId>,
             "name": <menu_item_name>,
             "description": <menu_item_description>,
             "price": <menu_item_price>
         },
         ...
     ]

Add menu item for a restaurant:

    
	POST localhost:8001/restaurants/{restaurantId>/menuItems
    Request Body
    {
            "restaurantId": <restaurantId>,
            "name": <menu_item_name>,
            "description": <menu_item_description>,
            "price": <menu_item_price>
    }
    Return HttpStatus.CREATED

Bulk upload menu items
        
        POST localhost:8001/restaurants/bulk/menuItems
        Request Body
        [
            {
                "restaurantId": <restaurantId>,
                "name": <menu_item_name>,
                "description": <menu_item_description>,
                "price": <menu_item_price>
            }
            ...
        ]
        Return HttpStatus.CREATED
	
Update a menu by menu Id

    PUT  localhost:8001/restaurants/menu/{menuId}
	Request Body
        {
                "restaurantId": <restaurantId>,
                "name": <menu_item_name>,
                "description": <menu_item_description>,
                "price": <menu_item_price>
        }
        Return HttpStatus.CREATED

### 2.Order Service
Create an Order

    POST localhost:8002/orders/{restaurantId}
    {
        "restaurantId": <restaurant_id>,
        "items":
        [
            {
                "name": <menu_item_name>,
                "price": <menu_item_price>,
                "quantity": <number of items>
            },
            ...
        ],
        "userInfo":
        {
            "firstName": <customer_first_name>,
            "lastName": <customer_last_name>,
            "phone": <customer_phone>,
            "address": <customer_address>
        },
        "specialNote": <special_note>
    }
    Return:
    HttpStatus.CREATED
    {
        "id": <order_id>,
        "restaurantId": <restaurant_id>,
        "items":
        [
            {
                "name": <menu_item_name>,
                "price": <menu_item_price>,
                "quantity": <# of items>
            },
            ...
        ],
        "userInfo":
        {
            "firstName": <customer_first_name>,
            "lastName": <customer_last_name>,
            "phone": <customer_phone>,
            "address": <customer_address>
        },
        "specialNote": <special_note>,
        "totalPrice": <total_price>,
        "orderTime": <order_time_in_milliseconds>
    }



Get order detail

    POST localhost:8002/orders/{orderId}
    Return:
        
        {
            "id": <order_id>,
            "restaurantId": <restaurant_id>,
            "items":
            [
                {
                    "name": <menu_item_name>,
                    "price": <menu_item_price>,
                    "quantity": <# of items>
                },
                ...
            ],
            "userInfo":
            {
                "firstName": <customer_first_name>,
                "lastName": <customer_last_name>,
                "phone": <customer_phone>,
                "address": <customer_address>
            },
            "specialNote": <special_note>,
            "totalPrice": <total_price>,
            "orderTime": <order_time_in_milliseconds>
        }
    

### 3.Payment Service
Make a payment

    Post /order/{orderId}/payment
    //post body: Credit card info

Validate payment by paymentId

    Get  /order/payment/validate/{paymentId}

Get payment detail by paymentId

    Get /order/payment/detail/{paymentId}


###4. Delivery Service
Store order info into orderDB

    Post /order/store/{orderId}
    //order info

Generate delivery time when payment done

    Get /order/{orderId}/deliveryTime