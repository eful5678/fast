<template>
  <div>
    <div>
      <h2>주문합니다 여긴 자식</h2>
    </div>
    <div>
      <table>
        <tr>
          <th>상품명</th>
          <td>
            <select v-model="fruitName">
              <option>선택</option>
              <option>사과</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>갯수</th>
          <td><input type="text" v-model="fruitQuantity"/></td>
        </tr>
      </table>
    </div>
    <div>
      <button @click="Order">주문하기</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      fruitName: "",
      fruitQuantity: 0,
      orderDetail: {
          name: '',
          quantity: '',
      },
    };
  },
  methods: {
    Order: function () {
    this.orderDetail.name = this.fruitName;
    this.orderDetail.quantity = this.fruitQuantity;
      console.log("Order");
      this.$emit("Order", this.orderDetail);
    },
  },
};
</script>

<style>
</style>