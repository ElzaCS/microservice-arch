package com.example.currencyconversionservice;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost:8000") //from application.properties of CurrencyExchange Service
@FeignClient(name="currency-exchange-service") //to directly call currency-exchange-service
//@FeignClient(name="netflix-zuul-api-gateway-server") //calls gateway-server, which calls exchange-service
@LoadBalancerClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
//    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") //for gateway-server
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
