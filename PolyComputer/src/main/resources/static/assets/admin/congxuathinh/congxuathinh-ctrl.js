app.controller("congxuathinh-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        congXuatHinhName: "",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/congxuathinhs").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            congXuatHinhName: "",
            description: ""
        };
        $scope.titleForm="Thêm mới Cổng Xuất Hình";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            congXuatHinhName: "",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Cổng Xuất Hình";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Cổng Xuất Hình";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them bp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/congxuathinhs`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Cổng Xuất Hình thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Cổng Xuất Hình !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat bp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/congxuathinhs/${item.congXuatHinhId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.congXuatHinhId == item.congXuatHinhId);
            $scope.items[index] = item;
            alert("Cập nhật Cổng Xuất Hình thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật Cổng Xuất Hình !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa bp
    $scope.delete = function(item){
        $http.delete(`/rest/congxuathinhs/${item.congXuatHinhId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.congXuatHinhId == item.congXuatHinhId);
            $scope.items.splice(index, 1);
            alert("Xóa Cổng Xuất Hình thành công !");
        }).catch(error => {
            alert("Lỗi xóa Cổng Xuất Hình !");
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