<template>
  <div>
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
  async asyncData() {
    const response = await axios.get("http://localhost:8090/products/list");
    console.log(response);
    const products = response.data;
    return { products }; // products: products
  },
};
</script>

<style></style>
