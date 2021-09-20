package guru.springframework.sfgdi.services;
//@Service

import org.springframework.stereotype.Service;

// we told Spring that this is a Spring managed component
@Service
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "HelloWorld - Constructor";
    }
}
