<template>
      <div class="col-md-3">
            <div class="panel">
                <div class="panel-heading">添加用户</div>
                <div class="panel-body">
                    <div class="field">
                        <div class="control">
                            <label for="userName" class="label">用户名：</label>
                            <input v-model="user.userName" type="text" class="input" id="userName">
                        </div>
                        <div class="control">
                            <label for="password" class="label">密码：</label>
                            <input v-model="user.password" type="password" class="input" id="password"
                                   placeholder="Password">
                        </div>
                    
                    </div>

                    <div class="field">
                        <div class="control">
                            <button type="submit" class="button is-primary" v-on:click="addUser">注册</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</template>

<script>
import 'bulma/css/bulma.css'
import Axios from 'axios';

export default {
    data(){
        return {user:{userName:"",password:""}}
    },
    methods:{
        addUser:function(){
            Axios.defaults.headers.post['Content-Type'] = 'application/json';
            var formData = JSON.stringify(this.user)
            console.log(formData)
             Axios.post("http://localhost:8082/HelloSSM/rest/user/",formData).then(response=>{
                console.log(response)
             });
        }
    }
}
</script>

<style>

</style>
