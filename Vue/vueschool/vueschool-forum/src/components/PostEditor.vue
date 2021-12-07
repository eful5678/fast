<template>
  <form @submit.prevent="save">
    <div class="form-group">
        <textarea
          class="form-input"
          v-model="text"></textarea>
    </div>
    <div class="form-actions">
      <button class="btn-blue">Submit</button>
    </div>
  </form>
</template>

<script>
export default {
  name: 'PostEditor',
  props: {
    threadId: {
      required: true,
      type: String
    }
  },
  data () {
    return {
      text: ''
    }
  },
  methods: {
    save () {
      const postId = 'greatPost' + Math.random()
      const post = {
        publishedAt: Math.floor(Date.now() / 1000),
        text: this.text,
        userId: 'ALXhxjwgY9PinwNGHpfai6OWyDu2',
        threadId: this.threadId,
        '.key': postId
      }

      // this.$set(sourceData.posts, postId, post)
      // this.$set(this.thread.posts, postId, postId)

      // sourceData.posts[postId] = post
      // this.thread.posts[postId] = postId
      this.text = ''

      this.$emit('save', {post})
    }
  }
}
</script>

<style scoped>

</style>
