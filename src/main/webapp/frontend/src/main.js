import Vue from 'vue'
import App from './App.vue'
import UserList from './component/UserList.vue'
import AddUser from './component/AddUser.vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)


const routes = [
    { path: '/', component: UserList },
    { path: '/UserList', component: UserList },
    { path: '/AddUser', component: AddUser }
]


const router = new VueRouter({
    routes:routes,
    linkActiveClass:"is-active"
})


new Vue({
  el: '#app',
  router:router,
  render: h => h(App)

})
