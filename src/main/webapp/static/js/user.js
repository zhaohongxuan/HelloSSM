
new Vue({
    el: '#user_tb',
    data: {
        userList: []
    },
    ready:function(){
        var self = this;
        $.ajax({
            url: '/HelloSSM/rest/user/selectAllUser',
            method: 'GET',
            success: function (data) {
                self.userList = data;
            },
            error: function (error) {
                alert(JSON.stringify(error));
            }
        });
    },
    methods:{
        delete:function(id){
            $.ajax({
                url: '/HelloSSM/rest/user/delete',
                method: 'POST',
                dataType:"json",
                data:{"id":id},
                success: function (result) {
                    if(result==true){
                        alert("删除成功");
                        location.reload();
                    }else{
                        alert("删除失败");
                    }
                },
                error: function (error) {
                    alert(JSON.stringify(error));
                }
            });

        }
    }
});

new Vue({
    el:"#userForm",
    data:{
        "id":"",
        "userName":"zhaohongxuan",
        "password":"123456"
    },
    methods:{
        add:function(){
            var param = {"id":this.id, "userName":this.userName,"password":this.userName};
            console.log(param);
            $.ajax({
                url: '/HelloSSM/rest/user/add',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: 'POST',
                dataType:"json",
                data:JSON.stringify(param),
                success: function (result) {
                    if(result==true){
                        alert("新增成功");
                        location.reload();
                    }else{
                        alert("新增失败");
                    }
                },
                error: function (error) {
                    alert(JSON.stringify(error));
                }
            });
        }
    }
});