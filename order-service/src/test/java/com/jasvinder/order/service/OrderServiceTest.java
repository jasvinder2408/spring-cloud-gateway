package com.jasvinder.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jasvinder.order.common.Payment;
import com.jasvinder.order.common.TransactionRequest;
import com.jasvinder.order.entity.Order;
import com.jasvinder.order.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;


//@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

   // @InjectMocks
    private OrderRepository orderRepository;
    //@Mock
    private OrderService orderService;
    @Mock
    RestTemplate restTemplate;

    @Before
    public void init() {
       // MockitoAnnotations.initMocks(this);
        orderService=new OrderService();
    }

    @Test(expected = NullPointerException.class)
    public void saveOrderTest(){
        Order order=new Order();
        Payment payment=new Payment();
        TransactionRequest transactionRequest=new TransactionRequest();
        transactionRequest.setOrder(order);
        transactionRequest.setPayment(payment);
        try {
            orderService.saveOrder(transactionRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
