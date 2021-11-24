<template>
  <!-- 
1. data 세팅 시점
1) 부모로부터 받은 정보를 언제 세팅하는가?
- 
 -->
  <div>
    <div>
      <h2>여긴 주문내역 여기도 자식</h2>
    </div>
    <div>
      <table>
        <tr>
          <th>과일명</th>
          <td>{{ fruitDetail.name }}</td>
        </tr>
        <tr>
          <th>Computed 가격</th>
          <td>{{ totalPrice }}</td>
        </tr>
        <tr>
          <th>Watch 가격</th>
          <td>{{ totalWatchPrice }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    fruitDetail: {
      type: Object,
    },
  },
  data() {
    return {
      fruitName: "",
      totalWatchPrice: 0,
    };
  },
  computed: {
    // Order 컴포넌트에서 주문을 하여 Main 컴포넌트에서 api를 쏜 후 data가 세팅되었을 때, 이 data를 Invoice에게 props로 내린다
    // Invoice에서는 해당 정보를 받았을 때, data의 변경을 감지하여 computed를 통해 계산한다
    totalPrice: function () {
      return this.fruitDetail.quantity * this.fruitDetail.price;
    },
  },
  watch: {
    // fruitName: function (val) {
    //   this.fruitName = val + "dd";
    totalWatchPrice: function () {
      this.fruitDetail.quantity * 3000;
    },
    fruitDetail: function(){
      this.totalWatchPrice = this.fruitDetail.quantity * 2000;
    },
    'fruitDetail.quantity': function(){
      this.totalWatchPrice = this.fruitDetail.quantity * 3000;
    }
  },
  created() {
    console.log("Invoice created()");
    console.log(this);
    this.fruitName = this.fruitDetail.name;
  },
};
</script>

<style>
</style>