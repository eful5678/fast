import Vue from 'vue'
import Router from 'vue-router'
import PageHome from '@/pages/PageHome'
import ThreadShow from '@/pages/PageThreadShow'
import NotFound from '@/pages/PageNotFound'

Vue.use(Router) // to use router plugin

export default new Router({
  routes: [
    {
      path: '/',
      name: 'PageHome',
      component: PageHome
    },
    {
      path: '/thread/show/:id',
      name: 'ThreadShow',
      component: ThreadShow,
      props: true
    },
    {
      path: '*',
      name: 'NotFound',
      // redirect: {name: 'PageHome'}
      component: NotFound
    }
  ],
  mode: 'history'
})
