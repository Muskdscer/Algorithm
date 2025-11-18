//package com.example.algorithm2025.leetcode01.tcc;
//
//@LocalTCC
//public interface IStorageService {
//    /**
//     * 减库存
//     * 注解try方法
//     * @param deductStorageDto 扣库存参数
//     * @return 响应结果
//     */
//    @TwoPhaseBusinessAction(
//            //该tcc的bean名称,写方法名便可，全局唯一
//            name = "deduct",
//            //二阶段确认方法
//            commitMethod = "commitDeduct",
//            //二阶段取消方法
//            rollbackMethod = "cancelDeduct",
//            //启用tcc防护（避免幂等、空回滚、悬挂）
//            useTCCFence = true
//    )
//    RespResult deduct(@BusinessActionContextParameter("deductStorageDto") DeductStorageDto deductStorageDto);
//
//    /**
//     * 确认方法，与@TwoPhaseBusinessAction.commitMethod对应
//     * 注：context可以传递try方法的参数
//     *
//     * @param context 上下文
//     * @return 是否成功
//     */
//    Boolean commitDeduct(BusinessActionContext context);
//
//    /**
//     * 回滚方法，与@TwoPhaseBusinessAction.rollbackMethod对应
//     * 注：context可以传递try方法的参数
//     *
//     * @param context 上下文
//     * @return 是否成功
//     */
//    Boolean cancelDeduct(BusinessActionContext context);
//}
