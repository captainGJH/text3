package com.gjh;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class springbootDruid {
    // StatViewServlet 配置管理页面，主要是管理数据库连接
    @Bean
    public ServletRegistrationBean DruidStatViewServlet() {
        ServletRegistrationBean srb = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 添加管理页面的初始化参数：initParams
        // 配置白名单，即允许访问druid管理页面的ip
        srb.addInitParameter("allow", "127.0.0.1");
        // 配置黑名单，即不允许访问druid管理页面的ip
        srb.addInitParameter("deny", "192.168.7.181");
        // 配置登陆的用户名和密码
        srb.addInitParameter("loginUsername", "admin");
        srb.addInitParameter("loginPassword", "123");
        // 配置是否可以重置,点击重置会重置页面，我们这里不希望，当然你要true也可以，直接不配置也行
        srb.addInitParameter("resetEnble", "false");
        return srb;
    }
    // webStatFilter 配置管理web请求的功能的过滤器，不但会管链接，也可以管请求
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean frb = new FilterRegistrationBean(new WebStatFilter());
        frb.addUrlPatterns("/*");
        // 不是所有的web请求都监控，去掉一些静态的请求和我自己druid的请求
        frb.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,/druid/*");
        return frb;
    }
    @Bean(destroyMethod = "close",initMethod = "init")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDataSource(){  //import javax.sql.DataSource;
        return new DruidDataSource();
    }
}
