package com.cheche365.cheche.botpy.flow.step

import com.cheche365.cheche.common.flow.IStep
import groovy.util.logging.Slf4j

import static com.cheche365.cheche.botpy.flow.Constants.get_API_PATH_CREATE_RENEWAL_INFO
import static com.cheche365.cheche.botpy.util.BusinessUtils.getQuoteGroup
import static com.cheche365.cheche.botpy.util.BusinessUtils.getVehicleDTO
import static com.cheche365.cheche.botpy.util.BusinessUtils.sendParamsAndReceive
import static com.cheche365.cheche.botpy.util.BusinessUtils.setRequestIdForPath
import static com.cheche365.cheche.common.util.FlowUtils.getContinueFSRV
import static groovyx.net.http.Method.POST



/**
 * 创建续保查询请求
 */
@Slf4j
class CreateRenewals implements IStep {

    @Override
    run(context) {
        def cityCodeMappings = context.cityCodeMappings

        def body = [
            prov_code: cityCodeMappings.prov_code, // 账号所在省份
            city_code: cityCodeMappings.city_code, // 账号所在城市代码
            ics      : getQuoteGroup(context),
            vehicle  : getVehicleDTO(context, context.vehicleInfo)
        ]

        def result = sendParamsAndReceive context, _API_PATH_CREATE_RENEWAL_INFO, body, POST, log

        if (result.request_id) {
            setRequestIdForPath context, result, _API_PATH_CREATE_RENEWAL_INFO
        }
        getContinueFSRV result
    }

}
