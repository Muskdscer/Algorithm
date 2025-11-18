//package com.example.algorithm2025.leetcode01.tcc;
//
//import javax.annotation.Resource;
//
//public class OrderServiceImpl implements IOrderService{
//    @Resource
//    private AccountFeignClient accountFeignClient;
//
//    /**
//     * 分支事务仅使用普通@Transactional注解即可
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public RespResult create(CreateOrderDto createOrderDto) {
//        log.info("开始TCC分支事务，XID={}", RootContext.getXID());
//
//        //计算订单金额（假设商品单价5元）
//        BigDecimal orderMoney = new BigDecimal(createOrderDto.getCount()).multiply(new BigDecimal(5));
//        /** 用户扣款 */
//        RespResult respResult = accountFeignClient.debit(new DebitDto(createOrderDto.getUserId(), orderMoney));
//        log.info("RPC用户扣减余额服务，结果：{}", respResult);
//        if (!RespResult.isSuccess(respResult)) {
//            throw new MsgRuntimeException("RPC用户扣减余额服务失败！");
//        }
//
//        /** 创建订单 */
//        Order order = new Order();
//        order.setUserId(createOrderDto.getUserId());
//        order.setCommodityCode(createOrderDto.getCommodityCode());
//        order.setCount(createOrderDto.getCount());
//        order.setMoney(orderMoney);
//        log.info("保存订单信息，参数：{}", order);
//        Boolean result = this.save(order);
//        log.info("保存订单信息，结果：{}", result);
//        if (!Boolean.TRUE.equals(result)) {
//            throw new MsgRuntimeException("保存新订单信息失败!");
//        }
//
//        if ("product-3".equals(createOrderDto.getCommodityCode())) {
//            throw new MsgRuntimeException("异常:模拟业务异常:Order branch exception");
//        }
//        return RespResult.successData(order);
//    }
//
//    @Override
//    public Boolean commitCreate(BusinessActionContext context) {
//        log.info("TCC提交成功, XID={}, createOrderDto={}", context.getXid(), context.getActionContext("createOrderDto"));
//        return true;
//    }
//
//    @Override
//    public Boolean cancelCreate(BusinessActionContext context) {
//        log.warn("TCC回滚业务, XID={}, createOrderDto={}", context.getXid(), context.getActionContext("createOrderDto"));
//        //此处正常应该实现create创建订单的补偿方法，即删除之前create方法中保存的DB订单信息，
//        //但由于当前Order服务位于整个服务调用链路的最后一位，执行到Order服务的Try阶段，即也意味着前面的Storage、Account服务的Try阶段都成功了，
//        //不存在Order服务的Try阶段执行成功了还需进行全局回滚的情况，所以也就没必要实现Order服务的Cancel方法（其实就是懒-_-|||）。
//
//        //若需实现create创建订单的补偿方法，可在DB中新创建个表，如order_tx_relation(order_id, tx_id)
//        //然后在create方法保存order成功后，同时将 (新生成的order_id, 全局事务XID) 的绑定关系保存到order_tx_relation表,
//        //在此Cancel方法中通过XID查询到对应的order_id，然后删除此order_id对应的订单信息。
//        return true;
//    }
//}
