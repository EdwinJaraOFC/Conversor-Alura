package com.alurachallenge.conversor;
import java.util.Map;

public record ConversionResponse(String base_code,
                                 Map<String, Double> conversion_rates) {

}
