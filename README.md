# admin_page
spring boot 를 이용하여 어드민페이지를 구현했습니다.

### screen

<img src="https://user-images.githubusercontent.com/59306143/101287287-b7512200-3832-11eb-810d-44ca980352bc.gif" alt="제목-없음-6" width="600" height="400"/>

---
### explanation

- 스프링에 컨트롤러로 활용할 것이라는 것을 알리기 위해 @RestController,
  api 주소를 매핑하기위해 @RequestMapping("/api").

- RequestParam 이 다수로 많아질 때, 객체를 통해 직접 받기 위해 model pakage 하위에
  searchParam class 를 만들어서 요청을 받도록 했습니다.

- @PostMapping, @GetMapping, @PutMapping, @DeleteMapping 으로 create, read, update, delete에 사용했습니다.

- 크롬 확장프로그램에서 restclient 를 사용했습니다.

- spring boot를 통해 REST API 를 작성했습니다.

- Lombok 으로 자바코드를 줄여 생산성을 높였습니다.

- JPA orm을 사용하여 데이터베이스의 정보를 쉽게 활용했습니다.

- MySQL로 테이블을 생성하고, properties에 spring.datasource.url로 데이터베이스와 주소를 연결했습니다.

- API통신 규격에는 snake case를 주로 사용한다 하여 snake case를 사용했습니다.

- 프로젝트에 entity pakage를 만들고 MySQL의 테이블과 동일한 클래스를 선언해줬습니다.
  (@Entity)

- JAVA에서는 camel case로 선언하더라도 JPA에서는 자동으로 snake case로 매칭해주는게 좋았습니다.

- primary key에 @GeneratedValue 를 통해 전략설정을 할 때, MySQL을 사용하므로 IDENTITY 로
  지정하여 기본키 생성을 데이터베이스에 위임했습니다.

- Repository 를 사용하여 따로 쿼리문을 작성하지 않고 기본적인 CRUD를 사용했습니다.

- test pakage 안에서 코딩하여 테스트 해보았습니다.
  @Autowired로 의존성 주입을 통해 객체를 만들지 않고 스프링이 관리하게 했습니다.

- MySQL workbench를 통해 ERD 작업을 했습니다.

- UML, 플로우차트, 시퀀스다이어그램에 대해 공부하고 있습니다.

- @Builder, @Accessors(chain = true) 로 객체를 생성할 때는 빌더패턴, 업데이트할 때는 체인패턴.

- application.properties 안에 spring.jackson.property-naming-strategy=SNAKE_CASE 라고 해주어 camel case로 개발하더라도 api 전문을 주고받을 때는 snake case로 주고 받을 수 있도록 했습니다.

- 오타로 인한 오류를 줄이기 위해 Enum 으로 관리했습니다.(status, orderType)

- 샘플데이터는 MySQL workbench 에서 sql문을 삽입하여 만들었습니다.

- 기초적인 부분만 공부했기에 코드 리뷰를 다시 해보고 있습니다.
