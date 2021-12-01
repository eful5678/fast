# Vue Router

## Why?
- To map components to the routes and let Vue Router know where to render them


## How?
- By Injecting the router -> get access 'this.$router'
- this.$router = router
    - not to import the router in every single component
### \<router-link>

### How to use?
```javascript
    import Vue from 'vue'

    // to use the router plugin
    Vue.use(Router)

    export default new Router({
        routes: [
            {
                path: ,
                name: ,
                component: 
            }
        ]
    })
```