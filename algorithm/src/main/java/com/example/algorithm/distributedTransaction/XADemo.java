package com.example.algorithm.distributedTransaction;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

public class XADemo {
//    XA {START|BEGIN} xid [JOIN|RESUME] // 开启XA事务
//
//    XA END xid [SUSPEND [FOR MIGRATE]] //将 XA 事务置为IDLE 状态,处于 IDLE 状态可以执⾏PREPARE 操作
//
//    XA PREPARE xid //⼆阶段提交：prepare
//
//    XA COMMIT xid [ONE PHASE] //提交事务
//
//    XA ROLLBACK xid //回滚事务
//
//    XA RECOVER [CONVERT XID] //列出所有处于prepared状态的事务
    public static void main(String[] args) {
        //RM1
//        Connection rm1Conn = DriverManager.getConnection("jdbc:mysql://IP1:3306/XXXX?useUnicode=true&characterEncoding=utf8","xxxx","xxxxx");
//        XAConnection rm1XAConn = new MysqlXAConnection((JdbcConnection) rm1Conn, true);
//        XAResource resource1 = rm1XAConn.getXAResource();
//        //RM2
//        Connection rm2Conn = DriverManager.getConnection("jdbc:mysql://IP2:3306/XXXX?useUnicode=true&characterEncoding=utf8","xxxx","xxxxx");
//        XAConnection rm2XAConn = new MysqlXAConnection((JdbcConnection) rm2Conn, true);
//        XAResource resource2 = rm2XAConn.getXAResource();
//
//        // 全局事务
//        byte[] globalId = UUID.randomUUID().toString().getBytes();
//        //一个标识
//        int formatId = 1;
//
//        //分支事务1
//        byte[] branch1Bqual = UUID.randomUUID().toString().getBytes();;
//        Xid xid1 = new MysqlXid(globalId, branch1Bqual, formatId);
//
//        //分支事务2
//        byte[] branch2Bqual = UUID.randomUUID().toString().getBytes();;
//        Xid xid2 = new MysqlXid(globalId, branch2Bqual, formatId);
//        try {
//            // 事务1开始
//            resource1.start(xid1, XAResource.TMNOFLAGS);
//            // 模拟业务
//            String sql1 = "update xxx set balance_amount = balance_amount - 100 where user_id= ? ";
//            PreparedStatement ps1 = rm1Conn.prepareStatement(sql1);
//            ps1.execute();
//            resource1.end(xid1, XAResource.TMSUCCESS);
//
//            // 事务2开始
//            resource1.start(xid2, XAResource.TMNOFLAGS);
//            // 模拟业务
//            String sql2 = "update xxx set balance_amount = balance_amount + 100 where user_id = ? ";
//            PreparedStatement ps2 = rm2Conn.prepareStatement(sql2);
//            ps2.execute();
//            resource1.end(xid2, XAResource.TMSUCCESS);
//
//
//            // 第一阶段：准备提交
//            int rm1_prepare = resource1.prepare(xid1);
//            int rm2_prepare = resource1.prepare(xid2);
//
//            // 第二阶段：TM根据第一阶段的情况决定是提交还是回滚
//            boolean onePhase = false;
//            if (rm1_prepare == XAResource.XA_OK && rm2_prepare == XAResource.XA_OK) {
//                resource1.commit(xid1, onePhase);
//                resource1.commit(xid2, onePhase);
//            } else {
//                resource1.rollback(xid1);
//                resource1.rollback(xid2);
//            }
//
//        } catch (Exception e) {
//            // 出现异常，回滚
//            resource1.rollback(xid1);
//            resource1.rollback(xid2);
//            e.printStackTrace();
//        }
    }
}
