package com.postech.entregavel1techchallenge.config.docs;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String INFO_TITLE = "tech-challenge";
    private static final String INFO_DESCRIPTION = "Serviço responsável pelo pedidos";

    @Bean
    public OpenApiCustomizer openApiCustomizer() {
        return openApi -> openApi.setInfo(getInfo());
    }

    private Info getInfo() {
        var info = new Info();
        info.setTitle(INFO_TITLE);
        info.setDescription(INFO_DESCRIPTION);
        return info;
    }


}
