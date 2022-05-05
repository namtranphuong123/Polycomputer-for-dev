app.controller("authority-ctrl", function($scope, $http, $location){
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];

    $scope.initialize = function(){
        //load all roles
        $http.get("/rest/roles").then(resp =>{
            $scope.roles = resp.data;
        })

        //load staffs and directors (administration)
        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admins = resp.data;
        })

        //load authorities of directors (administration)
        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities = resp.data;
        }).catch(error => {
            $location.path("/unauthorized");
        })
    }

    $scope.authority_of = function(acc, role){
        if($scope.authorities){
            return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.roleId == role.roleId);
        }
    }

    $scope.authority_changed = function(acc, role){
        var authority = $scope.authority_of(acc, role);
        if(authority){//da cap quyen => thu hoi quyen(xoa)
            $scope.revoke_authority(authority);
        }else{//chua dc cap quyen => cap quyen( them moi)
            authority = {account: acc, role: role};
            $scope.grant_authority(authority);
        }
    }


    //them moi authority
    $scope.grant_authority = function(authority){
        $http.post(`/rest/authorities`, authority).then(resp => {
            $scope.authorities.push(resp.data);
            Swal.fire({
              icon: 'success',
              title: 'Thành công',
              text: 'Cập nhật quyền sử dụng thành công!',
            })
        }).catch(error => {
          Swal.fire({
            icon: 'error',
            title: 'Thất bại',
            text: 'Cập nhật quyền sử dụng thất bại!',
          })
            console.log("Error", error);
        })
    }

    //xoa authority
    $scope.revoke_authority = function(authority){
        $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
            var index = $scope.authorities.findIndex(a => a.id == authority.id);
            $scope.authorities.splice(index, 1);
            Swal.fire({
              icon: 'success',
              title: 'Thành công',
              text: 'Thu hồi quyền sử dụng thành công!',
            })
        }).catch(error => {
          Swal.fire({
            icon: 'error',
            title: 'Thất bại',
            text: 'Thu hồi quyền sử dụng thất bại!',
          })
            console.log("Error", error);
        })
    }
    $scope.pager = {
        page: 0,
        size: 11,
        get admins(){
          var start = this.page * this.size;
          return $scope.admins.slice(start,start + this.size);
        },
        get count(){
          return Math.ceil(1.0 * $scope.admins.length / this.size);
        },
        first(){
          this.page = 0;admins
        },
        prev(){
          this.page--;
          if(this.page < 0){
            this.last();
          }
        },
        next(){
          this.page++;
          if(this.page >= this.count){
            this.first();
          }
        },
        last(){
          this.page = this.count - 1;
        }
      }
    $scope.initialize();
    
});