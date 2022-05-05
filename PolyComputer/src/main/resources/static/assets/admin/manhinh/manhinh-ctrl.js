app.controller("manhinh-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        manHinhName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/manhinhs").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            manHinhName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Màn Hình";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            manHinhName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Màn Hình";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Màn Hình";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them manhinh moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/manhinhs`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Màn Hình thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Màn Hình !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat manhinh
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/manhinhs/${item.manHinhId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.manHinhId == item.manHinhId);
            $scope.items[index] = item;
            alert("Cập nhật Màn Hình thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật Màn Hình !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa manhinh
    $scope.delete = function(item){
        $http.delete(`/rest/manhinhs/${item.manHinhId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.manHinhId == item.manHinhId);
            $scope.items.splice(index, 1);
            alert("Xóa Màn Hình thành công !");
        }).catch(error => {
            alert("Lỗi xóa Màn Hình !");
            console.log("Error", error);
        })
        $scope.initialize();
    }

    // phan trang
    $scope.pager = {
        page: 0,
        size: 5,
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count(){
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first(){
            this.page = 0;
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
});