# 집계 함수 사용시 리턴값 long int 나오는 함수들 정리

### count() 함수 이용 시 Long type 으로 리턴된다.
```java 

jpaQueryFactory
  .select(entity.`numberColumn`.count())
  .from(entity)
  .fetch();
```


### sum() 함수 이용 시 integer type 으로 리턴된다.
```java 

jpaQueryFactory
  .select(
    entity.`numberColumn`.sum()
    ,entity.target
   )
  .from(entity)
  .groupBy(entity.`target`)
  .fetch();
```

### 각 함수들 다른 타입으로 리턴을 원할때는 아래처럼 사용
```java

jpaQueryFactory
  .select(entity.`numberColumn`.count().intValue())     //int 타입으로 반환
  .from(entity)
  .fetch();


jpaQueryFactory
  .select(
    entity.`numberColumn`.sum().longValue()       //long 타입으로 반환
    ,entity.target
   )
  .from(entity)
  .groupBy(entity.`target`)
  .fetch();
```


