# Distributed Loyalty Card System Backend Services

## Local Development environment
1. Modify `hosts` file，add（you can use [SwitchHosts](http://oldj.github.io/SwitchHosts/))

```
127.0.0.1 lc-eureka
127.0.0.1 lc-mysql
127.0.0.1 lc-auth
```

2. Modify database connection config: `lc-user-biz-dev.yml` and `lc-auth-dev.yml` under the dir `lc-config/src/main/resources/`

3. mysql create database
```
-- mysql -u root -p
-- CREATE DATABASE loyaltycard;
```
4. import and execute `base.sql`, to create database

5. Start the following modules in sequence

```
1. EurekaApplication.java -- Service Registry
2. ConfigApplication.java -- Service Configuration Center
3. MonitorApplication.java -- Spring Boot Admin Monitor
4. ZipkinApplication.java -- Zipkin link monitoring
5. AdminBizApplication.java -- System Management Module
6. AuthApplication.java -- Authorization Module
7. GatewayApplication.java -- Zuul Gateway
```


