```java
public void 중복키가_존재하는_경우_3rd_인자에_merge함수로_해결() {
  int max = 3;
  List<Student> students = TestUtil.getStudentSample(max);
  students.add(new Student("name1", 30)); //중복 이름 추가

  Map<String, Integer> nameVsAgeMap = students
    .stream()
    .collect(Collectors.toMap(
        Student::getName,
        Student::getAge,
        (oldValue, newValue) -> {
          log.info("oldValue : {} newValue : {}", oldValue, newValue);
          return oldValue;
        })
    );
}
```
