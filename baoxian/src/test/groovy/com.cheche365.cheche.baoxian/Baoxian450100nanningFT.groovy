package com.cheche365.cheche.baoxian

import org.springframework.boot.autoconfigure.EnableAutoConfiguration

/**
 * 北京
 */
@EnableAutoConfiguration
class Baoxian450100nanningFT extends ABaoXianFT {

    @Override
    protected final getAreaProperties() {
        [id: 450100L, name: '南宁']
    }

}
