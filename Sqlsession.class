// BoardDAO.java 
@Autowired 
public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) { 
  super.setSqlSessionFactory(sqlSessionFactory) 
  } 
  
 public void insertBoard(BoardVO vo) { 
  getSqlSession().insert("BoardDAO.insertBoard", vo); 
 }




// Datasource/mapper context XML 파일 수정

//SqlSessionTemplate 빈 등록



/***

SqlSessionFactoryBean 등록되있을것임

***/


<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate"> 
  <constructor-arg index="0" ref="sqlSessionFactory">
  </constructor-arg> 
</bean> 


// BoardDAO.java 
@Autowired 
private SqlSessionTemplate mybatis; 
public void insertBoard(BoardVO vo) { 
  mybatis.insert("BoardDAO.insertBoard", vo); 
  }

