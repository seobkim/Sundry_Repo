
-- 각 행마다 번호를 부여하여 조회 OVER() 안은 정렬 조건을 제공
SELECT 
	ROW_NUMBER() OVER(ORDER BY job, name) row_num
     ,*
  FROM emp
 ORDER BY job, name
 
-- 페이징 기능 구현시 위의 쿼리보다 퍼포먼스
-- Oracle, postgreSQL 둘다 가능
-- Oracle은 12 버전 이후부터 사용 가능
-- 행 번호 부여하지않고 특졍 번호의 행을 조회
 SELECT *
 FROM emp
 ORDER BY name
 LIMIT 0	-- 조회해올 개수
 OFFSET 0	-- 조회를 해올 시작 번호
