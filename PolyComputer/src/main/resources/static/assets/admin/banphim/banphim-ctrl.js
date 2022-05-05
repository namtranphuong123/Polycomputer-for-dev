app.controller("banphim-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        banPhimName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/banphims").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            banPhimName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Bàn Phím";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            banPhimName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Bàn phím";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Bàn phím";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them bp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/banphims`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới bàn phím thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới bàn phím !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat bp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/banphims/${item.banPhimId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.banPhimId == item.banPhimId);
            $scope.items[index] = item;
            alert("Cập nhật bàn phím thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật bàn phím !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa bp
    $scope.delete = function(item){
        $http.delete(`/rest/banphims/${item.banPhimId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.banPhimId == item.banPhimId);
            $scope.items.splice(index, 1);
            alert("Xóa bàn phím thành công !");
        }).catch(error => {
            alert("Lỗi xóa bàn phím !");
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