# QueryDSL로 DBMS 내장함수 및 사용자 정의 함수 사용 시

#### 아래처럼 선언

```java
public class CustomMysqlDialect extends MySQL5Dialect {
    public CustomMysqlDialect() {
        super();
        registerFunction("group_concat", new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));

        registerFunction("distinct", new StandardSQLFunction("distinct", StandardBasicTypes.STRING));

        registerFunction("LENGTH", new StandardSQLFunction("LENGTH", StandardBasicTypes.INTEGER));

        registerFunction("DATE_SUB", new StandardSQLFunction("DATE_SUB", StandardBasicTypes.INTEGER));

        registerFunction("INTERVAL", new StandardSQLFunction("INTERVAL", StandardBasicTypes.INTEGER));

        registerFunction("DAYOFWEEK", new StandardSQLFunction("DAYOFWEEK", StandardBasicTypes.INTEGER));

        // INTERVAL 사용하기 위해 사용자 정의 함수로 등록하여 사용
        registerFunction("date_sub_interval", new SQLFunctionTemplate(StandardBasicTypes.DATE, "date_sub(?1, INTERVAL ?2 ?3)"));

    }
}
```

#### 프로퍼티 파일에 등록
```
Spring:
  jpa:
    database-platform: com.keycutstock.admin.keyword.CustomMysqlDialec
```

#### Repository 단에서 쿼리 시 stringTemplate 이용하여 쿼리 

``` java
 jpaQueryFactory.select(Projections.fields(entity.class,
  Expressions.stringTemplate("CONCAT(DATE_FORMAT(date_sub_interval({0},(DAYOFWEEK({0})-2),DAY),'%Y%m%d'),'-',DATE_FORMAT(date_sub_interval({0} ,(DAYOFWEEK({0})-8),DAY),'%Y%m%d'))", keywordStatisticsEntity.ymd).as("ymd")))
  .from(entity)
  .fetch();
```
