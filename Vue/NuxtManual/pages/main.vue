<template>
  <div>
    <p>메인 페이지입니다.</p>
    <div v-for="(product, proIndex) in products" :key="proIndex">
      <div>
        {{ product.name }}
        {{ product.price }}
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      products: [],
    };
  },
  async created() {
    const response = await axios.get("http://localhost:8090/products/list");
    console.log(response);
    this.products = response.data;
  },
  methods: {
    search: function () {
      console.log("ddd");
    },
  },
};
</script>

<style>
</style>