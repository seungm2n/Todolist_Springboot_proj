## 개발환경
- MariaDB
- DBeaver
- IntelliJ
- Springboot
- Thymeleaf
- JPA

# 프로젝트 생성

1) https://start.spring.io/ 에 접속하여 프로젝트를 생성한다.
2) Project - Gradle
	Language - Java
	Spring Boot - 2.5.4
	Java - 11	
	Dependencies - Lombok, Spring Boot DevTools, Spring Web, Spring Data JPA, Maria Driver, Thymeleaf
	* 여기서 Spring Boot를 선택할 시, 뒤에 아무것도 안 적혀있는 것이 안전한 버전이라고 생각하면 된다.
3) Genrate를 누르면 .zip파일 다운로드가 되어지는데, 이 파일을 압축 해제한다.
4) IntelliJ를 켜서 Open > build.gradle을 선택하고 Open as Project를 하여 프로젝트를 생성한다.
5) ExampleSpringApplication을 실행하면 DataSource 객체를 생성하려면 url 속성이 필요해 오류나면서 종료된다.
	- Dependencies에서 JPA를 추가하여 바로 시작이 안되기 때문에 Connection Tool 생성되기 위한 어떠한 설정 정보가 필요하다.
6) '/src/main/resources/application.properties'의 설정을 해준다.
	```
	spring.jpa.hibernate.ddl-auto=update
	spring.datasource.driverClassName=org.mariadb.jdbc.Driver
	spring.datasource.url=jdbc:mariadb://{DB IP주소}:3306/{데이터베이스이름}
	spring.datasource.username={DB 사용자명 :: root가 기본} 
	spring.datasource.password={비밀번호}
	```
7) 다시 실행해서 console을 보면 run 상태이다. 그러면 성공!
8) 다시 프로젝트로 들어가서 Contorller Package 생성하고 Contorller Class 파일을 생성한다.
	```
	@Controller
	public class HelloController {

		@GetMapping("/hello")
		public String hello() {
			return "hello";
		}
	}
	```
9) Contorller를 작성하고, src/main/reslources의 templates 패키지 안에 뷰 파일을 생성한다.
	```
	<html lang="ko"
		xmlns:th="http://www.thymeleaf.org"
		xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
		<div>Hello ! ! !</div>
	</html>
	```
	
- 여기까지가 테스트과정.

