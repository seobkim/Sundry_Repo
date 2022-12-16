# JPA / Hibernate 주의 옵션

### Spring Properties 

```
spring:
  jpa:
    hibernate:
      ddl-auto: none
```

#### ddl-auto 옵션 종류
- create : 기존 테이블 삭제 후 다시 생성 (drop + create)
- create-drop : create와 같으나 종료시점에 테이블 Drop
- update : 변경 분만 DB에 반영
- validate : 엔티티와 테이블이 정상 매핑되었는지만 확인
- none : 사용하지 않음 (사실상 없는 값이지만 관례상 none 표시)

```create``` ```create-drop``` ```update``` ```create-drop```  => 운영 DB 에서 사용하면 안됨.

#### 주의 사항
- 개발 초기 단계는 ```create``` 또는 ```update```
- 테스트 서버는 ```update``` 또는 ```validate```
- 스테이징과 운영 서버는 ```validate``` 또는 ```none```  
  
하지만 로컬 환경을 제외한 나머지 서버에서는 최대한 직접 쿼리를 날려서 적용하는 것이 가장 좋다.

### **결론은 spring.jpa.hibernate.ddl-auto: create 옵션은 로컬환경에서만 사용해야 된다는 것이다.**
