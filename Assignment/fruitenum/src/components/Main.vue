<template>
<!-- 
1. 화면정의
1) Main
- 판매하는 과일들의 목록을 보여주는 컴포넌트
- BO와의 통신을 담당한다
2) Order(자식 컴포넌트)
- 원하는 과일을 주문하는 컴포넌트
- 원하는 과일을 선택하고 주문하면 해당 data를 Main(부모) 컴포넌트에 emit으로 전달한다
3) Invoice
- 주문한 과일의 견적을 보여주는 컴포넌트
- 주문한 과일의 정보를 Main(부모)로부터 받아와 보여준다

2. 흐름
1) 최초에 Main 컴포넌트에서 과일조회 api를 쏜 후 과일의 대한 정보를 받아와 화면에 보여준다
2) Order 컴포넌트에서 원하는 과일과 수량을 선택한후 주문하면 해당 정보가 emit으로 Main으로 넘어간 후 Main에서 주문 api를 쏜다
3) Main 컴포넌트에서 주문 api를 쏜 후 response를 받아와 저장하고 이 정보를 Invoice 컴포넌트로 props를 통해 보낸다
4) Invoice 컴포넌트에서는 Main으로부터 받은 과일명, 가격정보, 수량정보를 computed를 통해 계산하여 총액을 구한다.

3. 예외상황
1) 과일 주문시, 주문하려는 과일이 판매하는 과일이 아닌 경우
2) 주문하려는 과일이 리스트에 존재하지만, 재고가 부족한 경우
 -->
  <div>
    <div>
      <h1>과일을 팝니다</h1>
    </div>
    <div>
      <div>
        <h2>과일목록</h2>
      </div>
      <table>
        <thead>
          <tr>
            <th>순번</th>
            <th>과일명</th>
            <th>가격</th>
            <th>재고</th>
            <th>할인</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(fruit, index) in fruitList" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ fruit.fruitName }}</td>
            <td>{{ fruit.fruitPrice }}</td>
            <td>{{ fruit.fruitQuantity }}</td>
            <td>{{ fruit.fruitDiscount }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <Order @Order="OrderGo"></Order>
    <Invoice :fruitDetail="fruitDetail"></Invoice>
  </div>
</template>

<script>
import axios from "axios";
import Order from "@/components/Order.vue";
import Invoice from "@/components/Invoice.vue";
export default {
  components: {
    Order,
    Invoice,
  },
  data() {
    return {
      fruitList: [],
      fruitDetail: {
        name: "",
        quantity: 0,
        price: 0
      },
      fruitName: "",
      fruitQuantity: "",
    };
  },
  created() {
    console.log('Main created()')
    console.log(this);
    this.search();
  },
  mounted() {
    console.log('Main mounted()')
    console.log(this);
  },
  methods: {
    // 전체 과일의 목록을 불러온다
    search: function () {
      axios
        .get("http://localhost:8090/fruit/search")
        .then((response) => {
          this.fruitList = response.data;
        })
        .catch((error) => console.log(error));
      console.log(this.fruitList);
    },
    // 선택된 정보를 전달하여 주문을 한다
    // 예외처리
    // 1. 선택된 과일의 해당하는 과일이 리스트에 없을경우
    // 2. 리스트에 선택한 과일이 있지만, 재고가 부족한경우
    OrderGo: function (detail) {
      this.fruitDetail.name = detail.name;
      this.fruitDetail.quantity = detail.quantity;
      axios
        .get("http://localhost:8090/fruit/order", {
          params: this.fruitDetail
        })
        .then((response) => {
          console.log(response);
          this.fruitDetail.name = response.data.fruitName;
          this.fruitDetail.price = response.data.fruitPrice;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
</style>