# Shop
>基于SpringMVC搭建的电商项目整合了SpringSecurity,thymeleaf,lombok
## 目录结构
```
.
├── README.md
├── directorylist.md
├── gen_dirlist.sh
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── lhb
    │   │           └── sh
    │   │               ├── config
    │   │               │   └── WebSecurityConfig.java //SpringSecurity配置
    │   │               ├── controller
    │   │               │   ├── BaseController.java //所有Controller的父类
    │   │               │   ├── IndexController.java
    │   │               │   ├── auth     //认证模块
    │   │               │   │   └── AuthController.java 
    │   │               │   └── user
    │   │               │       └── UserController.java
    │   │               ├── exception
    │   │               │   └── user
    │   │               │       ├── NonuniquenessException.java
    │   │               │       ├── NullValueException.java
    │   │               │       ├── RepeatException.java
    │   │               │       └── UserException.java
    │   │               ├── mapper
    │   │               │   ├── ProductMapper.java
    │   │               │   └── UserMapper.java
    │   │               ├── model
    │   │               │   ├── Product.java
    │   │               │   └── User.java
    │   │               ├── provider
    │   │               │   └── auth
    │   │               │       └── CustomerAuthenticationProvider.java
    │   │               ├── service
    │   │               │   ├── auth
    │   │               │   │   └── DbUserDetailsService.java
    │   │               │   └── user
    │   │               │       ├── UserService.java
    │   │               │       └── impl
    │   │               │           └── UserServiceImp.java
    │   │               └── util
    │   │                   ├── ResultUtil.java
    │   │                   ├── Security.java
    │   │                   └── enums
    │   │                       ├── AccountStaEnum.java
    │   │                       └── GoodsStaEnum.java
    │   └── resource
    │       ├── db
    │       │   └── migration
    │       │       ├── V1__create_user_table.sql
    │       │       ├── V2__create_product_table.sql
    │       │       ├── V3__create_address_table.sql
    │       │       └── V4__create_product_sku_table.sql
    │       ├── jdbc.properties
    │       ├── log4j2.xml
    │       ├── mapper
    │       │   ├── ProductMapper.xml
    │       │   └── UserMapper.xml
    │       ├── mybatis-config.xml
    │       └── spring
    │           ├── spring-dao.xml
    │           ├── spring-service.xml
    │           └── spring-web.xml
    └── test
        ├── Log4j2Test.java
        ├── SecurityTest.java
        └── log4j2.xml
```
