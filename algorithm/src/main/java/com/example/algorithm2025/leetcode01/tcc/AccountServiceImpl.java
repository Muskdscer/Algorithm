//package com.example.algorithm2025.leetcode01.tcc;
//
//@Service
//@Slf4j
//public class AccountServiceImpl implements IAccountService{
//    /**
//     * 分支事务仅使用普通@Transactional注解即可
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public RespResult debit(DebitDto debitDto) {
//        log.info("开始TCC分支事务，XID={}", RootContext.getXID());
//        log.info("用户扣款，参数：{}", debitDto);
//        int retCount = this.baseMapper.debit(debitDto.getUserId(), debitDto.getMoney());
//        log.info("用户扣款，结果：{}", retCount);
//        if (0 >= retCount) {
//            throw new MsgRuntimeException("用户扣款失败！");
//        }
//        return RespResult.success();
//    }
//
//    @Override
//    public Boolean commitDebit(BusinessActionContext context) {
//        log.info("TCC提交成功, XID={}, debitDto={}", context.getXid(), context.getActionContext("debitDto"));
//        return true;
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Boolean cancelDebit(BusinessActionContext context) {
//        DebitDto debitDto = context.getActionContext("debitDto", DebitDto.class);
//        log.warn("TCC回滚业务, XID={}, debitDto={}", context.getXid(), debitDto);
//        log.info("用户补款，参数：{}", debitDto);
//        int retCount = this.baseMapper.debit(debitDto.getUserId(), debitDto.getMoney().multiply(new BigDecimal(-1)));
//        log.info("用户补款，结果：{}", retCount);
//        return true;
//    }
//}
