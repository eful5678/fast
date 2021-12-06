import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ThreadShow from '../components/ThreadShow'

Vue.use(Router) // to use router plugin

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: HelloWorld
    },
    {
      path: '/thread/show/:id',
      name: 'ThreadShow',
      component: ThreadShow,
      props: true
    }
  ],
  mode: 'history'
})
