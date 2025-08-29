package com.example.algorithm2025.leetcode01.event;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * 事件引擎实现类
 */
public class EventEngineImpl implements EventEngine{
    /**
     * 异步执行器。也系统需要自行定义线程池
     */
    private Executor bizListenerExecutor;

    /**
     * 是否异步，默认为false
     */
    private boolean async;

    /**
     * 订阅端 KEY是TOPIC，VALUES是监听器集合
     */
    private Map<String, List<BizEventListener>> bizSubscribers = new HashMap<>(16);
    @Override
    public void publishEvent(BizEvent event) {
        List<BizEventListener> listeners = bizSubscribers.get(event.getTopic());
        if (CollectionUtils.isEmpty(listeners)) {
            return;
        }
        for (BizEventListener bizEventListener : listeners) {
            if (bizEventListener.decide(event)) {
                //异步执行的话，放入线程池
                if (async) {
                    bizListenerExecutor.execute(new EventSubscriber(bizEventListener, event));
                } else {
                    bizEventListener.onEvent(event);
                }

            }
        }
    }

    /**
     * Setter method for property <tt>bizListenerExecutor</tt>.
     *
     * @param bizListenerExecutor value to be assigned to property bizListenerExecutor
     */
    public void setBizListenerExecutor(Executor bizListenerExecutor) {
        this.bizListenerExecutor = bizListenerExecutor;
    }

    /**
     * Setter method for property <tt>bizSubscribers</tt>.
     *
     * @param bizSubscribers value to be assigned to property bizSubscribers
     */
    public void setBizSubscribers(Map<String, List<BizEventListener>> bizSubscribers) {
        this.bizSubscribers = bizSubscribers;
    }

    /**
     * Setter method for property <tt>async</tt>.
     *
     * @param async value to be assigned to property async
     */
    public void setAsync(boolean async) {
        this.async = async;
    }
}
