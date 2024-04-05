# Haerolog

- [호돌맨의 요절복통 개발쇼 (SpringBoot, Vue.JS, AWS) 강의](https://inf.run/FZXu)를 본인 스타일로 구현하는 프로젝트.

## 스터디

- 기간: 24.03.26 - 24.04.30
- 인원: 1인

## 참고하면 좋은 글

- https://velog.io/@yrc97/JPA-Foreign-key를-제거하기로-했습니다
    - 객체 그래프는 사용하면서 FK 제약 조건에서는 자유로운 설계

- 도메인 객체와 엔티티 객체 분리
    - [영한님 - 경험상 분리 시 잃는게 더 많았다.](https://www.inflearn.com/questions/924769/comment/270232)
    - [영한님 - 엔티티와 도메인 객체를 따로 분리하지 말고, 엔티티 자체를 도메인 객체로 사용하시는 것이 좋습니다.](https://www.inflearn.com/questions/90087/comment/78270)

## 학습 로그

| 회차 | 날짜       | 내용                                                                                                                                                                                                                                                                | 비고                                       |
|:--:|----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------|
| 1  | 24.03.26 | **[인증/인가] 세션 토큰 발급 기능, 데이터베이스를 통한 토큰 검증**                                                                                                                                                                                                                         | 글 작성 시 권한 처리 해보기                         |
| 2  | 24.03.27 | (도메인 객체와 엔티티 객체 분리하는 것의 고민)                                                                                                                                                                                                                                       | 게시글 도메인 모델/엔티티 분리                        |
| 3  | 24.03.28 | (도메인 객체와 엔티티 객체 분리하는 것의 고민 - JPA를 극한으로 일단 쓰자.) 실무 코드가 지저분한 건 도메인/엔티티가 분리가 안 되어서 지저분한 게 아니라 객체지향적이지 않기 때문인 것이 더 크다고 결론. 일단 JPA를 극한까지 써보면서 이해도를 더 높이고. 그랬는데도 부족함을 느끼면 그 때 한 번 더 분리를 고민해보자.                                                                          | 분리했던 도메인/엔티티 객체 하나로 합치는 과정, 깨지는 테스트 수정   |
| 4  | 24.03.29 | 고민 - PostAppender의 파라미터인 PostAppend 에 UserId만 알려줄까 아니면 User 자체를 비즈니스 레이어에서 이미 찾아서 넣어줄까?                                                                                                                                                                           | 이런 질문은 재민님께 질문해봐도 좋을 주제 같다.              |
| 5  | 24.04.01 | 고민 정리 - 테스트 시에는 클렌징을 각 테스트 클래스에서 진행하자. 실제로는 데이터 클렌징이 필요없더라도, 통합 테스트를 제공하는 상속 클래스를 상속 받기만 하면 쿼리가 발생한다. 즉 불 필요한 쿼리가 나갈 수 있다.  또, 상속한 클래스의 필드를 `super`로가져다 쓰면, 테스트 클래스의 필드에서는 그 의존성이 드러나질 않는 문제가 있다. 👉 데이터는 각 테스트 클래스에서 진행함으로써 불필요한 클렌징 쿼리를 줄이고 필요한 의존성도 바로 보이게 한다. | 각 테스트 클래스에서 클렌징하도록 테스트 코드 리팩토링 진행        |
| 6  | 24.04.05 | 쿠키를 통한 인증 진행                                                                                                                                                                                                                                                      | 호돌맨의 숙제: secure, httpOnly sameSite 왜 쓰는지 |
