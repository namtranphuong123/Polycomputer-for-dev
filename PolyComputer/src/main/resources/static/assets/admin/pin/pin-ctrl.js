app.controller("pin-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        pinName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/pins").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            pinName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Pin";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            pinName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Pin";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Pin";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them bp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/pins`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Pin thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Pin !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat bp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/pins/${item.pinId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.pinId == item.pinId);
            $scope.items[index] = item;
            alert("Cập nhật Pin thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật Pin !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa bp
    $scope.delete = function(item){
        $http.delete(`/rest/pins/${item.pinId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.pinId == item.pinId);
            $scope.items.splice(index, 1);
            alert("Xóa Pin thành công !");
        }).catch(error => {
            alert("Lỗi xóa Pin !");
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