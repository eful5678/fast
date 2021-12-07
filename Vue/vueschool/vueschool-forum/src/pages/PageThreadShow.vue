<template>
  <div class="col-large push-top">
    <h2>{{ thread.title }}</h2>
    <PostList :posts="posts"></PostList>
    <PostEditor
      @save="addPost"
      :threadId="id"></PostEditor>
  </div>
</template>

<script>
import sourceData from '@/data'
import PostList from '../components/PostList'
import PostEditor from '../components/PostEditor'

export default {
  name: 'PageThreadShow',
  components: {PostEditor, PostList},
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
      newPostText: ''
    }
  },
  computed: {
    posts () {
      const postIds = Object.values((this.thread.posts))
      return Object.values(sourceData.posts)
        .filter(post => postIds.includes(post['.key']))
    }
  },
  methods: {
    addPost (eventData) {
      console.log(eventData)
      const post = eventData.post
      const postId = eventData.post['.key']

      this.$set(sourceData.posts, postId, post)
      this.$set(this.thread.posts, postId, postId)
      // eventData.post.threadId = this.id
    }
  }
}
</script>

<style scoped>

</style>
