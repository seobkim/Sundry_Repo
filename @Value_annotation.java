//SpEL -> ${} , #{} 으로 프로퍼티 파일 내 값 참조 가능 Spring EL

//#{"표현식"}

//${"프로퍼티"}

//표현식 은 프로퍼티를 가질 수 있지만
//프로퍼티는 표현식 을 가질 수 없다.
//ex) #{ ${ my.data } + 1 }

//PropertyPlaceHolderConfigurer 에 빈등록하여
//<context-property-placeholder location="classpath:config/jdbc.properties, classpath:config/monitor.properties"/>
//PropertyPlaceholderConfigurer를 사용할 때 주의할 점은 두 개 이상의 PropertyPlaceholderConfigurer 빈을 설정하면 안 된다는 점이다.
//이 경우, 첫 번째 PropertyPlaceholderConfigurer의 설정이 적용되며, 두 번째 설정 내용은 적용되지 않는다.


@Value("#{fileProperties['is.dev']}")
	private boolean isDev;
