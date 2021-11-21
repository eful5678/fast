<template>
  <div>
    <div>
      <h1>과일을 팝니다</h1>
    </div>
    <div>
      <table>
        <thead>
          <tr>
            <th>순번</th>
            <th>과일명</th>
            <th>가격</th>
            <th>재고</th>
            <th>주문</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(fruit, index) in fruitList" :key="index">
            <td>{{ index }}</td>
            <td>{{ fruit.name }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      fruitList: [],
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
      axios.get('http://localhost:8090/fruit/search')
            .then(response => console.log(response));
    },
  },
};
</script>

<style lang="scss" scoped>
</style>