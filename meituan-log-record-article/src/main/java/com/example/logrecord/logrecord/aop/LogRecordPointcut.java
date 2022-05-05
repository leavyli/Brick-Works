package com.example.logrecord.logrecord.aop;

/**
 * @author: saino
 * @Description:
 * @date:2022/5/5 9:45
 */

//public class LogRecordPointcut extends StaticMethodMatcherPointcut implements Serializable {
//    // LogRecord的解析类
//    private LogRecordOperationSource logRecordOperationSource;
//
//    @Override
//    public boolean matches(@NonNull Method method, @NonNull Class<?> targetClass) {
//        // 解析 这个 method 上有没有 @LogRecordAnnotation 注解，有的话会解析出来注解上的各个参数
//        return !CollectionUtils.isEmpty(logRecordOperationSource.computeLogRecordOperations(method, targetClass));
//    }
//
//    void setLogRecordOperationSource(LogRecordOperationSource logRecordOperationSource) {
//        this.logRecordOperationSource = logRecordOperationSource;
//    }
//}
