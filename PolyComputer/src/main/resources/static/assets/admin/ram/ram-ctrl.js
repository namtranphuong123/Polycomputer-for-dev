app.controller("ram-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        ramName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/rams").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            ramName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Ram";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            ramName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Ram";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Ram";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them bp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/rams`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Ram thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Ram !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat bp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/rams/${item.ramId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.ramId == item.ramId);
            $scope.items[index] = item;
            alert("Cập nhật Ram thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật Ram !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa bp
    $scope.delete = function(item){
        $http.delete(`/rest/rams/${item.ramId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.ramId == item.ramId);
            $scope.items.splice(index, 1);
            alert("Xóa Ram thành công !");
        }).catch(error => {
            alert("Lỗi xóa Ram !");
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