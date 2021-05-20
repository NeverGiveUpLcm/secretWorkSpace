package com.itcast.springboot.converter;

import com.itcast.springboot.entity.People;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichunmiao
 * @date 2021/5/13
 */
public class MySelfMessageConverter implements HttpMessageConverter<People> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        if (clazz.isAssignableFrom(People.class)) {
            return true;
        }
        return false;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        MediaType mediaType = MediaType.parseMediaType("application/atguigu");
        return Arrays.asList(mediaType);
    }

    @Override
    public People read(Class<? extends People> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(People people, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String result = people.getUserName() + ";" + people.getAge();
        OutputStream body = outputMessage.getBody();
        body.write(result.getBytes());
    }
}
