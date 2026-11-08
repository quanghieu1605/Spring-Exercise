package com.springmasterclass.study.config;

import org.springframework.context.annotation.Configuration;
import com.springmasterclass.study.dto.response.UserRp;
import com.springmasterclass.study.entity.User;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(false).setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(User.class, UserRp.class).addMappings(mapper -> {
            mapper.map(User::getName, UserRp::setName);
        });
        return modelMapper;

    }

}