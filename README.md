# admin_page

### screen

<img src="https://user-images.githubusercontent.com/59306143/101287287-b7512200-3832-11eb-810d-44ca980352bc.gif" alt="제목-없음-6" width="600" height="400"/>

### explanation

사용자로 부터 접속을 받아주기위해 주소를 설정해야됨. 주소들의 묶음을 모아놓은 것을 컨트롤러라고 부름.

스프링에게 이곳을 컨트롤러로 활용할것이라는 것을 알리기위해 어노테이션으로 RestController
이곳으로 들어올 api주소를 매핑하기위해 RequestMapping("/api"). //localhost:8080/api

정상응답하는지 확인 하기 위해 웹브라우저를 통해 직접 확인.

@GetMapping을 이용하여 주소매핑. 메소드 지정이 필요없고, 주소만 설정해주면 됨.

RequestParam 이 세개, 네개이상으로 많아질 때, 객체를 통해서 직접 받는 방법
파라미터를 객체로 받기 위해 model 패키지를 만들어서 searchParam 클래스를 만들어서 요청을 받도록 함.
해당 파라미터를 받기 위해서 get set 메서드와 생성자가 있어야됨.

@postMapping
post는 주로 html <form> 이나 ajax 검색에 사용됨.
http post body 에 데이터를 넣어서 보내겠다~ -> @RequestBody
json, xml, multipart-form, text-plain 데이터 형식 중, 기본적으로 json을 사용.

크롬 확장프로그램에서 restclient 확장프로그램을 사용함.

@PutMapping, @PatchMapping
put/patch method post와 마찬가지로 body에 데이터가 들어있으며, 주로 update에 사용.

@DeleteMapping
delete method get과 마찬가지로 주소에 데이터가 들어있으며, 데이터를 삭제할때 사용.

REST API
rest의 개념.
http 프로토콜에 있는 method를 활용한 아키텍처 스타일.
http method를 통해서 resource를 처리함.
crud 를 통한 resource 조작을 할 때 사용 한다.

spring boot를 통해서 rest api 작성.
spring - 오픈소스 프레임워크. 여러 라이브러리, 설정이 힘듬. (버전충돌, 에러등..)
spring boot - 기본적으로 설정해야할 라이브러리들을 내장하고 있으며, 간단한 어노테이션을 통해 설정할 수 있도록 개발된 경량의 프레임워크. 기본적으로 스프링을 포함하고 있으며, 톰캣도 내장하고 있음.

Lombok - 자바코드를 줄여주고 생산성을 높여줌.
@Data 를 통해 자동적으로 기본생성자와 get, set 메서드, 등을 재정의 해줌.
@AllArgsConstructor 를 통해 모든 매개변수를 갖는 생성자를 추가해줌.

JPA - ORM(Object Relational Mapping)으로, RDB 데이터 베이스의 정보를 객체지향으로 손쉽게 활용할 수 있도록 도와주는 도구.
Object(자바객체)와 Relation(관계형 데이터베이스)둘간의 맵핑을 통해서 보다 손쉽게 적용할 수 있는 기술을 제공해준다.
또한 쿼리에 집중 하기 보다는 객체에 집중 함으로써, 조금 더 프로그래밍 적으로 많이 활용 할 수 있다.

Mysql로 테이블을 생성하고, defendency에 추가하고, properties에
spring.datasource.url로 데이터베이스와 주소 연결해줌.

주로 API통신 규격에는 snake case를 많이 사용한다하여 snake case를 사용함.

Entity : JPA 에서는 테이블을 자동으로 생성해주는 기능 존재.
DB Table == JPA Entity
@Entity -> 해당 class가 Entity임을 명시
@Table -> 실제 DB테이블의 이름을 명시
@Id -> Index primary key를 명시
@Column 실제 DB Column의 이름을 명시
@GeneratedValue -> Primary key 식별키의 전략 설정

프로젝트에 entity 패키지를 만들고, mysql의 테이블과 동일한 클래스들을 선언해줌.
@Entity 지정. (테이블과 클래스이름이 동일하면 자동매칭이 되므로@Table 필요없음)
테이블의 컬럼대로 똑같이 클래스 변수를 선언해줌.

자바에서는 camel case로 선언하더라도 JPA에서는 자동으로 snake case로 매칭해줌.
(변수이름과 컬럼이름이 같으면 자동매칭이 되므로 @Column 필요 없음)

primary key에 @GeneratedValue 를 통해 전략설정을 할때 mysql을 사용하므로 IDENTITY 사용하여 기본키 생성을 데이터베이스에 위임.

@Repository 를 사용하면 따로 쿼리문을 작성하지 않아도 기본적인 CRUD를 사용가능.

repository 패키지를 생성한 후 , 인터페이스 이름을 명명해줌. (주로 클래스entity명+repository)
extends JpaRepository<어떤 타입의 오브젝트 클래스가 들어갈건지-entity이름, 기본키 타입> 해줌.

test패키지안에서 코딩하여 서비스에 영향을 주지않고 개발했던 내용을 테스트해봄.
repository를 통해서 테스트 할 것이기 때문에 @Autowired 후 repository 생성.
@Autowired 는 스프링의 장점이자 디자인패턴인데, DI(defendency Injection) 의존성주입을 통해 직접객체를 만들지 않고, 스프링이 객체를 관리해주며 의존성 주입해줌.

DI의 기본핵심은 싱글톤. 매번 바뀌고 만드는 값인 user같은 객체는 직접 만들어 사용.

@Test 를 통해 테스트라는 것을 명시.

JPA 연관관계 설정 ERD(Entity Relationship Diagram)작업.
MySQL workbench를 통해 ERD작업.
entity 패키지 하위에 테이블과 동일하게 entity 생성하고
repository 패키지 하위에 entity와 동일한 repository 생성.

oneToMany = 1:N, oneToOne = 1:1, ManyToOne = N:1 에서
(fetch = FetchType.LAZY, mappedBy = "")
에서 fetchType 은 LAZY, EAGER 가 있음.
LAZY = 지연로딩, EAGER = 즉시로딩.
LAZY = 메서드를 호출하지 않는이상 연관관계가 설정된 테이블에 대해 셀렉을 하지 않음.
EAGER = 연관관계가 설정된 모든 테이블에 대해 조인이 일어남.
여러데이터로딩이 있을 때 , 데이터분실이나 성능의 저하를 불러옴.
그래서 EAGER 는 1:1 일 경우나 한건만 존재할 경우에 사용.

test패키지하위에서 테스트.

QueryMethod 를 통해 검색. 쿼리문을 메서드 형태로 작성해서 쿼리메서드.
한가지로 검색할 때 에는 findById, findByEmail, findByAccount
여러가지로 검색할 때 에는 findByIdAndEmail, FindByAccountAndEmail

기획자와 일할 때.
UML에 대해 알아야함. 플로우차트나 시퀀스다이어그램에 대해 알아야 소통가능.
