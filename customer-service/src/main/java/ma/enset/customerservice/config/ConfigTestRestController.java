package ma.enset.customerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestRestController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    private CustomerRecodConfigParams customerRecodConfigParams;

    public ConfigTestRestController(CustomerRecodConfigParams customerRecodConfigParams) {
        this.customerRecodConfigParams = customerRecodConfigParams;
    }

    @GetMapping("/testConfig1")
    public Map<String,String> testConfig(){
        return Map.of("p1",p1,"p2",p2);
    }
    @GetMapping("/testConfig2")
    public CustomerRecodConfigParams testConfig2(){
        return customerRecodConfigParams;
    }
}

