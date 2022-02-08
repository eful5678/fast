# Vue Instance

## Concept of Vue Instance
- Vue로 개발할 때 필수로 생성해야 하는 코드

## How to Create Vue Instance
- new Vue() 통해 인스턴스 생성
- 변수를 선언하여 인스턴스의 내용을 변수에 담을 수 있다
    - Vue에서 제공하는 api와 속성 확인 가능
```javascript
new Vue();
---

var vm = new Vue();
console.log(vm);

---

var vm = new Vue({
    el: '#app'
});
// body Tag 안에서 app이라는 id를 갖고있는 Tag를 찾아서 Vue Instance를 붙이는 것
// el을 지정함으로써 #app tag 안에서 Vue의 기능과 속성을 이용할 수 있다.
```
- el를 지정했을 때, Vue Dev Tool에서 Root가 생김 -> 확인필요

### 함수를 통하여 Instance 생성 in JS
- 미리 정의된 api 및 속성을 이용 <- new Vue를 사용하는 이유(Vue Instance)
- 생성자 함수 이용
```javascript
// 생성자 함수를 선언
function Person(name, job){
    this.name = name;
    this.job = job;
}

// 함수 생성
var p = new Person('Jin', 'developer');

function Vue() {
    this.logText = function () {
        console.log('hello');
    }
}

var vm = new Vue();
vm.logText();

```

### 생성자 함수(new Vue)
- 생성자 안에는 객체가 들어간다
- key : value
```javascript
new Vue({
    // options
    // options object
    el: ,
    template: ,
    data: ,
    methods: ,
    created: ,
    watch: ,
})
```
- el
    - Element
    - Vue Instance에 mount하기 위한 DOM element 제공
        - CSS selector string / actual HTML Element
    - Instance가 mount되었을때, element는 vm.$el에 접근 가능
        -vm.$el

- data -> vm.$data
    - Object
    - Vue Instance가 관찰하는 object
    - Vue Instance가 data 개체의 속성에 대한 Access를 프록시