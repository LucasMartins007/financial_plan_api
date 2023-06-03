
package com.lucas.github.financial_planning.config.custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.lucas.github.financial_planning.config.anotations.ExcludeFromResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.util.List;

@Configuration
public class CustomJsonSerializer {

    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    public ObjectMapper objectMapper() {
        SimpleModule module = new SimpleModule();
        module.setSerializerModifier(new ExcludeFromResponseSerializerModifier());

        return Jackson2ObjectMapperBuilder.json()
                .modules(module)
                .build();
    }

    private static class ExcludeFromResponseSerializerModifier extends com.fasterxml.jackson.databind.ser.BeanSerializerModifier {
        @Override
        public List<BeanPropertyWriter> changeProperties(
                SerializationConfig config,
                BeanDescription beanDesc,
                List<BeanPropertyWriter> beanProperties) {
            for (BeanPropertyWriter writer : beanProperties) {
                if (writer.getAnnotation(ExcludeFromResponse.class) != null) {
                    writer.assignNullSerializer(new NullJsonSerializer());
                }
            }
            return beanProperties;
        }
    }

    private static class NullJsonSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            // Intentionally left empty
        }
    }
}
