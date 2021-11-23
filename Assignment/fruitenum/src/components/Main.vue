<template>
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
            <th>주문</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(fruit, index) in fruitList" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ fruit.fruitName }}</td>
            <td>{{ fruit.fruitPrice }}</td>
            <td>{{ fruit.fruitQuantity }}</td>
            <td>{{ fruit.fruitDiscount }}</td>
            <td><button>주문하기</button></td>
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
        quantity: "",
      },
      fruitName: "",
      fruitQuantity: "",
    };
  },
  created() {
    console.log(this);
    this.search();
  },
  mounted() {
    console.log(this);
  },
  methods: {
    search: function () {
      console.log("search");
      axios
        .get("http://localhost:8090/fruit/search")
        .then((response) => {
          console.log(response);
          this.fruitList = response.data;
          console.log(this.fruitList);
        })
        .catch((error) => console.log(error));
      console.log(this.fruitList);
    },
    OrderGo: function (detail) {
      console.log("dd");
      console.log(detail);
      this.fruitDetail.name = detail.name;
      this.fruitDetail.quantity = detail.quantity;
      console.log(this.fruitDetail);
      axios
        .get("http://localhost:8090/fruit/order", {
          params: this.fruitDetail
        })
        .then((response) => {
          console.log(response);
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