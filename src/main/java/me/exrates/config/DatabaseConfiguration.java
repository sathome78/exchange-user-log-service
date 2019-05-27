package me.exrates.config;

import me.exrates.SSMGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

public class DatabaseConfiguration {

    @Value("${datasource.username}")
    private String user;
    @Value("${ssm.path}")
    private String ssmPath;

    @Autowired
    private SSMGetter ssmGetter;

    private String getPassword(String ssmPath) {
        return ssmGetter.lookup(ssmPath);
    }

}