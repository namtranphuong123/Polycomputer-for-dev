app.controller("cpu-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        cpuName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/cpus").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            cpuName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới CPU";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            cpuName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới CPU";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật CPU";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them bp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/cpus`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới CPU thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới CPU !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat bp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/cpus/${item.cpuId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.cpuId == item.cpuId);
            $scope.items[index] = item;
            alert("Cập nhật CPU thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật CPU !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa bp
    $scope.delete = function(item){
        $http.delete(`/rest/cpus/${item.cpuId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.cpuId == item.cpuId);
            $scope.items.splice(index, 1);
            alert("Xóa CPU thành công !");
        }).catch(error => {
            alert("Lỗi xóa CPU !");
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