创建订单
    POST /order/create
参数


```
name: "张三"
phone: "18868822111"
address: "慕课网总部"
openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
items: [{
    productId: "1423113435324",
    productQuantity: 2 //购买数量
}]

```


返回

```json
    {
      "code": 0,
      "msg": "成功",
      "data": {
          "orderId": "147283992738221" 
      }
    } 
```
