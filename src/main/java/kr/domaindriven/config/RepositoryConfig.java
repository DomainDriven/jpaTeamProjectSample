package kr.domaindriven.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class RepositoryConfig{
    //boot에서 다 알아서 해주니깐.. 사실 할께 없다. ㅇㅅㅇ
}