app.controller("luutru-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        luuTruName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/luutrus").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            luuTruName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Lưu Trữ";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            luuTruName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Lưu Trữ";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Lưu Trữ";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them luutru moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/luutrus`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Lưu Trữ thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Lưu Trữ !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat luutru
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/luutrus/${item.luuTruId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.luuTruId == item.luuTruId);
            $scope.items[index] = item;
            alert("Cập nhật Lưu Trữ thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật Lưu Trữ !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa luutru
    $scope.delete = function(item){
        $http.delete(`/rest/luutrus/${item.luuTruId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.luuTruId == item.luuTruId);
            $scope.items.splice(index, 1);
            alert("Xóa Lưu Trữ thành công !");
        }).catch(error => {
            alert("Lỗi xóa Lưu Trữ !");
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