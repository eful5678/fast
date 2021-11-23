<template>
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
          <th>가격</th>
          <td>{{ this.totalPrice }}</td>
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
  computed: {
    totalPrice: function () {
      return this.fruitDetail.quantity * 2000;
    },
  },
  created() {
    console.log(this);
    console.log(this.fruitDetail);
  },
};
</script>

<style>
</style>