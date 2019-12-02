package com.sbt.javaschool.rnd;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ICache {
    CacheType cacheType() default CacheType.MEMORY;
    String fileNamePrefix() default "";
    boolean zip() default false;
    Class<?>[] identityBy() default {String.class};
    int lengthList() default 1000;
}
