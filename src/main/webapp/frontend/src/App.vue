<template>
  <div id="app">

    <div class="container">
      <top></top>
      <div class="columns">
        <div class="column is-one-fifth">
          <side-bar></side-bar>
        </div>
        <div class="column">

          <user-list></user-list>
          <add-user></add-user>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import UserList from './component/UserList.vue'
import AddUser from './component/AddUser.vue'
import Top from './component/Top.vue'
import SideBar from './component/SideBar.vue'

export default {
  name: 'app',
  components:{Top,UserList,AddUser,SideBar},
  data () {
   return {
   }
  }
}
</script>

<style>

</style>  