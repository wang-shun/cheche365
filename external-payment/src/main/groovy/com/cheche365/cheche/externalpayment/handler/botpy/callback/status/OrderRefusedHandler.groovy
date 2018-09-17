package com.cheche365.cheche.externalpayment.handler.botpy.callback.status

import com.cheche365.cheche.externalpayment.model.BotpyBodyRecord
import com.cheche365.cheche.externalpayment.model.BotpyCallBackBody
import org.springframework.stereotype.Service

/**
 * Created by zhengwei on 19/03/2018.
 */

@Service
class OrderRefusedHandler extends BotpyStatusChangeHandler {

    @Override
    boolean support(BotpyBodyRecord record) {
        BotpyCallBackBody.STATUS_ORDER_REFUSED == record.proposalStatus()
    }

}
