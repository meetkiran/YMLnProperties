package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleDemoBean implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware {
    public LifeCycleDemoBean() {System.out.println("life constructor");
    }

    @Override
    public void destroy()throws Exception{

        System.out.print("destroyed");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.print("setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.print("setBeanName"+s);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.print("afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy");
    }

public void    beforeInit(){
        System.out.println("before init");
}
public void afterInit(){
        System.out.println(" After init");
}
}
