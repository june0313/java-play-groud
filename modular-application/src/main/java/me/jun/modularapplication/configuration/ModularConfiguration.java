package me.jun.modularapplication.configuration;

import me.jun.module.a.pub.PublicModuleA;
import me.jun.module.member.api.MemberApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModularConfiguration {
    @Bean
    public PublicModuleA publicModuleA() {
        return new PublicModuleA();
    }

    @Bean
    public MemberApi memberApi() {
        return new MemberApi();
    }
}
