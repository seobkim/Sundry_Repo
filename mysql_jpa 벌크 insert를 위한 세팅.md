## Mysql / JPA 벌크 Insert query를 위한 세팅

벌크 insert / update
JDBC URL에 rewriteBatchedStatements=true 옵션 추가

```
# .properties / .yaml
spring.jpa.hibernate.properties.jdbc.batch_size : 1000 (한번에 수행될 쿼리 수)
spring.jpa.hibernate.properties.jdbc.order_inserts : true
spring.jpa.hibernate.properties.jdbc.order_updates : true
```

#### EX)
Insert into 테이블 (row1);  
Insert into 테이블 (row2);  
Insert into 테이블 (row3);  
=====>  
Insert into 테이블 (row1),(row2),(row3);
