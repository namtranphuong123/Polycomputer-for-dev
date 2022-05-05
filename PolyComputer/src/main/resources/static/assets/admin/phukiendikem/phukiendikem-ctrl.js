app.controller("phukiendikem-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        phuKienDiKemName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/phukiendikems").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            phuKienDiKemName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Phụ Kiện Đi Kèm";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            phuKienDiKemName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Phụ Kiện Đi Kèm";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Phụ Kiện Đi Kèm";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them bp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/phukiendikems`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Phụ Kiện Đi Kèm thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Phụ Kiện Đi Kèm !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat bp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/phukiendikems/${item.phuKienDiKemId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.phuKienDiKemId == item.phuKienDiKemId);
            $scope.items[index] = item;
            alert("Cập nhật Phụ Kiện Đi Kèm thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật Phụ Kiện Đi Kèm !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa bp
    $scope.delete = function(item){
        $http.delete(`/rest/phukiendikems/${item.phuKienDiKemId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.phuKienDiKemId== item.phuKienDiKemId);
            $scope.items.splice(index, 1);
            alert("Xóa Phụ Kiện Đi Kèm thành công !");
        }).catch(error => {
            alert("Lỗi xóa Phụ Kiện Đi Kèm !");
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