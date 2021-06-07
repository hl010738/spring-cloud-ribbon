package com.springboot.ribbon

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.context.annotation.Bean

@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
class EurekaRibbonClientApplication {

    // Hystrix dashboard
    @Bean
    fun getServlet(): ServletRegistrationBean<HystrixMetricsStreamServlet> {

        var streamServlet = HystrixMetricsStreamServlet()
        var registrationBean = ServletRegistrationBean(streamServlet)

        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");

        return registrationBean
    }

    /*
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");

        return registrationBean;
    }
     */
}

fun main(args: Array<String>) {
    runApplication<EurekaRibbonClientApplication>(*args)
}
