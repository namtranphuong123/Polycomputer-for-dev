app.controller("gift-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        giftName: "",
        giftImage: "no-image.jpg",
        description: ""
    };
    $scope.initialize = function(){
        //load category
        $http.get("/rest/gifts").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            giftName: "",
            giftImage: "no-image.jpg",
            description: ""
        };
        $scope.titleForm="Thêm mới Quà Tặng";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            giftName: "",
            giftImage: "no-image.jpg",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Quà Tặng";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Quà Tặng";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them gift moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/gifts`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Quà Tặng thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới Quà Tặng !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //cap nhat gift
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/gifts/${item.giftId}`, item).then(resp => {
            var index = $scope.items.findIndex(b => b.giftId == item.giftId);
            $scope.items[index] = item;
            alert("Cập nhật Quà Tặng thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật gift !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    //xoa gift
    $scope.delete = function(item){
        $http.delete(`/rest/gifts/${item.giftId}`).then(resp => {
            var index = $scope.items.findIndex(b => b.giftId == item.giftId);
            $scope.items.splice(index, 1);
            alert("Xóa Quà Tặng thành công !");
        }).catch(error => {
            alert("Lỗi xóa Quà Tặng !");
            console.log("Error", error);
        })
        $scope.initialize();
    }
    $scope.imageChanged = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.giftImage = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload hình ảnh !");
            console.log("Error", error);
        })
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