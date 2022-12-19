# Mysql , query-dsl: jpa


### Bulk insert 하기

## Case 1: jpa SaveAll 메소드를 이용하여 3만건의 데이터 삽입 (키값은 auto_incremnet 사용 x)

SaveAll() 함수의 내부를 보면 영속성 관리 대상이되어 새로운 객체인지 아닌지 확인을 하기 때문에  
Select 후 insert 하는 쿼리 총 2건의 쿼리가 실행되고 insert 가 단건으로 처리됨.   
즉 성능 저하

```java
@Transactional
public <S extends T> S save(S entity) {
	if (this.entityInformation.isNew(entity)) {
    	this.em.persist(entity);
        return entity;
    } else {
        return this.em.merge(entity);
    }
 }
```
## Case 2: JPA Persist Context를 이용하여 데이터 삽입
Insert 하려는 테이블을 조회 영속성 컨텍스트에 담아두고 새로운값이 아닌지  
그값을 비교하며 entityManager를 이용해 바로 persist 하여 영속성을 변경  
그리고 영속성 반영을 한번에 flush 함.  
그리고 JDBC 의 rewriteBatchedStatements=true 옵션을 통해  
Insert 구문이 묶음으로 가 bulk insert가 가능

```java
@Repository
public class testClass(){

  @Autowired
  private JPAQueryFactory jpaQueryFactory;
  private EntityManager em;
  
  @Transactional
  public void bulkInsertTest(List<TestEntity> testEntityList) {
    
    // 키 값들만 가진 리스트로 변환
    List<String> entityKeyList = testEntityList.stream().map(testEntityList::getKey).collect(Collectors.toList());
  
  
    // 같은 키를 가진 리스트를 조회
    List<TestEntity> list = testEntityRepository.findAllByKeyIn(entityKeyList);
    
    HashMap<String,TestEntity> map = new HashMap<>();
    for (TestEntity entity : list) {
      cutsEntityHashMap.put(entity.getName(), entity);
    }
    
    // 변경할 데이터들의 key값을 리스트로 변환

    

    for (TestEntity entity : list) {
      if (cutsEntityHashMap.containsKey(entity.getCutName())) {
    

  }

}
```

Case 3:
querydsl-jpa가 아닌 querydsl-sql 모듈 사용
