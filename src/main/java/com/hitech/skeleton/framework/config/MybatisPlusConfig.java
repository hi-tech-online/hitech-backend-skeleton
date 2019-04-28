package com.hitech.skeleton.framework.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.hitech.skeleton")
public class MybatisPlusConfig {

	/**
	 * 乐观锁拦截器
	 *
	 * @return
	 */
	//@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}

	/**
	 * 分页插件 <br/>
	 * 利用攻击 SQL 阻断解析器，来防止 "全表更新"，"全表删除" 等高危操作。
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		List<ISqlParser> sqlParserList = new ArrayList<>();
		sqlParserList.add(new BlockAttackSqlParser());

		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		paginationInterceptor.setSqlParserList(sqlParserList);
		return paginationInterceptor;
	}

	/**
	 * 性能分析拦截器，用于输出每条 SQL 语句及其执行时间，仅开发、测试环境使用，生产环境不推荐。
	 */
	@Bean
//	@Profile({"dev","test"})
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		// SQL 格式化开关
		performanceInterceptor.setFormat(false);
		// SQL 最长执行时间，超过自动停止运行，单位毫秒
		performanceInterceptor.setMaxTime(1000);
		return performanceInterceptor;
	}
}
