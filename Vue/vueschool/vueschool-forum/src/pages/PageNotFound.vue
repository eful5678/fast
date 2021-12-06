<template>
  <div class="col-full">
    <h1>Not Found</h1>
    <p>Ooops, we couldn't find that you are looking for. Why don't you
      <router-link :to="{name: 'PageHome'}">
        go home instead?
      </router-link>
    </p>

  </div>
</template>

<script>
export default {
  name: 'PageNotFound'
}
</script>

<style scoped>
h1 {
  font-size: 100px;
}

p {
  font-size: 50px;
  font-width: 100;
}

div {
  text-align: center;
}
</style>
