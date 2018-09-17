package com.cheche365.cheche.scheduletask.model;

/**
 * 按天买车险分享活动报表实体
 * Created by yinJianBin on 2017/2/28.
 */
public class DailyInsuranceOfferReport extends AttachmentData {
    private String reportType;          //报表类型
    private String id;                  //编号
    private String orderNo;             //订单号
    private String startTime;           //起保日期
    private String licensePlateNo;      //车牌号
    private String mobile;              //手机号
    private String userName;            //持卡人
    private String bankName;            //开户银行
    private String userCardNo;          //投保人银行卡
    private String createTime;          //领取时间
    private String rewardDays;          //共领取天数
    private String refundPremium;       //兑换金额
    private String premium;             //商业险总保费
    private String compulsoryPremium;   //交强险保费
    private String autoTax;             //车船税
    private String totalPremium;        //总保费
    private String status;              //兑换状态
    private String jdCard;              //京东卡
    private String gift;                //实物礼品

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUserCardNo() {
        return userCardNo;
    }

    public void setUserCardNo(String userCardNo) {
        this.userCardNo = userCardNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRewardDays() {
        return rewardDays;
    }

    public void setRewardDays(String rewardDays) {
        this.rewardDays = rewardDays;
    }

    public String getRefundPremium() {
        return refundPremium;
    }

    public void setRefundPremium(String refundPremium) {
        this.refundPremium = refundPremium;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getCompulsoryPremium() {
        return compulsoryPremium;
    }

    public void setCompulsoryPremium(String compulsoryPremium) {
        this.compulsoryPremium = compulsoryPremium;
    }

    public String getAutoTax() {
        return autoTax;
    }

    public void setAutoTax(String autoTax) {
        this.autoTax = autoTax;
    }

    public String getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(String totalPremium) {
        this.totalPremium = totalPremium;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJdCard() {
        return jdCard;
    }

    public void setJdCard(String jdCard) {
        this.jdCard = jdCard;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }
}
