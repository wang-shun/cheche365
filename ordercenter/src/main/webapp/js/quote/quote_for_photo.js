/**
 * 处理拍照报价来源数据报价
 * */
function QuotePhoto(source,sourceId){
    this.source=source;
    this.sourceId=sourceId;
}

QuotePhoto.prototype={
    getQuoteInfo:function(callBackMethod){
        common.ajax.getByAjax(true, "get", "json","/orderCenter/quote/photo/"+this.sourceId,null,
            function (data) {
                QuotePhoto.prototype.initParam(data);
                callBackMethod(data);
            },
            function () {
                popup.mould.popTipsMould(true, "系统异常！", popup.mould.first, popup.mould.error, "", "57%", null);
            }
        );
    },
    initParam:function(data){
        quote.licensePlateNo = data.licensePlateNo;
        quote.user.userId = data.userId;
        quote.user.mobile = data.mobile;
        quote.insured.name = data.insuredName;
        quote.insured.identity = data.insuredIdNo;
        quote.insured.identityType=data.identityType;
        quote.insure.name = data.insuredName;
        quote.insure.identity = data.insuredIdNo;
        quote.insure.identityType=data.insuredIdType;
        quote.sourceChannel = data.sourceChannel;
        quote.owner.name= data.owner;
        quote.owner.identity = data.identity;
        quote.owner.identityType=data.identityType;
    },
    getQuote:function(companyId){
        quote.interface.getQuote(companyId, false);
    }

}


