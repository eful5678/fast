<template>
  <div>
    <h1>상세 페이지</h1>
    <div>
      {{ product }}
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { fetchProductById } from "@/api/index";
export default {
  async asyncData({ params }) {
    const response = await fetchProductById(params.id);
    const product = response.data;
    console.log(response);
    return { product };
  },
  //   created() {
  //     console.log(this.$route);
  //     const id = this.$route.params.id;
  //     fetchProductById(id);
  //   },
};
</script>

<style></style>
