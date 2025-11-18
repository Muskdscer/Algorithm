//package com.example.algorithm2025.leetcode01.tcc;
//
//import javax.annotation.Resource;
//
//@Service
//@Slf4j
//public class StorageServiceImpl implements IStorageService{
//    private final String CACHE_STORAGE_KEY_FORMAT = "storage:%s";
//    @Resource
//    private RedisTemplate redisTemplate;
//
//    /**
//     * 分支事务仅使用普通@Transactional注解即可
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public RespResult deduct(DeductStorageDto deductStorageDto) {
//        log.info("开始TCC分支事务，XID={}", RootContext.getXID());
//        log.info("扣减商品库存，参数: {}", deductStorageDto);
//        /** 模拟回滚异常 */
//        if ("product-2".equals(deductStorageDto.getCommodityCode())) {
//            throw new MsgRuntimeException("异常:模拟业务异常:Storage branch exception");
//        }
//
//        /** 扣减缓存中的商品库存 */
//        String cacheKey = String.format(CACHE_STORAGE_KEY_FORMAT, deductStorageDto.getCommodityCode());
//        Long cacheStorageCount = this.redisTemplate.opsForValue().decrement(cacheKey, deductStorageDto.getCount());
//        log.info("扣减后的商品库存: {}={}", cacheKey, cacheStorageCount);
//        if (cacheStorageCount < 0) {
//            throw new MsgRuntimeException("扣减商品缓存库存失败!");
//        }
//        return RespResult.success();
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Boolean commitDeduct(BusinessActionContext context) {
//        //获取事务上下文传递的参数
//        DeductStorageDto deductStorageDto = context.getActionContext("deductStorageDto", DeductStorageDto.class);
//        log.info("TCC提交成功, XID={}, deductStorageDto={}", context.getXid(), deductStorageDto);
//        /** 扣减DB中的商品库存 */
//        Integer retCount = this.baseMapper.deductStorage(deductStorageDto.getCommodityCode(), deductStorageDto.getCount());
//        log.info("修改商品库存，结果: {}", retCount);
//        //修改商品库存失败，则直接回滚
//        if (0 >= retCount) {
//            throw new MsgRuntimeException("修改商品库存失败!");
//        }
//        return true;
//    }
//
//    @Override
//    public Boolean cancelDeduct(BusinessActionContext context) {
//        //获取事务上下文传递的参数
//        DeductStorageDto deductStorageDto = context.getActionContext("deductStorageDto", DeductStorageDto.class);
//        log.warn("TCC回滚业务, XID={}, deductStorageDto={}", context.getXid(), deductStorageDto);
//        /** 还原缓存中的商品库存 */
//        String cacheKey = String.format(CACHE_STORAGE_KEY_FORMAT, deductStorageDto.getCommodityCode());
//        Long cacheStorageCount = this.redisTemplate.opsForValue().increment(cacheKey, deductStorageDto.getCount());
//        log.info("还原后的商品库存: {}={}", cacheKey, cacheStorageCount);
//        return true;
//    }
//}
