package com.cx.mall.entity;

import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * @author
 * @date 
 */
@ApiModel(value = "订单关联购物项表")
public class OrderItem {
    private Long orderItemId;
    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private String goodsCoverImg;
    private Integer sellingPrice;
    private Integer goodsCount;
    private Date createTime;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsCoverImg() {
        return goodsCoverImg;
    }

    public void setGoodsCoverImg(String goodsCoverImg) {
        this.goodsCoverImg = goodsCoverImg == null ? null : goodsCoverImg.trim();
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", orderItemId=" + orderItemId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsName=" + goodsName +
                ", goodsCoverImg=" + goodsCoverImg +
                ", sellingPrice=" + sellingPrice +
                ", goodsCount=" + goodsCount +
                ", createTime=" + createTime +
                "]";
        return sb;
    }

}
