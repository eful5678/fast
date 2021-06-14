# JPA

## # 상속관계 매핑
- 관계형 DB -> 상속관계 X
- Super Type <-> Sub Type 관계 모델링 기법이 객체 상속과 유사
    - Supertype
        - Generic Entity that has a relationship with one or more subtypes
    - Subtype
        - Sub-Grouping of the entities in an entity type that is meaningful to the organization and that shares common attributes or relationships distinct from other subgroups.
- 상속관계 매핑
    - 객체의 상속과 구조와 DB의 Super Type, Sub Type 관계를 매핑
- Super type, sub type 논리 모델 -> 실제 물리 모델
    - 각각 테이블로 변환 -> 조인 전략
    - 통합 테이블로 변환 -> 단일 테이블 전략
    - 서브타입 테이블로 변환 -> 구현 클래스마다 테이블 전략
___