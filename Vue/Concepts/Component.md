# Component

## Concept of Component
- 화면의 영역을 구분하여 개발할 수 있는 Vue의 기능
    - 컴포넌트 간의 관계
- 코드의 재사용성이 올라간다
- Root Component
    - Vue Instance 생성 시, 기본적으로 Root Component가 된다

## How to create Component
```javascript
// Vue.Component('Component Name', Component Content);

<div id="app">
    <app-header></app-header>
</div>

Vue.Component('app-header', {
    template: '<h1>Header</h1>'
})
```