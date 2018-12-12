<template>
  <aside class="menu">
    <p class="menu-label">
      Administration
    </p>
    <ul class="menu-list">
      <li>
        <a >用户管理</a>
        <ul>
          <li> <router-link to="/UserList" >用户列表</router-link> </li>
          <li> <router-link to="/AddUser">添加用户</router-link> </li>
        </ul>
      </li>
    </ul>
  </aside>
</template>

<script>
import 'bulma/css/bulma.css'

export default {

}
</script>

<style>

</style>
