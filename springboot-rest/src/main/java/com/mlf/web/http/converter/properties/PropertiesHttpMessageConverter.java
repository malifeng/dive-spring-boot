package com.mlf.web.http.converter.properties;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConverter() {
        super(new MediaType("text","properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream body = httpOutputMessage.getBody();

        MediaType contentType = httpOutputMessage.getHeaders().getContentType();

        Charset charset = contentType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(body,charset);
        properties.store(outputStreamWriter,"From PropertiesHttpMessageConverter");
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream body = httpInputMessage.getBody();

        MediaType contentType = httpInputMessage.getHeaders().getContentType();

        Charset charset = contentType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;

        InputStreamReader inputStreamReader = new InputStreamReader(body,charset);

        Properties properties = new Properties();
        properties.load(inputStreamReader);
        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null,httpInputMessage);
    }
}
