package com.example.algorithm2025.leetcode01.test.stateMachine;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigurableStateMachine {
    private State current;
    private List<SyncTransition> transitions = new ArrayList<>();

    public ConfigurableStateMachine(State initial, List<ConfigTransition> configList) {
        this.current = initial;
        for (ConfigTransition ct : configList) {
            transitions.add(new SyncTransition(State.valueOf(ct.from),
                    Event.valueOf(ct.event),
                    State.valueOf(ct.to),
                    null,
                    null));
        }
    }

    public void handleEvent(Event event) {
        for (SyncTransition t : transitions) {
            if (t.from == current && t.event == event) {
                current = t.to;
                System.out.println("状态转移到：" + current);
                return;
            }
            System.out.println("无效事件，当前状态：" + current);
        }
    }

    public State getCurrent() {
        return current;
    }

    // 加载配置
    public static List<ConfigTransition> loadConfig(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(new File(filePath), ConfigTransition[].class));
    }
}
