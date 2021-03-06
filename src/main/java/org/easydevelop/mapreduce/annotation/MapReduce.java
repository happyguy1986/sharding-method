package org.easydevelop.mapreduce.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * if the annotation method has a return value,then the aggregation result will replace the return value
 * if 
 * @author deyou
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MapReduce {
	/**
	 * SpEl referent to a instance that implements AggregationStrategy
	 * @return
	 */
	String reduceStrategy() default "";

	String dsSet() default "";
	
	ShardingFailedStrategy shardingFailedStrategy() default ShardingFailedStrategy.NOT_DEFINED;
	
	public static enum ShardingFailedStrategy{
		RETURN_NULL,
		THROW_EXCEPTION,
		NOT_DEFINED;
	}
}
