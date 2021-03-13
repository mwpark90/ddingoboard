# Arno Board

 ###기본 구조 설명  
 1. Springboot / Gradle / Thymeleaf / H2 DB 사용
 2. 기본적인 게시판구조로 로그인 후 게시판, 내정보, 어드민, 로그아웃페이지 구현
 3. 로그인시 회원가입을 통해 Member권한으로 유저등록이 가능 
 4. Admin 권한은 ID admin / PW 123 으로 로그인 
 5. 게시판은 등록된 공지 목록이 보이며 제목 클릭시 상세 내용 및 첨부파일을 확인 할 수 있음
 6. 공지 상세 페이지를 통해 수정 / 삭제가 가능 
 7. 첨부파일을 여러개가 등록이 가능 하도록 구현 
 8. 공지의 검색 기능 및 페이징 기능 구현 
 9. 내정보를 통해 이름 및 비밀번호 변경이 가능 
 10. 어드민 페이지는 현재까지 등록된 member / boardlist / boardlistFile을 확인 할 수 있음
 11. Member 권한 일 경우 어드민 페이지 접근은 불가 하도록 구현
 

  ###Build Start 
    1. gradle build

  gradle build 후 Server Run -> Localhost:8080/ 로 접근하여 로그인하도록 구성
  
  ###Data 
    1. Data.sql 파일을 통해 admin,user1에 대한 기본 정보 Insert 

 ###Result
    > 기본적인 게시판 구조로 구성을 했으며 구글링을 통해 fileUpload / Download는 참조 했다 UI는 디자인 및 기능 
    구성을 보다 편하게 하기 위해 지원 템플릿을 사용 했으며 BootStrap 버전이 서로 다른 것을 참조한 것은 그게 더 이뻐
    보여서 적용 했다.
