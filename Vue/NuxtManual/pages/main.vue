<template>
  <div>
    <p>메인 페이지입니다.</p>
  </div>
</template>

<script>
import axios from "axios";
export default {
  async created() {
    const response = axios.get("http://localhost:8090/products/list");
    console.log(response);
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