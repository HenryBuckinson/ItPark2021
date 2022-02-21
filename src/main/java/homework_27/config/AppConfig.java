package homework_27.config;

import homework_27.impls.PrototypePrinterImpl;
import homework_27.impls.SingletonPrinterImpl;
import homework_27.interfaces.PrototypePrinter;
import homework_27.interfaces.SingletonPrinter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("homework_27")
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.INTERFACES)
    PrototypePrinter protPrinter() {
        return new PrototypePrinterImpl();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    SingletonPrinter singPrinter(PrototypePrinter pt) {
        return new SingletonPrinterImpl(pt);
    }


}
