# 사용기술

- java8
- spring boot 1.3.1
- freemarker
- JPA
- h2database
    - 운영환경 db는 추후 작업예정
- lombok
    - ide별 별도 플러그인 설치 필요
- spring boot actuator
    - localhot:8080/docs 에서 자세한 정보 확인가능
- spring boot devtool
    - 런타임환경에서 클래스파일 변경시 프로젝트 리로드기능
        - intelliJ의 경우 빌드(command + F9)실행해볼 것
    - localhost:8080/h2-console로 접속해볼 것
        - url : jdbc:h2:mem:testdb
        - id : sa
        - pw : 빈값

# 샘플 프로젝트 안내


초간단 코멘트기능(다음 카페의 한줄글쓰기 기능)을 구현

- localhost:8080/comments로 접속시 확인 가능
- 페이징 처리
- 코멘트 추가, 수정, 삭제, 조회 기본적인 기능 구현됨.
- 관련된 코드는 comment 패키지에서 확인 가능.
