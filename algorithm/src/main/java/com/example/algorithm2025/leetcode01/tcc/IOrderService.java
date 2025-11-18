//package com.example.algorithm2025.leetcode01.tcc;
//
//@LocalTCC
//public interface IOrderService {
//    /**
//     * 创建订单（用户扣款、创建订单）
//     * 注解try方法
//     * @param createOrderDto 创建订单参数
//     * @return 响应结果
//     */
//    @TwoPhaseBusinessAction(
//            //该tcc的bean名称,写方法名便可，全局唯一
//            name = "create",
//            //二阶段确认方法
//            commitMethod = "commitCreate",
//            //二阶段取消方法
//            rollbackMethod = "cancelCreate",
//            //启用tcc防护（避免幂等、空回滚、悬挂）
//            useTCCFence = true
//    )
//    RespResult create(@BusinessActionContextParameter("createOrderDto") CreateOrderDto createOrderDto);
//
//    /**
//     * 确认方法，与@TwoPhaseBusinessAction.commitMethod对应
//     * 注：context可以传递try方法的参数
//     *
//     * @param context 上下文
//     * @return 是否成功
//     */
//    Boolean commitCreate(BusinessActionContext context);
//
//    /**
//     * 回滚方法，与@TwoPhaseBusinessAction.rollbackMethod对应
//     * 注：context可以传递try方法的参数
//     *
//     * @param context 上下文
//     * @return 是否成功
//     */
//    Boolean cancelCreate(BusinessActionContext context);
//}
