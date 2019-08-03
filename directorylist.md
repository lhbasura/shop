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
    │   │               │   └── WebSecurityConfig.java
    │   │               ├── controller
    │   │               │   ├── BaseController.java
    │   │               │   ├── IndexController.java
    │   │               │   ├── auth
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
