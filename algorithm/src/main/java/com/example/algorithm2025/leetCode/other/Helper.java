package com.example.algorithm2025.leetCode.other;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    // 将 Number 转换为 BigDecimal
    private BigDecimal toBigDecimal(Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        } else if (number instanceof Double || number instanceof Float) {
            return new BigDecimal(number.toString());
        } else {
            return BigDecimal.valueOf(number.longValue());
        }
    }

    // 计算平均值的方法，接受多个 Number 类型参数
    public BigDecimal avg(Number... numbers) {
        if (numbers.length == 0) return null;

        List<BigDecimal> bigDecimals = Arrays.stream(numbers)
                .map(this::toBigDecimal)
                .collect(Collectors.toList());

        BigDecimal sum = bigDecimals.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.divide(BigDecimal.valueOf(numbers.length), BigDecimal.ROUND_HALF_UP);
    }

    // 计算总和的方法，接受多个 Number 类型参数
    public BigDecimal sum(Number... numbers) {
        List<BigDecimal> bigDecimals = Arrays.stream(numbers)
                .map(this::toBigDecimal)
                .collect(Collectors.toList());

        return bigDecimals.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 计算最大值的方法，接受多个 Number 类型参数
    public BigDecimal max(Number... numbers) {
        if (numbers.length == 0) return null;

        List<BigDecimal> bigDecimals = Arrays.stream(numbers)
                .map(this::toBigDecimal)
                .collect(Collectors.toList());

        return bigDecimals.stream()
                .max(BigDecimal::compareTo)
                .orElse(null);
    }

    // 计算最小值的方法，接受多个 Number 类型参数
    public BigDecimal min(Number... numbers) {
        if (numbers.length == 0) return null;

        List<BigDecimal> bigDecimals = Arrays.stream(numbers)
                .map(this::toBigDecimal)
                .collect(Collectors.toList());

        return bigDecimals.stream()
                .min(BigDecimal::compareTo)
                .orElse(null);
    }
}
