app.controller("product-ctrl", function($scope, $http, $location){
    $scope.items = [];
    $scope.form = {
        productName: "",
        anhChinh: "laptop-mau.png",
        description: ""
    };
    $scope.cates = [];
    $scope.pins = [];
    $scope.brands = [];
    $scope.hedieuhanhs = [];
    $scope.manhinhs = [];
    $scope.phukiendikems = [];
    $scope.rams = [];
    $scope.socongluutrutoidas = [];
    $scope.colors = [];
    $scope.luutrus = [];
    $scope.cpus = [];
    $scope.cpuseries = [];
    $scope.chipdohoas = [];
    $scope.congxuathinhs = [];
    $scope.congketnois = [];
    $scope.banphims = [];

    $scope.initialize = function(){
        //load category
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
        });
        $scope.form = {
            productName: "",
            anhChinh: "laptop-mau.png",
            description: ""
        };
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        });

        $http.get("/rest/pins").then(resp => {
            $scope.pins = resp.data;
        });
        $http.get("/rest/brands").then(resp => {
            $scope.brands = resp.data;
        });
        $http.get("/rest/hedieuhanhs").then(resp => {
            $scope.hedieuhanhs = resp.data;
        });
        $http.get("/rest/phukiendikems").then(resp => {
            $scope.phukiendikems = resp.data;
        });
        $http.get("/rest/manhinhs").then(resp => {
            $scope.manhinhs = resp.data;
        });
        $http.get("/rest/rams").then(resp => {
            $scope.rams = resp.data;
        });
        $http.get("/rest/socongluutrutoidas").then(resp => {
            $scope.socongluutrutoidas = resp.data;
        });
        $http.get("/rest/colors").then(resp => {
            $scope.colors = resp.data;
        });
        $http.get("/rest/luutrus").then(resp => {
            $scope.luutrus = resp.data;
        });
        $http.get("/rest/cpus").then(resp => {
            $scope.cpus = resp.data;
        });
        $http.get("/rest/cpuseries").then(resp => {
            $scope.cpuseries = resp.data;
        });
        $http.get("/rest/chipdohoas").then(resp => {
            $scope.chipdohoas = resp.data;
        });
        $http.get("/rest/congxuathinhs").then(resp => {
            $scope.congxuathinhs = resp.data;
        });
        $http.get("/rest/congketnois").then(resp => {
            $scope.congketnois = resp.data;
        });
        $http.get("/rest/banphims").then(resp => {
            $scope.banphims = resp.data;
        });
        $scope.titleForm="Thêm mới Sản Phẩm";
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            productName: "",
            anhChinh: "laptop-mau.png",
            description: ""
        };
    }
    $scope.fillStatus = true;
    $scope.buttonFill=true;
    $scope.goToAdd = function(){
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.titleForm="Thêm mới Sản Phẩm";
        $scope.fillStatus = true;
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.titleForm="Cập nhật Sản Phẩm";
        $scope.fillStatus = false;
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them sp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/products`, item).then(resp => {
            $scope.items.push(resp.data);
            alert("Thêm mới Sản Phẩm thành công !");
            $scope.initialize();
        }).catch(error => {
            alert("Lỗi thêm mới Sản Phẩm !");
            console.log("Error", error);
            $scope.initialize();
        })
        $scope.initialize();
    }
    //cap nhat sp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.productId}`, item).then(resp => {
            var index = $scope.items.findIndex(c => c.productId == item.productId);
            $scope.items[index] = item;
            alert("Cập nhật Sản Phẩm thành công !");
            $scope.initialize();
        }).catch(error => {
            alert("Lỗi cập nhật Sản Phẩm !");
            console.log("Error", error);
            $scope.initialize();
        })
        $scope.initialize();
    }
    //xoa sp
    $scope.delete = function(item){
        $http.delete(`/rest/products/${item.productId}`).then(resp => {
            var index = $scope.items.findIndex(c => c.productId == item.productId);
            $scope.items.splice(index, 1);
            alert("Xóa Sản Phẩm thành công !");
            $scope.initialize();
        }).catch(error => {
            alert("Lỗi xóa Sản Phẩm !");
            console.log("Error", error);
            $scope.initialize();
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
            $scope.form.anhChinh = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload hình ảnh !");
            console.log("Error", error);
        })
    }

    $scope.imageChanged1 = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.anhPhu1 = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload hình ảnh !");
            console.log("Error", error);
        })
    }

    $scope.imageChanged2 = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.anhPhu2 = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload hình ảnh !");
            console.log("Error", error);
        })
    }

    $scope.imageChanged3 = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.anhPhu3 = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload hình ảnh !");
            console.log("Error", error);
        })
    }

    $scope.imageChanged4 = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.anhPhu4 = resp.data.name;
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