package com.cx.mall.service;

import com.cx.mall.entity.Order;
import com.cx.mall.utils.PageQueryUtil;
import com.cx.mall.utils.PageResult;
import com.cx.mall.vo.*;

import java.util.List;

/**
 * @author
 * @date 
 */
public interface OrderService {
    //后台分页
    PageResult getOrdersPage(PageQueryUtil pageUtil);

    //订单信息修改
    String updateOrderInfo(Order newBeeMallOrder);

    //配货
    String checkDone(Long[] ids);

    //出库
    String checkOut(Long[] ids);

    //关闭订单
    String closeOrder(Long[] ids);

    //保存订单
    String saveOrder(UserVO user, List<ShoppingCartItemVO> myShoppingCartItems);

    //获取订单详情
    OrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId);

    //获取订单详情
    Order getOrderByOrderNo(String orderNo);

    //我的订单列表
    PageResult getMyOrders(PageQueryUtil pageUtil);

    //手动取消订单
    String cancelOrder(String orderNo, Long userId);

    //确认收货
    String finishOrder(String orderNo, Long userId);

    String paySuccess(String orderNo, int payType);

    List<OrderItemVO> getOrderItems(Long id);

    PayVO getOrderPay(Long orderId);
}
