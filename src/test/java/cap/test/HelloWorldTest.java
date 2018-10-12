package cap.test;

import cap.service.HelloWorld;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

public class HelloWorldTest {

    @Test
    public void testSayhi(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloWorld.sayHi("zhao"));
    }

    @Test
    public void testSayHi1(){
        Resource resource = (Resource) new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory((org.springframework.core.io.Resource) resource);
        HelloWorld helloWorld = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(helloWorld.sayHi("chun"));
    }

    @Test
    public void testSayHi2(){
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloworld");
        System.out.println(helloWorld.sayHi("hua"));
    }
}
