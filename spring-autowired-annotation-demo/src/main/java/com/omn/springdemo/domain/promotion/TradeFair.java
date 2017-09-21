package com.omn.springdemo.domain.promotion;


import org.springframework.beans.factory.annotation.Autowired;

import com.omn.springdemo.domain.product.ConsumerProduct;
import com.omn.springdemo.domain.product.IndustrialProduct;

public class TradeFair {
	@Autowired
	private IndustrialProduct industrialProduct;
	@Autowired
	private ConsumerProduct consumerProduct;

//	public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
//		super();
//		this.industrialProduct = industrialProduct;
//		this.consumerProduct = consumerProduct;
//	}

	public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
		return industrialProduct.calculatePrice();
	}

	public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
		return consumerProduct.calculatePrice();
	}

	public String specialPromotionalPricing() {
		String priceInfo = "Industrial Product is priced at $" + declareIndustrialProductPrice(industrialProduct)
				+ " and " + "Consumer Product is priced at $" + declareConsumerProductPrice(consumerProduct);
		return priceInfo;
	}
}
