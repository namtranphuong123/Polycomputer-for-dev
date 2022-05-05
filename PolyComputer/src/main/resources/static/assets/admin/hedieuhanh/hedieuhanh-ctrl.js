app.controller("hedieuhanh-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        hedieuhanhName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/hedieuhanhs").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            heDieuHanhName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Hệ Điều Hành";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            heDieuHanhName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Hệ Điều Hành";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Hệ Điều Hành";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them hedieuhanh moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/hedieuhanhs`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Hệ Điều Hành thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Hệ Điều Hành !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat hedieuhanh
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/hedieuhanhs/${item.heDieuHanhId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.heDieuHanhId == item.heDieuHanhId);
            $scope.items[index] = item;
            alert("Cập nhật Hệ Điều Hành thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật Hệ Điều Hành !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa hedieuhanh
    $scope.delete = function(item){
        $http.delete(`/rest/hedieuhanhs/${item.heDieuHanhId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.heDieuHanhId == item.heDieuHanhId);
            $scope.items.splice(index, 1);
            alert("Xóa Hệ Điều Hành thành công !");
        }).catch(error => {
            alert("Lỗi xóa Hệ Điều Hành !");
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