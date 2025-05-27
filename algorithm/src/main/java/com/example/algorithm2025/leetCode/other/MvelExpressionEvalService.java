package com.example.algorithm2025.leetCode.other;

import org.mvel2.MVEL;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MvelExpressionEvalService {
    public boolean evaluate(String expression, Map<String, Object> variables) {
        return MVEL.evalToBoolean(expression, variables);
    }
}
