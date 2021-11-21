import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: '/main',
        },
        {
            path: '/main',
            component: () => import('@/components/Main.vue')
        }
    ]
})

export default router;