package guru.springframework;

import guru.springframework.controllers.MyController;
import guru.springframework.examplebeans.FakaDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		//ctx.getBean("lifecycleDemoBean");
		FakaDataSource fakaDataSource=ctx.getBean(FakaDataSource.class);
		System.out.println(fakaDataSource.getUsername());
        FakeJmsBroker fakaDataSource1=ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakaDataSource1.getUsername());
		/*System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());*/
	}
}
