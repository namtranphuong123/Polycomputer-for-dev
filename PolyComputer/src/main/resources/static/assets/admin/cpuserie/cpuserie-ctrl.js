app.controller("cpuserie-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        cpuSerieName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/cpuseries").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            cpuSerieName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Thế hệ CPU";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            cpuSerieName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Thế hệ CPU";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Thế hệ CPU";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them cpuserie moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/cpuseries`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Thế hệ CPU thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Thế hệ CPU !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat cpuserie
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/cpuseries/${item.cpuSerieId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.cpuSerieId == item.cpuSerieId);
            $scope.items[index] = item;
            alert("Cập nhật Thế hệ CPU thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật Thế hệ CPU !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa cpuserie
    $scope.delete = function(item){
        $http.delete(`/rest/cpuseries/${item.cpuSerieId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.cpuSerieId == item.cpuSerieId);
            $scope.items.splice(index, 1);
            alert("Xóa Thế hệ CPU thành công !");
        }).catch(error => {
            alert("Lỗi xóa Thế hệ CPU !");
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