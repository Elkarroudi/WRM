package org.wora.wrm.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.wora.wrm.entities.enums.AlgorithmType;

@Getter
@Configuration
public class AppConfiguration {

    @Value("${app.default.algorithm}")
    private AlgorithmType algorithmType = AlgorithmType.FIFO;

}
