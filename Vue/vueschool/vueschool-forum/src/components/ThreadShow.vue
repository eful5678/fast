<template>
  <div class="col-large push-top">
    <h2>{{ thread.title }}</h2>
    <div class="post-list">
      <div v-for="postId in thread.posts" class="post">
        <div class="user-info">
          <a href="#" class="user-name">{{ users[posts[postId].userId].name }}</a>
          <a href="#">
            <img class="avatar-large" :src="users[posts[postId].userId].avatar">
          </a>
        </div>
        <div class="post-content">
          <div>{{ posts[postId].text }}</div>
        </div>
        <div class="post-date text-faded">
          {{ posts[postId].publishedAt }}
        </div>

      </div>
    </div>

  </div>
</template>

<script>
import sourceData from '@/data'

export default {
  name: 'ThreadShow',
  // to passing down 'id' property to child component
  props: {
    id: {
      required: true,
      type: String
    }
  },
  data () {
    return {
      thread: sourceData.threads[this.id],
      posts: sourceData.posts,
      users: sourceData.users
    }
  }
}
</script>

<style scoped>

</style>
