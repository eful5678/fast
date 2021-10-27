<template>
  <div class="app">
    <main>
      <SearchInput
        :search-keyword="searchKeyword"
        @input="updateSearchKeyword"
        @search="searchProducts"
      ></SearchInput>
      <!-- <SearchInput v-model="searchKeyword"></SearchInput> -->
      <ul>
        <li
          class="item flex"
          v-for="product in products"
          :key="product.id"
          @click="moveToDetailPage(product.id)"
        >
          <img
            class="product-image"
            :src="product.imageUrl"
            :alt="product.name"
          />
          <p>{{ product.name }}</p>
          <span>{{ product.price }}</span>
        </li>
      </ul>
    </main>
  </div>
</template>

<script>
import axios from "axios";
import SearchInput from "../components/SearchInput.vue";
import { fetchProductsByKeyword } from "@/api/index";
// import ProductList from "~/components/ProductList.vue";
export default {
  components: { SearchInput },
  data() {
    return {
      searchKeyword: "",
    };
  },
  // components: {
  //   ProductList,
  // },
  async asyncData() {
    const response = await axios.get("http://localhost:8091/products/list");
    console.log(response);
    const products = response.data.map((item) => ({
      ...item,
      imageUrl: `${item.imageUrl}?random=${Math.random()}`,
    }));
    return { products }; // products: products
  },

  methods: {
    moveToDetailPage: function (id) {
      console.log("ddd");
      console.log(id);
      this.$router.push(`detail/${id}`);
    },
    updateSearchKeyword: function (keyword) {
      this.searchKeyword = keyword;
    },
    searchProducts: async function () {
      const response = await fetchProductsByKeyword(this.searchKeyword);
      console.log(response);
    },
  },
};
</script>

<style scoped>
.flex {
  display: flex;
  justify-content: center;
}
.item {
  display: inline-block;
  width: 400px;
  height: 300px;
  text-align: center;
  margin: 0 0.5rem;
  cursor: pointer;
}
.product-image {
  width: 400px;
  height: 250px;
}
.app {
  position: relative;
}
.cart-wrapper {
  position: sticky;
  float: right;
  bottom: 50px;
  right: 50px;
}
.cart-wrapper .btn {
  display: inline-block;
  height: 40px;
  font-size: 1rem;
  font-weight: 500;
}
</style>
