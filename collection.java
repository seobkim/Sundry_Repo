HashMap<String, Integer> fruitMap = new HashMap();

		  fruitMap.put("사과", 1000);
		  fruitMap.put("사과", 1000);
		  fruitMap.put("배", 2000);
		  fruitMap.put("자두", 3000);
		  fruitMap.put("수박", 4000);

		 

		  // get() --> Key에 해당하는 Value를 출력한다.

		  System.out.println( fruitMap.get("자두") );   // 3000

		 

		        // values() --> 저장된 모든 값 출력

		  System.out.println( fruitMap.values() ); // [1000, 2000, 3000, 4000]

		 

		  // HashMap에 넣은 Key와 Value를 Set에 넣고 iterator에 값으로 Set정보를 담에 준다.

		  // Interator itr = fruitMap.entrySet().interator(); 와 같다.

		  Set<Entry<String, Integer>> set = fruitMap.entrySet();

		  set.forEach(e ->System.out.println("이름 : " + e.getKey() + ", 가격 : " + e.getValue() + "원"));
		  
		  for(Entry<String, Integer> e: set) {
			  System.out.println(1);
			  System.out.println(e);
		  }
		  
		  
		  
		  Iterator<Entry<String, Integer>> itr = set.iterator();
		  
		  while (itr.hasNext()){

			   Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)itr.next();
	
			   System.out.println("이름 : " + e.getKey() + ", 가격 : " + e.getValue() + "원");

		  }

