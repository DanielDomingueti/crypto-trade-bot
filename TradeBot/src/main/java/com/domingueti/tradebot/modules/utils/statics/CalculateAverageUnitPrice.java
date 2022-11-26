package com.domingueti.tradebot.modules.utils.statics;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalculateAverageUnitPrice {

	public static Double execute(BigDecimal previousValue, Double previousUnits, BigDecimal newValue, Double newUnits) {
		return (previousValue.add(newValue)).doubleValue() / (previousUnits + newUnits);
	}

}
