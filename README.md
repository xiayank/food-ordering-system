# food-ordering-system

## Rest APIs
### Restaurant Service
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

### Order Service
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
    
> 将payment post到 Distribution service上，payment 会 distribute到queue里，payment service中的PaymentSink.class来consume，将payment
 发到complete updater上restTemplate.postForLocation(orderCompleteUpdater + "/api/orders", order); 使用updater的rest api中 template.convertAndSend("/topic/orders", order);
  /topic/orders定义在updater WebSocketApi.class里。
### Payment Distribution Service
Distribute payment
         
         POST localhost:8003/payments
         {
             "orderId": <order_id>,
             "amount": <payment_amount>,
             "creditCardInfo": 
             {
                 "firstName": <first_name>,
                 "lastName": <lastName>,
                 "expiredMonth": <month>,
                 "expiredYear": <year>,
                 "securityCode": <security_code>
             }
         }
         
         Because the process to make payments can be slow and be bottleneck of project
         so this API will produce the payment info into Message Queue. Let Payment Service to consume.

### Payment Service
Make a payment

    POST localhost:8004/payments
    {
        "orderId": <order_id>,
        
        "creditCardInfo": 
        {
            "firstName": <first_name>,
            "lastName": <lastName>,
            "expiredMonth": <month>,
            "expiredYear": <year>,
            "securityCode": <security_code>
        }
    }
    Return
    HttpStatus.CREATED
    Note: this API will store the payment into DB, find the matching order 
    and update the order paymentId, deliveryTime, and notify Order Complete Service with RestTemplate.



### Order Complete Service
Complete Order
    
    POST localhost:8005/api/orders
    {
        "id": <order_id>,
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
        "totalPrice": <total_order_price>,
        "orderTime": <order_time>,
        
        "deliveryTime": <food_delivery_time>,
        "paymentId": <payment_id>
    }
    Note: This API will serialize the order to WebSocket channel: "topic/orders", UI can subscribe to this channel to receive message and display to user.
    
