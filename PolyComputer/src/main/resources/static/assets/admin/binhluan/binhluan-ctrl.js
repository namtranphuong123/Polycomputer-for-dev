app.controller("binhluan-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        // customer: "",
        // productId: "",
        // noiDung: ""
        // description: ""
    };

    $scope.stars = [];
    $scope.initialize = function(){
        //load category
        $http.get("/rest/binhluans").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            // customer: "",
            // productId: "",
            // noiDung: ""
        };
        $http.get("/rest/stars").then(resp => {
            $scope.stars = resp.data;
        });
        $scope.titleForm="Cập Nhật Bình Luận";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            // customer: "",
            // productId: "",
            // noiDung: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Bình Luận";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Bình Luận";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them bp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/binhluans`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Bình Luận thành công !");
            // $scope.initialize();
        }).catch(error => {
            alert("Lỗi thêm mới Bình Luận !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat bp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/binhluans/${item.ratingId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.ratingId == item.ratingId);
            $scope.items[index] = item;
            alert("Cập nhật Bình Luận thành công !");
            $scope.initialize();
        }).catch(error => {
            alert("Lỗi cập nhật Bình Luận !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa bp
    $scope.delete = function(item){
        $http.delete(`/rest/binhluans/${item.ratingId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.ratingId == item.ratingId);
            $scope.items.splice(index, 1);
            alert("Xóa Bình Luận thành công !");
        }).catch(error => {
            alert("Lỗi xóa Bình Luận !");
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