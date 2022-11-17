package com.kingcode.quartz.simpleService.spring;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * Adds auto-wiring support to quartz jobs.
 * @see "https://gist.github.com/jelies/5085593"
 */
@Profile("application.properties")
class AutoWiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    private transient AutowireCapableBeanFactory beanJobFactory;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        beanJobFactory = applicationContext.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanJobFactory.autowireBean(job);
        return job;
    }
}
